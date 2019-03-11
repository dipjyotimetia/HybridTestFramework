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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.net.URL;


public class WebDriverController extends DriverOptions {

    private static Logger logger = LogManager.getLogger(WebDriverController.class);

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
    protected static DesiredCapabilities performance() {
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

