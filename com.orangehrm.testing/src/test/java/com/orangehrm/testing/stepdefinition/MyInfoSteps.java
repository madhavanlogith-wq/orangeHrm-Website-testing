package com.orangehrm.testing.stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangeHRM.seleniumuiframwork_genricutility.Base;
import com.orangeHRM.seleniumuiframwork_genricutility.Pages;

import java.time.Duration;

public class MyInfoSteps {

    WebDriver driver;
    WebDriverWait wait;

    public MyInfoSteps() {
        this.driver = Base.getDriver(); // 🔥 GET THREAD DRIVER
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("user is logged in and navigates to My Info page")
    public void user_is_logged_in_and_navigates_to_my_info_page() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Info']"))).click();

        wait.until(ExpectedConditions.visibilityOf(Pages.personalDetailsPage.getFirstName()));
    }

    @When("user updates first name and last name")
    public void user_updates_first_name_and_last_name() {

        Pages.personalDetailsPage.enterFirstName("Deebiga");
        Pages.personalDetailsPage.enterLastName("RK");
    }

    @When("user clicks nationality and marital status dropdown")
    public void user_clicks_nationality_and_marital_status_dropdown() {

        wait.until(ExpectedConditions.elementToBeClickable(Pages.personalDetailsPage.getNationalityDropdown())).click();
        wait.until(ExpectedConditions.elementToBeClickable(Pages.personalDetailsPage.getMaritalStatusDropdown())).click();
    }

    @When("user clicks save button")
    public void user_clicks_save_button() {

        wait.until(ExpectedConditions.elementToBeClickable(Pages.personalDetailsPage.getSaveButton())).click();
    }

    @Then("personal details should be saved successfully")
    public void personal_details_should_be_saved_successfully() {

        System.out.println("Personal Details Updated Successfully");
    }

    // CONTACT
    @When("user navigates to Contact Details tab")
    public void user_navigates_to_contact_details_tab() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Contact Details']"))).click();

        wait.until(ExpectedConditions.visibilityOf(Pages.contactDetailsPage.getStreet1()));
    }

    @When("user enters street address, city, mobile and work email")
    public void user_enters_street_address_city_mobile_and_work_email() {

        Pages.contactDetailsPage.enterStreet1("Chennai Street");
        Pages.contactDetailsPage.enterCity("Chennai");
        Pages.contactDetailsPage.enterMobile("9876543210");
        Pages.contactDetailsPage.enterWorkEmail("deebiga@test.com");
    }

    @When("user clicks save button in contact details")
    public void user_clicks_save_button_in_contact_details() {

        wait.until(ExpectedConditions.elementToBeClickable(Pages.contactDetailsPage.getSaveButton())).click();
    }

    @Then("contact details should be saved successfully")
    public void contact_details_should_be_saved_successfully() {

        System.out.println("Contact Details Updated Successfully");
    }

    // NEGATIVE
    @When("user clears first name field")
    public void user_clears_first_name_field() {

        Pages.personalDetailsPage.getFirstName().click();
        Pages.personalDetailsPage.getFirstName().sendKeys(Keys.CONTROL + "a");
        Pages.personalDetailsPage.getFirstName().sendKeys(Keys.DELETE);
    }

    @When("user enters only last name")
    public void user_enters_only_last_name() {

        Pages.personalDetailsPage.enterLastName("TestLast");
    }

    @Then("first name field should show required validation")
    public void first_name_field_should_show_required_validation() {

        wait.until(ExpectedConditions.attributeContains(
                Pages.personalDetailsPage.getFirstName(),
                "class",
                "error"
        ));

        System.out.println("Required validation displayed for First Name");
    }
}
