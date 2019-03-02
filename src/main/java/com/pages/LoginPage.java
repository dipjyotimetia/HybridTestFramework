package com.pages;

import com.core.UserActions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class LoginPage extends UserActions {

    private Logger logger = LogManager.getLogger(LoginPage.class);

    //Element that wont get changed
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement link;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement password;

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

    public void Login(String tcName) {
        try {
            navigate("http://automationpractice.com/index.php");
            click(link);
            enter(username, "");
            enter(password, "");
            click(loginButton);
            captureImage(tcName);
        } catch (Exception e) {
            logger.error(e);
        }

    }
}