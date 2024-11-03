
Feature: Dashboard Page

Background: 
Given Admin is in login Page
When Admin enter valid credentials  and clicks login button

@dashboard
Scenario: Verify after login Admin lands on dashboard page	
Then Admin should land on dashboard page


@NavTime
Scenario: Verify the response time	
Then Maximum navigation time in milliseconds, defaults to 30 seconds	


@BrokenLink
Scenario: Verify broken link		
Then HTTP response >= 400. Then the link is broken	


@SeeLmsTitle
Scenario: Verify LMS title	
Then Admin should see LMS -Learning management system as title	


@LmsTitalAlignment
Scenario: Verify LMS title alignment		
Then LMS title should be on the top left corner of page		


@NavBarTextSpell
Scenario: Validate navigation bar text		
Then Admin should see correct spelling in navigation bar text	
	
	
@LmsBarTextSpellandSpace
Scenario: Validate LMS title has correct spelling and space	
Then Admin should see correct spelling and 4 space in LMS title		


@NavBarAlign
Scenario: Validate alignment for navigation bar	
Then Admin should see the navigation bar text on the top right side		


@NavBarOrderhome
Scenario: Validate navigation bar order 1st home	
Then Admin should see Home in the 1st place		


@NavBarOrderprogram
Scenario: Validate navigation bar order 2nd program	
Then Admin should see program in the 2nd place		
	
		
@NavBarOrderbatch
Scenario: Validate navigation bar order 3rd batch	
Then Admin should see batch in the 3rd place


@NavBarOrderclass
Scenario: Validate navigation bar order 4th class	
Then Admin should see class in the 4th place		


@NavBarOrderlogout
Scenario: validate navigation bar order 5 th logout	
Then Admin should see logout in the 5th place
