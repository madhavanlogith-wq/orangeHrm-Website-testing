Feature: OrangeHRM Admin Job Module Automation

Background:
  Given user is on dashboard page
# ================= ADD JOB TITLE =================

@Admin
Scenario: Add new job title with all fields
    When user navigates to job titles
    And user clicks add button
    And user enters job title
        | HardWere Engeeunereer |
    And user enters job description
        | Responsible for data analysis |
    And user adds job note
        | Senior role |
    And user clicks save button of job title 
    Then job title should be added successfully