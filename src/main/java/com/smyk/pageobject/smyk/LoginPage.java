package com.smyk.pageobject.smyk;

import com.smyk.pageobject.BasePage;
import com.smyk.pageobject.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@class=\"text__title\" and contains(text(),'Zaloguj')]")
    public WebElement loginMenu;
    @FindBy(xpath = "//*[@class=\"text__title\" and contains(text(),'Twoje konto')]")
    public WebElement loggedMenu;
    @FindBy(xpath = "//*[@id=\"username\"]")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@role=\"button\" and @class=\"btn btn--full btn--size3 btn--with-action\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@class=\"input__note input__error\"]")
    public WebElement emptyErrorMessage;

    @FindBy(xpath = "//*[@class=\"form__message form__message--error\"]")
    public WebElement incorrectCredentialsErrorMessage;

    public LoginPage(WebDriver driver,
                      PageManager pageManager) {
        super(driver, pageManager);
    }
}
