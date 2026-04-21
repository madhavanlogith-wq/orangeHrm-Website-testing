Feature: OrangeHRM Admin Job Module Automation

Background:
  Given user is on dashboard page
  
   # ================= LOCATION =================
   
  @Admin
  Scenario Outline: Add new location
    When user navigates to organization  
    And user clicks locations link
    And user clicks add button
    And user enters location name
    And user selects country 
    And user enters city 
    And user enters address 
    And user clicks save button
    Then location should be added successfully

   