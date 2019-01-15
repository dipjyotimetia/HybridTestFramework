package com.reporting.ExtentReports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    private static ExtentReports extent;

    public synchronized static ExtentReports getReporter() {
        if (extent == null) {
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(workingDir + "\\Reports\\ExtentReportResults.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
//            extent.attachReporter(workingDir + "\\Reports\\ExtentReportResults.html", true);
        }
        return extent;
    }
}
