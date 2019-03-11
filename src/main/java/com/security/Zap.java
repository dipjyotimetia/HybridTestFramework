package com.security;

import org.zaproxy.clientapi.core.ClientApiException;

public class Zap implements ZapFunctionalities {

    private ZapApi zapApi;

    public Zap(ZapApi zapApi) {
        this.zapApi = zapApi;
    }

    @Override
    public void doSpidering() throws ClientApiException, InterruptedException {
        System.out.println("Spider started.");
        int progress;
        String spiderTaskId = zapApi.getSpiderTaskId();
        do {
            Thread.sleep(1000);
            progress = zapApi.getSpiderProgress(spiderTaskId);
            System.out.println("Spider progress : " + progress + "%");
        } while (progress < 100);
        System.out.println("Spider complete");
    }

    @Override
    public void doPassiveScan() throws ClientApiException, InterruptedException {
        System.out.println("Passive scanning started.");
        int recordsToScan;
        do {
            Thread.sleep(500);
            recordsToScan = zapApi.getNumberOfUnscannedRecods();
            System.out.println("There is still " + recordsToScan + " records to scan");
        } while (recordsToScan != 0);
        System.out.println("Passive scan completed");
    }

    @Override
    public void doActiveScan() throws ClientApiException, InterruptedException {
        System.out.println("Active scanning started.");
        String activeScanTaskId = zapApi.getActiveScanTaskId();
        int progress;
        do {
            Thread.sleep(5000);
            progress = zapApi.getActiveScanProgress(activeScanTaskId);
            System.out.println("Active Scan progress : " + progress + "%");
        } while (progress < 100);
        System.out.println("Active Scan complete");
    }
}
