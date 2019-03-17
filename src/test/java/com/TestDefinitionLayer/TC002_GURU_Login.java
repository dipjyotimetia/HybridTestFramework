package com.TestDefinitionLayer;

import com.core.UserActions;
import com.pages.LoginPage;
import com.pages.LoginPageGuru;
import com.reporting.ExtentReports.ExtentTestManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class TC002_GURU_Login extends UserActions {
    @Link("https://jira.cloud.com")
    @Feature("Api1")
    @Feature("Api2")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "E2E test for App")
    public void TestLogin() {

        String tName = "TC002_Test_Guru";

        LoginPageGuru loginPage = new LoginPageGuru();

        ExtentTestManager.startTest("Test1","Test Description guru");

        try {
            //loginPage.login();
            loginPage.verifyPassword(tName);
            CreateImageDoc(tName);
        } catch (Exception e) {
            catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }

    }
}
