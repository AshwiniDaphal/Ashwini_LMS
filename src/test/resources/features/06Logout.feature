Feature: Validation on Logout button

Background:  
Given Admin is logged in to LMS Portal
	@logout1
  Scenario: Verify logout function
    And   Admin should land on dashboard page
    When  Admin clicks on the logout in the menu bar
    Then  Admin should be redirected to login page
	@logout2
  Scenario: Verify back button function 
    Given Admin is logged out of the application
    And   Admin is in login page
    When  Admin clicks  browser back button
    Then  Admin should receive error message
    