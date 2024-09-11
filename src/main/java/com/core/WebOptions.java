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

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

/**
 * WebOptions is an abstract class that provides methods to configure web browsers for testing.
 * <p>
 * It includes methods for setting up Chrome, Firefox, and Edge browser options, as well as cloud capabilities
 * <p>
 * for running tests on BrowserStack and LambdaTest.
 * <p>
 * This class extends MobileOptions.
 */
@Slf4j
abstract class WebOptions extends MobileOptions {

    /**
     * Returns ChromeOptions with various settings for performance and security.
     *
     * @param perf String indicating whether performance testing is enabled ("YES" to enable, other values to disable)
     * @return ChromeOptions object with desired settings
     */
    protected ChromeOptions getChromeOptions(String perf) {
//        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments(setChromeOWASP());
        //options.addArguments("--incognito");
        //options.addArguments("--disable-extensions");
        //options.addArguments("--dns-prefetch-disable");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        if (perf.equalsIgnoreCase("YES")) {
            options.merge(DriverController.performance());
        }
        log.info("Chrome options added");
        return options;
    }

    /**
     * Returns FirefoxOptions with various settings for performance and security.
     *
     * @return FirefoxOptions object with desired settings
     */
    protected FirefoxOptions getFirefoxOptions() {
        //WebDriverManager.firefoxdriver().setup();
        //System.setProperty(FirefoxDriver.Capability.MARIONETTE, "true");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        options.addArguments("--headless=new");
        //options.setCapability(FirefoxDriver.Capability.PROFILE, profile);
        //setFirefoxOWASP(options);
        log.info("Firefox options added");
        return options;
    }

    /**
     * Get Edge Options
     *
     * @return options
     */
    protected EdgeOptions getEdgeOptions() {
//        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless=new");
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        edgeOptions.addArguments("--ignore-certificate-errors");
        edgeOptions.addArguments("--disable-popup-blocking");
        edgeOptions.addArguments("--headless=new");
        edgeOptions.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge Dev\\Application\\msedge.exe");
        return new EdgeOptions().merge(edgeOptions);
    }

    /**
     * Returns MutableCapabilities object with the specified browser options and performance settings.
     *
     * @param browser String indicating the browser to use ("chrome", "firefox", "edge")
     * @param perf    String indicating whether performance testing is enabled ("YES" to enable, other values to disable)
     * @return MutableCapabilities object with the specified browser options and performance settings
     */
    protected MutableCapabilities getBrowserOptions(String browser, String perf) {
        switch (browser) {
            case "firefox" -> {
                return getFirefoxOptions();
            }
            case "chrome" -> {
                return getChromeOptions(perf);
            }
            case "edge" -> {
                return getEdgeOptions();
            }
            default -> log.error("No browser option provided");
        }
        return null;
    }

    /**
     * Returns DesiredCapabilities object with cloud capabilities for the specified browser.
     *
     * @param browser String indicating the browser to use ("chrome", "firefox", "edge")
     * @return DesiredCapabilities object with cloud capabilities for the specified browser
     */
    protected DesiredCapabilities addCloudCapabilities(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome" -> {
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "latest");
                capabilities.setCapability("platform", "windows");
                log.info("Adding aws chrome capabilities");
            }
            case "firefox" -> {
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "latest");
                capabilities.setCapability("platform", "windows");
                log.info("Adding aws firefox capabilities");
            }
            case "edge" -> {
                capabilities.setCapability("browserName", "edge");
                capabilities.setCapability("browserVersion", "latest");
                capabilities.setCapability("platform", "windows");
                log.info("Adding aws firefox capabilities");
            }
            default -> log.info("No supported browser provided");
        }
        return capabilities;
    }

    /**
     * Returns DesiredCapabilities object with BrowserStack capabilities for the specified browser and test name.
     *
     * @param browser  String indicating the browser to use ("chrome", "firefox", "edge")
     * @param testName String containing the name of the test
     * @return DesiredCapabilities object with BrowserStack capabilities for the specified browser and test name
     */
    protected DesiredCapabilities addBrowserStackCapabilities(String browser, String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> browserStackOptions = new HashMap<>();
        browserStackOptions.put("os", "Windows");
        browserStackOptions.put("osVersion", "11");
        browserStackOptions.put("projectName", "HybridTestFramework");
        browserStackOptions.put("buildName", "BUILD_NAME");
        browserStackOptions.put("sessionName", testName);
        browserStackOptions.put("local", "false");
        browserStackOptions.put("debug", "false");
        browserStackOptions.put("consoleLogs", "info");
        browserStackOptions.put("networkLogs", "true");
        browserStackOptions.put("seleniumCdp", true);
        //browserStackOptions.put("local", "true");
        switch (browser) {
            case "chrome" -> {
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("browserVersion", "latest");
            }
            case "firefox" -> {
                capabilities.setCapability("browserName", "Firefox");
                capabilities.setCapability("browserVersion", "latest");
            }
            case "edge" -> {
                capabilities.setCapability("browserName", "Edge");
                capabilities.setCapability("browserVersion", "latest");
            }
            default -> log.info("browser selection is required");
        }
        capabilities.setCapability("bstack:options", browserStackOptions);
        return capabilities;
    }

    /**
     * Returns Capabilities object with LambdaTest capabilities for the specified browser and test name.
     *
     * @param browser  String indicating the browser to use ("chrome", "firefox", "edge")
     * @param testName String containing the name of the test
     * @return Capabilities object with LambdaTest capabilities for the specified browser and test name
     */
    protected Capabilities addLambdaTestCapabilities(String browser, String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("seCdp", true);
        ltOptions.put("project", "HybridTestFramework");
        ltOptions.put("name", testName);
        ltOptions.put("selenium_version", "4.8.0");
        switch (browser) {
            case "chrome" -> {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("111.0");
            }
            case "firefox" -> {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
            }
            case "edge" -> {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName("Windows 11");
                browserOptions.setBrowserVersion("latest");
            }
            default -> log.info("browser selection is required");
        }
        capabilities.setCapability("LT:Options", ltOptions);
        return capabilities;
    }

    /**
     * Returns LoggingPreferences object with logging preferences for various log types.
     *
     * @return LoggingPreferences object with logging preferences
     */
    private LoggingPreferences pref() {
        LoggingPreferences pref = new LoggingPreferences();
        pref.enable(LogType.BROWSER, Level.OFF);
        pref.enable(LogType.CLIENT, Level.OFF);
        pref.enable(LogType.DRIVER, Level.OFF);
        pref.enable(LogType.PERFORMANCE, Level.OFF);
        pref.enable(LogType.PROFILER, Level.OFF);
        pref.enable(LogType.SERVER, Level.OFF);
        log.info("Performance capability added");
        return pref;
    }

    /**
     * Set chrome for OWASP
     *
     * @return chromeOptions
     */
    private List<String> setChromeOWASP() {
        List<String> chromeOWASP = new ArrayList<>();
        chromeOWASP.add("--proxy-server=http://localhost:8082");
        chromeOWASP.add("--ignore-certificate-errors");
        log.info("OWASP for chrome added");
        return chromeOWASP;
    }

    /**
     * Set firefox for OWASP
     *
     * @param options firefox options
     * @return firefox options
     */
    private FirefoxOptions setFirefoxOWASP(FirefoxOptions options) {
        options.addPreference("network.proxy.type", 1);
        options.addPreference("network.proxy.http", "localhost");
        options.addPreference("network.proxy.http_port", 8082);
        options.addPreference("network.proxy.share_proxy_settings", true);
        options.addPreference("network.proxy.no_proxies_on", "");
        log.info("OWASP for firefox added");
        return options;
    }

    /**
     * Set firefox profile
     *
     * @return capability
     */
    private DesiredCapabilities fireFoxProfile() {
        ProfilesIni allProfiles = new ProfilesIni();
        FirefoxProfile myProfile = allProfiles.getProfile("WebDriver");
        if (myProfile == null) {
            File ffDir = new File(System.getProperty("user.dir") + File.separator + "ffProfile");
            if (!ffDir.exists()) {
                ffDir.mkdir();
            }
            myProfile = new FirefoxProfile(ffDir);
        }
        myProfile.setAcceptUntrustedCertificates(true);
        myProfile.setAssumeUntrustedCertificateIssuer(true);
        myProfile.setPreference("webdriver.load.strategy", "unstable");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(FirefoxDriver.SystemProperty.BROWSER_PROFILE, myProfile);
        return capabilities;
    }

    /**
     * Returns Playwright BrowserType.LaunchOptions with various settings for performance and security.
     *
     * @param headless Boolean indicating whether to run the browser in headless mode
     * @return BrowserType.LaunchOptions object with desired settings
     */
    protected LaunchOptions getPlaywrightOptions(boolean headless) {
        LaunchOptions options = new LaunchOptions();
        options.setHeadless(headless);
        options.setArgs(List.of("--ignore-certificate-errors", "--disable-popup-blocking", "--no-sandbox", "--disable-infobars", "--disable-dev-shm-usage", "--disable-browser-side-navigation", "--disable-gpu"));
        log.info("Playwright options added");
        return options;
    }

    /**
     * Initializes and returns a Playwright Browser instance with the specified options.
     *
     * @param options BrowserType.LaunchOptions object with desired settings
     * @return Browser instance
     */
    protected Browser initPlaywrightBrowser(LaunchOptions options) {
        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();
        return browserType.launch(options);
    }
}
