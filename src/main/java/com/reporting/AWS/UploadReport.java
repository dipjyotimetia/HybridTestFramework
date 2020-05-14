package com.reporting.AWS;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.File;

public class UploadReport {
    private final Logger logger = LogManager.getLogger(UploadReport.class);

    @Test
    public void UploadToS3() throws Exception {
        String bucketName = "";
        String keyName = "Reports";
        String filePath = "build/reports/allure-report";

        try {
            BasicAWSCredentials awsCreds = new BasicAWSCredentials("/", "/");
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.AP_SOUTHEAST_2)
                    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                    .build();
            s3Client.deleteObject(bucketName, keyName);

            TransferManager tm = TransferManagerBuilder.standard()
                    .withS3Client(s3Client)
                    .build();

            MultipleFileUpload upload = tm.uploadDirectory(bucketName, keyName, new File(filePath), true);
            logger.info("Object upload started");

            upload.waitForCompletion();
            logger.info("Object upload complete");
        } catch (AmazonServiceException e) {
            logger.error("Amazon Service Exception", e);
        } catch (SdkClientException e) {
            logger.error("SDK client Exception", e);
        }
    }
}
