Feature: OrangeHRM Admin Job Module Automation

Background:
  Given user is on dashboard page
  
   # ================= Custom Fields Configuration =================

 Scenario: Add custom field with dropdown values
    Given user navigates to PIM module
    When user clicks on Configuration menu
    And user clicks on Custom Fields option
    And user clicks on Add button
    And user enters field name "Department Type"
    And user selects screen "Contact Details"
    And user selects type "Drop Down"
    And user clicks on Save button
    Then custom field should be created successfully   
   