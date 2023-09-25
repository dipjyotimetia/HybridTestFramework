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

package com.security;

import lombok.extern.slf4j.Slf4j;
import org.zaproxy.clientapi.core.ClientApiException;

/**
 * This class provides methods for performing various security tests using the OWASP Zed Attack Proxy (ZAP).
 * <p>
 * It includes functionalities such as spidering, passive scanning, and active scanning.
 *
 * @author Dipjyoti Metia
 */
@Slf4j
public class Zap implements ZapFunctionalities {

    private final ZapApi zapApi;

    /**
     * Constructs a new Zap object with the specified ZapApi instance.
     *
     * @param zapApi a ZapApi instance for interacting with the ZAP API
     */
    public Zap(ZapApi zapApi) {
        this.zapApi = zapApi;
    }

    /**
     * Performs spidering on the target application to discover its structure and contents.
     * Spidering is a process where a tool crawls the target application, following links and gathering information.
     *
     * @throws ClientApiException   if an error occurs while interacting with the ZAP API
     * @throws InterruptedException if the spidering process is interrupted
     */
    @Override
    public void doSpidering() throws ClientApiException, InterruptedException {
        log.info("Spider started.");
        int progress;
        String spiderTaskId = zapApi.getSpiderTaskId();
        do {
            Thread.sleep(1000);
            progress = zapApi.getSpiderProgress(spiderTaskId);
            log.info("Spider progress : " + progress + "%");
        } while (progress < 100);
        log.info("Spider complete");
    }

    /**
     * Performs passive scanning on the target application.
     * Passive scanning is a non-intrusive process that analyzes HTTP requests and responses without actively sending new requests.
     *
     * @throws ClientApiException   if an error occurs while interacting with the ZAP API
     * @throws InterruptedException if the passive scanning process is interrupted
     */
    @Override
    public void doPassiveScan() throws ClientApiException, InterruptedException {
        log.info("Passive scanning started.");
        int recordsToScan;
        do {
            Thread.sleep(500);
            recordsToScan = zapApi.getNumberOfUnscannedRecods();
            log.info("There is still " + recordsToScan + " records to scan");
        } while (recordsToScan != 0);
        log.info("Passive scan completed");
    }

    /**
     * Performs active scanning on the target application.
     * Active scanning is an intrusive process that sends malicious payloads to the target application to identify security vulnerabilities.
     *
     * @throws ClientApiException   if an error occurs while interacting with the ZAP API
     * @throws InterruptedException if the active scanning process is interrupted
     */
    @Override
    public void doActiveScan() throws ClientApiException, InterruptedException {
        log.info("Active scanning started.");
        String activeScanTaskId = zapApi.getActiveScanTaskId();
        int progress;
        do {
            Thread.sleep(5000);
            progress = zapApi.getActiveScanProgress(activeScanTaskId);
            log.info("Active Scan progress : " + progress + "%");
        } while (progress < 100);
        log.info("Active Scan complete");
    }
}
