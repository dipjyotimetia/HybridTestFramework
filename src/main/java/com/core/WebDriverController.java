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

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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

import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.net.URI;
import java.net.URL;


public class WebDriverController<T> extends DriverOptions<T> {

    private static final Logger logger = LogManager.getLogger(WebDriverController.class);

    private static WebDriver _driverThread = null;
    private static BrowserMobProxyServer proxy;
    private final String username = System.getenv("BROWSERSTACK_USERNAME");
    private final String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
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
        DeviceFarmClient client = DeviceFarmClient.builder().region(Region.AP_SOUTHEAST_2).build();
        CreateTestGridUrlRequest request = CreateTestGridUrlRequest.builder()
                .expiresInSeconds(300)
                .projectArn("arn:aws:devicefarm:ap-southeast-2:111122223333:testgrid-project:1111111-2222-3333-4444-555555555")
                .build();
        try {
            switch (grid) {
                case "CLOUD":
                    logger.info("Make sure that the environment variables AWS_ACCESS_KEY and AWS_SECRET_KEY are configured in your testing environment.");
                    CreateTestGridUrlResponse response = client.createTestGridUrl(request);
                    _driverThread = new RemoteWebDriver(new URL(response.url()), addCloudCapabilities(browser));
                    logger.info("Grid client setup for AWS Device farm successful");
                    break;
                case "DOCKER":
                    logger.info("Make sure that docker containers are up and running");
                    _driverThread = new RemoteWebDriver(URI.create("http://localhost:4444/").toURL(), (Capabilities) getBrowserOptions(browser, perf));
                    logger.info("Grid client setup for Docker containers successful");
                    break;
                case "BROWSERSTACK":
                    logger.info("Make sure that browserstack configs provided");
                    _driverThread = new RemoteWebDriver(new URL("http://" + username + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), addBrowserStackCapabilities(browser, testName));
                    logger.info("Grid client setup for browserstack successful");
                    break;
                case "LOCAL":
                    switch (browser) {
                        case "firefox":
                            _driverThread = new FirefoxDriver(getFirefoxOptions());
                            logger.info("Initiating firefox driver");
                            break;
                        case "chrome":
                            _driverThread = new ChromeDriver(getChromeOptions(perf));
                            logger.info("Initiating chrome driver");
                            break;
                        case "ie":
                            _driverThread = new InternetExplorerDriver(getIEOptions());
                            logger.info("Initiating ie driver");
                            break;
                        case "edge":
                            _driverThread = new EdgeDriver(getEdgeOptions());
                            logger.info("Initiating edge driver");
                            break;
                        default:
                            logger.info("Browser listed not supported");
                    }
                default:
                    logger.info("Running in local docker container");
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
        logger.info("Make sure that Docker containers are up and running");
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
            logger.info("Performance reports will be available at Report folder");
        } catch (Exception e) {
            logger.info("Performance tests not included");
        } finally {
            _driverThread.quit();
        }
    }
}

