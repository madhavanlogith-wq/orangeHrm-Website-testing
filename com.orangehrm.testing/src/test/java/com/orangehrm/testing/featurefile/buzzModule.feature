Feature: Buzz Module

Background:
  Given user is logged into the application
  And user is on buzz page
@Admin
Scenario: Create and post content
  When user enters "hello"
  And user clicks post
  Then post should be created successfully