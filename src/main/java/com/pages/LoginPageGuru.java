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
package com.pages;

import com.core.UserActions;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageGuru extends UserActions {
    private final Logger logger = LogManager.getLogger(LoginPageGuru.class);

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(id = "advice-validate-password-pass")
    private WebElement errorText;


    public LoginPageGuru() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    public void login(String tcName) {
        try {
            navigate("http://live.guru99.com/index.php/customer/account/login/");
            enter(email, "testnow@gmail.com");
            enter(password, "123456");
            click(loginButton);
            captureImage(tcName);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    @Step("Verify password step for test:{0}, for method: {method}")
    public void verifyPassword(String tcName) {
        try {
            navigate("http://live.guru99.com/index.php/customer/account/login/");
            waitForElement(email);
            captureScreen("Home Page");
            enter(email, "testnow@gmail.com");
            enter(password, "12345");
            click(loginButton);
            captureImage(tcName);
            String actualValue = "Please enter 6 or more characters without leading or trailing spaces.";
            compareText(actualValue, getText(errorText));
            captureScreen("Error Page");
            clear(password);
            enter(password, "123456");
            click(loginButton);
            captureScreen("Login Page");
            captureImage(tcName);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
