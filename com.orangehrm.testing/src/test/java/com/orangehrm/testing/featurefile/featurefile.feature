Feature:Recruitment Module - Candidate and Vacancy Management
  
  Background:
    Given User is already logged in

             
@Admin            # Scenario 1 - Add Candidate
Scenario: Add candidate with valid mandatory details
  Given User navigates to Recruitment module
  When User clicks on Add Candidate button
  And User enters candidate details
  Then Candidate should be added successfully
  
             # =========================
             # Scenario 2 - Add Vacancy
             # =========================
  @Admin
  Scenario:Create vacancy with valid details
    Given User navigates to Recruitment > Vacancies section
    When User clicks on Add Vacancy button
    And User enters vacancy details
      | VacancyName   | Tim david   |
      | JobTitle      | Account Assistant |
      | HiringManager |Rahul Das |
    And User clicks Save button
    Then Vacancy should be created successfully

            # =========================
            # Scenario 3 - Candidate Search + View
            # =========================
  @Admin
  Scenario:Search and view candidate details
    Given User navigates to Candidate list page
    When User searches candidate "John Doe"
    And User clicks on the candidate result
    Then Candidate details should be displayed correctly

           # =========================
           # Scenario 4 - Vacancy Search + View
           # =========================
           
  @Admin
  Scenario:Search and view vacancy details
    Given User navigates to Vacancy list page
    When User searches vacancy "Software Engineer"
    And User clicks on the vacancy result
    Then Vacancy details should be displayed correctly
    
         # =========================
         # Scenario 5 - Scenario Outline (Email Validation)
         # =========================
  @Admin
  Scenario Outline:Validate invalid email formats while adding candidate
    Given User is on Add Candidate page
    When User enters FirstName as "<FirstName>"
    And User enters LastName as "<LastName>"
    And User enters Email as "<Email>"
    And User clicks Save button
    Then System should show email validation error
    And Candidate should not be created

    Examples:
      | FirstName | LastName | Email     |
      | John      | Doe      | john@     |
      | John      | Doe      | john.com  |
      
      
      # =========================
      # Scenario 6 - Scenario Outline (Empty Fields)
      # =========================
      
  @Admin
  Scenario:Validate system shows error when saving empty form
    Given User is on Add Candidate page
    When User clicks Save button without entering any data
    Then System should show validation error messages
    And Candidate should not be created
