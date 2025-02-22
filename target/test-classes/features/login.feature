Feature: Login  Page Verification

  Background: 
    Given The browser is open

  #	Scenario: Validate login with valid data in all field
  #Given Admin user is logged in with valid credentials
  #
  @login
  Scenario: Verify Admin is able to land on login page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  @login
  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error

  @login
  Scenario: Verify for broken link
    When Admin gives the correct LMS portal URL
    Then HTTP response >= 400,the link is broken

  @VerifySpelling
  Scenario: Verify the text spelling in the page
  When Admin gives the correct LMS portal URL
  Then Admin should see correct spellings in all fields
  
  @imageTest
  Scenario Outline: Verify application name
  When Admin gives the correct LMS portal URL
  Then Admin should see appName "<InputText>"
  Examples:
  |InputText|
  |LMS - Learning Management System|
  |NumpyNinja|
  
  @login
  Scenario: Validate sign in content
    When Admin gives the correct LMS portal URL
    Then Admin should see "Please login to LMS application"

  @login
  Scenario: Verify text field is present
    When Admin gives the correct LMS portal URL
    Then Admin should see two text field
    
  @login
  Scenario: Verify text on the first field
    When Admin gives the correct LMS portal URL
    Then Admin should "User" in the first text field

  Scenario: Verify dropdown is present
  When Admin gives the correct LMS portal URL
  Then Admin should see one dropdown
  
  Scenario: Verify asterisk next to USER text
  When Admin gives the correct LMS portal URL
  Then Admin should see asterisk mark symbol next to text for user field
  
  @login
  Scenario: Verify text on the second field
    When Admin gives the correct LMS portal URL
    Then Admin should "Password" in the second text field

    
Scenario: Verify asterisk mark symbol next to password text
    When Admin gives the correct LMS portal URL
    Then Admin should see asterisk mark symbol next to password text
    
 @PlaceHolder   
Scenario: Verify placeholder in dropdown to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see "Select the role" placeholder in dropdown
@roleContents
Scenario: Verify dropdown option to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see "Admin , staff, student" options in dropdown
   
   
Scenario: Verify the alignment input field for the login
    When Admin gives the correct LMS portal URL
    Then Admin should see input field on the centre of the page
   
    
Scenario: verify Login button is present
    When Admin gives the correct LMS portal URL
    Then Admin should see login button 
 @textColour   
Scenario: Verify input descriptive text in user field
    When Admin gives the correct LMS portal URL
    Then Admin should see user in gray color    
    
 @textColour     
Scenario: Verify input descriptive text in password field
    When Admin gives the correct LMS portal URL
    Then Admin should see password in gray color
    
 