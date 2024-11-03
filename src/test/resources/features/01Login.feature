Feature: Login  Page Verification

 @validAppURL
  Scenario: Verify Admin is able to land on login page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page
    
 @invalidURL
  Scenario: Verify Admin is able to land on home page with invalid URL
    Given Admin launch the browser
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve page not found error
 
 @SpellCheckLogin
  Scenario: Verify the text spelling in the page
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see correct spellings in all fields
    
 @imageVerification
  Scenario: Verify the company logo
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see logo on the left  side
 @imageVerification1
  Scenario: Verify application name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see app name "LMS - Learning Management System"
  @imageVerification2
  Scenario: Verify company name
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see company name below the app name

 @validLogin 
  Scenario: Validate login with valid credentials
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button
    Then Admin should land on dashboard page
    
 @VisibilityOfElements
  Scenario: Validate sign in content
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"
 @twoTextFields
  Scenario: Verify text field is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see 2 text field
 @UserFieldLoc
  Scenario: Verify text on the first text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "User" in the first text field
 @PassFieldLoc
  Scenario: Verify text on the second text field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see "Password" in the second text field

  Scenario: Verify asterik next to User text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see field mandatory * symbol next to User text

  Scenario: Verify asterik next to password text
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see * symbol next to password text
 @inputAlignment 
  Scenario: Verify the alignment input field for the login
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see input field on the centre of the page  
  @LoginButtonAlignment       
  Scenario: Verify the alignment input field for the login
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button on the centre of the page  
  @LoginButtonVisible  
  Scenario: verify Login button is present
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see login button
  @AdminGrayVisible 
  Scenario: Verify input descriptive test in Admin field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see Admin in gray color
  @PasswordGrayVisible
  Scenario: Verify input descriptive test in password field
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color
    
  @validLoginKeyboard
  Scenario: verify login button action through keyboard
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on dashboard page
    
  @validLoginMouse 
  Scenario: verify login button action through mouse
    Given Admin is in login Page
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on dashboard page
    
  @InvalidCredentials  
  Scenario Outline: Validate login with invalid credentials
    Given Admin is in login Page
    When Admin enter invalid credentials "<Username>" and "<Password>" clicks login button 
    Then Admin get an "<ErrorMessage>" message

		Examples: 
      | Username        | Password         | ErrorMessage                                   |
      | abc             |    xyz           | Invalid username and password Please try again |
      
 	@NullCredential         
  Scenario Outline: Validate login with invalid credentials
    Given Admin is in login Page
    When Admin enter invalid credentials "<Username>" and "<Password>" clicks login button 
    Then Admin Sees "<ErrorMessage>" message for one text field empty 
      
     Examples: 
      | Username        | Password         | ErrorMessage                                   | 
      |                 |LmsHackathon@2024 | Please login to LMS application                |
      |Sdet@gmail.com   |                  | Please login to LMS application                |
    
 @BrokenLink   
 Scenario: Verify for broken link
    Given Admin launch the browser
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400 the link is broken
