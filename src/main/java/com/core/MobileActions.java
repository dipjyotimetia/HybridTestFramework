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

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Ordering;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.android.*;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;
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
    private By getWebElementBy(String byElement, MobileBy mobileBy) {
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
    private WebElement getWebElement(String mobileElement, MobileBy mobileBy) throws Exception {
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
        }
        return element;
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
     * is present
     *
     * @param elements elements
     * @return boolean
     */
    protected boolean isPresent(List<WebElement> elements) {
        if (elements.size() != 0) {
            log.info(elements + ": element is Present");
            return true;
        }
        return false;
    }

    /**
     * Get page source
     *
     * @return pageSource
     */
    public String getPageSource() {
        return mobileThread.getPageSource();
    }


    /**
     * Verify text content
     *
     * @param actual   actual
     * @param expected expected
     */
    public void verifyTextContent(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    /**
     * Get Text content
     *
     * @param containText contain text
     * @return text
     */
    public String getTextContent(String containText) {
        return mobileThread.findElement(By.xpath("//*[contains(text(),'" + containText + "')]")).getText();
    }

    /**
     * Is Text present
     *
     * @param containsText contains text
     * @return boolean
     */
    public boolean isTextPresent(String containsText) throws Exception {
        if (mobileThread.getPageSource().contains(containsText)) {
            return true;
        } else {
            log.error("Text is not present");
        }
        return false;
    }

    /**
     * NetworkSPeed Android
     *
     * @param networkSpeed networkSpeed
     */
    public void networkSpeedAndroid(String networkSpeed) {
        switch (networkSpeed) {
            case "FULL":
                ((AndroidDriver) mobileThread).setNetworkSpeed(NetworkSpeed.FULL);
                break;
            case "GPRS":
                ((AndroidDriver) mobileThread).setNetworkSpeed(NetworkSpeed.GPRS);
                break;
            case "HSDPA":
                ((AndroidDriver) mobileThread).setNetworkSpeed(NetworkSpeed.HSDPA);
                break;
            case "LTE":
                ((AndroidDriver) mobileThread).setNetworkSpeed(NetworkSpeed.LTE);
                break;
            default:
                log.info("network speed not available");
                break;
        }
    }

    /**
     * SignalStrength Android
     *
     * @param signalStrength signalStrength
     */
    public void signalStrengthAndroid(String signalStrength) {
        switch (signalStrength) {
            case "GREAT":
                ((AndroidDriver) mobileThread).setGsmSignalStrength(GsmSignalStrength.GREAT);
                break;
            case "MODERATE":
                ((AndroidDriver) mobileThread).setGsmSignalStrength(GsmSignalStrength.MODERATE);
                break;
            case "NONE":
                ((AndroidDriver) mobileThread).setGsmSignalStrength(GsmSignalStrength.NONE_OR_UNKNOWN);
                break;
            default:
                log.info("Signal Strength not available");
                break;
        }
    }

    /**
     * SignalStrength Android
     *
     * @param voiceState voiceState
     */
    public void voiceStateAndroid(String voiceState) {
        switch (voiceState) {
            case "UNREGISTERED":
                ((AndroidDriver) mobileThread).setGsmVoice(GsmVoiceState.UNREGISTERED);
                break;
            case "ROAMING":
                ((AndroidDriver) mobileThread).setGsmVoice(GsmVoiceState.ROAMING);
                break;
            case "SEARCHING":
                ((AndroidDriver) mobileThread).setGsmVoice(GsmVoiceState.SEARCHING);
                break;
            default:
                log.info("Voice state not available");
                break;
        }
    }

    /**
     * SignalStrength Android
     *
     * @param powerState powerState
     */
    public void powerStateAndroid(String powerState) {
        switch (powerState) {
            case "ON":
                ((AndroidDriver) mobileThread).setPowerAC(PowerACState.ON);
                break;
            case "OFF":
                ((AndroidDriver) mobileThread).setPowerAC(PowerACState.OFF);
                break;
            default:
                log.info("Voice state not available");
                break;
        }
    }

    /**
     * Connection State
     *
     * @param connectionState connectionState
     * @param enabled         boolean
     */
    public void connectionStateAndroid(String connectionState, boolean enabled) {
        switch (connectionState) {
            case "AIRPLANE":
                if (enabled) {
                    ((AndroidDriver) mobileThread).setConnection(new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK)).isAirplaneModeEnabled();
                }
                ((AndroidDriver) mobileThread).setConnection(new ConnectionState(ConnectionState.AIRPLANE_MODE_MASK));
                break;
            case "DATA":
                if (enabled) {
                    ((AndroidDriver) mobileThread).setConnection(new ConnectionState(ConnectionState.DATA_MASK)).isDataEnabled();
                }
                ((AndroidDriver) mobileThread).setConnection(new ConnectionState(ConnectionState.DATA_MASK));
                break;
            case "WIFI":
                if (enabled) {
                    ((AndroidDriver) mobileThread).setConnection(new ConnectionState(ConnectionState.WIFI_MASK)).isWiFiEnabled();
                }
                ((AndroidDriver) mobileThread).setConnection(new ConnectionState(ConnectionState.WIFI_MASK));
                break;
            default:
                log.info("Connection state not available");
                break;
        }
    }

    /**
     * Press Back
     */
    public void pressBackAndroid() {
        ((AndroidDriver) mobileThread).pressKey(new KeyEvent(AndroidKey.BACK));
        log.info("Press Back");
    }

    /**
     * Shake Device
     */
    public void shakeDeviceIos() {
        ((IOSDriver) mobileThread).shake();
        log.info("Shake Device");
    }

    /**
     * Press Back
     */
    public void setKeyboardCorrectionIos(boolean bool) {
        ((IOSDriver) mobileThread).setKeyboardAutocorrection(bool);
        log.info("Shake Device");
    }

    /**
     * Swipe Down
     */
    public void swipeDown() {
        mobileThread.executeScript("scroll", ImmutableMap.of("direction", "down"));
        log.info("Swipe Down");
    }

    /**
     * Swipe Up
     */
    public void swipeUP() {
        mobileThread.executeScript("scroll", ImmutableMap.of("direction", "up"));
        log.info("Swipe Up");
    }

    /**
     * Accept Alert
     */
    public void acceptAlert() {
        mobileThread.executeScript("acceptAlert");
        log.info("Accept Alert");
    }

    /**
     * Dismiss Alert
     */
    public void dismissAlert() {
        mobileThread.executeScript("dismissAlert");
        log.info("Dismiss Alert");
    }

    /**
     * Get text from the element
     *
     * @param element element
     * @return string
     */
    protected String getText(WebElement element) {
        try {
            String value;
            fluentWait(element, 10);
            value = element.getText();
            return value;
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
        return null;
    }

    /**
     * Get text from the element
     *
     * @param element element
     * @return string
     */
    protected String getTextByXpath(String element) {
        try {
            String value;
            value = mobileThread.findElement(By.xpath(element)).getText();
            return value;
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
        return null;
    }

    /**
     * Get attribute text from the element
     *
     * @param element element
     * @return string
     */
    protected String getAttribute(WebElement element) {
        try {
            String value;
            fluentWait(element, 10);
            value = element.getAttribute("text");
            return value;
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
        return null;
    }

    /**
     * Scroll to specific location
     *
     * @param element element
     * @param value   location
     */
    public void scrollToLocation(WebElement element, int value) {
        try {
            JavascriptExecutor js = mobileThread;
            HashMap<String, Double> scrollElement = new HashMap<String, Double>();
            scrollElement.put("startX", 0.50);
            scrollElement.put("startY", 0.95);
            scrollElement.put("endX", 0.50);
            scrollElement.put("endY", 0.01);
            scrollElement.put("duration", 3.0);
            js.executeScript("swipe", scrollElement);
        } catch (ElementNotInteractableException e) {
            log.error("Element not visible", e);
        }
    }

    /**
     * Click on back button
     */
    public void clickBackButton() {
        mobileThread.navigate().back(); //Closes keyboard
    }

    /**
     * Threaded sleep
     *
     * @param time time
     */
    protected void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Log allure
     *
     * @param message log message
     */
    @Step("{0}")
    private void log(String message) {
        log.info(message);
    }


    /**
     * Get coordinate by id
     *
     * @param byId Byid
     * @return point
     */
    public Point getCoordinates(String byId) {
        WebElement element = mobileThread.findElement(By.id(byId));
        Point location = element.getLocation();
        System.out.println(location);
        return location;
    }

    /**
     * Wait for element to disappear
     *
     * @param id locatorId
     */
    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait(mobileThread, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public void outputIfMatchPassOrFail(String expectedValue, String actualValue) {
        String result;
        if (expectedValue.trim().contains(actualValue.trim())) {
            result = "(PASS)";
        } else {
            result = "(FAIL)";
        }
        log.info("Verifying Expected Value Matches Actual Value:");
        log.info("\t* Expected Value: " + expectedValue);
        log.info("\t* Actual Value: " + actualValue);
        log.info("===> " + result);
    }

    /**
     * Check List is sorted
     *
     * @param ListToSort lists
     * @return boolean
     */
    public boolean checkListIsSorted(List<String> ListToSort) {
        if (ListToSort.size() > 0) {
            try {
                if (Ordering.natural().isOrdered(ListToSort)) {
                    log.info("Check sorting ,List is sorted");
                    return true;
                } else {
                    log.error("Check Sorting,List is not sorted");
                    return false;
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        } else {
            log.info("There are no elements in the list");
        }
        return false;
    }

    /**
     * Generate random Data
     *
     * @param randomType randomType
     * @return value
     */
    protected String generateRandomData(String randomType) {
        String value = null;
        switch (randomType) {
            case "FirstName":
                value = "testauto" + faker.name().firstName();
                log.info("FirstName: " + value);
                break;
            case "LastName":
                value = faker.name().lastName();
                log.info("LastName: " + value);
                break;
            case "UserName":
                value = RandomStringUtils.randomAlphabetic(6);
                log.info("Username: " + value);
                break;
            case "Email":
                value = "testauto" + faker.internet().emailAddress();
                log.info("EmailAddress: " + value);
            case "Mobile":
                value = "0" + RandomStringUtils.randomNumeric(9);
                log.info("MobileNo: " + value);
            default:
                log.info("Random type not found");
                break;
        }
        return value;
    }

    /**
     * Generate random string
     *
     * @param count count
     * @return value
     */
    public String generateRandomString(int count) {
        String name = RandomStringUtils.randomAlphabetic(count);
        log.info(name);
        return name;
    }

    /**
     * Generate random ascii
     *
     * @param count count
     * @return value
     */
    public String generateRandomAscii(int count) {
        String name = RandomStringUtils.randomAscii(count);
        log.info(name);
        return name;
    }

    /**
     * Get user Data
     *
     * @param threadID threadId
     * @return data
     */
    public JSONObject getUserData(int threadID) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/" +
                    "credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray msg = (JSONArray) jsonObject.get("credentials");
            JSONObject a = (JSONObject) msg.get(threadID);
            log.info(msg.get(threadID).toString());
            return a;

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }

    /**
     * Get data from csv
     *
     * @param t_testcaseName testcaseName
     * @param t_fieldName    filedName
     * @param t_instance     instance
     * @return fieldValue
     */
    protected String getData(String t_testcaseName, String t_fieldName, int t_instance) {
        try {
            int flag = 0;
            CsvReader csvreaderobj = new CsvReader("input/DataSheet.csv");
            csvreaderobj.readHeaders();
            while (csvreaderobj.readRecord()) {
                String p_testcaseName = csvreaderobj.get("TestcaseName").trim();
                String p_testcaseInstance = csvreaderobj.get("TestcaseInstance").trim();
                if ((t_testcaseName.equalsIgnoreCase(p_testcaseName)) && (t_instance == Integer.parseInt(p_testcaseInstance))) {
                    for (int i = 0; i < csvreaderobj.getColumnCount() / 2 + 1; i++) {
                        String p_field = csvreaderobj.get("Field" + i).trim();
                        String p_objectProperty = csvreaderobj.get("Value" + i).trim();
                        dicttoread.put(p_field, p_objectProperty);
                    }
                    flag = 0;
                    break;
                } else {
                    flag = 1;
                }
            }
            if (flag == 1) {
                log.info("Not data present for testname" + t_testcaseName);
            }
        } catch (IOException ef) {
            log.error(ef.getMessage());
        }
        return (String) dicttoread.get(t_fieldName);
    }

    /**
     * GetData from SQlite
     *
     * @param testCaseName test name
     * @param filedName    filed name
     * @return data
     */
    protected String getData(String testCaseName, String filedName) {
        String filed = filedName;
        String testCase = testCaseName;
        String url = "jdbc:sqlite:input/testdata";
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        String value = null;
        try {
            conn = java.sql.DriverManager.getConnection(url);
            if (conn != null) {
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT " + filed + " FROM testdata WHERE TestcaseName = '" + testCase + "'");
                while (rs.next()) {
                    log.info(rs.getString(filed));
                    value = rs.getString(filed);
                }
            }
            assert conn != null;
            conn.close();
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return value;
    }

    /**
     * Write data to csv
     *
     * @param t_testcasename testcaseName
     * @param t_field        filedName
     * @param t_value        value
     * @param t_instance     instance
     */
    protected void writeData(String t_testcasename, String t_field, String t_value, int t_instance) {
        try {
            int flag = 0;
            int i;
            int P_valuenotduplicated = 0;
            String FileContent = null;
            CsvWriter csvOutput = new CsvWriter(new FileWriter("input\\Datasheet1.csv", false), ',');
            CsvReader csvobj = new CsvReader("input\\Datasheet.csv");
            csvobj.readHeaders();
            String FileContentPerRow = csvobj.getRawRecord();
            csvOutput.writeRecord(FileContentPerRow.split(","));
            while (csvobj.readRecord()) {
                FileContentPerRow = csvobj.getRawRecord();
                String p_testcaseName = csvobj.get("TestcaseName").trim();
                String p_testcaseInstance = csvobj.get("TestcaseInstance").trim();
                if (t_testcasename.equalsIgnoreCase(p_testcaseName) && (t_instance == Integer.parseInt(p_testcaseInstance))) {
                    flag = 1;
                    for (i = 1; i < csvobj.getColumnCount() / 2 + 1; i++) {
                        String p_filed = csvobj.get("Field" + i).trim();
                        if (p_filed.equalsIgnoreCase(t_field)) {
                            String p_field1 = csvobj.get("Value" + i).trim();
                            dicttoread.put(t_field, t_value);
                            log.info("value for the field: " + t_field + " is updated to: " + t_value + " Successfully");
                            String stp = CsvWriter.replace(FileContentPerRow, t_field + "," + p_field1, t_field + "," + t_value);
                            log.info(stp);
                            FileContentPerRow = stp;
                            P_valuenotduplicated = 1;
                        }
                    }
                    if (P_valuenotduplicated == 0) {
                        String p_field1 = csvobj.get("Value" + (i - 1)).trim();
                        dicttoread.put(t_field, t_value);
                        String stp1 = CsvWriter.replace(FileContentPerRow, p_field1, p_field1 + "," + t_field + "," + t_value);
                        log.info(stp1);
                        FileContentPerRow = stp1;
                        log.info("New Field: " + t_field + " is added successfully with value: " + t_value);
                    }
                    flag = 1;
                }
                csvOutput.writeRecord(FileContentPerRow.split(","));
            }
            csvOutput.flush();
            csvOutput.close();
            csvobj.close();
            RenameCsvFile("input\\Datasheet1.csv", "input\\Datasheet.csv");
            if (flag == 0) {
                log.info("No data present for the testname");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * WriteData to Sqlite
     *
     * @param testCaseName testName
     * @param fieldName    fieldName
     * @param updatedValue updated Value
     */
    protected void writeData(String testCaseName, String fieldName, String updatedValue) {
        String filed = fieldName;
        String value = updatedValue;
        String testCase = testCaseName;
        String url = "jdbc:sqlite:input/testdata";
        String selectQuery = "SELECT " + filed + " FROM testdata WHERE TestcaseName='" + testCase + "'";
        String query = "UPDATE testdata SET " + filed + "='" + value + "' WHERE TestcaseName='" + testCase + "'";
        Connection conn = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            conn = java.sql.DriverManager.getConnection(url);
            if (conn != null) {
                stmt = conn.createStatement();
                stmt.executeUpdate(query);
                rs = stmt.executeQuery(selectQuery);
                while (rs.next()) {
                    System.out.println(rs.getString(filed));
                    log.info("New Field: " + filed + " is added successfully with value: " + rs.getString(filed));
                }
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Rename csv file
     *
     * @param source sourceFile
     * @param dest   destinationFile
     */
    private boolean RenameCsvFile(String source, String dest) {
        boolean b = false;
        try {
            boolean b1 = false;
            File file1 = new File(dest);
            System.gc();
            file1.setWritable(true);
            Thread.sleep(500);
            if (file1.exists()) {
                b1 = file1.delete();
            }
            Thread.sleep(500);
            log.info(String.valueOf(b1));
            File file = new File(source);
            final String st = dest;
            b = file.renameTo(new File(st));
            log.info(String.valueOf(b));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return b;
    }

    /**
     * Capture image
     *
     * @param p_testcaseName testcaseName
     */
    public void captureImage(String p_testcaseName) {
        try {
            counter = counter + 1;
            File src = ((TakesScreenshot) mobileThread).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(("ScreensDoc\\" + p_testcaseName + "\\" + datetimeabc + "\\" + counter + ".png")));
        } catch (Exception e) {
            log.error("Capture screenShot failed", e);
        }
    }

    /**
     * Create image doc
     *
     * @param p_testcaseName1 testcaseName
     */
    protected void CreateImageDoc(String p_testcaseName1) {
        try (XWPFDocument doc = new XWPFDocument()) {
            XWPFParagraph p = doc.createParagraph();
            XWPFRun r = p.createRun();
            for (int i = 1; i <= counter; i++) {
                String path = "ScreensDoc\\" + p_testcaseName1 + "\\" + datetimeabc + "\\" + i + ".png";
                try (FileInputStream pic = new FileInputStream(path)) {
                    r.addBreak();
                    r.addCarriageReturn();
                    r.addPicture(pic, XWPFDocument.PICTURE_TYPE_PNG, "ScreensDoc\\" + p_testcaseName1 + "\\" +
                            datetimeabc + "\\" + i + ".png", Units.toEMU(300), Units.toEMU(400));
                    FileOutputStream out = new FileOutputStream("ScreensDoc\\" + p_testcaseName1 + "\\" + datetimeabc + "\\" + p_testcaseName1 + ".docx");
                    doc.write(out);
                    pic.close();
                    out.close();
                } catch (IOException io) {
                    log.error(io.getMessage());
                }
            }
            for (int i = 1; i <= counter; i++) {
                File src1 = new File("ScreensDoc\\" + p_testcaseName1 + "\\" + datetimeabc + "\\" + i + ".png");
                deleteDir(src1);
            }
            counter = 0;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Delete dir
     *
     * @param file fileName
     */
    private void deleteDir(File file) {
        File[] contents = file.listFiles();
        if (contents != null) {
            for (File f : contents) {
                f.delete();
            }
        }
        file.delete();
    }

    /**
     * System date format
     */
    protected void SystemDateFormat() {
        String abc1 = null;
        try {
            DateFormat date = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
            Date date1 = new Date();
            abc1 = date.format(date1);
            datetimeabc = "Run_" + abc1;
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    /**
     * SQL server windows authentication
     */
    public void windowsAuthentication() {
        String path = System.getProperty("java.library.path");
        path = "input/sqljdbc_auth.dll" + ";" + path;
        System.setProperty("java.library.path", path);
        try {
            final Field sysPathFiled = ClassLoader.class.getDeclaredField("sys_paths");
            sysPathFiled.setAccessible(true);
            sysPathFiled.set(null, null);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    protected void catchBlock(Exception e) {
        counter = 0;
        log.error("Error Description", e);
        Assert.fail("TestCase Failed", e);
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
