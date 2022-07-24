package com.core;

import com.github.javafaker.Faker;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

/**
 * @author Dipjyoti Metia
 */
@Slf4j
public class MobileActions extends DriverManager {
    private static final Faker faker = new Faker();
    private static String datetimeabc = null;
    private static int counter = 0;
    private final Map<Object, Object> dicttoread = new HashMap<>();

    /**
     * Capture screenshot
     *
     * @param name Screen name
     */
    protected void captureScreen(String name) throws Exception {
        File file = ((TakesScreenshot) mobileThread).getScreenshotAs(OutputType.FILE.FILE);
        String dest = System.getProperty("user.dir") + "\\Screenshots\\" + name + ".png";
        FileUtils.copyFile(file, new File(dest));
    }

    /**
     * Capture screens in log
     *
     * @param screenShotName screenshotName
     * @return destinationPath
     * @throws IOException exception
     */
    private String capture(String screenShotName) throws IOException {
        TakesScreenshot ts = mobileThread;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "\\Reports\\Screens\\" + screenShotName + ".png";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);
        return dest;
    }

    /**
     * Fluent wait
     *
     * @param element element
     * @param timeout timeoutInMilli
     */
    private void fluentWait(WebElement element, int timeout) {
        Wait<AppiumDriver> wait = new AppiumFluentWait<>(mobileThread)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Get Mobile ElementBY
     *
     * @param byElement byElement
     * @param mobileBy  mobileBy
     * @return by
     */
    private By getMobileElementBy(String byElement, MobileBy mobileBy) {
        By by = null;
        switch (mobileBy) {
            case ID:
                by = (By) mobileThread.findElement(By.id(byElement));
                break;
            case XPATH:
                by = (By) mobileThread.findElement(By.xpath(byElement));
                break;
            case NAME:
                by = (By) mobileThread.findElement(By.name(byElement));
                break;
            case CLASS:
                by = (By) mobileThread.findElement(By.className(byElement));
                break;
        }
        return by;
    }

    /**
     * Get mobile element
     *
     * @param mobileElement mobileElement
     * @param mobileBy      typeOf element
     * @return element
     * @throws Exception exception
     */
    private WebElement getMobileElement(String mobileElement, MobileBy mobileBy) throws Exception {
        WebElement element = null;
        switch (mobileBy) {
            case XPATH:
                element = mobileThread.findElement(By.xpath(mobileElement));
                break;
            case ID:
                element = mobileThread.findElement(By.id(mobileElement));
                break;
            case NAME:
                element = mobileThread.findElement(By.name(mobileElement));
                break;
            case CLASS:
                element = mobileThread.findElement(By.className(mobileElement));
                break;
            default:
                log.info("Element type not found");
                break;
        }
        if (element == null) {
            log.error("Mobile element not found");
            throw new Exception(mobileElement + "not found");
        }
        return element;
    }

    /**
     * Click on element
     *
     * @param element element
     */
    protected void click(WebElement element) {
        try {
            fluentWait(element, 10);
            element.click();
            log.info("Clicked on element: " + element);
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
    }

    /**
     * Click
     *
     * @param element     mobileElement
     * @param elementType elementType
     */
    public void click(String element, MobileBy elementType) throws Exception {
        click(getMobileElement(element, elementType));
    }

    /**
     * Click on element with timeout
     *
     * @param element element
     * @param timeOut timeOut
     */
    public void click(WebElement element, int timeOut) {
        try {
            fluentWait(element, timeOut);
            element.click();
            log.info("Clicked on element: " + element);
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
    }

    /**
     * Enter value in text field
     *
     * @param element element
     * @param value   value
     */
    protected void enter(WebElement element, String value) {
        try {
            fluentWait(element, 10);
            element.click();
            element.sendKeys(value);
            log.info("Entered value: " + value + "on element: " + element);
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
    }

    /**
     * Enter
     *
     * @param element     mobileElement
     * @param elementType elementType
     * @param value       value
     */
    protected void enter(String element, MobileBy elementType, String value) throws Exception {
        enter(getMobileElement(element, elementType), value);
    }


    /**
     * Element is displaying
     *
     * @param element element
     * @return boolean
     */
    public boolean isDisplayed(WebElement element) throws Exception {
        if (element.isDisplayed()) {
            log.info(element + ": element is Displayed");
            return true;
        } else {
            log.error("Element is not displayed");
        }
        return false;
    }

    /**
     * Element is enabled
     *
     * @param element element
     * @return boolean
     */
    protected boolean isEnabled(WebElement element) {
        if (element.isEnabled()) {
            log.info(element + ": element is Enabled");
            return true;
        }
        return false;
    }


    /**
     * Element is Selected
     *
     * @param element element
     * @return boolean
     */
    protected boolean isSelected(WebElement element) {
        if (element.isSelected()) {
            log.info(element + ": element is Selected");
            return true;
        }
        return false;
    }

    /**
     * Is Exists
     *
     * @param element     mobileElement
     * @param elementType elementType
     * @return boolean
     */
    protected boolean isExist(String element, MobileBy elementType) {
        boolean returnValue = false;
        switch (elementType) {
            case XPATH:
                if (mobileThread.findElements(By.xpath(element)).size() != 0) {
                    log.info(element + ": element is exists");
                    returnValue = true;
                }
            case ID:
                if (mobileThread.findElements(By.id(element)).size() != 0) {
                    log.info(element + ": element is exists");
                    returnValue = true;
                }
            case CLASS:
                if (mobileThread.findElements(By.className(element)).size() != 0) {
                    log.info(element + ": element is exists");
                    returnValue = true;
                }
            default:
                log.info("Element type is not available");
                break;
        }
        return returnValue;
    }


    /**
     * Wait for page to get loaded
     *
     * @param id locatorId
     */
    private void waitForPageToLoad(WebElement id) {
        WebDriverWait wait = new WebDriverWait(mobileThread, Duration.ofSeconds(35));
        wait.until((Function<? super WebDriver, ?>) ExpectedConditions.elementToBeClickable(id));
    }

    /**
     * Wait for element to be displayed
     *
     * @param arg element
     */
    public void waitForElement(WebElement arg) {
        waitForPageToLoad(arg);
    }

    public enum MobileBy {
        XPATH, ID, NAME, CLASS, ACCESS_ID
    }

}
