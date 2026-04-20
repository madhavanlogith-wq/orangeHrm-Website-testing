Feature: OrangeHRM Admin Module Automation

  Background:
    Given user launches browser and opens application
    When user enters valid username "<username>" and password "<password>"
    And user clicks login button
    Then user should see dashboard page with all elements

   # ================= ADD USER =================

  Scenario Outline: Add new user with all fields
    When user clicks add button
    And user selects user role "<role>"
    And user enters employee name "<empName>"
    And user selects status "<status>"
    And user enters username "<newUsername>"
    And user enters password "<newPassword>"
    And user enters confirm password "<confirmPassword>"
    And user clicks save button
    Then user should be added successfully

    Examples:
      | username | password | role  | empName         | status  | newUsername | newPassword | confirmPassword |
      | Admin    | admin123 | Admin | Ranga  Akun    | Enabled | admin123  | Admin@123   | Admin@123       |