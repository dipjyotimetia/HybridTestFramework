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
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Dipjyoti Metia
 */
public class SauceLoginPage extends MobileActions {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"AddToCartUnselected Icons\"]")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Displays number of items in your cart\"]")
    public WebElement cart;

    @iOSXCUITFindBy(accessibility = "Menu Icons")
    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"View menu\"]")
    public WebElement more;

    @iOSXCUITFindBy(accessibility = "LogOut-menu-item")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Login Menu Item\"]")
    public WebElement login;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/nameET\")")
    public WebElement username;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/passwordET\")")
    public WebElement password;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Login\"]")
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/loginBtn")
    public WebElement loginButton;

    public SauceLoginPage() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    public void login() {
        click(cart);
        click(more);
        click(login);
        enter(username, "bod@example.com");
        enter(password, "10203040");
        click(loginButton);
    }
}