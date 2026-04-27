Feature: My Info Module

  # =========================================
  # 1. SCENARIO OUTLINE (Examples)
  # =========================================
  @Admin
  Scenario Outline: Update Personal Details using Examples
    Given user is logged in and navigates to My Info page

    When user updates the first name "Deebiga"
    And user updates the last name "RK"
    And user clicks the nationality "Af" and marital status dropdown "Sin" myInfo

    When user updates personal details "<firstname>" "<lastname>"
    And user selects nationality and marital status

    And user clicks save button for the updated personal details
    Then personal details should be saved successfully

    Examples:
      | firstname | lastname |
      | Test      | User     |


  # =========================================
  # 2. DATATABLE (Contact Details)
  # =========================================
  @Admin
  Scenario: Update Contact Details using DataTable
    Given user is logged in and navigates to My Info page
    When user navigates to Contact Details tab
    And user enters contact details
      | street         | city    | mobile     | 
      | Chennaiii4 Street | Chennaiii7 | 9876546244 |
    And user clicks save button in contact details
    Then contact details should be saved successfully 


  # =========================================
  # 3. EXCEL DATA DRIVEN
  # =========================================
  @Admin
  Scenario: Update Personal Details using Excel
    Given user is logged in and navigates to My Info page
    When user updates personal details from excel "My_Info" row 1
    And user selects nationality and marital status
    And user clicks save button for personal details
    Then personal details should be saved successfully


  # =========================================
  # 4. NORMAL SCENARIO (Reusable steps)
  # =========================================
  @Admin
  Scenario: Add Emergency Contact (Normal Flow)
    Given user is logged in and navigates to My Info page
    When user navigates to Emergency Contacts tab
    And user clicks add button in emergency contacts
    And user enters name "Deebiga" relationship "Sister" and mobile "9876543210"
    And user clicks save button in emergency contacts
    Then emergency contact should be saved successfully


  # =========================================
  # 5. DATATABLE (Dependents)
  # =========================================
  @Admin
  Scenario: Add Dependent using DataTable
    Given user is logged in and navigates to My Info page
    When user navigates to Dependents tab
    And user clicks add button in dependents
    And user enters dependent details
      | name  | relation |
      | Kumar | Child    |
    And user clicks save button in dependents
    Then dependent should be saved successfully


  # =========================================
  # 6. NEGATIVE SCENARIO
  # =========================================
  @Admin
  Scenario: Validation when first name is empty
    Given user is logged in and navigates to My Info page
    When user clears first name field
    Then first name field should show required validation