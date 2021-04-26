package com.smyk.stepdefinitions;

import io.cucumber.java.en.Given;
import com.smyk.context.CucumberStepContext;
import com.smyk.pageobject.PageManager;
import com.smyk.properties.PropertyManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private static final Logger logger = LogManager.getLogger(NavigationSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @Given("Customer is on login page")
    public void customerIsOnLoginPage() {
        pageManager.open(propertyManager.getProperty("home.page.url"))
                .waitForPageToLoad();
        pageManager.loginPage().loginMenu.click();
        pageManager.loginPage().loginMenu.click();

    }

    @When("Customer proceed with login with empty email and password")
    public void customerProceedWithLoginWithEmptyEmailAndPassword() {
        pageManager.loginPage().loginButton.click();
    }

    @When("Customer proceed with login with incorrect <{string}> and <{string}>")
    public void customerProceedWithLoginWithIncorrectAnd(String arg0, String arg1) {
        pageManager.loginPage().email.sendKeys(arg0);
        pageManager.loginPage().password.sendKeys(arg1);
        pageManager.loginPage().loginButton.click();
    }

    @Then("Customer isn't able to login")
    public void customerIsnTAbleToLogin() {
        logger.info("Checking if message that fields are mandatory is shown");
        Assert.assertTrue(pageManager.loginPage().emptyErrorMessage.isDisplayed());
    }

    @When("Customer proceed with login with incorrect {string} and {string}")
    public void customerProceedWithLoginWithIncorrectEmailAndPassword(String email, String password) {
        pageManager.loginPage().email.sendKeys(email);
        pageManager.loginPage().password.sendKeys(password);
        pageManager.loginPage().loginButton.click();
    }

    @Then("Customer isn't able to login with incorrect credentials")
    public void customerIsnTAbleToLoginWithIncorrectCredentials() {
        logger.info("Checking if message that credentials are incorrect is shown");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.loginPage().incorrectCredentialsErrorMessage));
        Assert.assertTrue(pageManager.loginPage().incorrectCredentialsErrorMessage.isDisplayed());
    }

    @When("Customer proceed with login with correct {string} and {string}")
    public void customerProceedWithLoginWithCorrectEmailAndPassword(String email, String password) {
        pageManager.loginPage().email.sendKeys(email);
        pageManager.loginPage().password.sendKeys(password);
        pageManager.loginPage().loginButton.click();
    }


    @Then("Customer is able to login")
    public void customerIsAbleToLogin() {
        logger.info("Checking that user is logged in");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.loginPage().loggedMenu));
        Assert.assertTrue(pageManager.loginPage().loggedMenu.isDisplayed());
    }
}
