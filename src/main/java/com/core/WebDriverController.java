package com.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.URL;


public class WebDriverController {

    private static WebDriver _driverThread = null;

    @Parameters({"browser","grid"})
    @BeforeClass
    public void setup(String browser,String grid){
        initDriver(browser,grid);
    }

    public WebDriver getDriver(){
        return _driverThread;
    }

    //Get Chrome Options
    public static ChromeOptions getChromeOptions() {
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        //options.addArguments("--incognito");
        return options;
        /*ChromeDriverService service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        ChromeDriver driver = new ChromeDriver(service, options);*/
    }

    //Get Firefox Options
    public static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile profile = new FirefoxProfile();
        //Accept Untrusted Certificates
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        //Use No Proxy Settings
        profile.setPreference("network.proxy.type", 0);
        //Set Firefox profile to capabilities
        options.setCapability(FirefoxDriver.PROFILE, profile);
        return options;
    }

    public synchronized static void initDriver (String browser,String grid) {
        try {
            if (browser.equals("firefox")) {
                _driverThread = new FirefoxDriver(getFirefoxOptions());
                if (grid.equalsIgnoreCase("YES")){
                    _driverThread = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),getFirefoxOptions());
                }
            } else if (browser.equals("chrome")) {
                _driverThread = new ChromeDriver(getChromeOptions());
                if (grid.equalsIgnoreCase("YES")){
                    _driverThread = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),getChromeOptions());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
//        try {
//            Har har = server.getHar();
//            FileOutputStream fos = new FileOutputStream("C:\\temp\\perf.har");
//            har.writeTo(fos);
//            server.stop();
//        } catch (Exception e) {
//            logger.info("Performance test not included");
//        }
        _driverThread.quit();
    }

}

