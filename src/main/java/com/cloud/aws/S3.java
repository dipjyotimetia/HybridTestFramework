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
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;

@Slf4j
public class S3 extends Config {
    Region region = Region.AP_SOUTHEAST_2;

    /**
     * Create Bucket
     *
     * @param s3Client s3Client
     * @param bucket   bucketName
     */
    public void createBucket(S3Client s3Client, String bucket) {
        try {
            s3Client.createBucket(CreateBucketRequest
                    .builder()
                    .bucket(bucket)
                    .createBucketConfiguration(
                            CreateBucketConfiguration.builder()
                                    .locationConstraint(region.id())
                                    .build())
                    .build());
            log.info("Bucket Created: " + bucket);
        } catch (S3Exception e) {
            log.error(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    /**
     * DeleteBucket
     *
     * @param s3Client s3Client
     * @param bucket   bucketName
     */
    public void deleteBucket(S3Client s3Client, String bucket) {
        DeleteBucketRequest deleteBucketRequest = DeleteBucketRequest.builder().bucket(bucket).build();
        s3Client.deleteBucket(deleteBucketRequest);
        log.info("Bucket Deleted: " + bucket);
    }

    /**
     * Multipart Upload
     *
     * @param s3Client   s3Client
     * @param bucketName bucketName
     * @param key        key
     * @param filePath   path
     */
    private void multipartUpload(S3Client s3Client, String bucketName, String key, String filePath) {
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
