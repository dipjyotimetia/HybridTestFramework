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

package com.core;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.OS;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * MobileOptions class is responsible for handling capabilities and configurations
 * related to mobile devices and cloud providers. It sets desired capabilities for
 * Android and iOS devices and sets up cloud service capabilities for providers
 * like BrowserStack, Sauce Labs, and LambdaTest.
 *
 * @author Dipjyoti Metia
 * @version 1.0
 * @since 2020
 */
@Slf4j
abstract class MobileOptions {
    private static final String nodeJS = System.getenv("NODE_HOME") + "/node.exe";
    private static final String appiumJS = System.getenv("APPIUM_HOME") + "/main.js";
    private final String apk_url = System.getenv("APK_URL");
    private final String ipa_url = System.getenv("IPA_URL");
    private final String serverIp = "127.0.0.1";    //Local
    private final String appiumPort = "4723";
    private final String bs_username = System.getenv("BROWSERSTACK_USERNAME");
    private final String bs_accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final String sauce_username = System.getenv("SAUCE_USERNAME");
    private final String sauce_accessKey = System.getenv("SAUCE_ACCESS_KEY");
    private final String lambda_username = System.getenv("SAUCE_USERNAME");
    private final String lambda_accessKey = System.getenv("SAUCE_ACCESS_KEY");
    private final String serverUrl = "http://" + serverIp + ":" + appiumPort;
    private final String browserstackURL = "https://" + bs_username + ":" + bs_accessKey + "@hub-cloud.browserstack.com/wd/hub";
    private final String sauceURL = "https://" + sauce_username + ":" + sauce_accessKey + "@ondemand.apac-southeast-1.saucelabs.com/wd/hub";
    private final String lambdaURL = "https://" + lambda_username + ":" + lambda_accessKey + "@hub.lambdatest.com/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();

    /**
     * Generates a URL for the given cloud provider.
     *
     * @param cloudProvider name of the cloud provider.
     * @return URL of the cloud server.
     * @throws MalformedURLException exception.
     */
    URL createURL(String cloudProvider) throws MalformedURLException {
        switch (cloudProvider) {
            case "sauce" -> {
                log.info("Argument to driver object : " + sauceURL);
                return new URL(sauceURL);
            }
            case "browserstack" -> {
                log.info("Argument to driver object : " + browserstackURL);
                return new URL(browserstackURL);
            }
            case "lambda" -> {
                log.info("Argument to driver object : " + lambdaURL);
                return new URL(lambdaURL);
            }
            default -> {
                log.info("Argument to driver object : " + serverUrl);
                return new URL(serverUrl);
            }
        }
    }

    /**
     * Sets up cloud capabilities based on the given cloud provider.
     *
     * @param cloudProvider name of the cloud provider.
     * @param caps          DesiredCapabilities instance.
     * @param device        device name.
     */
    void cloudCapabilities(String cloudProvider, DesiredCapabilities caps, String device) {
        switch (cloudProvider) {
            case "sauce" -> saucelabsCapabilities(caps, device);
            case "browserstack" -> browserstackCapabilities(caps, device);
            case "lambda" -> lambdaTestCapabilities(caps, device);
            default -> log.info("Setting up local appium server");
        }
    }

    /**
     * Sets up BrowserStack capabilities.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     */
    private void browserstackCapabilities(DesiredCapabilities caps, String device) {
        deviceCapabilities(caps, device);
        HashMap<String, Object> browserstackOptions = new HashMap<>();
        browserstackOptions.put("automationVersion", "latest");
        browserstackOptions.put("appiumVersion", "2.0.0");
        browserstackOptions.put("projectName", "HybridTestFramework");
        //browserstackOptions.put("local", "true");
        browserstackOptions.put("buildName", "browserstack-build-1");
        browserstackOptions.put("sessionName", "first_test");
        caps.setCapability("bstack:options", browserstackOptions);
        log.info("Setting up browserstack capabilities");
    }

    /**
     * Sets up LambdaTest capabilities.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     */
    private void lambdaTestCapabilities(DesiredCapabilities caps, String device) {
        deviceCapabilities(caps, device);
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("appiumVersion", "2.0.0");
        ltOptions.put("w3c", true);
        ltOptions.put("isRealMobile", true);
        caps.setCapability("lt:options", ltOptions);
        log.info("Setting up lambdatest capabilities");
    }

    /**
     * Sets up Sauce Labs capabilities.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     */
    private void saucelabsCapabilities(DesiredCapabilities caps, String device) {
        deviceCapabilities(caps, device);
        HashMap<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("appiumVersion", "2.0.0");
        caps.setCapability("sauce:options", sauceOptions);
        log.info("Setting up saucelabs capabilities");
    }

    /**
     * Sets up device capabilities based on the given device name.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     */
    private void deviceCapabilities(DesiredCapabilities caps, String device) {
        switch (device) {
            case "samsung" -> {
                caps.setCapability("browserName", "chrome");
                caps.setCapability("platformName", "android");
                caps.setCapability("appium:platformVersion", "13.0");
                caps.setCapability("appium:deviceName", "Samsung Galaxy S23");
                caps.setCapability("appium:automationName", "uiautomator2");
                caps.setCapability("appium:app", apk_url);
            }
            case "pixel" -> {
                caps.setCapability("browserName", "chrome");
                caps.setCapability("platformName", "android");
                caps.setCapability("appium:platformVersion", "13.0");
                caps.setCapability("appium:deviceName", "Google Pixel 3");
                caps.setCapability("appium:automationName", "uiautomator2");
                caps.setCapability("appium:app", apk_url);
            }
            case "iPhone14" -> {
                caps.setCapability("browserName", "safari");
                caps.setCapability("platformName", "ios");
                caps.setCapability("appium:platformVersion", "16");
                caps.setCapability("appium:deviceName", "iPhone 14");
                caps.setCapability("appium:automationName", "xcuitest");
                caps.setCapability("appium:app", ipa_url);
            }
            default -> System.out.println("No device found");
        }
    }

    /**
     * Sets up Android capabilities.
     *
     * @param caps DesiredCapabilities instance.
     */
    public void androidCapabilities(DesiredCapabilities caps) {
        caps.setCapability("platformName", "android");
        caps.setCapability("platformVersion", "13.0");
        caps.setCapability(UiAutomator2Options.APP_PACKAGE_OPTION, "com.swaglabsmobileapp");
        caps.setCapability(UiAutomator2Options.APP_ACTIVITY_OPTION, "com.swaglabsmobileapp.MainActivity");
    }

    /**
     * Sets up iOS capabilities.
     *
     * @param caps DesiredCapabilities instance.
     */
    public void iosCapabilities(DesiredCapabilities caps) {
        caps.setCapability("platformName", "ios");
        caps.setCapability("platformVersion", "16");
        // _caps.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "");
        // _caps.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "");
        // _caps.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "");
//        caps.setCapability(IOSMobileCapabilityType.AUTO_DISMISS_ALERTS, true);
        caps.setCapability(XCUITestOptions.BUNDLE_ID_OPTION, "com.saucelabs.SwagLabsMobileApp");
        caps.setCapability(XCUITestOptions.APP_OPTION, "com.saucelabs.SwagLabsMobileApp");
    }

    /**
     * Creates an Appium driver service.
     *
     * @return DriverService instance.
     */
    public DriverService createAppiumService() {
        return new AppiumServiceBuilder().usingDriverExecutable(new File(nodeJS)).withAppiumJS(new File(appiumJS)).withIPAddress(serverIp)
//                .usingPort(APPIUM_Port)
//                .withArgument(Arg.TIMEOUT, "120")
//                .withArgument(Arg.LOG_LEVEL, "warn")
                .build();
    }

    /**
     * Stop appium server
     */
    public void stopAppiumServer() {
        if (OS.isFamilyWindows()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("taskkill /F /IM node.exe");
                runtime.exec("taskkill /F /IM cmd.exe");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
