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
import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZapApi {

    private final Logger logger = LogManager.getLogger(ZapApi.class);

    private static final String ZAP_ADDRESS = "localhost";
    private static final int ZAP_PORT = 8082;
    private static final String ZAP_API_KEY = "d025okl6n7blpkrr0iee6c7hsi";

    private final String target;
    private final ClientApi api;

    public ZapApi(String target) {
        this.target = target;
        api = new ClientApi(ZAP_ADDRESS, ZAP_PORT, ZAP_API_KEY);
    }

    public int getSpiderProgress(String taskId) throws ClientApiException {
        String status = ((ApiResponseElement) api.spider.status(taskId)).getValue();
        return Integer.parseInt(status);
    }

    public int getActiveScanProgress(String taskId) throws ClientApiException {
        String status = ((ApiResponseElement) api.ascan.status(taskId)).getValue();
        return Integer.parseInt(status);
    }

    public int getNumberOfAlerts() throws ClientApiException {
        return Integer.parseInt(((ApiResponseElement) api.core.numberOfAlerts(target)).getValue());
    }

    public int getNumberOfUnscannedRecods() throws ClientApiException {
        return Integer.parseInt(((ApiResponseElement) api.pscan.recordsToScan()).getValue());
    }

    public String getActiveScanTaskId() throws ClientApiException {
        return ((ApiResponseElement) getScanApiResponse()).getValue();
    }

    public String getSpiderTaskId() throws ClientApiException {
        return ((ApiResponseElement) getSpideringApiResponse()).getValue();
    }

    public void generateHtmlReport(String filePath) throws ClientApiException {
        String report = new String(api.core.htmlreport(), StandardCharsets.UTF_8);

        FileWriter fWriter;
        BufferedWriter writer;
        try {
            fWriter = new FileWriter(filePath);
            writer = new BufferedWriter(fWriter);
            writer.write(report);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    public void printAlerts() throws ClientApiException {
        logger.info("Alerts:");
        logger.info(new String(api.core.xmlreport(), StandardCharsets.UTF_8));
    }

    private ApiResponse getSpideringApiResponse() throws ClientApiException {
        return api.spider.scan(target, null, null, null, null);
    }

    private ApiResponse getScanApiResponse() throws ClientApiException {
        return api.ascan.scan(target, "True", "False", null, null, null);
    }
}