package com.orangehrm.testing.stepdefinition;

import org.testng.Assert;

import com.orangehrm.seleniumuiframwork_genricutility.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Time {

    Pages pages;

    public Time() {
        this.pages = new Pages(Hook.getDriver());
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

        Assert.assertTrue(
            pages.reports.getRequiredMessage().contains(expected),
            "Expected message not displayed: " + expected +
            " | Actual: " + pages.reports.getRequiredMessage()
        );
    }

    // ================= PROJECT INFO =================

    @When("user navigates to project info section")
    public void navigateToProjectInfo() {
        pages.projectInfo.navigateToProjectInfo();
    }

    @When("user clicks on project tab")
    public void clickProjectTab() {
        pages.projectInfo.clickProjectTab();
    }

    @When("user clicks on add project")
    public void clickAddProject() {
        pages.projectInfo.clickAddProject();
    }

    @When("user enters new project name {string}")
    public void enterNewProjectName(String name) {
        pages.projectInfo.enterProjectName(name);
    }

    @When("user enters customer name {string}")
    public void enterCustomer(String name) {
        pages.projectInfo.selectCustomer(name);
    }

    @When("user clicks save")
    public void clickSave() {
        pages.projectInfo.clickSave();
    }

    @Then("project should be saved successfully")
    public void verifyProjectAdded() {

        String msg = pages.projectInfo.getSuccessMessage();

        Assert.assertTrue(
            msg.contains("Success"),
            "Project not saved. Actual: " + msg
        );
    }
}
