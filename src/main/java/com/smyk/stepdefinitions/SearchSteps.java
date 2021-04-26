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

public class SearchSteps {
    private static final Logger logger = LogManager.getLogger(NavigationSteps.class.getSimpleName());

    WebDriver driver = CucumberStepContext.getInstance().getDriver();
    PageManager pageManager = CucumberStepContext.getInstance().getPageManager();
    PropertyManager propertyManager = CucumberStepContext.getInstance().getPropertyManager();

    @Given("Customer is on page with url homepage {string}")
    public void customerIsOnPageWithUrlHomepage(String url) {
        pageManager.open(propertyManager.getProperty(url))
                .waitForPageToLoad();
    }

    @When("Customer performs search for {string}")
    public void customerProceedWithLoginWithIncorrectAnd(String arg0) {
        pageManager.homePage().searchField.sendKeys(arg0);
        pageManager.homePage().searchButton.click();
    }

    @Then("any product isn't found")
    public void anyProductIsnTFound() {
        logger.info("Checking if message that any product isn't found is shown");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.homePage().notFoundProductMessage));
        Assert.assertTrue(pageManager.homePage().notFoundProductMessage.isDisplayed());
    }

    @Then("product is found")
    public void productIsFound() {
        logger.info("Checking if message that product is found is shown");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(pageManager.homePage().foundProductMessage));
        Assert.assertTrue(pageManager.homePage().foundProductMessage.isDisplayed());
    }

    @Then("Page title contains this")
    public void pageTitleContainsThis() {
        logger.info("Checking if product name is correct in product details page title");
        Assert.assertTrue(driver.getTitle().trim().contains("Brak wyników wyszukiwania - sklep smyk.com"));
    }
}
