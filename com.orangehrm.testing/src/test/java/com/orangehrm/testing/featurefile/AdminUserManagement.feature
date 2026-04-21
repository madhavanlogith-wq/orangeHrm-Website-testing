Feature: OrangeHRM Admin Module Automation

# ================= LOGIN =================


# ================= ADD USER =================
@Admin
Scenario Outline: Add new user with valid details in Admin module

  When user clicks add button
  And user selects user role "<role>"
  And user enters employee name "<empName>"
  And user selects status "<status>"
  And user enters username "<newUsername>"
  And user enters password "<newPassword>"
  And user enters confirm password "<confirmPassword>"
  And user clicks save button in Add User page
  Then user should be added successfully

Examples:
  | role  | empName     | status  | newUsername | newPassword | confirmPassword |
  | Admin | Ranga   | Enabled | admin12345    | Admin@1234  | Admin@1234      |