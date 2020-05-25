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

import org.apache.commons.lang.SystemUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

abstract class DriverOptions<T> {
    private final Logger logger = LogManager.getLogger(DriverOptions.class);

    /**
     * get chrome options
     *
     * @param perf perf option
     * @return chrome
     */
    protected ChromeOptions getChromeOptions(String perf) {
        setChromeSystemProperty();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(SystemUtils.IS_OS_LINUX);
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
            options.merge(WebDriverController.performance());
        }
        logger.info("Chrome options added");
        return options;
    }

    /**
     * Get firefox options
     *
     * @return options
     */
    protected FirefoxOptions getFirefoxOptions() {
        setFirefoxSystemProperty();
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        options.setHeadless(SystemUtils.IS_OS_LINUX);
        options.setCapability(FirefoxDriver.PROFILE, profile);
        //setFirefoxOWASP(options);
        logger.info("Firefox options added");
        return options;
    }

    /**
     * Get IE options
     *
     * @return options
     */
    protected InternetExplorerOptions getIEOptions() {
        System.setProperty("webdriver.ie.driver", "Driver/win/IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        logger.info("IE options added");
        return options;
    }

    /**
     * Get Edge Options
     *
     * @return options
     */
    protected EdgeOptions getEdgeOptions() {
        System.setProperty("webdriver.edge.driver", "Driver/win/msedgedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.setBinary(
                "C:\\Program Files (x86)\\Microsoft\\Edge Dev\\Application\\msedge.exe");
        return new EdgeOptions().merge(chromeOptions);
    }

    /**
     * Get Browser options
     *
     * @param browser browser
     * @param perf    perf
     * @return browserOption
     */
    protected T getBrowserOptions(String browser, String perf) {
        switch (browser) {
            case "firefox":
                return (T) getFirefoxOptions();
            case "chrome":
                return (T) getChromeOptions(perf);
            case "ie":
                return (T) getIEOptions();
            case "edge":
                return (T) getEdgeOptions();
            default:
                return (T) "";
        }
    }

    /**
     * Cloud capabilities
     *
     * @param browser browser
     */
    protected DesiredCapabilities addCloudCapabilities(String browser) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (browser) {
            case "chrome":
                capabilities.setCapability("browserName", "chrome");
                capabilities.setCapability("browserVersion", "81");
                capabilities.setCapability("platform", "windows");
                logger.info("Adding aws chrome capabilities");
                break;
            case "firefox":
                capabilities.setCapability("browserName", "firefox");
                capabilities.setCapability("browserVersion", "75");
                capabilities.setCapability("platform", "windows");
                logger.info("Adding aws firefox capabilities");
                break;
            case "ie":
                capabilities.setCapability("browserName", "internet explorer");
                capabilities.setCapability("browserVersion", "11");
                capabilities.setCapability("platform", "windows");
                logger.info("Adding aws firefox capabilities");
                break;
            default:
                logger.info("No supported browser provided");
        }
        return capabilities;
    }

    /**
     * Add browserstack capabilities
     */
    protected DesiredCapabilities addBrowserStackCapabilities(String browser, String testName) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "10");
        capabilities.setCapability("build", "HybridTestFramework");
        capabilities.setCapability("name", testName);
        switch (browser) {
            case "chrome":
                capabilities.setCapability("browser", "Chrome");
                capabilities.setCapability("browser_version", "81.0");
                break;
            case "firefox":
                capabilities.setCapability("browser", "Firefox");
                capabilities.setCapability("browser_version", "76.0");
                break;
            case "ie":
                capabilities.setCapability("browser", "IE");
                capabilities.setCapability("browser_version", "11.0");
                break;
            case "edge":
                capabilities.setCapability("browser", "Edge");
                capabilities.setCapability("browser_version", "81.0");
                break;
        }
        return capabilities;
    }

    /**
     * Set chrome system property
     */
    private void setChromeSystemProperty() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", "Driver/win/chromedriver.exe");
        } else if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "Driver/linux/chromedriver");
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            System.setProperty("webdriver.chrome.driver", "Driver/mac/chromedriver");
        }
    }

    /**
     * Set firefox system property
     */
    private void setFirefoxSystemProperty() {
        if (SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.gecko.driver", "Driver/win/geckodriver.exe");
        } else if (SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.gecko.driver", "Driver/linux/geckodriver");
        } else if (SystemUtils.IS_OS_MAC_OSX) {
            System.setProperty("webdriver.gecko.driver", "Driver/mac/geckodriver");
        }
    }

    /**
     * logging preference
     *
     * @return prefs
     */
    private LoggingPreferences pref() {
        LoggingPreferences pref = new LoggingPreferences();
        pref.enable(LogType.BROWSER, Level.OFF);
        pref.enable(LogType.CLIENT, Level.OFF);
        pref.enable(LogType.DRIVER, Level.OFF);
        pref.enable(LogType.PERFORMANCE, Level.OFF);
        pref.enable(LogType.PROFILER, Level.OFF);
        pref.enable(LogType.SERVER, Level.OFF);
        logger.info("Performance capability added");
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
        logger.info("OWASP for chrome added");
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
        logger.info("OWASP for firefox added");
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
        capabilities.setCapability(FirefoxDriver.PROFILE, myProfile);
        return capabilities;
    }

}
