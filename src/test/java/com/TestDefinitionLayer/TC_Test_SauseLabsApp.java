package com.TestDefinitionLayer;

import com.core.MobileActions;
import com.pages.mobile.LoginPage;
import com.reporting.ExtentReports.ExtentTestManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class TC_Test_SauseLabsApp extends MobileActions {
    @Link("Test")
    @Feature("test")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Demo Test")
    public void E2E_TestSauseLabs() {

        String TCname = "TC_Test_IOSSause";

        LoginPage loginPage = new LoginPage();

//        ExtentTestManager.getTest().setDescription("Sause Login");

        try {
            loginPage.login();
        } catch (Exception e) {
//            catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }

    }
}