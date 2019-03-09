package com.core;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.awaitility.Awaitility;

import static org.awaitility.Duration.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.*;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class UserActions extends DriverManager {
    private Logger logger = LogManager.getLogger(UserActions.class);

    private static final Faker faker = new Faker();
    private static String datetimeabc = null;
    private static int Counter = 0;
    private static String abc1 = null;
    private Dictionary dicttoread = new Hashtable();
    private static String _dbusername = "";
    private static String _dbpassword = "";
    private static String _dburl = "";
    private static WebDriverWait wait;
    private static JavascriptExecutor jsExec;

    protected void navigate(String url) {
        SystemDateFormat();
        driverThread.navigate().to(url);
    }

    private void fluentWait(WebElement element, int timeout) {
        try {
            Wait wait = new FluentWait(driverThread)
                    .withTimeout(Duration.ofSeconds(timeout))
                    .pollingEvery(Duration.ofMillis(5))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (ElementNotVisibleException e) {
            e.printStackTrace();
        }
    }

    private void loading(WebElement loadingElement) {
        Awaitility.await("Wait for new user to load").atMost(5, TimeUnit.SECONDS)
                .until(loadingElement::getText, not("loading..."));
    }

    private void loadingComplete(WebElement loadingElement) {
        Awaitility.await("Wait for new user to load").atMost(5, TimeUnit.SECONDS)
                .until(loadingElement::getText, is("Complete!"));
    }


    protected void selectByValue(WebElement element, String value) {
        try {
            fluentWait(element, 10);
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            logger.error(e);

        }
    }

    protected void selectByIndex(WebElement element, int value) {
        try {
            fluentWait(element, 10);
            Select select = new Select(element);
            select.selectByIndex(value);
        } catch (Exception e) {
            logger.error(e);

        }
    }

    protected void mouseOver(WebElement element) {
        fluentWait(element, 10);
        Actions action = new Actions(driverThread);
        action.moveToElement(element);
        action.click();
        action.perform();
    }


    protected void click(WebElement element) {
        fluentWait(element, 10);
        element.click();
    }

    protected void enter(WebElement element, String value) {
        fluentWait(element, 10);
        element.sendKeys(value);
    }

    /**
     * This method clear the present field value
     * @param element WebElement
     */
    protected void clear(WebElement element) {
        fluentWait(element, 10);
        element.clear();
    }

    /**
     * This method return inner text from element
     * @param element WebElement
     * @return Inner Text
     */
    protected String getText(WebElement element) {
        fluentWait(element, 10);
        return element.getText();
    }

    /**
     * This method utilises TestNG Asserts to compare Texts
     * @param actual Actual Value
     * @param expected Expected Value
     */
    protected void compareText(String actual,String expected){
        try {
            Assert.assertEquals(actual, expected);
            logger.info("Text compared successfully");
        }
        catch (Exception e){
            logger.error("Texts compare failed"+e);
        }
    }
    public void setDriver() {
        wait = new WebDriverWait(driverThread, 10);
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
        WebDriverWait wait = new WebDriverWait(driverThread, 15);
        JavascriptExecutor jsExec = (JavascriptExecutor) driverThread;
        String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";
        ExpectedCondition<Boolean> angularLoad = driver -> Boolean.valueOf(((JavascriptExecutor) driver)
                .executeScript(angularReadyScript).toString());
        boolean angularReady = Boolean.valueOf(jsExec.executeScript(angularReadyScript).toString());
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
        WebDriverWait wait = new WebDriverWait(driverThread, 15);
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
        if (jQueryDefined == true) {
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

    public void waitJQueryAngular() {
        waitUntilJQueryReady();
        waitUntilAngularReady();
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
        WebDriverWait wait = new WebDriverWait(driverThread, timeout);
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
     * @throws Exception Exception
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
        } catch (FileNotFoundException ef) {
            logger.error(ef);
        } catch (IOException e) {
            logger.error(e);
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
     * @throws IOException IOException
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
     * @return
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
     * @throws IOException Exception
     */
    protected void captureImage(String p_testcaseName) throws IOException {
        try {
            Counter = Counter + 1;
            File src = ((TakesScreenshot) driverThread).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(("ScreensDoc\\" + p_testcaseName + "\\" + datetimeabc + "\\" + Counter + ".png")));
        } catch (Exception e) {
            logger.error("Capture screenShot failed", e);
        }
    }

    /**
     * Create image doc
     *
     * @param p_testcaseName1 testcaseName
     * @throws IOException            IoException
     * @throws InvalidFormatException invalidFormatException
     */
    protected void CreateImageDoc(String p_testcaseName1) {
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
                                if (rs.getString(i).toString() == null && i != columnCount) {
                                }
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

    protected String generateRandomFirstName() {
        String name = faker.name().firstName();
        logger.info("FirstName: " + name);
        return name;
    }

    protected String generateRandomLastName() {
        String name = faker.name().lastName();
        logger.info("LastName: " + name);
        return name;
    }

    protected String generateRandomUserName() {
        String name = RandomStringUtils.randomAlphabetic(6);
        logger.info("Username: " + name);
        return name;
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

    protected void catchBlock(Exception e) {
        Counter = 0;
        logger.error("Error Description", e);
        Assert.fail("TestCase Failed", e);
    }


}
