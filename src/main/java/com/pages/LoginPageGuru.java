package com.pages;

import com.core.UserActions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageGuru extends UserActions {
    private Logger logger = LogManager.getLogger(LoginPageGuru.class);

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
            enter(email, "smita@gmail.com");
            enter(password, "123456");
            click(loginButton);
            captureImage(tcName);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void verifyPassword(String tcName) {
        try {
            navigate("http://live.guru99.com/index.php/customer/account/login/");
            enter(email, "smita@gmail.com");
            enter(password, "12345");
            click(loginButton);
            captureImage(tcName);
            String actualValue = "Please enter 6 or more characters without leading or trailing spaces.";
            compareText(actualValue, getText(errorText));
            clear(password);
            enter(password, "123456");
            click(loginButton);
            captureImage(tcName);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
