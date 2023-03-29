/*
MIT License
Copyright (c) 2021 Dipjyoti Metia
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
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Dipjyoti Metia
 */
public class SauceLoginPage extends MobileActions {

    @iOSXCUITFindBys(value = {@iOSXCUITBy(accessibility = "test-Username"), @iOSXCUITBy(xpath = "//XCUIElementTypeTextField[@name=\"test-Username\"]")})
    @AndroidFindBy(accessibility = "test-Username")
    private WebElement userName;

    @iOSXCUITFindBy(accessibility = "test-Password")
    @AndroidFindBy(accessibility = "test-Password")
    private WebElement password;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @AndroidFindBy(accessibility = "test-LOGIN")
    private WebElement loginButton;

    public SauceLoginPage() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    public void login() {
        enter(userName, "standard_user");
        enter(password, "secret_sauce");
        click(loginButton);
    }
}