package com.smyk.pageobject.smyk;

import com.smyk.pageobject.BasePage;
import com.smyk.pageobject.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"Warstwa_1-2\"]")
    public WebElement basketItem;
    @FindBy(xpath = "//*[contains(text(),'Twój koszyk jest pusty.')]")
    public WebElement emptyBasketMessage;

    @FindBy(xpath = "//*[@class=\"complex-product__name\"]")
    public WebElement clickOnProduct;

    @FindBy(xpath = "//*[contains(text(),'Dodaj do koszyka')]")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//*[contains(text(),'Produkt został dodany do koszyka')]")
    public WebElement addedToBasket;

    @FindBy(xpath = "//*[@class=\"cart-controls-cart__button cart-controls-cart__button--red\" and @role=\"button\"]")
    public WebElement removeProduct;


    public BasketPage(WebDriver driver,
                     PageManager pageManager) {
        super(driver, pageManager);
    }
}
