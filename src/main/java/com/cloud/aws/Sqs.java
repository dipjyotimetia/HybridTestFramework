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

package com.cloud.aws;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import java.util.List;

@Slf4j
public class Sqs {

    /**
     * DeleteSQSQueue
     *
     * @param sqsClient sqsClient
     * @param queueName queueName
     */
    public static void deleteSQSQueue(SqsClient sqsClient, String queueName) {
        try {
            GetQueueUrlRequest getQueueRequest = GetQueueUrlRequest.builder()
                    .queueName(queueName)
                    .build();

            String queueUrl = sqsClient.getQueueUrl(getQueueRequest).queueUrl();

            DeleteQueueRequest deleteQueueRequest = DeleteQueueRequest.builder()
                    .queueUrl(queueUrl)
                    .build();

            sqsClient.deleteQueue(deleteQueueRequest);

        } catch (SqsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * Create Queue
     *
     * @param sqsClient sqsClient
     * @param queueName queueName
     */
    public void createQueue(SqsClient sqsClient, String queueName) {
        CreateQueueRequest createQueueRequest = CreateQueueRequest.builder()
                .queueName(queueName)
                .build();

        sqsClient.createQueue(createQueueRequest);
    }

    /**
     * ListQueue
     *
     * @param sqsClient sqsClient
     * @param prefix    prefix
     */
    public void listQueue(SqsClient sqsClient, String prefix) {

        try {
            ListQueuesRequest listQueuesRequest = ListQueuesRequest.builder().queueNamePrefix(prefix).build();
            ListQueuesResponse listQueuesResponse = sqsClient.listQueues(listQueuesRequest);

            for (String url : listQueuesResponse.queueUrls()) {
                log.info(url);
            }

        } catch (SqsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * GetQueURL
     *
     * @param sqsClient sqsClient
     * @param queueName queueName
     * @return url
     */
    public String getQueueURL(SqsClient sqsClient, String queueName) {
        try {
            GetQueueUrlResponse getQueueUrlResponse =
                    sqsClient.getQueueUrl(GetQueueUrlRequest.builder().queueName(queueName).build());
            return getQueueUrlResponse.queueUrl();
        } catch (SqsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return "";
    }

    /**
     * Send Message
     *
     * @param sqsClient sqsClient
     * @param queueUrl  queueUrl
     */
    public void sendMessage(SqsClient sqsClient, String queueUrl) {
        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody("Hello world!")
                .delaySeconds(10)
                .build());
    }

    /**
     * Receive Message
     *
     * @param sqsClient sqsClient
     * @param queueUrl  queueUrl
     * @return message
     */
    public List<Message> receiveMessage(SqsClient sqsClient, String queueUrl) {
        try {
            ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .maxNumberOfMessages(5)
                    .build();
            return sqsClient.receiveMessage(receiveMessageRequest).messages();
        } catch (SqsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return null;
    }

    /**
     * DeleteMessage
     *
     * @param sqsClient sqsClient
     * @param messages  message
     * @param queueUrl  queueUrl
     */
    public void deleteMessage(SqsClient sqsClient, List<Message> messages, String queueUrl) {
        try {
            for (Message message : messages) {
                DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                        .queueUrl(queueUrl)
                        .receiptHandle(message.receiptHandle())
                        .build();
                sqsClient.deleteMessage(deleteMessageRequest);
            }
        } catch (SqsException e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }
}