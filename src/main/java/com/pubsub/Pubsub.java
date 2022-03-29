package com.pubsub;

import com.cloud.gcp.Config;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.pubsub.v1.*;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.*;
import com.avro.Customer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Pubsub {
    SubscriptionAdminSettings subscriptionAdminSettings;
    TopicAdminSettings topicAdminSettings;
    ManagedChannel channel;
    Config config = new Config();

    public Pubsub(String host) {
        channel = ManagedChannelBuilder.forTarget(host).usePlaintext().build();
        subscriptionAdminSettings = config.subscriptionAdminSettings(config.channelProvider(channel), config.credentialProvider());
        topicAdminSettings = config.topicAdminSettings(config.channelProvider(channel), config.credentialProvider());
    }

    public void closeChannel(){
        channel.shutdown();
    }

    public void publishAvroRecords(String projectId, String topicId)
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
        Publisher publisher = createPublisher(projectId, topicId);
        block:
        try {
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

    public void createTopic(String projectID, String topicId) {
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings)) {
            TopicName topicName = TopicName.of(projectID, topicId);
            topicAdminClient.createTopic(topicName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void createSubscription(String subscriptionId, String projectID, String topicId) {
        try {
            SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create(subscriptionAdminSettings);
            ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(projectID, subscriptionId);
            subscriptionAdminClient.createSubscription(subscriptionName, TopicName.of(projectID, topicId), PushConfig.getDefaultInstance(), 10);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public Publisher createPublisher(String projectID, String topicID) {
        try {
            return Publisher.newBuilder(TopicName.of(projectID, topicID))
                    .setChannelProvider(config.channelProvider(channel))
                    .setCredentialsProvider(config.credentialProvider())
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public SubscriberStubSettings subscriberStubSettings() {
        try {
            return SubscriberStubSettings.newBuilder()
                    .setTransportChannelProvider(config.channelProvider(channel))
                    .setCredentialsProvider(config.credentialProvider())
                    .build();
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
