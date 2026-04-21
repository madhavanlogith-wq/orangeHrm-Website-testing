package com.orangehrm.testing.stepdefinition;
package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.Map;

public class RecruitmentSteps {

    private Pages pages;

    // ✅ Thread-safe Pages initialization
    public RecruitmentSteps() {
        this.pages = new Pages(Base.getDriver());
    }

    // ================= LOGIN =================

    @Given("User is already logged in")
    public void already_logged_in() {
        Base.getDriver().get("https://opensource-demo.orangehrmlive.com/");
        pages.lp.login("Admin", "admin123");
    }

    // ================= ADD CANDIDATE =================

    @When("User navigates to Recruitment module")
    public void go_to_recruitment() {
        pages.rp.goToRecruitment();
    }

    @When("User clicks on Add Candidate button")
    public void click_add_candidate() {
        pages.rp.clickAdd();
    }

    @When("User enters candidate details")
    public void enter_candidate_details(DataTable data) {

        Map<String, String> map = data.asMap(String.class, String.class);

        pages.cp.addCandidate(
                map.get("FirstName"),
                map.get("LastName"),
                map.get("Email")
        );
    }

    @Then("Candidate should be added successfully")
    public void verify_candidate_added() {

        Assert.assertTrue(
                pages.cp.getResult() != null &&
                !pages.cp.getResult().isEmpty(),
                "Candidate not added"
        );
    }

    // ================= ADD VACANCY =================

    @When("User navigates to Recruitment vacancies section")
    public void go_to_vacancy_section() {
        pages.rp.goToRecruitment();
        pages.vp.goToVacancy();
    }

    @When("User clicks on Add Vacancy button")
    public void click_add_vacancy() {
        pages.vp.clickAdd();
    }

    @When("User enters vacancy details")
    public void enter_vacancy_details(DataTable data) {

        Map<String, String> map = data.asMap(String.class, String.class);

        pages.vp.addVacancy(
                map.get("VacancyName"),
                map.get("JobTitle"),
                map.get("HiringManager")
        );
    }

    @Then("Vacancy should be created successfully")
    public void verify_vacancy_created() {

        Assert.assertTrue(
                pages.vp.getResult() != null &&
                !pages.vp.getResult().isEmpty(),
                "Vacancy not created"
        );
    }

    // ================= SEARCH CANDIDATE =================

    @When("User navigates to Candidate list page")
    public void navigate_candidate_list() {
        pages.rp.goToRecruitment();
    }

    @When("User searches candidate {string}")
    public void search_candidate(String name) {
        pages.cp.searchAndSelectCandidate(name);
    }

    @Then("Candidate details should be displayed correctly")
    public void verify_candidate_details() {

        Assert.assertTrue(
                Base.getDriver().getCurrentUrl().contains("viewCandidate"),
                "Candidate page not opened"
        );
    }

    // ================= SEARCH VACANCY =================

    @When("User navigates to Vacancy list page")
    public void navigate_vacancy_list() {
        pages.rp.goToRecruitment();
        pages.vp.goToVacancy();
    }

    @When("User searches vacancy {string}")
    public void search_vacancy(String name) {
        pages.vp.searchAndSelectVacancy(name);
    }

    @Then("Vacancy details should be displayed correctly")
    public void verify_vacancy_details() {

        Assert.assertTrue(
                pages.vp.getResult() != null &&
                !pages.vp.getResult().isEmpty(),
                "Vacancy search failed"
        );
    }

    // ================= VALIDATIONS =================

    @When("User is on Add Candidate page")
    public void on_add_candidate_page() {
        pages.rp.goToRecruitment();
        pages.rp.clickAdd();
    }

    @When("User enters FirstName as {string}")
    public void enter_firstname(String fn) {
        pages.cp.enterFirstName(fn);
    }

    @When("User enters LastName as {string}")
    public void enter_lastname(String ln) {
        pages.cp.enterLastName(ln);
    }

    @When("User enters Email as {string}")
    public void enter_email(String em) {
        pages.cp.enterEmail(em);
    }

    @When("User clicks Save button")
    public void click_save() {
        pages.cp.clickSave();
    }

    @Then("System should show email validation error")
    public void verify_email_error() {

        String error = pages.cp.getError();

        Assert.assertTrue(
                error != null && !error.isEmpty(),
                "Email validation error not displayed"
        );
    }

    @Then("Candidate should not be created")
    public void candidate_not_created() {
        Assert.assertTrue(true); // placeholder
    }

    @When("User clicks Save button without entering any data")
    public void save_without_data() {
        pages.cp.clickSave();
    }

    @Then("System should show validation error messages")
    public void validate_empty_errors() {

        String error = pages.cp.getError();

        Assert.assertTrue(
                error != null && !error.isEmpty(),
                "Validation errors not displayed"
        );
    }
}
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.orangehrm.testing.utilities.BaseClass;
//import com.orangehrm.testing.utilities.Pages;
//
//import java.time.Duration;
//import java.util.Map;
//
//public class RecruitmentSteps {
//	
//    // ✅ Initialize Pages with driver
//    private Pages pages;
//
//    @Before
//    public void init() {
//        pages = new Pages(BaseClass.getDriver());
//    }
//
//    // ================= LOGIN =================
//
//    @Given("User is already logged in")
//    public void already_logged_in() {
//
//        BaseClass.getDriver().get("https://opensource-demo.orangehrmlive.com/");
//
//        pages.lp.login("Admin", "admin123");
//    }
//
//    // ================= ADD CANDIDATE =================
//
//    @Given("User navigates to Recruitment module")
//    public void goToRecruitment() {
//        pages.rp.goToRecruitment();
//    }
//
//    @When("User clicks on Add Candidate button")
//    public void clickAddCandidate() {
//        pages.rp.clickAdd();
//    }
//
//    @When("User enters candidate details")
//    public void enterCandidateDetails(DataTable data) {
//
//        Map<String, String> map = data.asMap(String.class, String.class);
//
//        pages.cp.addCandidate(
//                map.get("FirstName"),
//                map.get("LastName"),
//                map.get("Email")
//        );
//    }
//
//    @Then("Candidate should be added successfully")
//    public void verifyCandidate() {
//
//    	Assert.assertNotNull(pages.cp.getResult());
//    }
//
//    // ================= ADD VACANCY =================
//
//    @Given("User navigates to Recruitment > Vacancies section")
//    public void goToVacancy() {
//
//        pages.rp.goToRecruitment();
//
//        WebDriverWait wait = new WebDriverWait(BaseClass.getDriver(), Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//a[text()='Vacancies']")
//        ));
//
//        pages.vp.goToVacancy();
//    }
//
//    @When("User clicks on Add Vacancy button")
//    public void clickAddVacancy() {
//        pages.vp.clickAdd();
//    }
//
//    @When("User enters vacancy details")
//    public void enterVacancyDetails(DataTable data) {
//
//        Map<String, String> map = data.asMap(String.class, String.class);
//
//        pages.vp.addVacancy(
//                map.get("VacancyName"),
//                map.get("JobTitle"),
//                map.get("HiringManager")
//        );
//    }
//
//    @Then("Vacancy should be created successfully")
//    public void verifyVacancy() {
//
//        Assert.assertTrue(
//                pages.vp.getResult() != null &&
//                pages.vp.getResult().length() > 0,
//                "Vacancy not created successfully"
//        );
//    }
//
//    // ================= SEARCH CANDIDATE =================
//
//    @Given("User navigates to Candidate list page")
//    public void navigate_candidate_list() {
//        pages.rp.goToRecruitment();
//    }
//
//    @When("User searches candidate {string}")
//    public void searchCandidate(String name) throws InterruptedException {
//        pages.cp.searchAndSelectCandidate(name);
//    }
//
//    @When("User clicks on the candidate result")
//    public void user_clicks_candidate_result() {
//        // already handled
//    }
//
//    @Then("Candidate details should be displayed correctly")
//    public void verifySearchCandidate() {
//
//        Assert.assertTrue(
//                BaseClass.getDriver().getCurrentUrl().contains("viewCandidate"),
//                "Candidate details page not opened"
//        );
//    }
//
//    // ================= SEARCH VACANCY =================
//
//    @Given("User navigates to Vacancy list page")
//    public void navigate_vacancy_list() {
//        pages.rp.goToRecruitment();
//        pages.vp.goToVacancy();
//    }
//
//    @When("User searches vacancy {string}")
//    public void searchVacancy(String name) {
//        pages.vp.searchAndSelectVacancy(name);
//    }
//
//    @When("User clicks on the vacancy result")
//    public void user_clicks_vacancy_result() {
//        // already handled
//    }
//
//    @Then("Vacancy details should be displayed correctly")
//    public void verifyVacancySearch() {
//
//        Assert.assertTrue(
//                pages.vp.getResult() != null &&
//                pages.vp.getResult().length() > 0,
//                "Vacancy search failed"
//        );
//    }
//
//    // ================= VALIDATIONS =================
//
//    @Given("User is on Add Candidate page")
//    public void user_is_on_add_candidate_page() {
//        pages.rp.goToRecruitment();
//        pages.rp.clickAdd();
//    }
//
//    @When("User enters FirstName as {string}")
//    public void enter_firstname(String fn) {
//        pages.cp.enterFirstName(fn);
//    }
//
//    @When("User enters LastName as {string}")
//    public void enter_lastname(String ln) {
//        pages.cp.enterLastName(ln);
//    }
//
//    @When("User enters Email as {string}")
//    public void enter_email(String em) {
//        pages.cp.enterEmail(em);
//    }
//
//    @When("User clicks Save button")
//    public void click_save_button() {
//        pages.cp.clickSave();
//    }
//
//    @Then("System should show email validation error")
//    public void verify_email_error() {
//
//        String error = pages.cp.getError();
//
//        Assert.assertTrue(
//                error != null && error.length() > 0,
//                "Email validation error not displayed"
//        );
//    }
//
//    @Then("Candidate should not be created")
//    public void candidate_not_created() {
//        Assert.assertTrue(true); // placeholder
//    }
//
//    @When("User clicks Save button without entering any data")
//    public void save_without_data() {
//        pages.cp.clickSave();
//    }
//
//    @Then("System should show validation error messages")
//    public void validate_empty_form_errors() {
//
//        String error = pages.cp.getError();
//
//        Assert.assertTrue(
//                error != null && error.length() > 0,
//                "Validation errors not displayed"
//        );
//    }
//}