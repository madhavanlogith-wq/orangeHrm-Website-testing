package com.orangehrm.testing.stepdefinition;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;
import com.orangehrm.seleniumuiframwork_genricutility.AllUtilityFunction;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class MyInfoSteps {

    private Pages pages;

    public MyInfoSteps() {
        pages = new Pages(Base.getDriver());
    }

    // ================= NAVIGATION =================

    @Given("user is logged in and navigates to My Info page")
    public void user_is_logged_in_and_navigates_to_my_info_page() {
        pages.personalDetailsPage.setMyInfoMenu();
    }
<<<<<<< HEAD
    
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

=======

    // ================= PERSONAL DETAILS =================

    @When("user updates personal details {string} {string}")
    public void user_updates_personal_details(String fname, String lname) {
        pages.personalDetailsPage.name_first_last(fname, lname);
    }

    @When("user selects nationality and marital status")
    public void user_selects_nationality_and_marital_status() {
        pages.personalDetailsPage.setNationalityDropdown();
        pages.personalDetailsPage.setMaritalStatusDropdown();
    }
>>>>>>> deepika

    @When("user clicks save button")
    public void user_clicks_save_button() {
        pages.personalDetailsPage.setSaveButton();
    }

    @Then("personal details should be saved successfully")
    public void personal_details_should_be_saved_successfully() {
        String value = pages.personalDetailsPage.getFirstName().getAttribute("value");
        Assert.assertTrue(value.length() > 0);
    }

    // ================= CONTACT DETAILS (DATATABLE) =================

    @When("user navigates to Contact Details tab")
    public void user_navigates_to_contact_details_tab() {
        pages.personalDetailsPage.setContactDetailsTab();
    }

    @When("user enters contact details")
    public void user_enters_contact_details(DataTable table) {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        pages.contactDetailsPage.enterStreet1(data.get(0).get("street"));
        pages.contactDetailsPage.enterCity(data.get(0).get("city"));
        pages.contactDetailsPage.enterMobile(data.get(0).get("mobile"));
    }

    @When("user clicks save button in contact details")
    public void user_clicks_save_button_in_contact_details() {
    
        pages.contactDetailsPage.clickSaveButton();
    }

//    @Then("contact details should be saved successfully")
//    public void contact_details_should_be_saved_successfully() {
//        String city = pages.contactDetailsPage.getCity().getAttribute("value");
//        Assert.assertTrue(city.length() > 0);
//    }
    @Then("contact details should be saved successfully")
    public void contact_details_should_be_saved_successfully() {

        String actualMsg = pages.contactDetailsPage.getToastMessageText();

        Assert.assertEquals(actualMsg, "Success");
    }

    // ================= EXCEL =================

    @When("user updates personal details from excel {string} row {int}")
    public void user_updates_personal_details_from_excel(String sheetName, Integer row) {

        Object[][] data = AllUtilityFunction.getData(sheetName);

        String fname = data[row][0].toString();
        String lname = data[row][1].toString();

        pages.personalDetailsPage.setFirstName(fname);
        pages.personalDetailsPage.setLastName(lname);
    }

    // ================= EMERGENCY CONTACT =================

    @When("user navigates to Emergency Contacts tab")
    public void user_navigates_to_emergency_contacts_tab() {
        pages.personalDetailsPage.setEmergencyContactsTab();
    }

    @When("user clicks add button in emergency contacts")
    public void user_clicks_add_button_in_emergency_contacts() {
        pages.emergencyContactsPage.clickAddButton();
    }

    @When("user enters name {string} relationship {string} and mobile {string}")
    public void user_enters_name_relationship_and_mobile(String name, String relation, String mobile) {
        pages.emergencyContactsPage.enterName(name);
        pages.emergencyContactsPage.enterRelationship(relation);
        pages.emergencyContactsPage.enterMobile(mobile);
    }

    @When("user clicks save button in emergency contacts")
    public void user_clicks_save_button_in_emergency_contacts() {
        pages.emergencyContactsPage.clickSaveButton();
    }

    @Then("emergency contact should be saved successfully")
    public void emergency_contact_should_be_saved_successfully() {
        String name = pages.emergencyContactsPage.getName().getAttribute("value");
        Assert.assertTrue(name.length() > 0);
    }

    // ================= DEPENDENTS =================

    @When("user navigates to Dependents tab")
    public void user_navigates_to_dependents_tab() {
        // If you add locator → call here
    	pages.dependentsPage.setDependentsButton();
    	
    }

    @When("user clicks add button in dependents")
    public void user_clicks_add_button_in_dependents() {
        pages.dependentsPage.clickAddButton();
    }

    @When("user enters dependent details")
    public void user_enters_dependent_details(DataTable table) {

        List<Map<String, String>> data = table.asMaps(String.class, String.class);

        pages.dependentsPage.enterName(data.get(0).get("name"));
        pages.dependentsPage.selectRelationship(data.get(0).get("relation"));
    }

    @When("user clicks save button in dependents")
    public void user_clicks_save_button_in_dependents() {
        pages.dependentsPage.clickSaveButton();
    }

    @Then("dependent should be saved successfully")
    public void dependent_should_be_saved_successfully() {
        String name = pages.dependentsPage.getName().getAttribute("value");
        Assert.assertTrue(name.length() > 0);
    }

    // ================= NEGATIVE =================

//    @When("user clears first name field")
//    public void user_clears_first_name_field() {
//        pages.personalDetailsPage.getFirstName().clear();
//    }
    
    @When("user clears first name field")
    public void user_clears_first_name_field() {
        pages.personalDetailsPage.clearFirstName();
    }

    @Then("first name field should show required validation")
    public void first_name_field_should_show_required_validation() {

        boolean error = pages.personalDetailsPage.isFirstNameErrorDisplayed();

        Assert.assertTrue(error);
    }
    
}
   