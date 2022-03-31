package com.TestDefinitionLayer;

import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.pubsub.Pubsub;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import org.testcontainers.containers.PubSubEmulatorContainer;
import org.testcontainers.utility.DockerImageName;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

@Link("https://jira.cloud.com")
@Feature("GRPCApi")
public class TC010_GCPTest {
    String PROJECT_ID = "DEMO_PROJECT_ID";
    String TOPIC_ID = "DEMO_TOPIC_ID";
    String SUBSCRIPTION_ID = "DEMO_SUBSCRIPTION_ID";
    public PubSubEmulatorContainer pubSubEmulatorContainer = new PubSubEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
    );

    @BeforeTest
    public void beforeTest() {
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

    @AfterTest
    public void StopContainer() {
        pubSubEmulatorContainer.stop();
        System.out.println("Stopping  pubSub container");
    }
}
