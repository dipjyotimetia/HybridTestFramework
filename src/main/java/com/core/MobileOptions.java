package com.core;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.OS;
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
    DesiredCapabilities _caps = new DesiredCapabilities();
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
    private final String sauceURL = "https://" + sauce_username + ":" + sauce_accessKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";

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
     * @param _caps         capabilities
     * @param device        device
     * @throws IOException exception
     */
    void _cloudCapabilities(String cloudProvider, DesiredCapabilities _caps, String device) throws IOException {
        switch (cloudProvider) {
            case "sause":
                _saucelabsCapabilities(_caps, device);
                break;
            case "browserstack":
                _browserstackCapabilities(_caps, device);
                break;
            default:
                _createService().start();
                break;
        }
    }

    /**
     * Browserstack capabilities
     *
     * @param _caps  capabilities
     * @param device device
     */
    private void _browserstackCapabilities(DesiredCapabilities _caps, String device) {
        switch (device) {
            case "samsung":
                _caps.setCapability("platformName", "android");
                _caps.setCapability("platformVersion", "10.0");
                _caps.setCapability("deviceName", "Samsung Galaxy S20");
                _caps.setCapability("app", apk_url);
                break;
            case "pixel":
                _caps.setCapability("platformName", "android");
                _caps.setCapability("platformVersion", "9.0");
                _caps.setCapability("deviceName", "Google Pixel 3");
                _caps.setCapability("app", apk_url);
                break;
            case "iPhone12":
                _caps.setCapability("platformName", "ios");
                _caps.setCapability("platformVersion", "14");
                _caps.setCapability("deviceName", "iPhone 12");
                _caps.setCapability("app", ipa_url);
                break;
            default:
                System.out.println("No device found");
                break;
        }
//        _caps.setCapability("browserstack.appium_version", appConfig.getAppiumVersion());
//        _caps.setCapability("project", appConfig.getApplicationName());
//        _caps.setCapability("build", testName + sysTime());
//        _caps.setCapability("name", testName);
    }

    /**
     * Saucelabs capabilities
     * https://saucelabs.com/platform/platform-configurator
     *
     * @param _caps  capabilities
     * @param device device
     */
    private void _saucelabsCapabilities(DesiredCapabilities _caps, String device) {
        switch (device) {
            case "samsung":
                _caps.setCapability("platformName", "Android");
                _caps.setCapability("appium:platformVersion", "11");
                _caps.setCapability("appium:deviceName", "Samsung.*Galaxy.*");
                _caps.setCapability("appium:orientation", "portrait");
                _caps.setCapability("sauceLabsImageInjectionEnabled", true);
                _caps.setCapability("autoGrantPermissions", true);
                _caps.setCapability("idleTimeout", "90");
                _caps.setCapability("newCommandTimeout", "90");
                _caps.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
                break;
            case "iPhone12":
                _caps.setCapability("platformName", "iOS");
                _caps.setCapability("appium:platformVersion", "15.0");
                _caps.setCapability("appium:deviceName", "iPhone .*");
                _caps.setCapability("appium:orientation", "portrait");
                _caps.setCapability("automationName", "XCUITEST");
                _caps.setCapability("sauceLabsImageInjectionEnabled", true);
                _caps.setCapability("autoAcceptAlerts", true);
                _caps.setCapability("idleTimeout", "90");
                _caps.setCapability("newCommandTimeout", "90");
                _caps.setCapability("app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");
                break;
            default:
                System.out.println("No device found");
                break;
        }
        _caps.setCapability("username", sauce_username);
        _caps.setCapability("accessKey", sauce_accessKey);
        _caps.setCapability("deviceType", "phone");
        _caps.setCapability("deviceOrientation", "portrait");
    }

    /**
     * Android capabilities
     *
     * @param _caps capabilities
     */
    void _androidCapabilities(DesiredCapabilities _caps) {
        _caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        _caps.setCapability(MobileCapabilityType.NO_RESET, true);
        _caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        _caps.setCapability(MobileCapabilityType.AUTO_WEBVIEW, false);
        _caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        _caps.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, "UiAutomator2");
        _caps.setCapability(AndroidMobileCapabilityType.ANDROID_INSTALL_TIMEOUT, 60);
        _caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.swaglabsmobileapp");
        // _caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.swaglabsmobileapp.MainActivity");
    }

    /**
     * IOS capabilities
     *
     * @param _caps capabilities
     */
    void _iosCapabilities(DesiredCapabilities _caps) {
        _caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        _caps.setCapability(MobileCapabilityType.FULL_RESET, false);
        _caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        _caps.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, "XCUITest");
        _caps.setCapability(MobileCapabilityType.NO_RESET, true);
        // _caps.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "");
        // _caps.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "");
        // _caps.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "");
        _caps.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.saucelabs.SwagLabsMobileApp");
        _caps.setCapability(IOSMobileCapabilityType.APP_NAME, "com.saucelabs.SwagLabsMobileApp");
    }

    /**
     * Create appium driver service
     *
     * @return service
     */
    DriverService _createService() {
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
    public void _stopAppiumServer() {
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
