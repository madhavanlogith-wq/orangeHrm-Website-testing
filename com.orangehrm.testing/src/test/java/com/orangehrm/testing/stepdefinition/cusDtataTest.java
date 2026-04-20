package com.orangehrm.testing.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.testing.objectrepository.pages.DashbordPage;
import com.orangehrm.testing.objectrepository.pages.PimCusDataPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class cusDtataTest extends Base{
	DashbordPage d = new DashbordPage(Base.getDriver());
	PimCusDataPage pcd = new PimCusDataPage(Base.getDriver());

	@Given("user navigates to PIM module")
	public void user_navigates_to_pim_module() {
	    d.setPimLink();
	}
	@When("user clicks on Configuration menu")
	public void user_clicks_on_configuration_menu() {
	    pcd.setConfigurationMenu();
	}
	@When("user clicks on Custom Fields option")
	public void user_clicks_on_custom_fields_option() {
	   pcd.setCustomField();
	}
	@When("user clicks on Add button")
	public void user_clicks_on_add_button() {
	    pcd.setAddButton();
	}
	@When("user enters field name {string}")
	public void user_enters_field_name(String string) {
	    pcd.setFieldName(string);
	}
	@When("user selects screen {string}")
	public void user_selects_screen(String string) {
	    pcd.setScreen();
	    pcd.setScreenDroupDown();
	}
	@When("user selects type {string}")
	public void user_selects_type(String string) {
		pcd.setType();
		pcd.setTypeDroupDown();
	}
	
	@When("user clicks on Save button")
	public void user_clicks_on_save_button() {
		pcd.setSaveButton();
	}
	@Then("custom field should be created successfully")
	public void custom_field_should_be_created_successfully() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		   WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(pcd.getVerifyCusDara()));
		    String actualMsg = messageElement.getText();
		    Assert.assertEquals(actualMsg,"Successfully Saved");
//			System.out.println(Pages.aujp.getVerifyUserAdded());

	   System.out.println("created successfully");
	}
}

