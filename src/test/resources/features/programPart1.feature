@program1
Feature: Validating LMS Program module

  Background: 
    Given Admin user is logged in with valid credentials

  @Navigation
  Scenario: Admin should be able to navigate Manage Program page
    Given Admin is on home page after login
    When Admin click Program in bar menu
    Then Admim should be on Manage Program page

  @logout
  Scenario: Verify logout button on Program page
   When Admin click Program in bar menu
    Then Admin should see Logout in menu bar

  @lmsHeading
  Scenario: Verify LMS heading in Menu bar
    Then Admin should be able to see LMS - Learning Management System

  @pageNames
  Scenario: Verify all Mnages page haeading names in Menu bar
    Then Admin should see the page names in order Home,Program,Batch,Class,Edit/delete on Mange program page

  @manageProgHeading
  Scenario: Verify Manage Program Heading
    Then Admin should be able to see Manage Program heading

  @pageHeadings
  Scenario: Verify headings on Manage Page
    Then Admin should able to see Program name, description, and status for each program

  @addProgramOption
  Scenario: Verify Add New Program after clicking on Program in menu bar
    When Admin clicks on Program option in menu bar
    Then Admin should see sub menu in menu bar as Add New Program in Program page

  @deleteButton
  Scenario: Verify delete button on left side is disabled
    Then Admin should see a Delete button in left top is disabled in Manage Program

  @searchBar
  Scenario: Verify Search bar
    Then Admin should see Search bar with text as Search in Program page

  @uncheckedBox
  Scenario: Verify checkbox unchecked beside Program Name column header
    Then Admin should see checkbox default state as unchecked beside Program Name on Manage Program

  @sortIcon
  Scenario: Verify Sort icon in Manage Program
    Then Admin should see the sort arrow icon beside to each header except Edit and Delete on Manage Program

  @editDeleteButton
  Scenario: Verify edit and delete icon on manage program
    Then Admin should see the Edit and Delete buttons on each row of the data table on Manage Program
