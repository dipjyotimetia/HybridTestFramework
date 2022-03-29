package com.TestDefinitionLayer;

import com.cloud.gcp.Firestore;
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
import com.pubsub.Pubsub;
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
import java.util.concurrent.ExecutionException;

public class TC010_GCPTest {
    String PROJECT_ID = "DEMO_PROJECT_ID";
    String TOPIC_ID = "DEMO_TOPIC_ID";
    String SUBSCRIPTION_ID = "DEMO_SUBSCRIPTION_ID";
    public FirestoreEmulatorContainer firestoreEmulatorContainer = new FirestoreEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
    );

    public PubSubEmulatorContainer pubSubEmulatorContainer = new PubSubEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
    );

    @BeforeTest
    public void beforeTest() {
        firestoreEmulatorContainer.start();
        System.out.println("Starting firestore container");
        pubSubEmulatorContainer.start();
        System.out.println("Starting pubSub container");
    }

    @Test
    public void testPubSub() throws IOException {
        Pubsub pubsub = new Pubsub(pubSubEmulatorContainer.getEmulatorEndpoint());
        try {
            pubsub.createTopic(PROJECT_ID, TOPIC_ID);
            pubsub.createSubscription(SUBSCRIPTION_ID, PROJECT_ID, TOPIC_ID);

            PubsubMessage message = PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("test message")).build();
            pubsub.createPublisher(PROJECT_ID, TOPIC_ID).publish(message);

            try (SubscriberStub subscriber = GrpcSubscriberStub.create(pubsub.subscriberStubSettings())) {
                PullRequest pullRequest = PullRequest.newBuilder()
                        .setMaxMessages(1)
                        .setSubscription(ProjectSubscriptionName.format(PROJECT_ID, SUBSCRIPTION_ID))
                        .build();
                PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);

                Assert.assertNotNull(pullResponse.getReceivedMessagesList());
                Assert.assertEquals(pullResponse.getReceivedMessages(0).getMessage().getData().toStringUtf8(), "test message");
            }
        } finally {
            pubsub.closeChannel();
        }
    }

    @Test
    public void testFireStore() throws ExecutionException, InterruptedException {
        Firestore fireStore = new Firestore(firestoreEmulatorContainer.getEmulatorEndpoint(), PROJECT_ID);
        QuerySnapshot querySnapshot = fireStore.addQuery();
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
