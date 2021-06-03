/*
MIT License

Copyright (c) 2020 Dipjyoti Metia

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
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.lambda.LambdaClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;

import java.net.URI;

@Slf4j
public class Config {

    /**
     * Setup S3 client connection
     *
     * @param region cloud region
     * @param env    environment
     * @return s3client
     */
    public S3Client SetupS3(Region region, String env) {
        S3Client client = S3Client.builder().region(region).build();
        switch (env) {
            case "DEV":
                client = S3Client.builder().region(region).endpointOverride(URI.create("http://localhost:4566")).build();
                break;
            case "PROD":
                client = S3Client.builder().region(region).build();
                break;
            default:
                log.info("");
                break;
        }
        return client;
    }

    /**
     * Setup DynamoDB client connection
     *
     * @param region cloud region
     * @param env    environment
     * @return dynamoClient
     */
    public DynamoDbClient SetupDynamoDB(Region region, String env) {
        DynamoDbClient client = DynamoDbClient.builder().region(region).build();
        switch (env) {
            case "DEV":
                client = DynamoDbClient.builder().region(region).endpointOverride(URI.create("http://localhost:4566")).build();
                break;
            case "PROD":
                client = DynamoDbClient.builder().region(region).build();
                break;
            default:
                log.info("");
                break;
        }
        return client;
    }

    /**
     * Setup SetupSQS client connection
     *
     * @param region cloud region
     * @param env    environment
     * @return sqsClient
     */
    public SqsClient SetupSQS(Region region, String env) {
        SqsClient client = SqsClient.builder().region(region).build();
        switch (env) {
            case "DEV":
                client = SqsClient.builder().region(region).endpointOverride(URI.create("http://localhost:4566")).build();
                break;
            case "PROD":
                client = SqsClient.builder().region(region).build();
                break;
            default:
                log.info("");
                break;
        }
        return client;
    }

    /**
     * Setup SetupSNS client connection
     *
     * @param region cloud region
     * @param env    environment
     * @return snsClient
     */
    public SnsClient SetupSNS(Region region, String env) {
        SnsClient client = SnsClient.builder().region(region).build();
        switch (env) {
            case "DEV":
                client = SnsClient.builder().region(region).endpointOverride(URI.create("http://localhost:4566")).build();
                break;
            case "PROD":
                client = SnsClient.builder().region(region).build();
                break;
            default:
                log.info("");
                break;
        }
        return client;
    }

    /**
     * Setup SetupLambda client connection
     *
     * @param region cloud region
     * @param env    environment
     * @return lambdaClient
     */
    public LambdaClient SetupLambda(Region region, String env) {
        LambdaClient client = LambdaClient.builder().region(region).build();
        switch (env) {
            case "DEV":
                client = LambdaClient.builder().region(region).endpointOverride(URI.create("http://localhost:4566")).build();
                break;
            case "PROD":
                client = LambdaClient.builder().region(region).build();
                break;
            default:
                log.info("");
                break;
        }
        return client;
    }

}
