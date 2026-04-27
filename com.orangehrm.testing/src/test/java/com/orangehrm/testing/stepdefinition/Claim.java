package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

import java.util.List;
import java.util.Map;

import com.orangehrm.seleniumuiframwork_genricutility.AllUtilityFunction;
import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;

public class Claim {


    private Pages pages;

    private Pages getPages() {
        if (pages == null) {
            pages = new Pages(Base.getDriver());
        }
        return pages;
    }

    @Given("user is on dashboard")
    public void user_is_on_dashboard() {
        System.out.println("User is on dashboard");
    }

    // ================= SUBMIT CLAIM (DATATABLE) =================

    @When("user submits claim with following details")
    public void user_submits_claim_with_following_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Navigate once (better design)
        getPages().submit_Claim.openClaimModule();
        getPages().submit_Claim.openSubmitClaimTab();

        for (Map<String, String> row : data) {

            String event = row.get("event");
            String currency = row.get("currency");
            String remarks = row.get("remarks");

            getPages().submit_Claim.selectEvent(event);
            getPages().submit_Claim.selectCurrency(currency);
            getPages().submit_Claim.enterRemarks(remarks);

            getPages().submit_Claim.clickCreate();
        }
    }

    @Then("user should be navigated to claim details page")
    public void user_should_be_navigated_to_claim_details_page() {

        Assert.assertTrue(
                Base.getDriver().getCurrentUrl().contains("/claim/submitClaim"),
                "Not navigated to Claim Details page"
        );
    }

    @When("user clicks Submit button")
    public void user_clicks_submit_button() {
    	getPages().submit_Claim.clickSubmit();
    	getPages().submit_Claim.waitForSubmission();
    }

    @Then("claim should be submitted successfully")
    public void claim_should_be_submitted_successfully() {

        String url = Base.getDriver().getCurrentUrl();

        Assert.assertTrue(
                url.contains("/claim/submitClaim/id/"),
                "Claim not submitted. URL: " + url
        );
    }

    // ================= MY CLAIMS =================
    
//  Excel Data Variables
    String ref_ID;

    //  Load Excel Data Before Scenario
    @Before
    public void loadExcelData() {
        Object[][] data = AllUtilityFunction.getData("Claim");

        ref_ID = data[0][0].toString();
       
    }


    
    @When("user navigates to Claim module")
    public void user_navigates_to_claim_module() {
    	getPages().submit_Claim.openClaimModule();
    }

    @When("user clicks on My Claims section")
    public void user_clicks_on_my_claims_section() {
    	getPages().my_claims.openMyClaims();
    }
    
    @When("user enters reference ID")
    public void user_enters_reference_id() {
        getPages().my_claims.enterReferenceId(ref_ID);
    }
    

//    @When("user enters reference ID {string}")
//    public void user_enters_reference_id(String refId) {
//        pages.my_claims.enterReferenceId(refId);
//    }
  
    @When("user selects reference ID from dropdown")
    public void user_selects_reference_id_from_dropdown() {
    	getPages().my_claims.selectReferenceFromDropdown();
    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {
    	getPages().my_claims.clickSearch();
    }

    @When("user clicks on View button for the claim")
    public void user_clicks_on_view_button_for_the_claim() {
    	getPages().my_claims.clickView();
    }

    @Then("user should be redirected to claim details page")
    public void user_should_be_redirected_to_claim_details_page() {

        Assert.assertTrue(
                Base.getDriver().getCurrentUrl().contains("/claim/submitClaim"),
                "Not redirected to Claim Details page"
        );
    }

    @Then("URL should contain claim id")
    public void url_should_contain_claim_id() {

        String url = Base.getDriver().getCurrentUrl();

        Assert.assertTrue(
                url.matches(".*/claim/submitClaim/id/\\d+"),
                "Invalid URL format: " + url
        );
    }
}