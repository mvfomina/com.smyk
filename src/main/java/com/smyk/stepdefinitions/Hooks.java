package com.smyk.stepdefinitions;

import com.smyk.context.CucumberStepContext;
import com.smyk.drivers.DriverManager;
import com.smyk.pageobject.PageManager;
import com.smyk.properties.PropertyManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup(){
        CucumberStepContext.getInstance().setPropertyManager(new PropertyManager("smyk.properties"));
        CucumberStepContext.getInstance().setDriver(DriverManager.getDriver("Chrome", "LOCAL"));
        CucumberStepContext.getInstance().setPageManager( new PageManager(CucumberStepContext.getInstance().getDriver()));
    }

    @After
    public void cleanUp(){
        CucumberStepContext.getInstance().getDriver().quit();
    }

}
