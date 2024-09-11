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

import com.core.WebActions;
import com.pages.web.LoginPageGuru;
import com.reporting.extentreport.ExtentTestManager;
import com.microsoft.playwright.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Link("https://jira.cloud.com")
@Feature("Api1")
@Feature("Api2")
public class TC002_GURU_Login extends WebActions {

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for App")
    @Description("Test Description")
    @Story("Test Guru")
    public void TestLogin() {

        String tName = "TC002_Test_Guru";

        LoginPageGuru loginPage = new LoginPageGuru();

        ExtentTestManager.startTest("Test1", "Test Description guru99.com");

        try {
            //loginPage.login();
            loginPage.verifyPassword(tName);
            // CreateImageDoc(tName);
        } catch (Exception e) {
            catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }

    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for App using Playwright")
    @Description("Test Description with Playwright")
    @Story("Test Guru with Playwright")
    public void TestLoginWithPlaywright() {

        String tName = "TC002_Test_Guru_Playwright";

        ExtentTestManager.startTest("Test2", "Test Description guru99.com with Playwright");

        try (Playwright playwright = Playwright.create()) {
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            page.navigate("https://example.com");
            page.fill("input[name='username']", "testuser");
            page.fill("input[name='password']", "password");
            page.click("button[type='submit']");
            // Add assertions and other actions as needed
            browser.close();
        } catch (Exception e) {
            catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }

    }
}
