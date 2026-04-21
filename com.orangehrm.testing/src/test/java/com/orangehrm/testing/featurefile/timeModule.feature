	Feature: Time Module
	
	Background:
	  Given user is on Time page
	@Admin
	Scenario: Punch in successfully
	  When user navigates to attendance section
	  And user opens the punch page
	  And user clicks punch in
	  Then PunchIn should be saved sucessfully
	@Admin
	Scenario: No records when project not available
	When user navigates to reports section
	And user clicks on project reports
	And user clicks on view button
	Then system should display "Required"
	
	
	
	@Admin
	Scenario Outline: Add new project with valid details
  When user navigates to project info section
  And user clicks on project tab
  And user clicks on add project
  And user enters new project name "<projectName>"
  And user enters customer name "<customerName>"
  And user clicks save
  Then project should be saved successfully

Examples:
  | projectName                			 | customerName |
  | project1sogaaanave2312               | fr           |
  | testProject4sogaaanave2312           | fr           |
  