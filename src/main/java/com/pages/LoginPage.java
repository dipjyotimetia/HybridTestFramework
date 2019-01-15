package com.pages;

import com.core.UserActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class LoginPage extends UserActions {

    //Element that wont get changed
    @CacheLookup
    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement link;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"passwd\"]")
    private WebElement password;

    //Multiple element match
    @FindAll({@FindBy(how= How.XPATH ,using = "//*[@id=\"SubmitLogin\"]"),
            @FindBy(how= How.ID_OR_NAME ,using = "SubmitLogin")})
    private WebElement loginButton;

    //List of elements
    @FindBys(@FindBy(xpath = "//*[@id=\"down\"]"))
    private List<WebElement> testDropdown;

    public LoginPage(){
        super();
        PageFactory.initElements(driverThread,this);
    }

    public void Login(){
        navigate("http://automationpractice.com/index.php");
        click(link);
        enter(username,"");
        enter(password,"");
        click(loginButton);
    }
}