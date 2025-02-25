
 Feature: Login  Page Verification

  Scenario: Validate login with valid data in all field
    Given Admin user is logged in with valid credentials
    Then Admin should land on home page

  @ValidURL
  Scenario: Verify Admin is able to land on login page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the login page

  @InValidUrl
  Scenario: Verify Admin is able to land on home page with invalid URL
    When Admin gives the invalid LMS portal URL
    Then Admin should receive application error

  @brokenlink
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
      | InputText                        |
      | LMS - Learning Management System |
      | NumpyNinja                       |

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
  Scenario Outline: Verify dropdown option to select role
    When Admin gives the correct LMS portal URL
    Then Admin should see "<roleName>" options in dropdown

    Examples: 
      | roleName |
      | Admin    |
      | Staff    |
      | Student  |

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

  @loginDDT
  Scenario Outline: Validate login with invalid data
    When Admin enter invalid "<uname>" ,"<pwd>" and "<role>" clicks login button
    Then Error message "<errorMsg>" is received

    Examples: 
      | uname          | pwd    | role  | errorMsg                          |
      |                | feb@34 | Admin | Please enter your user name       |
      | sdet@gmail.com |        | Admin | Please enter your password        |
      | sdet@gmail.com | feb@12 | Admin | Username and password didnt match |
      | sdet@gm.com    | fed@12 |       | Enter Role                        |

  Scenario: verify login button action through keyboard
    When Admin enter valid credentials  and clicks login button through keyboard
    Then Admin should land on home page

  Scenario: verify login button action through mouse
    When Admin enter valid credentials  and clicks login button through mouse
    Then Admin should land on home page
