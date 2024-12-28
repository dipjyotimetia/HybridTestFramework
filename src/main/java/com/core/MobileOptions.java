/*
MIT License

Copyright (c) 2025 Dipjyoti Metia

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

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.OS;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;

/**
 * MobileOptions class is responsible for handling capabilities and configurations
 * related to mobile devices and cloud providers. It sets desired capabilities for
 * Android and iOS devices and sets up cloud service capabilities for providers
 * like BrowserStack, Sauce Labs, and LambdaTest.
 *
 * @author Dipjyoti Metia
 */
@Slf4j
abstract class MobileOptions {
    private static final String nodeJS = System.getenv("NODE_HOME") + "/node.exe";
    private static final String appiumJS = System.getenv("APPIUM_HOME") + "/main.js";
    public final String lambda_username = System.getenv("LT_USERNAME");
    public final String lambda_accessKey = System.getenv("LT_ACCESS_KEY");
    private final String apk_url = System.getenv("APK_URL");
    private final String ipa_url = System.getenv("IPA_URL");
    private final String serverIp = "127.0.0.1";    //Local
    private final String github_run_number = System.getenv("GITHUB_RUN_NUMBER");
    private final String bs_username = System.getenv("BROWSERSTACK_USERNAME");
    private final String bs_accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final String sauce_username = System.getenv("SAUCE_USERNAME");
    private final String sauce_accessKey = System.getenv("SAUCE_ACCESS_KEY");
    public final String browserstackGridURL = "https://" + bs_username + ":" + bs_accessKey + "@hub-cloud.browserstack.com/wd/hub";
    public final String sauceGridURL = "https://" + sauce_username + ":" + sauce_accessKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public final String lambdaGridURL = "https://" + lambda_username + ":" + lambda_accessKey + "@hub.lambdatest.com/wd/hub";

    /**
     * Generates a URL for the given cloud provider.
     *
     * @param provider name of the cloud provider.
     * @return URL of the cloud server.
     * @throws MalformedURLException exception.
     */
    URL setupMobileGrid(String provider) throws MalformedURLException {
        log.info("Creating URL for cloud provider: {}", provider);
        switch (provider) {
            case "sauce" -> {
                return new URL(sauceGridURL);
            }
            case "browserstack" -> {
                return new URL(browserstackGridURL);
            }
            case "lambda" -> {
                return new URL(lambdaGridURL);
            }
            case "local" -> {
                return URI.create("http://" + serverIp + ":" + "4723").toURL();
            }
            default -> {
                log.error("Invalid cloud provider");
                return null;
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
    void cloudMobileCapabilities(String cloudProvider, DesiredCapabilities caps, String device) {
        log.info("Setting up capabilities for cloud provider: {} and device: {}", cloudProvider, device);
        switch (cloudProvider) {
            case "browserstack" -> browserStackMobileCapabilities(caps, device);
            case "lambda" -> lambdaTestMobileCapabilities(caps, device);
            case "sauce" -> sauceLabsMobileCapabilities(caps, device);
            default -> log.info("Setting up local appium server");
        }
    }

    /**
     * Sets up BrowserStack capabilities.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     * @see <a href="https://www.browserstack.com/docs/app-automate/capabilities">BrowserStack Capabilities</a>
     */
    private void browserStackMobileCapabilities(DesiredCapabilities caps, String device) {
        log.info("Setting up capabilities for BrowserStack");
        HashMap<String, Object> bStackOptions = new HashMap<>();
        genericMobileCapabilities(caps, device);
        switch (device) {
            case "s23" -> {
                caps.setCapability("appium:platformVersion", "13");
                caps.setCapability("appium:deviceName", "Samsung Galaxy S23");
            }
            case "pixel" -> {
                caps.setCapability("appium:platformVersion", "15");
                caps.setCapability("appium:deviceName", "Google Pixel 9 Pro");
            }
            case "iPhone16" -> {
                caps.setCapability("appium:platformVersion", "18");
                caps.setCapability("appium:deviceName", "iPhone 16");
            }
            default -> System.out.println("No device found");
        }
        bStackOptions.put("userName", bs_username);
        bStackOptions.put("accessKey", bs_accessKey);
        bStackOptions.put("appiumVersion", "2.6.0");
        bStackOptions.put("projectName", "HybridTestFramework");
        bStackOptions.put("local", "false");
        bStackOptions.put("buildName", github_run_number);
        bStackOptions.put("sessionName", "Demo session");
        caps.setCapability("bstack:options", bStackOptions);
    }

    /**
     * Sets up LambdaTest capabilities.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     * @see <a href="https://www.lambdatest.com/support/docs/desired-capabilities-in-appium/">LambdaTest Capabilities</a>
     */
    private void lambdaTestMobileCapabilities(DesiredCapabilities caps, String device) {
        log.info("Setting up capabilities for LambdaTest");
        genericMobileCapabilities(caps, device);
        HashMap<String, Object> ltOptions = new HashMap<>();
        switch (device) {
            case "s23" -> {
                ltOptions.put("platformName", "android");
                ltOptions.put("deviceName", "Galaxy S23");
                ltOptions.put("platformVersion", "14");
            }
            case "pixel" -> {
                ltOptions.put("platformName", "android");
                ltOptions.put("platformVersion", "14");
                ltOptions.put("deviceName", "Pixel 9 Pro");
            }
            case "iPhone16" -> {
                ltOptions.put("platformName", "ios");
                ltOptions.put("platformVersion", "18");
                ltOptions.put("deviceName", "iPhone 16");
            }
            default -> System.out.println("No device found");
        }
        ltOptions.put("isRealMobile", false);
        ltOptions.put("user", lambda_username);
        ltOptions.put("accessKey", lambda_accessKey);
        ltOptions.put("w3c", true);
        ltOptions.put("appiumVersion", "2.6.0");
        ltOptions.put("build", "HybridTestFramework");
        ltOptions.put("deviceOrientation", "portrait");
        ltOptions.put("autoGrantPermissions", true);
        ltOptions.put("autoAcceptAlerts", true);
        caps.setCapability("lt:options", ltOptions);
    }

    /**
     * Sets up Sauce Labs capabilities.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     * @see <a href="https://docs.saucelabs.com/mobile-apps/automated-testing/appium/virtual-devices/">Sauce Labs Capabilities</a>
     */
    private void sauceLabsMobileCapabilities(DesiredCapabilities caps, String device) {
        log.info("Setting up capabilities for Sauce Labs");
        genericMobileCapabilities(caps, device);
        HashMap<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", sauce_username);
        sauceOptions.put("accessKey", sauce_accessKey);
        sauceOptions.put("appiumVersion", "latest");
        caps.setCapability("sauce:options", sauceOptions);
    }

    /**
     * Sets up device capabilities based on the given device name.
     *
     * @param caps   DesiredCapabilities instance.
     * @param device device name.
     * @see <a href="https://appium.io/docs/en/2.0/guides/caps/">Appium Capabilities</a>
     */
    private void genericMobileCapabilities(DesiredCapabilities caps, String device) {
        switch (device) {
            case "s23", "pixel" -> {
                caps.setCapability("appium:platformName", "android");
                caps.setCapability("appium:automationName", "uiautomator2");
                caps.setCapability("appium:app", apk_url);
            }
            case "iPhone16" -> {
                caps.setCapability("appium:platformName", "ios");
                caps.setCapability("appium:automationName", "xcuitest");
                caps.setCapability("appium:app", ipa_url);
            }
            default -> System.out.println("No device found");
        }
    }

    /**
     * Creates an Appium driver service.
     *
     * @return DriverService instance.
     */
    public AppiumDriverLocalService createAppiumService() {
        log.info("Creating Appium service");
        return new AppiumServiceBuilder().
                usingDriverExecutable(new File(nodeJS)).
                withAppiumJS(new File(appiumJS)).
                withIPAddress(serverIp)
                .usingPort(4723)
                .withArgument(() -> "--log")
                .build();
    }

    /**
     * Stop appium server
     */
    public void stopAppiumServer() {
        log.info("Stopping Appium server");
        if (OS.isFamilyWindows()) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("taskkill /F /IM node.exe");
                runtime.exec("taskkill /F /IM cmd.exe");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }
}
