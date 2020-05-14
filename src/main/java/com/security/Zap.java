package com.security;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.zaproxy.clientapi.core.ClientApiException;

public class Zap implements ZapFunctionalities {

    private final Logger logger = LogManager.getLogger(Zap.class);

    private final ZapApi zapApi;

    public Zap(ZapApi zapApi) {
        this.zapApi = zapApi;
    }

    @Override
    public void doSpidering() throws ClientApiException, InterruptedException {
        logger.info("Spider started.");
        int progress;
        String spiderTaskId = zapApi.getSpiderTaskId();
        do {
            Thread.sleep(1000);
            progress = zapApi.getSpiderProgress(spiderTaskId);
            logger.info("Spider progress : " + progress + "%");
        } while (progress < 100);
        logger.info("Spider complete");
    }

    @Override
    public void doPassiveScan() throws ClientApiException, InterruptedException {
        logger.info("Passive scanning started.");
        int recordsToScan;
        do {
            Thread.sleep(500);
            recordsToScan = zapApi.getNumberOfUnscannedRecods();
            logger.info("There is still " + recordsToScan + " records to scan");
        } while (recordsToScan != 0);
        logger.info("Passive scan completed");
    }

    @Override
    public void doActiveScan() throws ClientApiException, InterruptedException {
        logger.info("Active scanning started.");
        String activeScanTaskId = zapApi.getActiveScanTaskId();
        int progress;
        do {
            Thread.sleep(5000);
            progress = zapApi.getActiveScanProgress(activeScanTaskId);
            logger.info("Active Scan progress : " + progress + "%");
        } while (progress < 100);
        logger.info("Active Scan complete");
    }
}
