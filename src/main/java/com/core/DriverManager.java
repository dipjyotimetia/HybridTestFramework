package com.core;


import org.openqa.selenium.WebDriver;

public class DriverManager extends WebDriverController {

    public WebDriver driverThread;

    public DriverManager() {
        this.driverThread = super.getDriver();
    }

}
