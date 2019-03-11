package com.security;

import org.zaproxy.clientapi.core.ApiResponse;
import org.zaproxy.clientapi.core.ApiResponseElement;
import org.zaproxy.clientapi.core.ClientApi;
import org.zaproxy.clientapi.core.ClientApiException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ZapApi {

    private static final String ZAP_ADDRESS = "localhost";
    private static final int ZAP_PORT = 8888;
    private static final String ZAP_API_KEY = "d025okl6n7blpkrr0iee6c7hsi";

    private String target;
    private ClientApi api;

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
        System.out.println("Alerts:");
        System.out.println(new String(api.core.xmlreport(), StandardCharsets.UTF_8));
    }

    private ApiResponse getSpideringApiResponse() throws ClientApiException {
        return api.spider.scan(target, null, null, null, null);
    }

    private ApiResponse getScanApiResponse() throws ClientApiException {
        return api.ascan.scan(target, "True", "False", null, null, null);
    }
}