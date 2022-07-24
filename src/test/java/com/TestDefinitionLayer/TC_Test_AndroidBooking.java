package com.TestDefinitionLayer;

import com.core.MobileActions;
import com.pages.mobile.HomePage;
import com.reporting.ExtentReports.ExtentTestManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class TC_Test_AndroidBooking extends MobileActions {

    @Link("Test")
    @Feature("test")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Demo Test")
    public void E2E_TestAndroid_Bookings() {

        String TCname = "TC_Test_AndroidBooking";

        HomePage homePage = new HomePage();

//        ExtentTestManager.getTest().setDescription("Search for bookings");

        try {
            homePage.searchDestination()
                    .selectDate()
                    .search();
            // CreateImageDoc(TCname);
        } catch (Exception e) {
//            catchBlock(e);
        } finally {
            ExtentTestManager.endTest();
        }
    }
}
