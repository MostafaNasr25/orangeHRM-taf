package com.web_taf.tests;

import com.web_taf.pages.Admin;
import com.web_taf.pages.Dashboard;
import com.web_taf.pages.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AdminTabStepdefs extends BaseTest {

    private Login login = new Login(edgeDriver);
    private Dashboard dashboard = new Dashboard(edgeDriver);
    private Admin admin = new Admin(edgeDriver);

    int currentCount;
    int icreasedCount;
    int decreasedCount;

    @Given("Admin navigate to the orangeHRM website")
    public void adminNavigateToTheOrangeHRMWebsite() {
        edgeDriver.navigate().to(properties.getProperty("orangeHrmLink"));
    }

    @When("Admin login with username {string} and password {string}")
    public void adminLoginWithUsernameAndPassword(String username, String password) {
        dashboard = login.login(properties.getProperty(username), properties.getProperty(password));
    }

    @And("navigate to the Admin page")
    public void navigateToTheAdminPage() {
        dashboard.clickOnAdminPageButton();
    }

    @And("get user counts")
    public void getUserCounts() throws InterruptedException {
      currentCount =  admin.getRecordsCount();
        System.out.println(currentCount);
    }


    @And("click on add button")
    public void clickOnAddButton() {
        admin.clickAddButton();
    }


    @And("enter user role {string} , employee name {string} and status {string}")
    public void enterUserRoleEmployeeNameAndStatus(String userRole, String employeeName, String status) throws InterruptedException {
        admin.selectUserRole(userRole);
        admin.enterEmployeeName(employeeName);
        admin.selectStatus(status);

    }

    @And("enter user name {string}, password {string} and confirm password {string}")
    public void enterUserNamePasswordAndConfirmPassword(String newUsername, String userPassword, String confirmPassword) throws InterruptedException {
        admin.enterUsername(newUsername);
        admin.enterPassword(userPassword);
        admin.enterConfirmedPassword(confirmPassword);
    }

    @And("click on save button")
    public void clickOnSaveButton() {
        admin.clickOnSaveButton();
    }

    @Then("validate that new user added")
    public void validateThatNewUserAdded() {
        Assert.assertTrue(admin.waitToastedMessage().isDisplayed());
    }

    @Then("validate user counts increased by one")
    public void validateUserCountsIncreasedBy() throws InterruptedException {
        Thread.sleep(2000);
        icreasedCount =  admin.getRecordsCount();
        System.out.println(icreasedCount);
        Assert.assertEquals(icreasedCount,currentCount+1);

    }

    @And("search for new user b name {string}")
    public void searchForNewUserBName(String newUsername) {
        admin.searchByUserName(newUsername);
        admin.clickOnSearchButton();
    }

    @And("click on delete button and confirmation delete")
    public void clickOnDeleteButtonAndConfirmationDelete() {
        admin.clickOnDeleteButton();
        admin.clickOnConfirmDeleteButton();

    }

    @Then("validate that new user deleted")
    public void validateThatNewUserDeleted() {
        Assert.assertTrue(admin.waitToastedMessage().isDisplayed());

    }

    @Then("validate that user counts decreased by one")
    public void validateThatUserCountsDecreasedByOne() throws InterruptedException {
        dashboard.clickOnAdminPageButton();
        Thread.sleep(2000);
        decreasedCount =  admin.getRecordsCount();
        System.out.println(decreasedCount);
        Assert.assertEquals(decreasedCount,currentCount);

    }
}
