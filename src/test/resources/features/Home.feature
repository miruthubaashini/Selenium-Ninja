Feature: HomePage

  Background: 
    Given Admin user is logged in with valid credentials

  @LMS_title
  Scenario: Verify LMS title
    Then Admin should see LMS -Learning management system as title

  @LMS_title
  Scenario: Verify LMS title alignment
    Then LMS title should be on the top left corner of page

  @NavBar
  Scenario Outline: Validate navigation bar text
    Then Admin should see "<tabs>" in <place>

    Examples: 
      | tabs    | place |
      | Home    |     0 |
      | Program |     1 |
      | Batch   |     2 |
      | Class   |     3 |
      | Logout  |     4 |
      
  @spellCheckHomeNavBar
  Scenario: Validate navigation bar text spelling
    Then Admin should see correct spelling in navigation bar text
    
  @pie-chart 
  Scenario: Verify verify pie-chart presence
  Then Admin should see piechart
  
  Scenario: Verify user details
  Then Admin should see welcome message with user name and role
  
  Scenario: Verify bar chart
  Then Admin should see bar chart for Active and inactive user
  
  Scenario: Verify user count
  Then Admin should see user count 

	Scenario: Verify staff count
	Then Admin should see staff count 
	
	Scenario: verify program count
	Then Admin should see Program count 
	
	Scenario: Verify batch count 
	Then Admin should see batch  count 
	
	Scenario: Verify staff table pagination
	Then Admin should see staff table with pagination icons
	
	Scenario: Verify staff data page split
	Then Admin should see 5 staff data in a page
	
	Scenario: verify previous page icon disable
	Then admin should see previous page icon disabled
	
	Scenario: verify first page icon disabled
	Then admin should see first page icon disabled