Feature: Claims Module

  Background:
    Given user is logged into the application
    And user is on dashboard
    When user navigates to Claim module
    
   @Admin
Scenario: Submit claim successfully and verify submission

  When user submits claim with following details
    | event         | currency      | remarks               |
    | Accommodation | Indian Rupee  | Business trip claim   |

  Then user should be navigated to claim details page
  When user clicks Submit button
  Then claim should be submitted successfully

@Admin
  Scenario: Search claim by reference ID and verify navigation using dynamic URL

    When user clicks on My Claims section
    And user enters reference ID "202604210000007"
    And user selects reference ID from dropdown
    And user clicks on Search button

    When user clicks on View button for the claim
    Then user should be redirected to claim details page
    And URL should contain claim id