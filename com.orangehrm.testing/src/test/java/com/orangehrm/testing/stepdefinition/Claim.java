package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;
import io.cucumber.java.en.*;
import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;

public class Claim {

    private Pages pages;

    public Claim() {
        this.pages = new Pages(Base.getDriver());
    }
    
  @Given("user is on dashboard")
  public void user_is_on_dashboard() {
      System.out.println("User is on dashboard");
  }

    // ================= SUBMIT CLAIM =================

    @When("user navigates to Submit Claim section")
    public void user_navigates_to_submit_claim_section() {
        pages.submit_Claim.openClaimModule();
        pages.submit_Claim.openSubmitClaimTab();
    }

    @When("user selects event as {string}")
    public void user_selects_event_as(String event) {
        pages.submit_Claim.selectEvent(event);
    }

    @When("user selects currency as {string}")
    public void user_selects_currency_as(String currency) {
        pages.submit_Claim.selectCurrency(currency);
    }

    @When("user enters remarks {string}")
    public void user_enters_remarks(String remarks) {
        pages.submit_Claim.enterRemarks(remarks);
    }

    @When("user clicks on Create button")
    public void user_clicks_on_create_button() {
        pages.submit_Claim.clickCreate();
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
        pages.submit_Claim.clickSubmit();
        pages.submit_Claim.waitForSubmission();
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

    @When("user navigates to Claim module")
    public void user_navigates_to_claim_module() {
        pages.submit_Claim.openClaimModule();
    }

    @When("user clicks on My Claims section")
    public void user_clicks_on_my_claims_section() {
        pages.my_claims.openMyClaims();
    }

    @When("user enters reference ID {string}")
    public void user_enters_reference_id(String refId) {
        pages.my_claims.enterReferenceId(refId);
    }

    @When("user selects reference ID from dropdown")
    public void user_selects_reference_id_from_dropdown() {
        pages.my_claims.selectReferenceFromDropdown();
    }

    @When("user clicks on Search button")
    public void user_clicks_on_search_button() {
        pages.my_claims.clickSearch();
    }

    @When("user clicks on View button for the claim")
    public void user_clicks_on_view_button_for_the_claim() {
        pages.my_claims.clickView();
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
 
// @Given("user is on dashboard")
// public void user_is_on_dashboard() {
//     System.out.println("User is on dashboard");
// }
