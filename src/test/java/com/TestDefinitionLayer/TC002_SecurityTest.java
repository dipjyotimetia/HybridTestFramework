package com.TestDefinitionLayer;

import com.security.Zap;
import com.security.ZapApi;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import static org.assertj.core.api.Assertions.assertThat;

public class TC002_SecurityTest {
    private static final String TARGET = "http://zero.webappsecurity.com/online-banking.html";

    private ZapApi zapApi = new ZapApi(TARGET);
    private Zap zap = new Zap(zapApi);

    @Test
    public void zapSecurityTest() {
        try {
            zap.doSpidering();
            zap.doPassiveScan();
            zap.doActiveScan();

            zapApi.generateHtmlReport("report.html");

            assertThat(zapApi.getNumberOfAlerts()).isZero();
        }
        catch (ClientApiException ce){
            ce.printStackTrace();
        }
        catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }
}
