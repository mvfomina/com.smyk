package com.smyk.pageobject.smyk;

import com.smyk.pageobject.BasePage;
import com.smyk.pageobject.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    @FindBy(xpath = "//*[@id=\"q\"]")
    public WebElement searchField;

    @FindBy(xpath = "//*[@class=\"icon-search\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[contains(text(),'Nie znaleźliśmy wyników wyszukiwania dla podanego przez Ciebie hasła.')]")
    public WebElement notFoundProductMessage;

    @FindBy(xpath = "//*[contains(text(),'Wyniki wyszukiwania dla ')]")
    public WebElement foundProductMessage;

    public HomePage(WebDriver driver, PageManager pageManager) {
        super(driver, pageManager);
    }


}
