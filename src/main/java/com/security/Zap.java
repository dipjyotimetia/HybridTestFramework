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
