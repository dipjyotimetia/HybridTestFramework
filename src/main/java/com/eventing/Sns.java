/*
MIT License

Copyright (c) 2023 Dipjyoti Metia

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

package com.eventing;

import com.cloud.aws.Config;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.*;

@Slf4j
public class Sns extends Config {

    /**
     * CreateSNSTopic
     *
     * @param snsClient snsClient
     * @param topicName topicName
     * @return topic
     */
    public String createSNSTopic(SnsClient snsClient, String topicName) {
        CreateTopicResponse result = null;
        try {
            CreateTopicRequest request = CreateTopicRequest.builder()
                    .name(topicName)
                    .build();

            result = snsClient.createTopic(request);
            return result.topicArn();
        } catch (SnsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }

    /**
     * ListSNSTopics
     *
     * @param snsClient snsClient
     */
    public void listSNSTopics(SnsClient snsClient) {
        try {
            ListTopicsRequest request = ListTopicsRequest.builder()
                    .build();

            ListTopicsResponse result = snsClient.listTopics(request);
            log.info("Status was " + result.sdkHttpResponse().statusCode() + "\n\nTopics\n\n" + result.topics());

        } catch (SnsException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * SubscribeEmail
     *
     * @param snsClient snsClient
     * @param topicArn  topicARN
     * @param email     email
     */
    public void subEmail(SnsClient snsClient, String topicArn, String email) {
        try {
            SubscribeRequest request = SubscribeRequest.builder()
                    .protocol("email")
                    .endpoint(email)
                    .returnSubscriptionArn(true)
                    .topicArn(topicArn)
                    .build();

            SubscribeResponse result = snsClient.subscribe(request);
            log.info("Subscription ARN: " + result.subscriptionArn() + "\n\n Status was " + result.sdkHttpResponse().statusCode());

        } catch (SnsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * PublishTopic
     *
     * @param snsClient snsClient
     * @param message   message
     * @param topicArn  topicArn
     */
    public void pubTopic(SnsClient snsClient, String message, String topicArn) {
        try {
            PublishRequest request = PublishRequest.builder()
                    .message(message)
                    .topicArn(topicArn)
                    .build();

            PublishResponse result = snsClient.publish(request);
            log.info(result.messageId() + " Message sent. Status was " + result.sdkHttpResponse().statusCode());

        } catch (SnsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * UnsubscribeTopic
     *
     * @param snsClient       snsClient
     * @param subscriptionArn subscriptionArn
     */
    public void unSub(SnsClient snsClient, String subscriptionArn) {
        try {
            UnsubscribeRequest request = UnsubscribeRequest.builder()
                    .subscriptionArn(subscriptionArn)
                    .build();

            UnsubscribeResponse result = snsClient.unsubscribe(request);

            log.info("\n\nStatus was " + result.sdkHttpResponse().statusCode()
                    + "\n\nSubscription was removed for " + request.subscriptionArn());

        } catch (SnsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * DeleteSNSTopic
     *
     * @param snsClient snsClient
     * @param topicArn  topicArn
     */
    public void deleteSNSTopic(SnsClient snsClient, String topicArn) {
        try {
            DeleteTopicRequest request = DeleteTopicRequest.builder()
                    .topicArn(topicArn)
                    .build();

            DeleteTopicResponse result = snsClient.deleteTopic(request);
            log.info("\n\nStatus was " + result.sdkHttpResponse().statusCode());

        } catch (SnsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}
