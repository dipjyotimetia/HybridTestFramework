package com.reporting.Listeners;

import com.core.DriverManager;
import com.logging.ResultSender;
import com.logging.TestStatus;
import com.relevantcodes.extentreports.LogStatus;
import com.reporting.ExtentReports.ExtentManager;
import com.reporting.ExtentReports.ExtentTestManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class TestListener extends DriverManager implements ITestListener {
    private Logger logger = LogManager.getLogger(TestListener.class);

    private TestStatus testStatus;
//    private ResultSender rs= new ResultSender();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        logger.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driverThread);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        logger.info("I am in onFinish method " + iTestContext.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        this.testStatus = new TestStatus();
        logger.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"PASS");
        logger.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"FAIL");
        logger.error("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
        Object testClass = iTestResult.getInstance();
        this.driverThread = ((DriverManager) testClass).getDriver();
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driverThread).
                getScreenshotAs(OutputType.BASE64);
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"SKIP");
        logger.warn("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        logger.error("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

//    private void sendStatus(ITestResult iTestResult, String status){
//        this.testStatus.setTestClass(iTestResult.getTestClass().getName());
//        this.testStatus.setDescription(iTestResult.getMethod().getDescription());
//        this.testStatus.setStatus(status);
//        this.testStatus.setExecutionDate(LocalDateTime.now().toString());
//        rs.send(this.testStatus);
//    }
}
