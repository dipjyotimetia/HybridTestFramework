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
import com.deque.axe.AXE;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.awaitility.Awaitility;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class UserActions<T> extends DriverManager<T> {
    private static final Faker faker = new Faker();
    private static String datetimeabc = null;
    private static int Counter = 0;
    private static String abc1 = null;
    private static String _dbusername = "";
    private static String _dbpassword = "";
    private static String _dburl = "";
    private static WebDriverWait wait;
    private static JavascriptExecutor jsExec;
    private final Logger logger = LogManager.getLogger(UserActions.class);
    private Dictionary dicttoread = new Hashtable();

    public static Map<String, String> get(Map<String, String> formParams) {
        return formParams
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * sleep
     *
     * @param seconds time
     */
    private static void sleep(Integer seconds) {
        long secondsLong = (long) seconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void navigate(String url) {
        SystemDateFormat();
        driverThread.navigate().to(url);
        driverThread.manage().window().maximize();
        driverThread.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    /**
     * Fluent Wait
     *
     * @param element element
     * @param timeout timeout
     */
    private void fluentWait(WebElement element, int timeout) {
        try {
            Wait wait = new FluentWait<>(driverThread)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    /**
     * WaitForElement
     *
     * @param element element
     */
    protected void waitForElement(WebElement element) {
        new WebDriverWait(driverThread, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * WaitForAlert
     */
    protected void waitForAlert() {
        new WebDriverWait(driverThread, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    /**
     * WaitForElements
     *
     * @param elements elements
     */
    protected void waitForElements(List<WebElement> elements) {
        new WebDriverWait(driverThread, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    /**
     * WaitForElementToInvisible
     *
     * @param elements elements
     */
    protected void waitForElementToInvisible(WebElement elements) {
        new WebDriverWait(driverThread, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(elements));
    }

    /**
     * WaitForElementsToInvisible
     *
     * @param elements elements
     */
    protected void waitForElementsToInvisible(List<WebElement> elements) {
        new WebDriverWait(driverThread, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    /**
     * Accept alert
     */
    protected void acceptAlert() {
        Alert alert = driverThread.switchTo().alert();
        alert.accept();
    }

    /**
     * Dismiss alert
     */
    protected void dismissAlert() {
        Alert alert = driverThread.switchTo().alert();
        alert.dismiss();
    }

    /**
     * Get Alert Text
     *
     * @return alertText
     */
    protected String getAlertText() {
        Alert alert = driverThread.switchTo().alert();
        return alert.getText();
    }

    /**
     * Double Click
     *
     * @param element element
     */
    protected void doubleClick(WebElement element) {
        new Actions(driverThread).doubleClick(element).build().perform();
    }

    /**
     * Drag and drop
     *
     * @param element1 element1
     * @param element2 element2
     */
    protected void dragAndDrop(WebElement element1, WebElement element2) {
        new Actions(driverThread).dragAndDrop(element1, element2).build().perform();
    }

    /**
     * SwitchToFrame
     *
     * @param element element
     */
    protected void switchToFrame(WebElement element) {
        driverThread.switchTo().frame(element);
    }

    /**
     * SwitchToFrame
     *
     * @param index frameIndex
     */
    protected void switchToFrame(int index) {
        driverThread.switchTo().frame(index);
    }

    /**
     * SwitchToFrame
     *
     * @param frameId frameId
     */
    protected void switchToFrame(String frameId) {
        driverThread.switchTo().frame(frameId);
    }

    /**
     * SwitchToParentFrame
     */
    protected void switchToParentFrame() {
        driverThread.switchTo().parentFrame();
    }

    /**
     * Switch to default content
     */
    protected void switchToDefaultContent() {
        driverThread.switchTo().defaultContent();
    }

    /**
     * GetButtonColor
     *
     * @return color
     */
    protected Color getButtonColor() {
        return Color.fromString(driverThread.findElement(By.xpath("")).getCssValue("color"));
    }

    /**
     * GetBackgroundColor
     *
     * @return color
     */
    protected Color getBackgroundColor() {
        return Color.fromString(driverThread.findElement(By.xpath("")).getCssValue("background-color"));
    }

    /**
     * Loading
     *
     * @param loadingElement loadingElement
     */
    private void loading(WebElement loadingElement) {
        Awaitility.await("Wait for new user to load").atMost(5, TimeUnit.SECONDS)
                .until(loadingElement::getText, not("loading..."));
    }

    /**
     * Loading complete
     *
     * @param loadingElement loading Element
     */
    private void loadingComplete(WebElement loadingElement) {
        Awaitility.await("Wait for new user to load").atMost(5, TimeUnit.SECONDS)
                .until(loadingElement::getText, is("Complete!"));
    }

    /**
     * Mouse over
     *
     * @param element element
     */
    protected void mouseOver(WebElement element) {
        fluentWait(element, 10);
        Actions action = new Actions(driverThread);
        action.moveToElement(element);
        action.click();
        action.perform();
    }

    /**
     * Click
     *
     * @param element click on element
     */
    protected void click(WebElement element) {
        fluentWait(element, 10);
        element.click();
    }

    /**
     * Enter
     *
     * @param element element
     * @param value   value
     */
    protected void enter(WebElement element, String value) {
        fluentWait(element, 10);
        element.sendKeys(value);
    }

    /**
     * Select Element
     *
     * @param element  element
     * @param selectBy selectBy
     * @param t        t
     */
    protected void selectElement(WebElement element, SelectBy selectBy, T t) {
        Select select = new Select(element);
        switch (selectBy) {
            case INDEX:
                select.selectByIndex((Integer) t);
                break;
            case VALUE:
                select.selectByValue((String) t);
                break;
            case TEXT:
                select.selectByVisibleText((String) t);
                break;
            default:
                logger.info("Provided option not found");
        }
    }

    /**
     * IsMultiple
     *
     * @param elements elements
     * @return boolean
     */
    protected Boolean isMultiple(WebElement elements) {
        Select select = new Select(elements);
        return select.isMultiple();
    }

    /**
     * GetAllSelectedOption
     *
     * @param elements elements
     * @return allSelectedOptions
     */
    protected List<WebElement> getAllSelectedOption(WebElement elements) {
        Select select = new Select(elements);
        return select.getAllSelectedOptions();
    }

    /**
     * GetOption
     *
     * @param elements elements
     * @return options
     */
    protected List<WebElement> getOptions(WebElement elements) {
        Select select = new Select(elements);
        return select.getOptions();
    }

    /**
     * GetFirstSelectedOption
     *
     * @param elements elements
     * @return webElement
     */
    protected WebElement getFirstSelectedOption(WebElement elements) {
        Select select = new Select(elements);
        return select.getFirstSelectedOption();
    }

    /**
     * DeselectElement
     *
     * @param element  element
     * @param selectBy selectBy
     * @param t        t
     */
    protected void deselectElement(WebElement element, SelectBy selectBy, T t) {
        Select select = new Select(element);
        switch (selectBy) {
            case INDEX:
                select.deselectByIndex((Integer) t);
                break;
            case VALUE:
                select.deselectByValue((String) t);
                break;
            case TEXT:
                select.deselectByVisibleText((String) t);
                break;
            default:
                logger.info("Provided option not found");
        }
    }

    /**
     * Deselect ALl
     *
     * @param elements elements
     */
    protected void deselectAll(WebElement elements) {
        Select select = new Select(elements);
        select.deselectAll();
    }

    enum SelectBy {
        INDEX, VALUE, TEXT
    }

    /**
     * This method clear the present field value
     *
     * @param element WebElement
     */
    protected void clear(WebElement element) {
        fluentWait(element, 10);
        element.clear();
    }

    /**
     * This method return inner text from element
     *
     * @param element WebElement
     * @return Inner Text
     */
    protected String getText(WebElement element) {
        fluentWait(element, 10);
        return element.getText();
    }

    /**
     * Filter element
     *
     * @param elements element
     * @return filtered elements list
     */
    public long filterElement(List<WebElement> elements) {
        return elements.stream().filter(WebElement::isDisplayed).count();
    }

    /**
     * Enter visible element
     *
     * @param elements elements
     * @param value    value
     */
    public void enterVisibleElement(List<WebElement> elements, String value) {
        elements.stream().filter(WebElement::isDisplayed).findFirst().get().sendKeys(value);
    }

    /**
     * Get all values
     *
     * @param elements elements
     */
    public void getAllValues(List<WebElement> elements) {
        elements.forEach(logger::info);
    }

    /**
     * Click element by value
     *
     * @param elements element
     * @param value    value
     */
    public void clickElementByValue(List<WebElement> elements, String value) {
        elements.stream().filter(element -> element.getAttribute("value").matches(value))
                .forEach(WebElement::click);
    }

    /**
     * Get All Links
     *
     * @return all links
     */
    public List<String> getAllLinks(List<WebElement> elements) {
        return elements.stream().map(ele -> ele.getText().trim()).collect(Collectors.toList());
    }

    /**
     * This method utilises TestNG Asserts to compare Texts
     *
     * @param actual   Actual Value
     * @param expected Expected Value
     */
    protected void compareText(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
            logger.info("Text compared successfully");
        } catch (Exception e) {
            logger.error("Texts compare failed" + e);
        }
    }

    public void setDriver() {
        wait = new WebDriverWait(driverThread, Duration.ofSeconds(10));
        jsExec = (JavascriptExecutor) driverThread;
    }

    /**
     * wait for jquery load
     */
    private void waitForJQueryLoad() {
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) driverThread)
                .executeScript("return jQuery.active") == 0);
        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");
        if (!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            wait.until(jQueryLoad);
        } else {
            System.out.println("JQuery is Ready!");
        }
    }

    /**
     * wait for angular load
     */
    private void waitForAngularLoad() {
        WebDriverWait wait = new WebDriverWait(driverThread, Duration.ofSeconds(15));
        JavascriptExecutor jsExec = (JavascriptExecutor) driverThread;
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        ExpectedCondition<Boolean> angularLoad = driver -> {
            assert driver != null;
            return Boolean.valueOf(((JavascriptExecutor) driver)
                    .executeScript(angularReadyScript).toString());
        };
        boolean angularReady = Boolean.parseBoolean(jsExec.executeScript(angularReadyScript).toString());
        if (!angularReady) {
            System.out.println("ANGULAR is NOT Ready!");
            wait.until(angularLoad);
        } else {
            System.out.println("ANGULAR is Ready!");
        }
    }

    /**
     * wait until js ready
     */
    private void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(driverThread, Duration.ofSeconds(15));
        JavascriptExecutor jsExec = (JavascriptExecutor) driverThread;
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driverThread)
                .executeScript("return document.readyState").toString().equals("complete");
        boolean jsReady = (Boolean) jsExec.executeScript("return document.readyState").toString().equals("complete");
        if (!jsReady) {
            System.out.println("JS in NOT Ready!");
            wait.until(jsLoad);
        } else {
            System.out.println("JS is Ready!");
        }
    }

    /**
     * wait until jquery ready
     */
    private void waitUntilJQueryReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driverThread;
        Boolean jQueryDefined = (Boolean) jsExec.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            sleep(20);
            waitForJQueryLoad();
            waitUntilJSReady();
            sleep(20);
        } else {
            System.out.println("jQuery is not defined on this site!");
        }
    }

    /**
     * wait for angular ready
     */
    private void waitUntilAngularReady() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driverThread;
        Boolean angularUnDefined = (Boolean) jsExec.executeScript("return window.angular === undefined");
        if (!angularUnDefined) {
            Boolean angularInjectorUnDefined = (Boolean) jsExec.executeScript("return angular.element(document).injector() === undefined");
            if (!angularInjectorUnDefined) {
                sleep(20);
                waitForAngularLoad();
                waitUntilJSReady();
                sleep(20);
            } else {
                System.out.println("Angular injector is not defined on this site!");
            }
        } else {
            System.out.println("Angular is not defined on this site!");
        }
    }

    /**
     * Wait jquery angular
     */
    public void waitJQueryAngular() {
        waitUntilJQueryReady();
        waitUntilAngularReady();
    }

    /**
     * find element
     *
     * @param locator        locator
     * @param timeoutSeconds timeout
     * @return webelement
     */
    private WebElement findElement(final By locator, final int timeoutSeconds) {
        FluentWait<WebDriver> wait = new FluentWait<>(driverThread)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(100))
                .withMessage("Timeout occured!")
                .ignoring(NoSuchElementException.class);
        return wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driverThread.findElement(locator);
            }
        });
    }

    /**
     * click when ready
     *
     * @param locator locator
     * @param timeout timeout
     */
    public void clickWhenReady(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driverThread, Duration.ofSeconds(timeout));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
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
                logger.info("Not data present for testname" + t_testcaseName);
            }
        } catch (IOException ef) {
            logger.error(ef);
        }
        return (String) dicttoread.get(t_fieldName);
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
                            logger.info("value for the field: " + t_field + " is updated to: " + t_value + " Successfully");
                            String stp = csvOutput.replace(FileContentPerRow, t_field + "," + p_field1, t_field + "," + t_value);
                            logger.info(stp);
                            FileContentPerRow = stp;
                            P_valuenotduplicated = 1;
                        }
                    }
                    if (P_valuenotduplicated == 0) {
                        String p_field1 = csvobj.get("Value" + (i - 1)).trim();
                        dicttoread.put(t_field, t_value);
                        String stp1 = csvOutput.replace(FileContentPerRow, p_field1, p_field1 + "," + t_field + "," + t_value);
                        logger.info(stp1);
                        FileContentPerRow = stp1;
                        logger.info("New Field: " + t_field + " is added successfully with value: " + t_value);
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
                logger.info("No data present for the testname");
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Rename csv file
     *
     * @param source sourceFile
     * @param dest   destinationFile
     * @return boolean
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
            logger.info(b1);
            File file = new File(source);
            final String st = dest;
            b = file.renameTo(new File(st));
            logger.info(b);
        } catch (Exception e) {
            logger.error(e);
        }
        return b;
    }

    /**
     * Capture image
     *
     * @param p_testcaseName testcaseName
     */
    protected void captureImage(String p_testcaseName) {
        try {
            if (!SystemUtils.IS_OS_LINUX || !SystemUtils.IS_OS_MAC_OSX) {
                Counter = Counter + 1;
                File src = ((TakesScreenshot) driverThread).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(src, new File(("ScreensDoc\\" + p_testcaseName + "\\" + datetimeabc + "\\" + Counter + ".png")));
            }
        } catch (Exception e) {
            logger.error("Capture screenShot failed", e);
        }
    }

    /**
     * Create image doc
     *
     * @param p_testcaseName1 testcaseName
     */
    protected void CreateImageDoc(String p_testcaseName1) {
        if (!SystemUtils.IS_OS_LINUX || !SystemUtils.IS_OS_MAC_OSX) {
            try (XWPFDocument doc = new XWPFDocument()) {
                XWPFParagraph p = doc.createParagraph();
                XWPFRun r = p.createRun();
                for (int i = 1; i <= Counter; i++) {
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
                        logger.error(io);
                    }
                }
                for (int i = 1; i <= Counter; i++) {
                    File src1 = new File("ScreensDoc\\" + p_testcaseName1 + "\\" + datetimeabc + "\\" + i + ".png");
                    deleteDir(src1);
                }
                Counter = 0;
            } catch (Exception e) {
                logger.error(e);
            }
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
    private void SystemDateFormat() {
        try {
            DateFormat date = new SimpleDateFormat("yyyy.MM.dd_hh.mm");
            Date date1 = new Date();
            abc1 = date.format(date1);
            datetimeabc = "Run_" + abc1;
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * SQL server windows authentication
     */
    public void WindowsAuthentication() {
        String path = System.getProperty("java.library.path");
        path = "input/sqljdbc_auth.dll" + ";" + path;
        System.setProperty("java.library.path", path);
        try {
            final Field sysPathFiled = ClassLoader.class.getDeclaredField("sys_paths");
            sysPathFiled.setAccessible(true);
            sysPathFiled.set(null, null);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    /**
     * Execute SQL query
     *
     * @param query sqlQuery
     * @return result string
     * @throws SQLException SQLException
     */
    public String ExecuteQuery(String query) throws SQLException {
        String resultValue = "";
        String columnName = "";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            logger.error("Class not found", e);
        }
        try (Connection connection = java.sql.DriverManager.getConnection(_dburl, _dbusername, _dbpassword)) {
            try (Statement stmt = connection.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(query)) {
                    while (rs.next()) {
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnCount = rsmd.getColumnCount();
                        for (int i = 1; i <= columnCount; i++) {
                            try {
                                rs.getString(i);
                            } catch (NullPointerException e) {
                                resultValue = "NULL";
                                logger.info("column name:" + columnName + "|" + "Column value:" + resultValue);
                                continue;
                            }
                            columnName = rsmd.getColumnName(i);
                            resultValue = rs.getString(i).toString();
                            logger.info("column name:" + columnName + "|" + "Column value:" + resultValue);
                        }
                    }
                }
                connection.close();
            } catch (SQLException sq) {
                logger.error(sq);
            }
        } catch (SQLException sq) {
            logger.error(sq);
        }
        return resultValue;
    }

    /**
     * Generate random Data
     *
     * @param dataType randomType
     * @return value
     */
    protected String generateRandomData(String dataType) {
        String value = null;
        switch (dataType) {
            case "FirstName":
                value = "testauto" + faker.name().firstName();
                logger.info("FirstName: " + value);
                break;
            case "LastName":
                value = faker.name().lastName();
                logger.info("LastName: " + value);
                break;
            case "UserName":
                value = RandomStringUtils.randomAlphabetic(6);
                logger.info("Username: " + value);
                break;
            case "Email":
                value = "testauto" + faker.internet().emailAddress();
                logger.info("EmailAddress: " + value);
            case "Mobile":
                value = "0" + RandomStringUtils.randomNumeric(9);
                logger.info("MobileNo: " + value);
            default:
                logger.info("Random type not found");
                break;
        }
        return value;
    }

    /**
     * Generate random strings
     *
     * @return string
     */
    public String generateRandomString() {
        String name = RandomStringUtils.randomAlphabetic(5);
        logger.info(name);
        return name;
    }

    /**
     * Generate random email
     *
     * @return string
     */
    protected String generateRandomEmail() {
        String email = faker.internet().emailAddress();
        logger.info("EmailAddress: " + email);
        return email;
    }

    /**
     * Generate random mobile no
     *
     * @return string
     */
    protected String generateRandomMobileNo() {
        String mobNo = "0" + RandomStringUtils.randomNumeric(9);
        logger.info("MobileNo: " + mobNo);
        return mobNo;
    }

    /**
     * Visibility of element located
     *
     * @param locator locator
     * @return condition
     */
    public ExpectedCondition<WebElement> visibilityOfElementLocated(final By locator) {
        return new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement toReturn = driver.findElement(locator);
                if (toReturn.isDisplayed()) {
                    return toReturn;
                }
                return null;
            }
        };
    }

    /**
     * Get mobile element
     *
     * @param webElement webElement
     * @param elementBy  typeOf element
     * @return element
     * @throws Exception exception
     */
    private List<WebElement> getWebElements(String webElement, WebElementBy elementBy) throws Exception {
        List<WebElement> element = new ArrayList<>();
        switch (elementBy) {
            case XPATH:
                element = driverThread.findElements(By.xpath(webElement));
                break;
            case ID:
                element = driverThread.findElements(By.id(webElement));
                break;
            case NAME:
                element = driverThread.findElements(By.name(webElement));
                break;
            case CSS:
                element = driverThread.findElements(By.cssSelector(webElement));
                break;
            case CLASS:
                element = driverThread.findElements(By.className(webElement));
                break;
            default:
                logger.info("Element type not found");
                break;
        }
        if (element == null) {
            logger.error("Web element not found");
            throw new Exception(webElement + "not found");
        }
        return element;
    }

    /**
     * Get mobile element
     *
     * @param webElement webElement
     * @param elementBy  typeOf element
     * @return element
     * @throws Exception exception
     */
    private WebElement getWebElement(String webElement, WebElementBy elementBy) throws Exception {
        WebElement element = null;
        switch (elementBy) {
            case XPATH:
                element = driverThread.findElement(By.xpath(webElement));
                break;
            case ID:
                element = driverThread.findElement(By.id(webElement));
                break;
            case NAME:
                element = driverThread.findElement(By.name(webElement));
                break;
            case CSS:
                element = driverThread.findElement(By.cssSelector(webElement));
                break;
            case CLASS:
                element = driverThread.findElement(By.className(webElement));
                break;
            default:
                logger.info("Element type not found");
                break;
        }
        if (element == null) {
            logger.error("Web element not found");
            throw new Exception(webElement + "not found");
        }
        return element;
    }

    /**
     * Is Exists
     *
     * @param element webElement
     * @return boolean
     */
    protected boolean isExist(List<WebElement> element) {
        if (element.size() != 0) {
            logger.info(element + ": element is exists");
            return true;
        }
        return false;
    }

    /**
     * isElement displayed
     *
     * @param element     element
     * @param displayType displayType
     * @return boolean
     */
    protected Boolean isElementDisplayed(WebElement element, DisplayType displayType) {
        boolean returnValue = false;
        switch (displayType) {
            case IS_ENABLED:
                returnValue = element.isEnabled();
                break;
            case IS_SELECTED:
                returnValue = element.isSelected();
                break;
            case IS_DISPLAYED:
                returnValue = element.isDisplayed();
                break;
            default:
                logger.info("Element display type not available");
        }
        return returnValue;
    }

    /**
     * Mouseover
     *
     * @param ele1 element1
     * @param ele2 element2
     */
    protected void mouseOver(WebElement ele1, WebElement ele2) {
        Actions actions = new Actions(driverThread);
        actions.moveToElement(ele1).pause(Duration.ofMillis(500)).click(ele2).build().perform();
    }

    /**
     * SwitchToTab
     */
    protected void switchToTab() {
        driverThread.switchTo().newWindow(WindowType.TAB);
    }

    /**
     * SwitchToWindow
     */
    protected void switchToWindow() {
        driverThread.switchTo().newWindow(WindowType.WINDOW);
    }

    /**
     * SwitchToNewWindow
     */
    protected void switchToNewWindow() {
        String parentWindow = driverThread.getWindowHandle();
        Set<String> handles = driverThread.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driverThread.switchTo().window(windowHandle);
                ///
                driverThread.close();
                driverThread.switchTo().window(parentWindow);
            }
        }
    }

    /**
     * Accessibility test
     *
     * @param scriptUrl url
     */
    protected void accessibilityTest(URL scriptUrl) {
        AXE.inject(driverThread, scriptUrl);
        JSONObject responseJSON = new AXE.Builder(driverThread, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");
        if (violations.length() == 0) {
            Assert.assertTrue(true, "No violations found");
        } else {
            AXE.writeResults("path & name of the file you want to save the  report", responseJSON);
            Assert.fail(AXE.report(violations));
        }
    }

    /**
     * Add cookies
     *
     * @param key   key
     * @param value value
     */
    protected void addCookie(String key, String value) {
        driverThread.manage().addCookie(new Cookie(key, value));
    }

    /**
     * Delete Cookie
     *
     * @param key key
     */
    protected void deleteCookie(String key) {
        driverThread.manage().deleteCookieNamed(key);
    }

    /**
     * Delete all cookie
     *
     * @param key key
     */
    protected void deleteAllCookie(String key) {
        driverThread.manage().deleteAllCookies();
    }

    /**
     * Get Named Cookie
     *
     * @param key   key
     * @param value value
     */
    protected void getNamedCookie(String key, String value) {
        driverThread.manage().addCookie(new Cookie(key, value));
        Cookie cookie = driverThread.manage().getCookieNamed(key);
        logger.info(cookie);
    }

    protected void catchBlock(Exception e) {
        Counter = 0;
        logger.error("Error Description", e);
        Assert.fail("TestCase Failed", e);
    }

    public enum WebElementBy {
        XPATH, ID, NAME, CLASS, CSS
    }

    public enum DisplayType {
        IS_ENABLED, IS_SELECTED, IS_DISPLAYED
    }
}
