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

package com.core;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.OS;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

@Slf4j
abstract class MobileOptions {
    private static final String nodeJS = System.getenv("NODE_HOME") + "/node.exe";
    private static final String appiumJS = System.getenv("APPIUM_HOME") + "/main.js";
    private static DriverService service;
    private final String apk_url = System.getenv("APK_URL");
    private final String ipa_url = System.getenv("IPA_URL");
    private final String sauce_username = System.getenv("SAUCE_USERNAME");
    private final String sauce_accessKey = System.getenv("SAUCE_ACCESS_KEY");
    private final String serverIp = "127.0.0.1";    //Local
    private final String appiumPort = "4723";
    private final String username = System.getenv("BROWSERSTACK_USERNAME");
    private final String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final String serverUrl = "http://" + serverIp + ":" + appiumPort + "/wd/hub";
    private final String cloudURL = "https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub";
    private final String sauceURL = "https://" + sauce_username + ":" + sauce_accessKey + "@ondemand.apac-southeast-1.saucelabs.com:443/wd/hub";
    DesiredCapabilities caps = new DesiredCapabilities();

    /**
     * CreateURL
     *
     * @param cloudProvider cloud provider
     * @return cloud server url
     * @throws MalformedURLException exception
     */
    URL createURL(String cloudProvider) throws MalformedURLException {
        if (Objects.equals(cloudProvider, "sauce")) {
            log.info("Argument to driver object : " + sauceURL);
            return new URL(sauceURL);
        } else if (Objects.equals(cloudProvider, "browserstack")) {
            log.info("Argument to driver object : " + cloudURL);
            return new URL(cloudURL);
        } else {
            log.info("Argument to driver object : " + serverUrl);
            return new URL(serverUrl);
        }
    }

    /**
     * Cloud Capabilities
     *
     * @param cloudProvider cloudProvider
     * @param caps          capabilities
     * @param device        device
     * @throws IOException exception
     */
    void cloudCapabilities(String cloudProvider, DesiredCapabilities caps, String device) throws IOException {
        switch (cloudProvider) {
            case "sauce":
                saucelabsCapabilities(caps, device);
                break;
            case "browserstack":
                browserstackCapabilities(caps, device);
                break;
            default:
                createService().start();
                break;
        }
    }

    /**
     * Browserstack capabilities
     *
     * @param caps   capabilities
     * @param device device
     */
    private void browserstackCapabilities(DesiredCapabilities caps, String device) {
        switch (device) {
            case "samsung":
                caps.setCapability("platformName", "android");
                caps.setCapability("platformVersion", "10.0");
                caps.setCapability("deviceName", "Samsung Galaxy S20");
                caps.setCapability("app", apk_url);
                break;
            case "pixel":
                caps.setCapability("platformName", "android");
                caps.setCapability("platformVersion", "9.0");
                caps.setCapability("deviceName", "Google Pixel 3");
                caps.setCapability("app", apk_url);
                break;
            case "iPhone12":
                caps.setCapability("platformName", "ios");
                caps.setCapability("platformVersion", "14");
                caps.setCapability("deviceName", "iPhone 12");
                caps.setCapability("app", ipa_url);
                break;
            default:
                System.out.println("No device found");
                break;
        }
//        caps.setCapability("browserstack.appium_version", appConfig.getAppiumVersion());
//        caps.setCapability("project", appConfig.getApplicationName());
//        caps.setCapability("build", testName + sysTime());
//        caps.setCapability("name", testName);
    }

    /**
     * Saucelabs capabilities
     * https://saucelabs.com/platform/platform-configurator
     *
     * @param caps   capabilities
     * @param device device
     */
    private void saucelabsCapabilities(MutableCapabilities caps, String device) {
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("appiumVersion", "1.22.1");
//        sauceOptions.setCapability("build", "<your build id>");
//        sauceOptions.setCapability("name", "<your test name>");
        switch (device) {
            case "samsung":
                caps.setCapability("platformName", "Android");
                caps.setCapability("browserName", "Chrome");
                caps.setCapability("appium:platformVersion", "12");
                caps.setCapability("appium:deviceName", "Google Pixel 4a (5G) GoogleAPI Emulator");
                caps.setCapability("appium:orientation", "portrait");
                caps.setCapability("sauceLabsImageInjectionEnabled", true);
                caps.setCapability("autoGrantPermissions", true);
                caps.setCapability("idleTimeout", "90");
                caps.setCapability("newCommandTimeout", "90");
                caps.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                caps.setCapability("sauce:options", sauceOptions);
                break;
            case "iPhone12":
                caps.setCapability("platformName", "iOS");
                caps.setCapability("appium:platformVersion", "15.0");
                caps.setCapability("appium:deviceName", "iPhone .*");
                caps.setCapability("appium:orientation", "portrait");
                caps.setCapability("automationName", "XCUITEST");
                caps.setCapability("sauceLabsImageInjectionEnabled", true);
                caps.setCapability("autoAcceptAlerts", true);
                caps.setCapability("idleTimeout", "90");
                caps.setCapability("newCommandTimeout", "90");
                caps.setCapability("app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
                caps.setCapability("sauce:options", sauceOptions);
                break;
            default:
                System.out.println("No device found");
                break;
        }
//        caps.setCapability("username", sauce_username);
//        caps.setCapability("accessKey", sauce_accessKey);
//        caps.setCapability("deviceType", "phone");
//        caps.setCapability("deviceOrientation", "portrait");
    }

    /**
     * Android capabilities
     *
     * @param caps capabilities
     */
    void androidCapabilities(DesiredCapabilities caps) {
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(MobileCapabilityType.AUTO_WEBVIEW, false);
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, "UiAutomator2");
        caps.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 60);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.swaglabsmobileapp");
        // caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.swaglabsmobileapp.MainActivity");
    }

    /**
     * IOS capabilities
     *
     * @param caps capabilities
     */
    void iosCapabilities(DesiredCapabilities caps) {
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        caps.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        // caps.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "");
        // caps.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "");
        // caps.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "");
        caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.saucelabs.SwagLabsMobileApp");
        caps.setCapability(IOSMobileCapabilityType.APP_NAME, "com.saucelabs.SwagLabsMobileApp");
    }

    /**
     * Create appium driver service
     *
     * @return service
     */
    DriverService createService() {
        new AppiumServiceBuilder()
                .usingDriverExecutable(new File(nodeJS))
                .withAppiumJS(new File(appiumJS))
//                .withIPAddress(serverIp)
//                .usingPort(APPIUM_Port)
//                .withArgument(Arg.TIMEOUT, "120")
//                .withArgument(Arg.LOG_LEVEL, "warn")
                .build();
        return service;
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
