package com.smyk.pageobject;

import com.smyk.pageobject.smyk.BasketPage;
import com.smyk.pageobject.smyk.HomePage;
import com.smyk.pageobject.smyk.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageManager {

    private static final Logger logger = LogManager.getLogger(PageManager.class.getSimpleName());

    public WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private BasketPage basketPage;

    public PageManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage homePage(){
        if(homePage == null)
            homePage = new HomePage(driver, this);
        return homePage;
    }

    public LoginPage loginPage(){
        if(loginPage == null)
            loginPage = new LoginPage(driver, this);
        return loginPage;
    }

    public BasketPage basketPage(){
        if(basketPage == null)
            basketPage = new BasketPage(driver, this);
        return basketPage;
    }

    public PageManager open(String url){
        logger.info("Opening page with url: " + url);
        driver.navigate().to(url);
        return this;
    }

    public PageManager waitForPageToLoad(){
        logger.info("Waiting till next page is loaded");
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }
}
