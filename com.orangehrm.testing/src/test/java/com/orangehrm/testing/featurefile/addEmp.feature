Feature: OrangeHRM Admin Job Module Automation

Background:
    Given user is on dashboard page

  @Positive
  Scenario: Add employee with valid details
    Given user clicks on Add Employee button
    When user enters first name "Amirtha"
    And user enters middle name "Amirtha"
    And user enters last name "Amirtha"
    And user enters employee id "434"
    And user clicks on Save button
    Then system should display message "Successfully Saved"


  @Negative
  Scenario: Add employee without mandatory fields
    Given user clicks on Add Employee button
    When user leaves first name blank
    And user leaves last name blank 
    And user clicks on Save button
    Then system should display error message "Required"