package com.pages.web;

import com.core.WebActions;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class LoginOrange extends WebActions {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "button[type=submit]")
    private WebElement loginButton;

    public LoginOrange() {
        super();
        PageFactory.initElements(driverThread, this);
    }

    @Step("Login step for test:{0}, for method: {method}")
    public void Login(String tcName) {
        try {
            navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            enter(username, "Admin");
            enter(password, "admin123");
            click(loginButton);
            captureImage(tcName);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
