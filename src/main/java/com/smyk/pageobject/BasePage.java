package com.smyk.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v89.page.Page;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage extends Page {

    protected WebDriver driver;
    protected PageManager pageManager;

    public BasePage(WebDriver driver,PageManager pageManager){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.pageManager = pageManager;
    }


}
