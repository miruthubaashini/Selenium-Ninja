@program1
Feature: Validating LMS Program module

  Background: 
    Given Admin user is logged in with valid credentials

  @Navigation
  Scenario: Admin should be able to navigate Manage Program page
    When Admin click Program in bar menu
    Then Admim should be on Manage Program page

  @logout
  Scenario: Verify logout button on Program page
    When Admin click Program in bar menu
    Then Admin should see Logout in menu bar

  @lmsHeading
  Scenario: Verify LMS heading in Menu bar
    When Admin click Program in bar menu
    Then Admin sees the "LMS - Learning Management System" title on Manage Class page

  @pageNames
  Scenario: Verify Manages pages all heading names in Menu bar
    When Admin click Program in bar menu
    Then Admin should see data table with page names in order Home,Program,Batch,Class on Mange program page
      | Home|
      | Program |
      | Batch|
      | Class|
      | Logout|


  @manageProgHeading
  Scenario: Verify Manage Program Heading
    When Admin click Program in bar menu
    Then Admin sees the "Manage Program" header on Manage Class page

  @addProgramOption
  Scenario: Verify Add New Program after clicking on Program in menu bar
    When Admin click Program in bar menu
    Then Admin should see sub menu in menu bar as Add New Program in Program page

  @deleteButton
  Scenario: Verify delete button on left side is disabled
    When Admin click Program in bar menu
    Then Admin should see a Delete button in left top is disabled in Manage Program

  @searchBar
  Scenario: Verify Search bar
    When Admin click Program in bar menu
    Then Admin should see Search bar with text as Search in Program page

  @uncheckedBox
  Scenario: Verify checkbox unchecked beside Program Name column header
    When Admin click Program in bar menu
    Then Admin should see checkbox default state as unchecked beside Program Name on Manage Program

  @sortIcon
  Scenario: Verify Sort icon on Manage Program
    When Admin click Program in bar menu
    Then Admin should see the following sort icon beside to each header except Edit and Delete on Manage Program
      | Program Name        |
      | Program Description |
      | Program Status      |

  @editButton
  Scenario: Verify edit and delete icon on manage program
    When Admin click Program in bar menu
    Then Admin should see the Edit buttons on each row of the data table on Manage Program

  @deleteButton
  Scenario: Verify edit and delete icon on manage program
    When Admin click Program in bar menu
    Then Admin should see the delete buttons on each row of the data table on Manage Program

  @paginationIcon
  Scenario: Verify pagination icons below data table in manage program
    When Admin click Program in bar menu
    Then Admin sees the text "Showing x to x of x entries" below the data table on Manage Class page
    And admin sees the pagination controls below the data table on Manage Class page

  @footerMsg
  Scenario: Verify footer message in manage program
    When Admin click Program in bar menu
    Then Admin sees the "In total there are z programs." on Program page

  @popUpWindow
  Scenario: Verify add New Program text
    When Admin click Program in bar menu
    Then Admin should see pop up of add new program

  @popWindowTitle
  Scenario: Verify title of the pop up window
    Given Admin is on program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see window title as "Program Details" in program

  @redAsterisk
  Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on program page
    When Admin clicks on Add New Program under the Program menu bar
    Then Admin should see red asterisk mark beside mandatory field "Name"

  @emptyForm
  Scenario: Verify empty form submission
    Given Admin is on Program details form
    When Admin clicks save button without entering mandatory field in program module
    Then Admin gets error message

  @cancelButton
  Scenario: Verify cancel button
    Given Admin is on Program details form
    When Admin clicks Cancel button
    Then Admin can see program details form disappears

  @textInNameField
  Scenario Outline: Verify entered program name field text
    Given Admin is on Program details form
    When Admin enters the Name in the text box on form from from "<sheetName>" and <rowNum>
    Then Admin can see the text entered in the program name field

    Examples: 
      | sheetName | rowNum |
      | Program1  |      2 |

  @textDescriptionField
  Scenario Outline: Verify entered description field text
    Given Admin is on Program details form
    When Admin enters the Description in text box on form from from "<sheetName>" and <rowNum>
    Then Admin can see the text entered in description box on form

    Examples: 
      | sheetName | rowNum |
      | Program1  |      2 |

  @radioButton
  Scenario Outline: Verify select Status
    Given Admin is on Program details form
    When Admin selects the "<status>" of the program by clicking on the radio button Active/InActive on Program page
    Then Admin can see "<status>" selected on Program page

    Examples: 
      | status   |
      | Active   |
      | Inactive |
      

  @createProgram
  Scenario Outline: Verify Admin is able to save the program details
    Given Admin is on Program details form
    When Admin enter valid details for mandatory from "<sheetName>" and <rowNum> fields and Click on save button
    Then Admin gets message Successful Program created

    Examples: 
      | sheetName | rowNum |
      | Program1  |      1 |

  @programCreated
  Scenario Outline: Verify added Program is created
    Given Admin is on program page
    When Admin searches "<sheetName>" and <rowNum> with newly created Program Name
    Then Records of the newly created Program Name is displayed and match the data entered

    Examples: 
      | sheetName | rowNum |
      | Program1  |      1 |

  @closeByXS
  Scenario: Verify close window with X
    Given Admin is on Program details form
    When Admin Click on "X" button on form
    Then Admin can see program details form disappears
