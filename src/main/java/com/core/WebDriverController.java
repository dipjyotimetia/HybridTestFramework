package com.core;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.net.URL;
import java.util.logging.Level;


public class WebDriverController {

    private Logger logger = LogManager.getLogger(WebDriverController.class);

    private static WebDriver _driverThread = null;
    private static BrowserMobProxyServer proxy;
    private String testName = null;


    @Parameters({"browser", "grid", "perf"})
    @BeforeClass
    public void setup(String browser, String grid, String perf) {
        testName = this.getClass().getName().substring(24);
        initDriver(browser, grid, perf);
    }

    public WebDriver getDriver() {
        return _driverThread;
    }

    /**
     * Initialize driver
     *
     * @param browser browser
     * @param grid    grid
     * @param perf    perf
     */
    private synchronized void initDriver(String browser, String grid, String perf) {
        try {
            switch (browser) {
                case "firefox":
                    _driverThread = new FirefoxDriver(getFirefoxOptions());
                    _driverThread.manage().window().maximize();
                    if (grid.equalsIgnoreCase("YES")) {
                        _driverThread = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getFirefoxOptions());
                    }
                    break;
                case "chrome":
                    //FileSystem.downloadDriver();
                    _driverThread = new ChromeDriver(getChromeOptions(perf));
                    _driverThread.manage().window().maximize();
                    if (grid.equalsIgnoreCase("YES")) {
                        _driverThread = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getChromeOptions(perf));
                    }
                    break;
                case "ie":
                    _driverThread = new InternetExplorerDriver(getIEOptions());
                    _driverThread.manage().window().maximize();
                    if (grid.equalsIgnoreCase("YES")) {
                        _driverThread = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), getIEOptions());
                    }
                    break;
                default:
                    logger.info("Please provide valid browser details");
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Added performance capability
     *
     * @return capabilities
     */
    private DesiredCapabilities performance() {
        proxy = new BrowserMobProxyServer();
        proxy.start();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        } catch (Exception e) {
            logger.error(e);
        }
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar("TestPerformance");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, seleniumProxy);
        return caps;
    }


    /**
     * get chrome options
     *
     * @param perf perf option
     * @return chrome
     */
    private ChromeOptions getChromeOptions(String perf) {
        System.setProperty("webdriver.chrome.driver", "Driver/win/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        if (perf.equalsIgnoreCase("YES")) {
            options.merge(performance());
        }
        return options;
    }

    /**
     * get firefox options
     *
     * @return options
     */
    private FirefoxOptions getFirefoxOptions() {
        System.setProperty("webdriver.gecko.driver", "Driver/win/geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        profile.setPreference("network.proxy.type", 0);
        //options.setHeadless(true);
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    /**
     * get IE options
     * @return options
     */
    private InternetExplorerOptions getIEOptions() {
        System.setProperty("webdriver.ie.driver", "Driver/win/IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
        options.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
        options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        options.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        return options;
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

        return pref;
    }

    @AfterClass
    public void tearDown() {
        try {
            Har har = proxy.getHar();
            FileOutputStream fos = new FileOutputStream("Reports\\performance\\" + testName + ".har");
            har.writeTo(fos);
            proxy.stop();
        } catch (Exception e) {
            logger.info("Performance tests not included");
        } finally {
            _driverThread.quit();
        }
    }
}

