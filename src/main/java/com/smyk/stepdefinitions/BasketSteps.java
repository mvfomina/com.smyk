package com.smyk.stepdefinitions;

import com.smyk.context.CucumberStepContext;
import com.smyk.pageobject.PageManager;
import com.smyk.properties.PropertyManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasketSteps {
    private static final Logger logger = LogManager.getLogger(NavigationSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @Given("Customer is on page with url homepage - {string}")
    public void customerIsOnPageWithUrlHomepage(String url) {
        pageManager.open(propertyManager.getProperty(url))
                .waitForPageToLoad();
    }

    @When("Customer open basket")
    public void customerOpenBasket() {
        pageManager.basketPage().basketItem.click();
    }

    @Then("message about empty basket is shown")
    public void messageAboutEmptyBasketIsShown() {
        logger.info("Checking if message about empty basket is shown");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.basketPage().emptyBasketMessage));
        Assert.assertTrue(pageManager.basketPage().emptyBasketMessage.isDisplayed());
    }

    @When("Customer adds {string} to the basket")
    public void customerAddsProductToTheBasket(String product) {
        pageManager.homePage().searchField.sendKeys(product);
        pageManager.homePage().searchButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.basketPage().clickOnProduct));
        pageManager.basketPage().clickOnProduct.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.basketPage().addToBasketButton));
        pageManager.basketPage().addToBasketButton.click();
    }

    @Then("product is shown in the basket")
    public void productIsShownInTheBasket() {
        logger.info("Checking if summary is shown in the basket");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.basketPage().addedToBasket));
        Assert.assertTrue(pageManager.basketPage().addedToBasket.isDisplayed());
    }

    @And("Customer remove product")
    public void customerRemoveProduct() {
        logger.info("Checking if summary is shown in the basket");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.basketPage().removeProduct));
        pageManager.basketPage().removeProduct.click();
    }
}
