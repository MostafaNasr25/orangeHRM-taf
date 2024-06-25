package com.web_taf.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Admin extends BasePage {

    public Admin(WebDriver driver) {
        super(driver);
    }


    private final By addButton = By.xpath("//*[@class='oxd-icon bi-plus oxd-button-icon']");
    private final By usernameTextField = By.xpath("(//input[@class= 'oxd-input oxd-input--active'])[2]");
    private final By passwordTextField = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private final By confirmedPasswordTextField = By.xpath("(//input[@type='password'])[2]");
    private final By saveButton = By.xpath("//button[@type= 'submit']");
    private final By statusButton = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i");
    private final By userRoleButton = By.xpath("//*[@class= 'oxd-icon bi-caret-down-fill oxd-select-text--arrow'][1]");
    private final By employeeNameTextField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By userNameSearchField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By deleteButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space']");
    private final By confirmDeleteButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    private final By toastedMessage = By.xpath("//*[@class='oxd-toast oxd-toast--success oxd-toast-container--toast']");

    public int getRecordsCount() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> records = driver.findElements(By.xpath("//*[@class= 'oxd-table-card']"));
        int recordsCount = records.size();
         return recordsCount;
    }

    public void clickAddButton() {
        waitUntilElementIsClickable(addButton).click();
    }

    public void selectUserRole(String userRole) throws InterruptedException {
        int indexOfSelectedUserRole = 1;
        waitUntilElementIsClickable(userRoleButton).click();
        Thread.sleep(2000);
        if (userRole.equalsIgnoreCase("Admin")) {
            indexOfSelectedUserRole = 2;
        } else if (userRole.equalsIgnoreCase("ESS")) {
            indexOfSelectedUserRole = 3;
        }
//        Thread.sleep(1000);
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[" + indexOfSelectedUserRole + "]")).click();
    }

    public void selectStatus(String status) throws InterruptedException {
        int indexOfSelectedStatus = 1;
        waitUntilElementIsClickable(statusButton).click();
        Thread.sleep(2000);
        if (status.equalsIgnoreCase("Enabled")) {
            indexOfSelectedStatus = 2;
        } else if (status.equalsIgnoreCase("Disabled")) {
            indexOfSelectedStatus = 3;
        }

        driver.findElement(By.xpath("(//div[@role='listbox']//div[@class='oxd-select-option'])[" + indexOfSelectedStatus + "]")).click();

    }

    public void enterUsername(String username) {
        waitUntilElementIsPresence(usernameTextField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitUntilElementIsPresence(passwordTextField).sendKeys(password);
    }

    public void enterConfirmedPassword(String confirmedPassword) throws InterruptedException {
        waitUntilElementIsPresence(confirmedPasswordTextField).sendKeys(confirmedPassword);

    }

    public void enterEmployeeName(String employeeName) throws InterruptedException {

        waitUntilElementIsPresence(employeeNameTextField).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(driver.findElement(employeeNameTextField), employeeName)
                .pause(2000)
                .sendKeys(Keys.ARROW_DOWN)
                .pause(2000)
                .sendKeys(Keys.ENTER)
                .perform();
    }

    public void clickOnSaveButton() {
        waitUntilElementIsClickable(saveButton).click();
    }

    public void searchByUserName(String username) {
        waitUntilElementIsClickable(userNameSearchField).click();
        waitUntilElementIsPresence(userNameSearchField).sendKeys(username);
    }

    public void clickOnSearchButton() {
        waitUntilElementIsClickable(searchButton).click();
    }

    public void clickOnDeleteButton(){
        waitUntilElementIsClickable(deleteButton).click();
    }

    public void clickOnConfirmDeleteButton(){
        waitUntilElementIsClickable(confirmDeleteButton).click();
    }

    public WebElement waitToastedMessage(){
        return waitUntilElementIsPresence(toastedMessage);

    }
}
