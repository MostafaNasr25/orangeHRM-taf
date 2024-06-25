package com.web_taf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class BasePage {
        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
        final static int waitTime = 35 ;
        protected WebDriver driver;


        public WebElement waitUntilElementIsPresence(By by){
            return new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).until(ExpectedConditions.presenceOfElementLocated(by));
        }

        public WebElement waitUntilElementIsClickable(By by){
            return new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).until(ExpectedConditions.elementToBeClickable(by));
        }
    }

