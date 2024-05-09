package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver ldriver;

    public LoginPage(WebDriver rdriver){

        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy (name="uid")
    @CacheLookup
    private WebElement userName;

    @FindBy (name="password")
    @CacheLookup
    private WebElement passWord;

    @FindBy (name="btnLogin")
    @CacheLookup
    private WebElement btnLogin;

    public void submitUsername(String userNameStr){

        userName.clear();
        userName.sendKeys(userNameStr);
    }

    public void submitPassword(String userPasswordstr){

        passWord.clear();
        passWord.sendKeys(userPasswordstr);
    }

    public void submitLogin(){

        btnLogin.click();
    }

}
