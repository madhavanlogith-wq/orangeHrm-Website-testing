Feature: Leave Module

   @Admin
   Scenario: Admin adds leave entitlement to individual employee with valid date
    When navigate to Leave module to perform entitlements
    And click on Entitlements dropdown
    And click on Add Entitlements
    And enter Employee Name "user name"
    And select Leave Type "CAN - FMLA" for addentitlement
    And select Leave Period "2021-01-01 - 2021-31-12" to permit period
    And select on the entitlement period "776"
    And click on Save button on add entitlement 
    Then verify success message "Leave entitlement successfully added" on entitlements
    
  @Login_as_employee
  Scenario: Apply Leave

    When navigate to leave module for  apply
    And click on Apply
    And select Leave Type "CAN - FMLA"
    And select From Date "2026-05-05"
    And select To Date "2026-05-06"
    And select Partial Date "Start Day Only"
    And select Start Day "Half Day - Afternoon"
    And enter Comments "Family vacation"
    And click on Apply button
    Then verify success message "Leave request successfully submitted"
    
  @Login_as_employee
  Scenario: Apply Leave

    When navigate to leave module for  apply
    And click on Apply
    And select Leave Type "CAN - FMLA"
    And select From Date "2026-05-05"
    And select To Date "2026-05-06"
    And select Partial Date "Start Day Only"
    And select Start Day "Half Day - Afternoon"
    And enter Comments "Family vacation"
    And click on Apply button
    But failed message "failed submition"
    
    @Login_as_employee
    Scenario: My Leave
    
    When navigate to leave module for myleave
    When click on My Leave 
    And select Myleave From Date "2026-05-05" 
    And select Myleave To Date "2026-05-06"
    And select my Leave Type "CAN - FMLA"
    And click on myleave search button
    Then filtered succesfully "user  name" 
   
  
    @Login_as_employee
    Scenario: User generates report by selecting Leave Period
    When navigate to Leave module to navigate report
    And click on Reports dropdown
    And click on My Leave Entitlements and Usage Report
    And select Leave Period for generate report "2025-01-01 - 2025-31-12"
    And click on Generate button
    Then verify report is generated successfully
    
    @Admin
    Scenario: Admin configures leave period with valid data 
    When navigate to Leave module to perform configure
    And click on Configure dropdown
    And click on Leave Period
    And select Start Month "February" for leave period
    And select Start Date "02" for leave period start date
    And click on Save button on leave period
    Then verify success message "Leave Period saved successfully" on leave period
    
    @Admin
    Scenario: HR/Manager searches leave records with valid filters
    When navigate to Leave module to perform leave list
    And click on Leave List
    And select From Date "2026-05-05" for leave list
    And select To Date "2026-05-06" for leave list
    And select Status for leave list
    And select Leave Type  for the leave list "CAN - FMLA"
    And enter Employee Name "user name" for leave list
    And select Sub Unit  for the  leave list "Administration"
    And click on Search button on leave list
    Then verify leave records matching all selected filters are displayed on the leave list "user  name"
    
    
   @Admin
Scenario Outline: HR/Manager assigns leave to employee with valid data

    When navigate to Leave module to perform assign leave
    And click on Assign Leave
    And enter Employee Name "<employeeName>" for assign leave
    And select Leave Type "<leaveType>" for assign leave
    And select From Date "<fromDate>" for assign leave
    And select To Date "<toDate>" for assign leave
    And select to the partial day to assign the leave for employee "Start Day Only"
    And select to the start day to assign the leave for employee "Half Day - Morning"
    And enter Comments "<comments>" for assign leave
    And click on Assign button on assign leave
    Then verify success message "<message>" on assign leave

Examples:
    | employeeName         | leaveType     | fromDate   | toDate     | comments            | message                      |
    | user name            | CAN - FMLA    | 2026-05-05 | 2026-05-06 | Medical emergency   | Leave assigned successfully  |

    