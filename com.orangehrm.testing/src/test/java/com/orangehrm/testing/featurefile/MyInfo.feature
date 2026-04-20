Feature: My Info - Personal Details

  Scenario: Update personal details successfully
    Given user is logged in and navigates to My Info page
    When user updates first name and last name
    And user clicks nationality and marital status dropdown
    And user clicks save button
    Then personal details should be saved successfully


  Scenario: Update contact details successfully
    Given user is logged in and navigates to My Info page
    When user navigates to Contact Details tab
    And user enters street address, city, mobile and work email
    And user clicks save button in contact details
    Then contact details should be saved successfully


  Scenario: Add emergency contact successfully
    Given user is logged in and navigates to My Info page
    When user navigates to Emergency Contacts tab
    And user clicks add button
    And user enters name, relationship and mobile
    And user clicks save button in emergency contacts
    Then emergency contact should be saved successfully


  Scenario: Add dependent successfully
    Given user is logged in and navigates to My Info page
    When user navigates to Dependents tab
    And user clicks add button in dependents
    And user enters dependent name and selects relationship
    And user clicks save button in dependents
    Then dependent should be saved successfully


  Scenario: Add work experience in qualifications successfully
    Given user is logged in and navigates to My Info page
    When user navigates to Qualifications tab
    And user clicks add button in qualifications
    And user enters company and job title
    And user clicks save button in qualifications
    Then work experience should be saved successfully


  # NEGATIVE SCENARIO

  Scenario: Validation when first name is empty
    Given user is logged in and navigates to My Info page
    When user clears first name field
    And user enters only last name
    And user clicks save button
    Then first name field should show required validation
    