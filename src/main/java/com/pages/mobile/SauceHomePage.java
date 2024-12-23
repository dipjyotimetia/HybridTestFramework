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

package com.pages.mobile;

import com.core.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Dipjyoti Metia
 */
public class SauceHomePage extends MobileActions {

    @AndroidFindBy(id = "com.booking:id/search_details_text")
    @iOSXCUITBy(xpath = "")
    public WebElement destination;

    @AndroidFindBy(id = "com.booking:id/disam_search")
    public WebElement search;

    @AndroidFindBy(id = "com.booking:id/bt_accept")
    public WebElement acceptCookie;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    public WebElement closeButton;

    @AndroidFindBy(id = "com.booking:id/disambiguation_search_edittext")
    public WebElement searchEdit;

    @AndroidFindBy(id = "com.booking:id/button_positive")
    public WebElement gotIt;

    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,'Paris')])[1]")
    public WebElement select;

    @AndroidFindBy(id = "com.booking:id/calendar_confirm")
    public WebElement selectDate;

    @AndroidFindBy(id = "com.booking:id/search_search")
    public WebElement searchButton;

    public SauceHomePage() {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driverThread), this);
    }

    public SauceHomePage searchDestination() {
        if (!driverThread.findElements(By.id("com.booking:id/bt_accept")).isEmpty()) {
            click(acceptCookie);
            click(closeButton);
        }
        waitForElement(destination);
        click(destination);
        enter(searchEdit, "Paris");
        click(select);
        return this;
    }

    public SauceHomePage selectDate() {
        click(selectDate);
        return this;
    }

    public void search() {
        click(searchButton);
    }

}