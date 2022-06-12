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

