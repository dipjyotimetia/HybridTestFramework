/*
MIT License
Copyright (c) 2025 Dipjyoti Metia
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

import com.core.MobileActions;
import com.pages.mobile.SauceLoginPage;
import com.reporting.extentreport.ExtentTestManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class TC12_SauceLabsApp extends MobileActions {
    @Link("Test")
    @Feature("test")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Demo Test")
    public void TestSauceLabsApp() {

        String TCname = "TC_Test_IOSSause";

        SauceLoginPage loginPage = new SauceLoginPage();

        ExtentTestManager.startTest(TCname, "verify login");

        try {
            loginPage.login();
        } catch (Exception e) {
           catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }
    }
}