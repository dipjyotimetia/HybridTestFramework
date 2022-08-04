/*
MIT License
Copyright (c) 2021 Dipjyoti Metia
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package com.TestDefinitionLayer;

import com.eventing.Pubsub;
import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
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
    public PubSubEmulatorContainer pubSubEmulatorContainer = new PubSubEmulatorContainer(
            DockerImageName.parse("gcr.io/google.com/cloudsdktool/cloud-sdk:367.0.0-emulators")
    );
    String PROJECT_ID = "DEMO_PROJECT_ID";
    String TOPIC_ID = "DEMO_TOPIC_ID";
    String SUBSCRIPTION_ID = "DEMO_SUBSCRIPTION_ID";

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
