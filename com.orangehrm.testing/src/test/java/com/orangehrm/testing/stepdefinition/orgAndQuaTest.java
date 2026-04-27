package com.orangehrm.testing.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.AllUtilityFunction;
import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.testing.objectrepository.pages.DashbordPage;
import com.orangehrm.testing.objectrepository.pages.organizationPage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class orgAndQuaTest extends Base {

    DashbordPage d = new DashbordPage(Base.getDriver());
    organizationPage ong = new organizationPage(Base.getDriver());

    //  Excel Data Variables
    String location, country, city, address;

    //  Load Excel Data Before Scenario
    @Before
    public void loadExcelData() {
        Object[][] data = AllUtilityFunction.getData("Sheet1");

        location = data[0][0].toString();
        country  = data[0][1].toString();
        city     = data[0][2].toString();
        address  = data[0][3].toString();
    }

    @When("user navigates to organization")
    public void user_navigates_to_organization() {
        d.setAdminLink();
        ong.setOrganizationMenu();
    }

    @When("user clicks locations link")
    public void user_clicks_locations_link() {
        ong.setLocationsOption();
        ong.setAddButton();
    }

    //  LOCATION (Excel)
    @When("user enters location name")
    public void user_enters_location_name() {
    	ong.setOrganizationMenu();
    	ong.setLocationsOption();
        ong.setAddButton();
        ong.setLocationNameField(location);
    }

    //  COUNTRY (Excel)
    @When("user selects country")
    public void user_selects_country() {
        ong.setCountryDropdown();
        ong.setCountryOption(); // if static selection

        //  If dynamic method exists, use:
        // ong.selectCountry(country);
    }

    //  CITY (Excel)
    @When("user enters city")
    public void user_enters_city() {
        ong.setCityField(city);
    }

    // ADDRESS (Excel)
    @When("user enters address")
    public void user_enters_address() {
        ong.setAddressField(address);
    }
    @When("user clicks save button")
    public void user_clicks_save_button() {
        ong.setSaveButton();
    }

    @Then("location should be added successfully")
    public void location_should_be_added_successfully() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement messageElement = wait.until(
                ExpectedConditions.visibilityOf(ong.getSuccessMessage()));
        String actualMsg = messageElement.getText();
        Assert.assertTrue(actualMsg.contains("Success"));
        System.out.println("Location added successfully");
    }
}
//import java.time.Duration;
//
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.orangeHRM.seleniumuiframwork_Object_repository.DashbordPage;
//import com.orangeHRM.seleniumuiframwork_Object_repository_Admin.addUserPage;
//import com.orangeHRM.seleniumuiframwork_Object_repository_Admin.organizationPage;
//import com.orangeHRM.seleniumuiframwork_genricutility.Base;
//
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class orgAndQuaTest extends Base {
//	DashbordPage d = new DashbordPage(Base.getDriver());
//	organizationPage ong = new organizationPage(Base.getDriver());
//	addUserPage au = new addUserPage(Base.getDriver());
//	
//	@When("user navigates to organization")
//	public void user_navigates_to_organization() {
//		d.setAdminLink();
//	    ong.setOrganizationMenu();
//	
//	}
//	@When("user clicks locations link")
//	public void user_clicks_locations_link() {
//		ong.setLocationsOption();
//	    ong.setAddButton();
//	}
//	@When("user enters location name {string}")
//	public void user_enters_location_name(String string) {
//		ong.setOrganizationMenu();
//	    ong.setLocationsOption();
//		ong.setAddButton();
//	    ong.setLocationNameField(string);
//	}
//	@When("user selects country {string}")
//	public void user_selects_country(String string) {
//		ong.setCountryDropdown();
//		ong.setCountryOption();
//	}
//	@When("user enters city {string}")
//	public void user_enters_city(String string) {
//		ong.setCityField(string);
//	}
//	@When("user enters address {string}")
//	public void user_enters_address(String string) {
//		ong.setAddressField(string);
//	}
//	@Then("location should be added successfully")
//	public void location_should_be_added_successfully() {
//		ong.setSaveButton();
//		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//		   WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(au.getVerifyUserAdded()));
//		    String actualMsg = messageElement.getText();
//		    Assert.assertEquals(actualMsg,"Successfully Saved");
//		System.out.println("lication added successfully");
//	}
//}
