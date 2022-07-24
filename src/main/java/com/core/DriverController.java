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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.devicefarm.DeviceFarmClient;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlRequest;
import software.amazon.awssdk.services.devicefarm.model.CreateTestGridUrlResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;


@Slf4j
public class DriverController extends WebOptions {
    private static WebDriver _driverThread = null;
    private static AppiumDriver _mobileThread = null;
    private static BrowserMobProxyServer proxy;
    private final String username = System.getenv("BROWSERSTACK_USERNAME");
    private final String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private String testName = null;

    @Parameters({"type", "browser", "device", "grid", "perf"})
    @BeforeClass
    public void setup(String type, String browser, String device, String grid, String perf) {
        testName = this.getClass().getName().substring(24);
        switch (type) {
            case "web":
                initWebDriver(browser, grid, perf);
                break;
            case "mobile":
                initMobileDriver(device, grid);
                break;
            default:
                log.info("select test type to proceed with one testing");
        }
    }

    public WebDriver getWebDriver() {
        return _driverThread;
    }

    public AppiumDriver getMobileDriver() {
        return _mobileThread;
    }

    /**
     * Initialize web driver
     *
     * @param browser browser
     * @param grid    grid
     * @param perf    perf
     */
    private synchronized void initWebDriver(String browser, String grid, String perf) {
        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.AP_SOUTHEAST_2).build();
        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
                .expiresInSeconds(300)
                .projectArn("arn:aws:devicefarm:ap-southeast-2:111122223333:testgrid-project:1111111-2222-3333-4444-555555555")
                .build();
        try {
            switch (grid) {
                case "CLOUD":
                    log.info("Make sure that the environment variables AWS_ACCESS_KEY and AWS_SECRET_KEY are configured in your testing environment.");
                    CreateTestGridUrlResponse response = client.createTestGridUrl(request);
                    _driverThread = new RemoteWebDriver(new URL(response.url()), addCloudCapabilities(browser));
                    log.info("Grid client setup for AWS Device farm successful");
                    break;
                case "DOCKER":
                    log.info("Make sure that docker containers are up and running");
                    _driverThread = new RemoteWebDriver(URI.create("http://localhost:4444/").toURL(), getBrowserOptions(browser, perf));
                    log.info("Grid client setup for Docker containers successful");
                    break;
                case "browserstack":
                    log.info("Make sure that browserstack configs provided");
                    _driverThread = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), addBrowserStackCapabilities(browser, testName));
                    log.info("Grid client setup for browserstack successful");
                    break;
                case "LOCAL":
                    switch (browser) {
                        case "firefox":
                            _driverThread = new FirefoxDriver(getFirefoxOptions());
                            log.info("Initiating firefox driver");
                            break;
                        case "chrome":
                            _driverThread = new ChromeDriver(getChromeOptions(perf));
                            log.info("Initiating chrome driver");
                            break;
                        case "edge":
                            _driverThread = new EdgeDriver(getEdgeOptions());
                            log.info("Initiating edge driver");
                            break;
                        default:
                            log.info("Browser listed not supported");
                    }
                default:
                    log.info("Running in local docker container");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Initialize mobile driver
     *
     * @param device device
     */
    private synchronized void initMobileDriver(String device, String cloud) {
        try {
            switch (device) {
                case "NEXUS":
                    log.info("Selected device is NEXUS");
                    _caps.setCapability(MobileCapabilityType.UDID, "NEXUS");
                    _caps.setCapability(MobileCapabilityType.DEVICE_NAME, "NEXUS");
                    _androidCapabilities(_caps);
                    _cloudCapabilities(cloud, _caps, "NEXUS");
                    _mobileThread = new AndroidDriver(createURL(cloud), _caps);
                    break;
                case "PIXEL":
                    log.info("Selected device is PIXEL");
                    _caps.setCapability(MobileCapabilityType.UDID, "PIXEL");
                    _caps.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL");
                    _androidCapabilities(_caps);
                    _cloudCapabilities(cloud, _caps, "PIXEL");
                    _mobileThread = new AndroidDriver(createURL(cloud), _caps);
                    break;
                case "samsung":
                    log.info("Selected device is SAMSUNG");
                    _cloudCapabilities(cloud, _caps, "samsung");
                    _androidCapabilities(_caps);
                    _mobileThread = new AndroidDriver(createURL(cloud), _caps);
                    break;
                case "iPhone12":
                    log.info("Selected device is IPHONE");
                    _cloudCapabilities(cloud, _caps, "iPhone12");
                    _iosCapabilities(_caps);
                    _mobileThread = new IOSDriver(createURL(cloud), _caps);
                    break;
                case "IPHONE":
                    log.info("Selected device is IPHONE");
                    _caps.setCapability(MobileCapabilityType.UDID, "iphone");
                    _caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iphone");
                    _iosCapabilities(_caps);
                    _cloudCapabilities(cloud, _caps, "IPHONE");
                    _mobileThread = new IOSDriver(createURL(cloud), _caps);
                    break;
                case "WEB":
                    log.info("Selected device is WEB");
                    _caps.setCapability(MobileCapabilityType.UDID, "NEXUS");
                    _caps.setCapability(MobileCapabilityType.DEVICE_NAME, "NEXUS");
                    _createService().start();
                    _cloudCapabilities(cloud, _caps, "WEB");
                    _mobileThread = new AndroidDriver(createURL(cloud), _caps);
                    break;
            }
        } catch (NullPointerException |
                 MalformedURLException ex) {
            log.error("Appium driver could not be initialised for device", ex);
            throw new RuntimeException("Appium driver could not be initialised for device: " + device);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        log.info("Driver initialized");
    }

    /**
     * Added performance capability
     *
     * @return capabilities
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
            if (_driverThread != null) {
                _driverThread.quit();
            } else {
                _mobileThread.quit();
                _createService().stop();
                _stopAppiumServer();
            }
        }
    }
}

