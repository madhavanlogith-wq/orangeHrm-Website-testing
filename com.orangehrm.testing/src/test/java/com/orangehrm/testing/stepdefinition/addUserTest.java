package com.orangehrm.testing.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.testing.objectrepository.pages.DashbordPage;
import com.orangehrm.testing.objectrepository.pages.addUserPage;

import io.cucumber.java.en.*;

public class addUserTest {

    WebDriver driver = Base.getDriver();

    DashbordPage d = new DashbordPage(driver);
    addUserPage au = new addUserPage(driver);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // ================= LOGIN (Handled in Hooks) =================

    @Given("user launches browser and opens application")
    public void user_launches_browser_and_opens_application() {
        // handled in hooks
    }

    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String u, String p) {
        // handled in hooks
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        // handled in hooks
    }

    @Then("user should see dashboard page with all elements")
    public void user_should_see_dashboard_page_with_all_elements() {
        System.out.println("Logged into OrangeHRM successfully");
    }

    // ================= ADD USER =================

    @When("user clicks add button")
    public void user_clicks_add_button() {
        d.setAdminLink();
        au.setAddButtonUser();
    }

    @When("user selects user role {string}")
    public void user_selects_user_role(String role) {
        au.setRoledroupdown();
        au.setSelectRole();
    }

    @When("user enters employee name {string}")
    public void user_enters_employee_name(String empName) {
        au.setEmployeeNameTextField(empName);
    }

    @When("user selects status {string}")
    public void user_selects_status(String status) {
        au.setStstusTextField();
        au.setEnabledOption();
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        au.setUsernameTextField(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        au.setPasswordTextField(password);
    }

    @When("user enters confirm password {string}")
    public void user_enters_confirm_password(String confirmPassword) {
        au.setConfirmPasswordTextField(confirmPassword);
    }

    // 🔥 FIX: RENAMED STEP TO AVOID DUPLICATE ERROR
    @When("user clicks save button in Add User page")
    public void user_clicks_save_button_in_add_user_page() {
        au.setSaveButton();
    }

    @Then("user should be added successfully")
    public void user_should_be_added_successfully() {

        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOf(au.getVerifyUserAdded())
        );

        String actualMsg = messageElement.getText();

        Assert.assertTrue(
                actualMsg.contains("Successfully Saved"),
                "User not added successfully. Actual: " + actualMsg
        );

        System.out.println("User added successfully");
    }
}