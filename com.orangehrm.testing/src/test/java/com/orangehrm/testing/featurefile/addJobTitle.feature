Feature: OrangeHRM Admin Job Module Automation

Background:
  Given user is on dashboard page
# ================= ADD JOB TITLE =================

Scenario: Add new job title with all fields
    When user navigates to job titles
    And user clicks add button
    And user enters job title
        | Softwere Engeener |
    And user enters job description
        | Responsible for data analysis |
    And user adds job note
        | Senior role |
    And user clicks save button
    Then job title should be added successfully