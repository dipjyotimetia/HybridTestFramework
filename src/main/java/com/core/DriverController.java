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

import com.config.AppConfig;
import com.typesafe.config.ConfigFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.net.URI;

/**
 * Driver controller
 */
@Slf4j
public class DriverController extends WebOptions {
    private static final AppConfig appConfig = new AppConfig(ConfigFactory.load());
    private static WebDriver driverThread = null;
    private static BrowserMobProxyServer proxy;
    DriverService appiumService = null;
    private String testName = null;

    /**
     * Configures and returns desired capabilities for performance testing.
     * Initializes the BrowserMobProxy server and sets the required proxy settings.
     *
     * @return DesiredCapabilities object with performance testing capabilities
     */
    protected static DesiredCapabilities performance() {
        log.info("Make sure that Docker containers are up and running");
        proxy = new BrowserMobProxyServer();
        proxy.start();
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        try {
            String hostIp = Inet4Address.getLocalHost().getHostAddress();
            seleniumProxy.setHttpProxy(hostIp + ":" + proxy.getPort());
            seleniumProxy.setSslProxy(hostIp + ":" + proxy.getPort());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
        proxy.newHar("TestPerformance");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, seleniumProxy);
        return caps;
    }

    /**
     * Initializes the appropriate driver (web or mobile) based on the provided parameters.
     * This method should be invoked before executing any test.
     *
     * @param type    The type of test to run, either "web" or "mobile"
     * @param browser The browser to use for web testing (e.g. "chrome", "firefox", "edge")
     * @param device  The mobile device to use for mobile testing (e.g. "NEXUS", "PIXEL", "samsung", "iPhone14", "IPHONE", "EMULATOR")
     * @param grid    The environment to run the test in (e.g. "aws", "docker", "browserstack", "lambda", "local")
     * @param perf    Flag to enable performance testing ("true" to enable, "false" to disable)
     */
    @Parameters({"type", "browser", "device", "grid", "perf"})
    @BeforeClass
    public void setup(String type, String browser, String device, String grid, String perf) {
        testName = this.getClass().getName().substring(24);
        switch (type) {
            case "web" -> initWebDriver(browser, grid, perf);
            case "mobile" -> initMobileDriver(device, grid);
            default -> log.info("select test type to proceed with one testing");
        }
    }

    /**
     * Returns the AppConfig object, which provides application configurations.
     *
     * @return AppConfig object with application configurations
     */
    public AppConfig getAppConfig() {
        return appConfig;
    }

    /**
     * Returns the WebDriver object for the current test.
     *
     * @return WebDriver object for the current test
     */
    public WebDriver getWebDriver() {
        return driverThread;
    }

    /**
     * Initializes the web driver based on the provided browser, grid, and performance testing flag.
     * Supports running tests on local and remote environments.
     *
     * @param browser The browser to use for web testing (e.g. "chrome", "firefox", "edge")
     * @param grid    The environment to run the test in (e.g. "aws", "docker", "browserstack", "lambda", "local")
     * @param perf    Flag to enable performance testing ("true" to enable, "false" to disable)
     */
    private synchronized void initWebDriver(String browser, String grid, String perf) {
            try {
                switch (grid) {
                    case "docker":
                        log.info("Make sure that docker containers are up and running");
                        driverThread = new RemoteWebDriver(URI.create("http://localhost:4445/wd/hub").toURL(), getBrowserOptions(browser, perf),false);
                        log.info("Grid client setup for Docker containers successful");
                        break;
                    case "browserstack":
                        log.info("Make sure that browserstack configs provided");
                        driverThread = new RemoteWebDriver(createURL("browserstack"), addBrowserStackCapabilities(browser, testName),false);
                        log.info("Grid client setup for browserstack successful");
                        break;
                    case "lambda":
                        log.info("Make sure that lambda configs provided");
                        driverThread = new RemoteWebDriver(createURL("lambda"), addLambdaTestCapabilities(browser, testName),false);
                        log.info("Grid client setup for lambda successful");
                        break;
                    case "local":
                        switch (browser) {
                            case "firefox" -> {
                                driverThread = new FirefoxDriver(getFirefoxOptions());
                                log.info("Initiating firefox driver");
                            }
                            case "chrome" -> {
                                driverThread = new ChromeDriver(getChromeOptions(perf));
                                log.info("Initiating chrome driver");
                            }
                            case "edge" -> {
                                driverThread = new EdgeDriver(getEdgeOptions());
                                log.info("Initiating edge driver");
                            }
                            default -> log.info("Browser listed not supported");
                        }
                    default:
                        log.info("Running in local docker container");
                        break;
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
    }

    /**
     * Initializes the mobile driver based on the provided device and cloud platform.
     * Supports running tests on local and remote environments.
     *
     * @param device The mobile device to use for mobile testing (e.g. "NEXUS", "PIXEL", "samsung", "iPhone14", "IPHONE", "EMULATOR")
     * @param cloud  The cloud platform to use for remote testing (e.g. "aws", "docker", "browserstack", "lambda", "local")
     */
    private synchronized void initMobileDriver(String device, String cloud) {
        try {
            switch (device) {
                case "s23" -> {
                    log.info("Selected device is SAMSUNG");
                    androidAppPkg(caps);
                    cloudMobileCapabilities(cloud, caps, "samsung");
                    driverThread = new RemoteWebDriver(createURL(cloud), caps);
                }
                case "iPhone16" -> {
                    log.info("Selected device is IPHONE");
                    iosAppPkg(caps);
                    cloudMobileCapabilities(cloud, caps, "iPhone14");
                    driverThread = new RemoteWebDriver(createURL(cloud), caps);
                }
                case "EMULATOR" -> {
                    log.info("Selected device is EMULATOR");
                    appiumService = createAppiumService();
                    caps.setCapability(UiAutomator2Options.UDID_OPTION, "NEXUS");
                    caps.setCapability(UiAutomator2Options.DEVICE_NAME_OPTION, "NEXUS");
                    appiumService.start();
                    driverThread = new AndroidDriver(createURL(cloud), caps);
                }
                default -> log.info("Required device selection");
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
    }

    /**
     * Clean up after running tests. If performance testing was enabled, save the HAR file to the Reports folder.
     * Close the WebDriver and stop the Appium server if it was used.
     */
    @AfterClass
    public void tearDown() {
        try {
            Har har = proxy.getHar();
            FileOutputStream fos = new FileOutputStream("Reports\\performance\\" + testName + ".har");
            har.writeTo(fos);
            proxy.stop();
            log.info("Performance reports will be available at Report folder");
        } catch (Exception e) {
            log.info("Performance tests not included");
        } finally {
            if (driverThread != null) {
                driverThread.quit();
            } else {
                if (appiumService != null) {
                    appiumService.stop();
                    stopAppiumServer();
                }
            }
        }
    }
}
