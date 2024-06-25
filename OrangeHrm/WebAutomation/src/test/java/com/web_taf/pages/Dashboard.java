package com.web_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard extends BasePage {

    public Dashboard(WebDriver driver){
        super(driver);
    }

    private final By adminPageButton = By.linkText("Admin");

    public Admin clickOnAdminPageButton(){
        waitUntilElementIsClickable(adminPageButton).click();
        return new Admin(driver);
    }

}
