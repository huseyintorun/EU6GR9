package com.translantik.pages;

import com.translantik.utilities.BrowserUtils;
import com.translantik.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "prependedInput")
    public WebElement userNameLp;

    @FindBy(id = "prependedInput2")
    public WebElement passwordLp;

    @FindBy(id = "_submit")
    public WebElement submit;

    @FindBy(css = ".alert.alert-error>div")
    public WebElement warning;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(id = "remember_me")
    public WebElement checkBox;

    @FindBy(css = ".custom-checkbox__text")
    public WebElement rememberMe;





    public void login(String username, String password) {

        userNameLp.sendKeys(username);
        passwordLp.sendKeys(password);
        submit.click();

    }
}
