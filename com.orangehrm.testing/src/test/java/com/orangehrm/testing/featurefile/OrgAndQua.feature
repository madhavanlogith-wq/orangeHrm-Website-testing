Feature: OrangeHRM Admin Job Module Automation

Background:
  Given user is on dashboard page
  
   # ================= LOCATION =================
   
  @Admin
  Scenario Outline: Add new location
    When user navigates to organization  
    And user clicks locations link
    And user clicks add button
    And user enters location name "<location>"
    And user selects country "<country>"
    And user enters city "<city>"
    And user enters address "<address>"
    And user clicks save button
    Then location should be added successfully

    Examples:
      | username | password | location        | country | city    | address   |
      | Admin    | admin123 | Karur Office  | India   | Chennai | OMR Road  |