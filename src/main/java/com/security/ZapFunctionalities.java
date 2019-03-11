package com.security;

import org.zaproxy.clientapi.core.ClientApiException;

public interface ZapFunctionalities {

    void doSpidering() throws ClientApiException, InterruptedException;
    void doPassiveScan() throws ClientApiException, InterruptedException;
    void doActiveScan() throws ClientApiException, InterruptedException;

}