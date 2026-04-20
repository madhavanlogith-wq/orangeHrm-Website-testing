package com.orangehrm.testing.stepdefinition;

import com.orangehrm.seleniumuiframwork_genricutility.Base;
import com.orangehrm.seleniumuiframwork_genricutility.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeaveModule {

    private Pages pages;

    // ✅ Initialize Pages using ThreadLocal driver
    public LeaveModule() {
        this.pages = new Pages(Base.getDriver());
    }

    // ================= APPLY =================

    @When("navigate to leave module for  apply")
    public void navigate_to_leave_module_for_apply() {
        pages.dashboardpage.getLeaveLink().click();
    }

    @When("click on Apply")
    public void click_on_apply() {
        pages.leavepage.getApplyBtn().click();
    }

    @When("select Leave Type {string}")
    public void select_leave_type(String leaveType) {
        pages.apply.selectLeaveType(Base.getDriver(), leaveType);
    }

    @When("select From Date {string}")
    public void select_from_date(String fromDate) {
        pages.apply.enterFromDate(Base.getDriver(), fromDate);
    }

    @When("select To Date {string}")
    public void select_to_date(String toDate) {
        pages.apply.enterToDate(Base.getDriver(), toDate);
    }

    @When("select Partial Date {string}")
    public void select_partial_date(String partialDate) {
        pages.apply.selectPartialDays(Base.getDriver(), partialDate);
    }

    @When("select Start Day {string}")
    public void select_start_day(String startDay) {
        pages.apply.selectStartDay(Base.getDriver(), startDay);
    }

    @When("enter Comments {string}")
    public void enter_comments(String comments) {
        pages.apply.enterComments(comments);
    }

    @When("click on Apply button")
    public void click_on_apply_button() {
        pages.apply.clickApply(Base.getDriver());
    }

    @Then("verify success message {string}")
    public void verify_success_message(String msg) {
        pages.apply.isSuccessfullyApplied(Base.getDriver());
    }

    // ================= MY LEAVE =================

    @When("navigate to leave module for myleave")
    public void navigate_to_leave_module_for_myleave() {
        pages.dashboardpage.getLeaveLink().click();
    }

    @When("click on My Leave")
    public void click_on_my_leave() {
        pages.leavepage.getMyLeaveBtn().click();
    }

    @When("select Myleave From Date {string}")
    public void select_myleave_from_date(String fromDate) {
        pages.myleave.enterFromDate(Base.getDriver(), fromDate);
    }

    @When("select Myleave To Date {string}")
    public void select_myleave_to_date(String toDate) {
        pages.myleave.enterToDate(Base.getDriver(), toDate);
    }

    @When("select my Leave Type {string}")
    public void select_my_leave_type(String leaveType) {
        pages.myleave.selectLeaveType(Base.getDriver(), leaveType);
    }

    @When("click on myleave search button")
    public void click_on_myleave_search_button() {
        pages.myleave.clickSearch(Base.getDriver());
    }

    @Then("filtered succesfully {string}")
    public void filtered_succesfully(String empName) {
        pages.myleave.isEmpLeaveDisplayed(Base.getDriver(), empName);
    }

    // ================= ENTITLEMENTS =================

    @When("navigate to Leave module to perform entitlements")
    public void navigate_to_leave_module_to_perform_entitlements() {
        pages.dashboardpage.getLeaveLink().click();
    }

    @When("click on Entitlements dropdown")
    public void click_on_entitlements_dropdown() {
        pages.leavepage.getEntitlementsBtn().click();
    }

    @When("click on Add Entitlements")
    public void click_on_add_entitlements() {
        pages.leavepage.getAddEntitlement().click();
    }

    @When("enter Employee Name {string}")
    public void enter_employee_name(String employeeName) {
        pages.addentitlement.enterEmployeeName(Base.getDriver(), employeeName);
    }

    @When("select Leave Type {string} for addentitlement")
    public void select_leave_type_for_addentitlement(String leaveType) {
        pages.addentitlement.selectLeaveType(Base.getDriver(), leaveType);
    }

    @When("select Leave Period {string} to permit period")
    public void select_leave_period_to_permit_period(String leavePeriod) {
        pages.addentitlement.selectLeavePeriod(Base.getDriver(), leavePeriod);
    }

    @When("select on the entitlement period {string}")
    public void select_on_the_entitlement_period(String value) {
        pages.addentitlement.enterEntitlement(value);
    }

    @When("click on Save button on add entitlement")
    public void click_on_save_button_on_add_entitlement() {
        pages.addentitlement.clickSave(Base.getDriver());
    }

    @Then("verify success message {string} on entitlements")
    public void verify_success_message_on_entitlements(String msg) {
        pages.addentitlement.verifyEntitlementAdded(Base.getDriver());
    }

    // ================= REPORT =================

    @When("navigate to Leave module to navigate report")
    public void navigate_to_leave_module_to_navigate_report() {
        pages.dashboardpage.getLeaveLink().click();
    }

    @When("click on Reports dropdown")
    public void click_on_reports_dropdown() {
        pages.leavepage.getReportBtn().click();
    }

    @When("click on My Leave Entitlements and Usage Report")
    public void click_on_my_leave_entitlements_and_usage_report() {
        pages.leavepage.getMyLeaveReportBtn().click();
    }

    @When("select Leave Period for generate report {string}")
    public void select_leave_period_for_generate_report(String leavePeriod) {
        pages.myleavereport.selectLeavePeriod(Base.getDriver(), leavePeriod);
    }

    @When("click on Generate button")
    public void click_on_generate_button() {
        pages.myleavereport.generated();
    }

    @Then("verify report is generated successfully")
    public void verify_report_is_generated_successfully() {
        pages.myleavereport.isGenerated(Base.getDriver());
    }

    // ================= ASSIGN LEAVE =================

    @When("navigate to Leave module to perform assign leave")
    public void navigate_to_leave_module_to_perform_assign_leave() {
        pages.dashboardpage.getLeaveLink().click();
    }

    @When("click on Assign Leave")
    public void click_on_assign_leave() {
        pages.leavepage.getAssignLeaveBtn().click();
    }

    @When("enter Employee Name {string} for assign leave")
    public void enter_employee_name_for_assign_leave(String employeeName) throws InterruptedException {
        pages.assignLeave.enterEmployeeName(Base.getDriver(), employeeName);
    }

    @When("select Leave Type {string} for assign leave")
    public void select_leave_type_for_assign_leave(String leaveType) {
        pages.assignLeave.selectLeaveType(Base.getDriver(), leaveType);
    }

    @When("select From Date {string} for assign leave")
    public void select_from_date_for_assign_leave(String fromDate) {
        pages.assignLeave.enterFromDate(Base.getDriver(), fromDate);
    }

    @When("select To Date {string} for assign leave")
    public void select_to_date_for_assign_leave(String toDate) {
        pages.assignLeave.enterToDate(Base.getDriver(), toDate);
    }

    @When("select to the partial day to assign the leave for employee {string}")
    public void select_to_the_partial_day_to_assign_the_leave_for_employee(String partialDays) {
        pages.assignLeave.selectPartialDays(Base.getDriver(), partialDays);
    }

    @When("select to the start day to assign the leave for employee {string}")
    public void select_to_the_start_day_to_assign_the_leave_for_employee(String duration) {
        pages.assignLeave.selectDuration(Base.getDriver(), duration);
    }

    @When("enter Comments {string} for assign leave")
    public void enter_comments_for_assign_leave(String comments) {
        pages.assignLeave.getComments().sendKeys(comments);
    }

    @When("click on Assign button on assign leave")
    public void click_on_assign_button_on_assign_leave() {
        pages.assignLeave.getAssignBtn().click();
    }

    @Then("verify success message {string} on assign leave")
    public void verify_success_message_on_assign_leave(String msg) {
        pages.assignLeave.verify_leave_assigned(Base.getDriver());
    }
    
 // ================= LEAVE LIST =================

    @When("navigate to Leave module to perform leave list")
    public void navigate_to_leave_module_to_perform_leave_list() {
        pages.dashboardpage.getLeaveLink().click();
    }

    @When("click on Leave List")
    public void click_on_leave_list() {
        pages.leavepage.getLeaveListBtn().click();
    }

    @When("select From Date {string} for leave list")
    public void select_from_date_for_leave_list(String fromDate) {
        pages.leavelist.enterFromDate(Base.getDriver(), fromDate);
    }

    @When("select To Date {string} for leave list")
    public void select_to_date_for_leave_list(String toDate) {
        pages.leavelist.enterToDate(Base.getDriver(), toDate);
    }

    @When("select Status for leave list")
    public void select_status_for_leave_list() {
        pages.leavelist.selectShowLeaveStatus(Base.getDriver());
    }

    @When("select Leave Type  for the leave list {string}")
    public void select_leave_type_for_the_leave_list(String leaveType) {
        pages.leavelist.selectLeaveType(Base.getDriver(), leaveType);
    }

    @When("enter Employee Name {string} for leave list")
    public void enter_employee_name_for_leave_list(String employeeName) {
        pages.leavelist.enterEmployeeName(Base.getDriver(), employeeName);
    }

    @When("select Sub Unit  for the  leave list {string}")
    public void select_sub_unit_for_the_leave_list(String subUnit) {
        // If implemented
        // pages.leavelist.selectSubUnit(Base.getDriver(), subUnit);
    }

    @When("click on Search button on leave list")
    public void click_on_search_button_on_leave_list() {
        pages.leavelist.clickSave(Base.getDriver());
    }

    @Then("verify leave records matching all selected filters are displayed on the leave list {string}")
    public void verify_leave_records_matching_all_selected_filters_are_displayed_on_the_leave_list(String name) {
        pages.leavelist.verify_emps_filtered(Base.getDriver(), name);
    }
}
