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

package com.reporting.listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.core.DriverManager;
import com.reporting.extentreport.ExtentTestManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry extends DriverManager implements IRetryAnalyzer {
    private static final int maxTry = 0; //Run the failed test 2 times
    private int count = 0;

    /**
     * Retry Times
     *
     * @param iTestResult The result of the test method that just ran.
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!iTestResult.isSuccess()) {                      //Check if test not succeed
            if (count < maxTry) {                            //Check if maxtry count is reached
                count++;                                     //Increase the maxTry count by 1
                iTestResult.setStatus(ITestResult.FAILURE);  //Mark test as failed
                extendReportsFailOperations(iTestResult);    //ExtentReports fail operations
                return true;                                 //Tells TestNG to re-run the test
            }
        } else {
            iTestResult.setStatus(ITestResult.SUCCESS);      //If test passes, TestNG marks it as passed
        }
        return false;
    }

    /**
     * Report Fail Operation
     *
     * @param iTestResult
     */
    public void extendReportsFailOperations(ITestResult iTestResult) {
        try {
            Object testClass = iTestResult.getInstance();
            this.driverThread = ((DriverManager) testClass).getWebDriver();
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driverThread).getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().log(Status.FAIL, "Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
