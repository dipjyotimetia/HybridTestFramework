package com.cloud.aws;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;

@Slf4j
public class S3 extends config {

    String bucketName = "test-bucket";
    String key = "Reports";
    String filePath = "build/reports/allure-report";
    Region region = Region.AP_SOUTHEAST_2;
    S3Client s3Client = SetupS3(region, "DEV");

    public void createBucket() {
        try {
            s3Client.createBucket(CreateBucketRequest
                    .builder()
                    .bucket(bucketName)
                    .createBucketConfiguration(
                            CreateBucketConfiguration.builder()
                                    .locationConstraint(region.id())
                                    .build())
                    .build());
            log.info(bucketName);
        } catch (S3Exception e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    public void deleteBucket(String bucket) {
        DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket(bucket).build();
        s3Client.deleteBucket(deleteBucketRequest);
    }

    private void multipartUpload(String bucketName) {
        CreateMultipartUploadRequest createMultipartUploadRequest = CreateMultipartUploadRequest.builder()
                .bucket(bucketName).key(key)
                .build();
        CreateMultipartUploadResponse response = s3Client.createMultipartUpload(createMultipartUploadRequest);
        String uploadId = response.uploadId();
        log.info(uploadId);

        UploadPartRequest uploadPartRequest1 = UploadPartRequest.builder().bucket(bucketName).key(key)
                .uploadId(uploadId)
                .partNumber(1).build();
        String etag1 = s3Client.uploadPart(uploadPartRequest1, RequestBody.fromFile(new File(filePath))).eTag();
        CompletedPart part1 = CompletedPart.builder().partNumber(1).eTag(etag1).build();

        CompletedMultipartUpload completedMultipartUpload = CompletedMultipartUpload.builder().parts(part1).build();
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                CompleteMultipartUploadRequest.builder().bucket(bucketName).key(key).uploadId(uploadId)
                        .multipartUpload(completedMultipartUpload).build();
        s3Client.completeMultipartUpload(completeMultipartUploadRequest);
        log.info("Object upload complete");
    }
}
