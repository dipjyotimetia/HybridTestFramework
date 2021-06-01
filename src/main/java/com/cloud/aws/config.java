package com.cloud.aws;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.s3.S3Client;

import java.net.URI;

@Slf4j
public class config {

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
}
