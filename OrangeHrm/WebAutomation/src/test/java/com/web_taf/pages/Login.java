package com.web_taf.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BasePage {

    public Login (WebDriver driver){
        super(driver);
    }

    private final By userNameField = By.name("username");

    private final By passwordField = By.name("password");

    private final By logInButton = By.xpath("//button[@type='submit']");

    public void enterUserName(String userName) {
        waitUntilElementIsPresence(userNameField).sendKeys(userName);
    }

    public void enterPassword(String password) {
        waitUntilElementIsPresence(passwordField).sendKeys(password);
    }

    public void clickOnLogInButton() {
        waitUntilElementIsClickable(logInButton).click();
    }

    public Dashboard login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickOnLogInButton();
        return new Dashboard(driver);
    }

}
