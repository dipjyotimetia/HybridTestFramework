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
import org.openqa.selenium.support.*;

import java.util.List;

public class LoginPage extends UserActions {

    private final Logger logger = LogManager.getLogger(LoginPage.class);

    //Element that wont get changed
    @CacheLookup
    @FindBy(css = "#header div.header_user_info a")
    private WebElement signInLink;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"login_form\"]/div/p[1]/a")
    private WebElement forgotPasswordLink;

    //Multiple element match
    @FindAll({@FindBy(how = How.XPATH, using = "//*[@id=\"SubmitLogin\"]"),
            @FindBy(how = How.ID_OR_NAME, using = "SubmitLogin")})
    private WebElement loginButton;

    //List of elements
    @FindBys(@FindBy(xpath = "//*[@id=\"down\"]"))
    private List<WebElement> testDropDown;

    public LoginPage() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    @Step("Login step for test:{0}, for method: {method}")
    public void Login(String tcName) {
        try {
            navigate("http://automationpractice.com/index.php");
            click(signInLink);
            enter(username, "");
            enter(password, "");
            click(loginButton);

            captureImage(tcName);
        } catch (Exception e) {
            logger.error(e);
        }

    }
}