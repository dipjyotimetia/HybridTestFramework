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

import com.cloud.aws.Config;
import com.cloud.aws.S3;
import com.cloud.aws.Sqs;
import com.eventing.Sns;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Slf4j
public class TC007_AwsTest extends Config {

    Region region = Region.AP_SOUTHEAST_2;
    S3Client s3Client = setupS3(region, "DEV");
    SnsClient snsClient = setupSNS(region, "DEV");
    SqsClient sqsClient = setupSQS(region, "DEV");

    S3 s3 = new S3();
    Sns sns = new Sns();
    Sqs sqs = new Sqs();

    @Test
    public void TestS3() {
        s3.createBucket(s3Client, "test-s3");
        s3.deleteBucket(s3Client, "test-s3");
    }

    @Test
    public void TestSNS() {
        String topicName = sns.createSNSTopic(snsClient, "newtopic");
        sns.listSNSTopics(snsClient);
        sns.pubTopic(snsClient, "newMessage", topicName);
        sns.deleteSNSTopic(snsClient, topicName);
    }

    @Test
    public void TestSQS() {
        sqs.createQueue(sqsClient, "newsqs");
        String queueUrl = sqs.getQueueURL(sqsClient, "newsqs");
        sqs.sendMessage(sqsClient, queueUrl);
    }
}

