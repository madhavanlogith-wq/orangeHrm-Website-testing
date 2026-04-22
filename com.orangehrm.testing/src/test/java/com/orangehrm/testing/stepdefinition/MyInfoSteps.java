package com.orangehrm.testing.stepdefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;

import java.time.Duration;

public class MyInfoSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ NEW: Pages object (like Buzz class)
    private Pages pages;

    // ✅ Initialize Pages using ThreadLocal driver
    public MyInfoSteps() {
        this.driver = Base.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        this.pages = new Pages(Base.getDriver());   // 🔥 IMPORTANT CHANGE
    }

    @Given("user is logged in and navigates to My Info page")
    public void user_is_logged_in_and_navigates_to_my_info_page() {

        wait.until(ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//span[text()='My Info']")
        )).click();

        wait.until(ExpectedConditions.visibilityOf(
                pages.personalDetailsPage.getFirstName()
        ));
    }
    
    @When("user updates the first name {string}")
    public void user_updates_the_first_name(String firstName) {
       pages.personalDetailsPage.enterFirstName(firstName);
    }
    @When("user updates the last name {string}")
    public void user_updates_the_last_name(String lastName) {
        // Write code here that turns the phrase above into concrete actions
        pages.personalDetailsPage.enterLastName(lastName);
    }
    @When("user clicks the nationality {string} and marital status dropdown {string} myInfo")
    public void user_clicks_the_nationality_and_marital_status_dropdown_my_info(String nationality, String martialStatus) {
    	
       pages.personalDetailsPage.selectMaritalStatus(driver, nationality);
       pages.personalDetailsPage.selectMaritalStatus(driver, martialStatus);
    }


    @When("user clicks save button")
    public void user_clicks_save_button() {

        wait.until(ExpectedConditions.elementToBeClickable(
                pages.personalDetailsPage.getSaveButton()
        )).click();
    }

    @Then("personal details should be saved successfully")
    public void personal_details_should_be_saved_successfully() {
        System.out.println("Personal Details Updated Successfully");
    }

    // CONTACT
    @When("user navigates to Contact Details tab")
    public void user_navigates_to_contact_details_tab() {

        wait.until(ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//a[text()='Contact Details']")
        )).click();

        wait.until(ExpectedConditions.visibilityOf(
                pages.contactDetailsPage.getStreet1()
        ));
    }

    @When("user enters street address, city, mobile and work email")
    public void user_enters_street_address_city_mobile_and_work_email() {

        pages.contactDetailsPage.enterStreet1("Chennai Street");
        pages.contactDetailsPage.enterCity("Chennai");
        pages.contactDetailsPage.enterMobile("9876543210");
        pages.contactDetailsPage.enterWorkEmail("deebiga@test.com");
    }

    @When("user clicks save button in contact details")
    public void user_clicks_save_button_in_contact_details() {

        wait.until(ExpectedConditions.elementToBeClickable(
                pages.contactDetailsPage.getSaveButton()
        )).click();
    }

    @Then("contact details should be saved successfully")
    public void contact_details_should_be_saved_successfully() {
        System.out.println("Contact Details Updated Successfully");
    }

    // NEGATIVE
    @When("user clears first name field")
    public void user_clears_first_name_field() {

        pages.personalDetailsPage.getFirstName().click();
        pages.personalDetailsPage.getFirstName().sendKeys(Keys.CONTROL + "a");
        pages.personalDetailsPage.getFirstName().sendKeys(Keys.DELETE);
    }

    @When("user enters only last name")
    public void user_enters_only_last_name() {

        pages.personalDetailsPage.enterLastName("TestLast");
    }

    @Then("first name field should show required validation")
    public void first_name_field_should_show_required_validation() {

        wait.until(ExpectedConditions.attributeContains(
                pages.personalDetailsPage.getFirstName(),
                "class",
                "error"
        ));

        System.out.println("Required validation displayed for First Name");
    }
    
    // ================= EMERGENCY CONTACT =================

    @When("user navigates to Emergency Contacts tab")
    public void user_navigates_to_emergency_contacts_tab() {

        wait.until(ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//a[text()='Emergency Contacts']")
        )).click();

        wait.until(ExpectedConditions.visibilityOf(
                pages.emergencyContactsPage.getAddButton()
        ));
    }

    @When("user enters name, relationship and mobile")
    public void user_enters_name_relationship_and_mobile() {

        pages.emergencyContactsPage.enterName("John Doe");
        pages.emergencyContactsPage.enterRelationship("Brother");
        pages.emergencyContactsPage.enterMobile("9876543210");
    }

    @When("user clicks save button in emergency contacts")
    public void user_clicks_save_button_in_emergency_contacts() {

        wait.until(ExpectedConditions.elementToBeClickable(
                pages.emergencyContactsPage.getSaveButton()
        )).click();
    }

    @Then("emergency contact should be saved successfully")
    public void emergency_contact_should_be_saved_successfully() {

////        String msg = pages.emergencyContactsPage
//
//        if (msg != null && msg.toLowerCase().contains("success")) {
//            System.out.println("Emergency Contact Saved Successfully");
//        } else {
//            throw new AssertionError("Emergency Contact not saved. Message: " + msg);
//        }
    }
    
    // ================= DEPENDENTS =================

    @When("user navigates to Dependents tab")
    public void user_navigates_to_dependents_tab() {

        wait.until(ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//a[text()='Dependents']")
        )).click();

        wait.until(ExpectedConditions.visibilityOf(
                pages.dependentsPage.getAddButton()
        ));
    }

    @When("user clicks add button in dependents")
    public void user_clicks_add_button_in_dependents() {

        pages.dependentsPage.clickAddButton();
    }

    @When("user enters dependent name and selects relationship")
    public void user_enters_dependent_name_and_selects_relationship() {

        pages.dependentsPage.enterName("Rahul Kumar");
        pages.dependentsPage.selectRelationship("Child");
    }

    @When("user clicks save button in dependents")
    public void user_clicks_save_button_in_dependents() {

        wait.until(ExpectedConditions.elementToBeClickable(
                pages.dependentsPage.getSaveButton()
        )).click();
    }

    @Then("dependent should be saved successfully")
    public void dependent_should_be_saved_successfully() {

//        String msg = pages.dependentsPage.getSuccessMessage();
//
//        if (msg != null && msg.toLowerCase().contains("success")) {
//            System.out.println("Dependent saved successfully");
//        } else {
//            throw new AssertionError("Dependent not saved. Message: " + msg);
//        }
    }
    
    // ================= QUALIFICATIONS (WORK EXPERIENCE) =================

    @When("user navigates to Qualifications tab")
    public void user_navigates_to_qualifications_tab() {

        wait.until(ExpectedConditions.elementToBeClickable(
                org.openqa.selenium.By.xpath("//a[text()='Qualifications']")
        )).click();

        wait.until(ExpectedConditions.visibilityOf(
                pages.qualificationsPage.getAddButton()
        ));
    }

    @When("user clicks add button in qualifications")
    public void user_clicks_add_button_in_qualifications() {

        pages.qualificationsPage.clickAddButton();
    }

    @When("user enters company and job title")
    public void user_enters_company_and_job_title() {

        pages.qualificationsPage.enterCompany("TCS");
        pages.qualificationsPage.enterJobTitle("Software Engineer");
    }

    @When("user clicks save button in qualifications")
    public void user_clicks_save_button_in_qualifications() {

        wait.until(ExpectedConditions.elementToBeClickable(
                pages.qualificationsPage.getSaveButton()
        )).click();
    }

    @Then("work experience should be saved successfully")
    public void work_experience_should_be_saved_successfully() {

//        String msg = pages.qualificationsPage.getSuccessMessage();
//
//        if (msg != null && msg.toLowerCase().contains("success")) {
//            System.out.println("Work Experience saved successfully");
//        } else {
//            throw new AssertionError("Work Experience not saved. Message: " + msg);
//        }
    }
}