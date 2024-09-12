/*
MIT License

Copyright (c) 2023 Dipjyoti Metia

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

package com.pages.web;

import com.core.WebActions;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

@Slf4j
public class LoginPage extends WebActions {

    @FindBy(css = "input[data-test='username']")
    private WebElement username;

    @FindBy(css = "input[data-test='password']")
    private WebElement password;

    @FindBy(css = "input[data-test='login-button']")
    private WebElement loginButton;

    //Multiple element match
    @FindAll({@FindBy(how = How.XPATH, using = "//*[@id=\"SubmitLogin\"]"),
            @FindBy(how = How.ID_OR_NAME, using = "SubmitLogin")})
    private WebElement loginButtonLink;

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
            navigate("https://www.saucedemo.com/");
            enter(username, "standard_user");
            enter(password, "secret_sauce");
            click(loginButton);

            captureImage(tcName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}