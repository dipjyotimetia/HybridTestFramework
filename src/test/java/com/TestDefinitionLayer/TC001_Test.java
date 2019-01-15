package com.TestDefinitionLayer;

import com.core.UserActions;
import com.pages.LoginPage;
import com.reporting.ExtentReports.ExtentTestManager;
import org.testng.annotations.Test;

public class TC001_Test extends UserActions {

    @Test
    public void TestLogin() {

        String tName = "TC001_Test";

        LoginPage loginPage = new LoginPage();

        ExtentTestManager.startTest("Test1","Test Description");

        try {
            loginPage.Login();
            CreateImageDoc(tName);
        } catch (Exception e) {
            catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }

    }
}
