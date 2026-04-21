package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Time {

    private Pages pages;
    private WebDriverWait wait;

    // ✅ FIX: constructor-based initialization (thread-safe style)
    public Time() {
        this.pages = new Pages(Base.getDriver());
        this.wait = new WebDriverWait(Base.getDriver(), Duration.ofSeconds(10));
    }

    // ================= ATTENDANCE =================

    @When("user navigates to attendance section")
    public void openAttendance() {
        pages.attendance.openAttendanceSection();
    }

    @When("user opens the punch page")
    public void openPunchSection() {
        pages.attendance.openPunchSection();
    }

    @When("user clicks punch in")
    public void clickPunchIn() {
        pages.attendance.clickPunchIn();
    }

    @Then("PunchIn should be saved sucessfully")
    public void verifyPunchIn() {

        String actual = pages.attendance.getSuccessMessage();

        Assert.assertTrue(
                actual.contains("Success"),
                "Punch In failed. Actual: " + actual
        );
    }

    // ================= REPORTS =================

    @When("user navigates to reports section")
    public void navigateToReports() {
        pages.reports.openReportsSection();
    }

    @When("user clicks on project reports")
    public void clickProjectReports() {
        pages.reports.openProjectReports();
    }

    @When("user clicks on view button")
    public void clickViewButton() {
        pages.reports.clickView();
    }

    @Then("system should display {string}")
    public void verifyMessage(String expected) {

        String actual = pages.reports.getRequiredMessage();

        Assert.assertTrue(
                actual.contains(expected),
                "Expected message not displayed: " + expected +
                        " | Actual: " + actual
        );
    }

    // ================= PROJECT INFO =================

    @When("user navigates to project info section")
    public void navigateToProjectInfo() {
        pages.project_info.navigateToProjectInfo();
    }

    @When("user clicks on project tab")
    public void clickProjectTab() {
        pages.project_info.clickProjectTab();
    }

    @When("user clicks on add project")
    public void clickAddProject() {
        pages.project_info.clickAddProject();
    }

    @When("user enters new project name {string}")
    public void enterNewProjectName(String name) {
        pages.project_info.enterProjectName(name);
    }

    @When("user enters customer name {string}")
    public void enterCustomer(String name) {
        pages.project_info.selectCustomer(name);
    }

    @When("user clicks save")
    public void clickSave() {
        pages.project_info.clickSave();
    }

    @Then("project should be saved successfully")
    public void verifyProjectAdded() {

        String msg = pages.project_info.getSuccessMessage();

        Assert.assertTrue(
                msg.contains("Success"),
                "Project not saved. Actual: " + msg
        );
    }
    
    // ================= TIME PAGE =================

    @Given("user is on Time page")
    public void user_is_on_time_page() {

        // Navigate from dashboard to Time module
        pages.dashboardpage.getTimeLink().click();

        System.out.println("User navigated to Time page successfully");
    }
}