package com.pubsub;

import com.cloud.gcp.Config;
import com.google.api.core.ApiFuture;
import com.google.cloud.pubsub.v1.Publisher;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminSettings;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.Encoding;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import com.avro.Customer;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class PubSub {
    //    Config config = new Config();
//    String projectId = "local-pubsub";
//    String topicId = "my-topic-3";
    public static void createTopicExample(String projectId, String topicId, Config config) throws IOException {
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create(TopicAdminSettings.newBuilder()
                .setTransportChannelProvider(config.ChannelProvider())
                .setCredentialsProvider(config.CredentialProvider())
                .build())) {
            TopicName topicName = TopicName.of(projectId, topicId);
            Topic topic = topicAdminClient.createTopic(topicName);
            System.out.println("Created topic: " + topic.getName());
        }
    }

    public static void messagePublisher(String projectId, String topicId, Config config)
            throws IOException, ExecutionException, InterruptedException {

        TopicName topicName = TopicName.of(projectId, topicId);

        Publisher publisher = null;
        try {
            // Create a publisher instance with default settings bound to the topic
            publisher = Publisher.newBuilder(topicName)
                    .setChannelProvider(config.ChannelProvider())
                    .setCredentialsProvider(config.CredentialProvider())
                    .build();

            String message = "Hello World!";
            ByteString data = ByteString.copyFromUtf8(message);
            PubsubMessage pubsubMessage = PubsubMessage.newBuilder().setData(data).build();

            // Once published, returns a server-assigned message id (unique within the topic)
            ApiFuture<String> messageIdFuture = publisher.publish(pubsubMessage);
            String messageId = messageIdFuture.get();
            System.out.println("Published message ID: " + messageId);
        } finally {
            if (publisher != null) {
                // When finished with the publisher, shutdown to free up resources.
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }

    public static void publishAvroRecords(String projectId, String topicId, Config config)
            throws IOException, ExecutionException, InterruptedException {

        Encoding encoding = null;

        TopicName topicName = TopicName.of(projectId, topicId);

        // Get the topic encoding type.
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
            encoding = topicAdminClient.getTopic(topicName).getSchemaSettings().getEncoding();
        }

        // Instantiate an avro-tools-generated class defined in `us-states.avsc`.
        Customer customer = Customer.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setAge(25)
                .setHeight(185.5f)
                .setWeight(85.6f)
                .setAutomatedEmail(false)
                .build();

        Publisher publisher = null;

        block:
        try {
            publisher = Publisher.newBuilder(topicName)
                    .setChannelProvider(config.ChannelProvider())
                    .setCredentialsProvider(config.CredentialProvider())
                    .build();

            // Prepare to serialize the object to the output stream.
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

            Encoder encoder = null;

            // Prepare an appropriate encoder for publishing to the topic.
            switch (encoding) {
                case BINARY:
                    System.out.println("Preparing a BINARY encoder...");
                    encoder = EncoderFactory.get().directBinaryEncoder(byteStream, /*reuse=*/ null);
                    break;

                case JSON:
                    System.out.println("Preparing a JSON encoder...");
                    encoder = EncoderFactory.get().jsonEncoder(Customer.getClassSchema(), byteStream);
                    break;

                default:
                    break block;
            }

            // Encode the object and write it to the output stream.
            customer.customEncode(encoder);
            encoder.flush();

            // Publish the encoded object as a Pub/Sub message.
            ByteString data = ByteString.copyFrom(byteStream.toByteArray());
            PubsubMessage message = PubsubMessage.newBuilder().setData(data).build();
            System.out.println("Publishing message: " + message);

            ApiFuture<String> future = publisher.publish(message);
            System.out.println("Published message ID: " + future.get());

        } finally {
            if (publisher != null) {
                publisher.shutdown();
                publisher.awaitTermination(1, TimeUnit.MINUTES);
            }
        }
    }
}
