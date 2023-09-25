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

package com.TestDefinitionLayer;

import com.security.Zap;
import com.security.ZapApi;
import org.testng.annotations.Test;
import org.zaproxy.clientapi.core.ClientApiException;

import static org.assertj.core.api.Assertions.assertThat;

public class TC002_SecurityTest {
    private static final String TARGET = "http://zero.webappsecurity.com/online-banking.html";

    private final ZapApi zapApi = new ZapApi(TARGET);
    private final Zap zap = new Zap(zapApi);

    @Test
    public void zapSecurityTest() {
        try {
            zap.doSpidering();
            zap.doPassiveScan();
            zap.doActiveScan();

            zapApi.generateHtmlReport("report.html");

            assertThat(zapApi.getNumberOfAlerts()).isZero();
        } catch (ClientApiException | InterruptedException ce) {
            ce.printStackTrace();
        }
    }
}
