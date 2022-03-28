package com.TestDefinitionLayer;

import com.google.api.core.ApiFuture;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.NoCredentials;
import com.google.cloud.firestore.*;
import com.google.cloud.pubsub.v1.*;
import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.testcontainers.containers.FirestoreEmulatorContainer;
import org.testcontainers.containers.PubSubEmulatorContainer;
import org.testcontainers.utility.DockerImageName;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class TC010_GCPTest {

    String PROJECT_ID = "DEMO_PROJECT_ID";
    public FirestoreEmulatorContainer firestoreEmulatorContainer = new FirestoreEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
    );

    public PubSubEmulatorContainer pubSubEmulatorContainer = new PubSubEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
    );

    private void createTopic(String topicId, TransportChannelProvider channelProvider, NoCredentialsProvider credentialsProvider) throws IOException {
        TopicAdminSettings topicAdminSettings = TopicAdminSettings.newBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .build();
        try (TopicAdminClient topicAdminClient = TopicAdminClient.create(topicAdminSettings)) {
            TopicName topicName = TopicName.of(PROJECT_ID, topicId);
            topicAdminClient.createTopic(topicName);
        }
    }

    private void createSubscription(String subscriptionId, String topicId, TransportChannelProvider channelProvider, NoCredentialsProvider credentialsProvider) throws IOException {
        SubscriptionAdminSettings subscriptionAdminSettings = SubscriptionAdminSettings.newBuilder()
                .setTransportChannelProvider(channelProvider)
                .setCredentialsProvider(credentialsProvider)
                .build();
        SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create(subscriptionAdminSettings);
        ProjectSubscriptionName subscriptionName = ProjectSubscriptionName.of(PROJECT_ID, subscriptionId);
        subscriptionAdminClient.createSubscription(subscriptionName, TopicName.of(PROJECT_ID, topicId), PushConfig.getDefaultInstance(), 10);
    }

    @BeforeTest
    public void beforeTest() {
        firestoreEmulatorContainer.start();
        System.out.println("Starting firestore container");
        pubSubEmulatorContainer.start();
        System.out.println("Starting pubSub container");
    }

    @Test
    public void testPubSub() throws IOException {
        String hostport = pubSubEmulatorContainer.getEmulatorEndpoint();
        ManagedChannel channel = ManagedChannelBuilder.forTarget(hostport).usePlaintext().build();
        try {
            TransportChannelProvider channelProvider =
                    FixedTransportChannelProvider.create(GrpcTransportChannel.create(channel));
            NoCredentialsProvider credentialsProvider = NoCredentialsProvider.create();

            String topicId = "my-topic-id";
            createTopic(topicId, channelProvider, credentialsProvider);

            String subscriptionId = "my-subscription-id";
            createSubscription(subscriptionId, topicId, channelProvider, credentialsProvider);

            Publisher publisher = Publisher.newBuilder(TopicName.of(PROJECT_ID, topicId))
                    .setChannelProvider(channelProvider)
                    .setCredentialsProvider(credentialsProvider)
                    .build();
            PubsubMessage message = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("test message")).build();
            publisher.publish(message);

            SubscriberStubSettings subscriberStubSettings =
                    SubscriberStubSettings.newBuilder()
                            .setTransportChannelProvider(channelProvider)
                            .setCredentialsProvider(credentialsProvider)
                            .build();
            try (SubscriberStub subscriber = GrpcSubscriberStub.create(subscriberStubSettings)) {
                PullRequest pullRequest = PullRequest.newBuilder()
                        .setMaxMessages(1)
                        .setSubscription(ProjectSubscriptionName.format(PROJECT_ID, subscriptionId))
                        .build();
                PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);

                Assert.assertNotNull(pullResponse.getReceivedMessagesList());
                Assert.assertEquals(pullResponse.getReceivedMessages(0).getMessage().getData().toStringUtf8(), "test message");
            }
        } finally {
            channel.shutdown();
        }
    }

    @Test
    public void testFireStore() throws ExecutionException, InterruptedException {
        FirestoreOptions options = FirestoreOptions.getDefaultInstance().toBuilder()
                .setHost(firestoreEmulatorContainer.getEmulatorEndpoint())
                .setCredentials(NoCredentials.getInstance())
                .setProjectId("test-project")
                .build();
        Firestore firestore = options.getService();

        CollectionReference users = firestore.collection("users");
        DocumentReference docRef = users.document("alovelace");
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Ada");
        data.put("last", "Lovelace");
        ApiFuture<WriteResult> result = docRef.set(data);
        result.get();

        ApiFuture<QuerySnapshot> query = users.get();
        QuerySnapshot querySnapshot = query.get();

        Assert.assertNotNull(querySnapshot.getDocuments().get(0).getData());
    }

    @AfterTest
    public void StopContainer() {
        firestoreEmulatorContainer.stop();
        System.out.println("Stopping firestore container");
        pubSubEmulatorContainer.stop();
        System.out.println("Stopping  pubSub container");
    }


}
