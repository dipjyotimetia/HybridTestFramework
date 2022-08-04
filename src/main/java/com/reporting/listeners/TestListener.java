/*
MIT License

Copyright (c) 2020 Dipjyoti Metia

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

package com.reporting.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.core.DriverManager;
import com.logging.TestStatus;
import com.reporting.extentreport.ExtentManager;
import com.reporting.extentreport.ExtentTestManager;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener extends DriverManager implements ITestListener {

    private TestStatus testStatus;
//    private ResultSender rs= new ResultSender();

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "0", type = "text/plain")
    public static String saveTextLogs(String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("I am in onStart method " + iTestContext.getName());
        if (this.driverThread != null) {
            iTestContext.setAttribute("WebDriver", this.driverThread);
        } else {
            iTestContext.setAttribute("WebDriver", this.mobileThread);
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("I am in onFinish method " + iTestContext.getName());
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        this.testStatus = new TestStatus();
        log.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"PASS");
        log.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            if (this.driverThread != null) {
                //        this.sendStatus(iTestResult,"FAIL");
                saveScreenshotPNG();
                log.error("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
                Object testClass = iTestResult.getInstance();
                this.driverThread = ((DriverManager) testClass).getWebDriver();
                String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driverThread).getScreenshotAs(OutputType.BASE64);
                ExtentTestManager.getTest().log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            } else {
                saveScreenshotPNG();
                log.error("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
                Object testClass = iTestResult.getInstance();
                this.mobileThread = ((DriverManager) testClass).getMobileDriver();
                String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) mobileThread).getScreenshotAs(OutputType.BASE64);
                ExtentTestManager.getTest().log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
//        this.sendStatus(iTestResult,"SKIP");
        log.warn("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.error("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        if ((this.driverThread != null)) {
            return ((TakesScreenshot) this.driverThread).getScreenshotAs(OutputType.BYTES);
        } else {
            return ((TakesScreenshot) this.mobileThread).getScreenshotAs(OutputType.BYTES);
        }
    }
//    private void sendStatus(ITestResult iTestResult, String status){
//        this.testStatus.setTestClass(iTestResult.getTestClass().getName());
//        this.testStatus.setDescription(iTestResult.getMethod().getDescription());
//        this.testStatus.setStatus(status);
//        this.testStatus.setExecutionDate(LocalDateTime.now().toString());
//        rs.send(this.testStatus);
//    }
}
