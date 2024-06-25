package com.web_taf.tests;


import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseTest {

    protected static WebDriver edgeDriver;
    protected static Properties properties;


    public WebDriver getDriver() {
        return edgeDriver;
    }

}
