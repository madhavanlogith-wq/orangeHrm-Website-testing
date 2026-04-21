
package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.testing.objectrepository.pages.DashbordPage;
import com.orangehrm.testing.objectrepository.pages.pimAddEmpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addEmpTest extends Base{
	DashbordPage d = new DashbordPage(Base.getDriver());
	pimAddEmpPage aep = new pimAddEmpPage(Base.getDriver());
	
	@Given("user clicks on Add Employee button")
	public void user_clicks_on_add_employee_button() {
		d.setPimLink();
	    aep.setAddButton();
	}
	@When("user enters first name {string}")
	public void user_enters_first_name(String string) {
	    aep.setFirstName(string);
	}
	@When("user enters middle name {string}")
	public void user_enters_middle_name(String string) {
	    aep.setMiddleName(string);
	}
	@When("user enters last name {string}")
	public void user_enters_last_name(String string) {
	    aep.setLastName(string);
	}
	@When("user enters employee id {string}")
	public void user_enters_employee_id(String string) {
	    aep.setType(string);
	}
	@Then("system should display message {string}")
	public void system_should_display_message(String string) {

	    aep.setSaveButton();
	    String actualText = aep.getGetVerify().getText();
		Assert.assertEquals(actualText, string);
	    System.out.println("Saved");
	}
	@When("user leaves first name blank")
	public void user_leaves_first_name_blank() {
	    aep.getFirstName();
	}
	@When("user leaves last name blank")
	public void user_leaves_last_name_blank() {
	    aep.getMiddleName();
//	    aep.getSaveButton();
	    aep.clickSaveButton();
	}
	@Then("system should display error message {string}")
	public void system_should_display_error_message(String string) {
		String actualText = aep.getVerifyError().getText();
		Assert.assertEquals(actualText, string);
//		 String actualText = aep.getSuccessMessage();
//		    Assert.assertEquals(actualText, string);
		System.out.println("Negative Scenario Exicuted");
	}
}
