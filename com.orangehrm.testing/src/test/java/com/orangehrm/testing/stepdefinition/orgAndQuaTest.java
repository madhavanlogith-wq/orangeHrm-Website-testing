package com.orangehrm.testing.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.testing.objectrepository.pages.DashbordPage;
import com.orangehrm.testing.objectrepository.pages.addUserPage;
import com.orangehrm.testing.objectrepository.pages.organizationPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class orgAndQuaTest extends Base {
	DashbordPage d = new DashbordPage(Base.getDriver());
	organizationPage ong = new organizationPage(Base.getDriver());
	addUserPage au = new addUserPage(Base.getDriver());
	
	@When("user navigates to organization")
	public void user_navigates_to_organization() {
		d.getAdminLink();
	    ong.setOrganizationMenu();
	
	}
	@When("user clicks locations link")
	public void user_clicks_locations_link() {
		ong.setLocationsOption();
	    ong.setAddButton();
	}
	@When("user enters location name {string}")
	public void user_enters_location_name(String string) {
		ong.setOrganizationMenu();
	    ong.setLocationsOption();
		ong.setAddButton();
	    ong.setLocationNameField(string);
	}
	@When("user selects country {string}")
	public void user_selects_country(String string) {
		ong.setCountryDropdown();
		ong.setCountryOption();
	}
	@When("user enters city {string}")
	public void user_enters_city(String string) {
		ong.setCityField(string);
	}
	@When("user enters address {string}")
	public void user_enters_address(String string) {
		ong.setAddressField(string);
	}
	@Then("location should be added successfully")
	public void location_should_be_added_successfully() {
		ong.setSaveButton();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		   WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(au.getVerifyUserAdded()));
		    String actualMsg = messageElement.getText();
		    Assert.assertEquals(actualMsg,"Successfully Saved");
		System.out.println("lication added successfully");
	}
}

