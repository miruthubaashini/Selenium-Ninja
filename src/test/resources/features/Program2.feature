@program2
Feature: Program2 feature
  To validate the features of Manage Program page

  Background: 
    Given Admin user is logged in with valid credentials

<<<<<<< HEAD
  ################# Delete multiple starts
  Scenario: Verify Admin is able to select multiple programs in program page
    When Admin selects more than single program by clicking on the checkbox
    Then All the Programs get selected

  Scenario Outline: Verify Admin is able to delete Multiple programs in program page
    When Admin clicks on the delete button on the left top of the program page "<deleteOption>"
    Then Admin lands on Confirmation form in the program page

    Examples: 
      | deleteOption |
      | Pop          |

  Scenario Outline: Verify Admin is able to click No in the program
    When Admin clicks on "<deleteOption>"  button in the program page
    Then Admin can see Programs are still selected and not deleted

    Examples: 
      | deleteOption |
      | No           |

  Scenario Outline: Verify Admin is able to click Yes in the dialog box
    When Admin clicks on "<deleteOption>" button in the confirmation page
    Then Admin can see Successful  program deleted message in the page

    Examples: 
      | deleteOption |
      | Yes          |

  Scenario: Verify Admin is able to deleted program in the program
    When Admin Searches for Deleted Program names in the program
    Then There should be zero results in the program page
  ################# Delete multiple ends
  
  
  ################# Delete single starts
  Scenario Outline: Verify delete feature for single program
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin will get confirm deletion popup for a single program

  Scenario Outline: Verify Admin is able to close the window with X button
    When Admin Click on "<deleteOption>" button
    Then Admin can see Confirm Deletion form disappear

    Examples: 
      | deleteOption |
      | X            |

    Examples: 
      | deleteOption |
      | Pop          |

  Scenario Outline: Verify Admin is able to click No in single program delete
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin can see Confirmation form disappears

    Examples: 
      | deleteOption |
      | No           |

  Scenario Outline: Verify Admin is able to close the window with X in the program
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin can see Confirmation form disappears

    Examples: 
      | deleteOption |
      | X            |

  Scenario Outline: Verify Admin is able to click Yes in single program delete
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin can see Successful Program Deleted message

    Examples: 
      | deleteOption |
      | Yes          |

  Scenario: Verify Admin is able to deleted single program
    When Admin Searches for one Deleted Program name
    Then There should be zero results for the search result
  ################# Delete single ends
  
  ################# search starts
=======
  #################Edit Program
  Scenario: Verify Edit option of Programs page
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

  Scenario: Verify title of the pop up window
    When Admin clicks on Edit option for a program
    Then Admin lands on a pop up Program details form

  Scenario: Verify mandatory fields with red asterisk mark
    When Admin clicks on Edit option for one program
    Then Admin should see red asterisk mark beside mandatory field "Name"

  Scenario: Verify Admin is able to click Cancel
    When Admin edits the program name and click on cancel button
    Then Updated program name is not seen by the Admin

  Scenario: Verify Admin is able to click x
    When Admin edits the program name and click on x button
    Then Updated program name is not seen by the Admin

  Scenario: Verify edit  Program description in program details
    When Admin edits the program description and click on save button
    Then Updated program description is seen by the Admin

  Scenario: Verify edit  Program Name in program details
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin

  Scenario: Verify edited Program details
    When Admin searches with newly updated Program Name
    Then Admin verifies that the details are correctly updated

  Scenario: Verify edit  Program status in program details
    When Admin edits the program status and click on save button
    Then Updated program status is seen by the Admin

  ################ Delete multiple starts
  Scenario: Verify Admin is able to select multiple programs in program page
    When Admin selects more than single program by clicking on the checkbox
    Then All the Programs get selected

  Scenario Outline: Verify Admin is able to delete Multiple programs in program page
    When Admin clicks on the delete button on the left top of the program page "<deleteOption>"
    Then Admin lands on Confirmation form in the program page

    Examples: 
      | deleteOption |
      | Pop          |

  Scenario Outline: Verify Admin is able to click No in the program
    When Admin clicks on "<deleteOption>"  button in the program page
    Then Admin can see Programs are still selected and not deleted

    Examples: 
      | deleteOption |
      | No           |

  Scenario Outline: Verify Admin is able to click Yes in the dialog box
    When Admin clicks on "<deleteOption>" button in the confirmation page
    Then Admin can see Successful  program deleted message in the page

    Examples: 
      | deleteOption |
      | Yes          |

  Scenario: Verify Admin is able to deleted program in the program
    When Admin Searches for Deleted Program names in the program
    Then There should be zero results in the program page

  ############### Delete multiple ends
  ############### Delete single starts
  Scenario Outline: Verify delete feature for single program
    When Admin clicks on delete button for a single program
    Then Admin will get confirm deletion popup for a single program

  Scenario Outline: Verify Admin is able to click No in single program delete
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin can see Confirmation form disappears

    Examples: 
      | deleteOption |
      | No           |

  Scenario Outline: Verify Admin is able to close the window with X button
    When Admin Click on "<deleteOption>" button
    Then Admin can see Confirm Deletion form disappear

    Examples: 
      | deleteOption |
      | X            |

  Scenario Outline: Verify Admin is able to close the window with X in the program
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin can see Confirmation form disappears

    Examples: 
      | deleteOption |
      | X            |

  Scenario Outline: Verify Admin is able to click Yes in single program delete
    When Admin clicks on delete button for a single program "<deleteOption>"
    Then Admin can see Successful Program Deleted message

    Examples: 
      | deleteOption |
      | Yes          |

  Scenario: Verify Admin is able to deleted single program
    When Admin Searches for one Deleted Program name
    Then There should be zero results for the search result

  ################ Delete single ends
  ################ search starts
>>>>>>> a9bade0eeb3f672cbf7fe9a8e419e39a2ea8d497
  Scenario: Verify Admin is able to search results found for programs name
    When Admin enter the programs to search By program name
    Then Admin should able to see Program name with description and status for searched program name

  Scenario: Verify Admin is able to search results found for program description
    When Admin enter the program to search By program description
    Then Admin should able to see Program name with description and status for searched program name

  Scenario: Verify Admin is able to search results not found
    When Admin enter the program to search By program name that does not exist
    Then Admin should able to see Program name with description and status for searched program name

  Scenario: Verify Admin is able to search with partial program name
    When Admin enter the program to search By partial name of program
    Then Admin should able to see Program name with description and status for searched program name
<<<<<<< HEAD
  ################# search ends
  
  ################# paginatiom starts
=======

  ################ search ends
  ############### paginatiom starts
>>>>>>> a9bade0eeb3f672cbf7fe9a8e419e39a2ea8d497
  Scenario: Validate the next page link of programs
    When Admin clicks next page link on the data table on programs page
    Then Admin should see the Next enabled link on programs page

  Scenario: Validate the last page link of programs
    When Admin clicks last page link on the data table on programs page
    Then Admin should see the last page link with next page link disabled on the table on programs page

  Scenario: Validate the previous page link of programs
    When Admin clicks previous page link on the data table on programs page
    Then Admin should see the previous page on the table on programs page

  Scenario: Validate the first page link of programs
    When Admin clicks first page link on the data table on programs page
    Then Admin should see the very first page on the data table on programs page

  Scenario: Verify pagination when there are no records in programs page
    When Admin clicks Program menu on the navigation bar
    Then Admin should not see any pagination icons and message "No records found"

  Scenario: Verify pagination when there are less than 5 records in programs page
    When Admin clicks Program menu on the navigation bar
    Then Admin should see pagination icons disabled
<<<<<<< HEAD
  ################# paginatiom end
  
  ##################Sorting Starts
=======

  ############### paginatiom end
  ################Sorting Starts
>>>>>>> a9bade0eeb3f672cbf7fe9a8e419e39a2ea8d497
  Scenario: Verify sorting of  Program name in Ascending order or Descending order
    When Admin clicks on Arrow next to program Name in programs page
    Then Admin See the Program Name is sorted in Ascending order or Descending order

  Scenario: Verify sorting of  Program status in Ascending order or Descending order
    When Admin clicks on Arrow next to program status in programs page
    Then Admin See the Program status is sorted in Ascending order or Descending order

  Scenario: Verify sorting of  Program description in Ascending order or Descending order
    When Admin clicks on Arrow next to program description in programs page
    Then Admin See the Program description is sorted in Ascending order or Descending order
<<<<<<< HEAD
  ##################Sorting ends
  
  
  ###################Edit Program
  Scenario: Verify Edit option of Programs page
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

  Scenario: Verify title of the pop up window
    When Admin clicks on Edit option for a program
    Then Admin lands on a pop up Program details form

  Scenario: Verify mandatory fields with red asterisk mark
    When Admin clicks on Edit option for one program
    Then Admin should see red asterisk mark beside mandatory field "Name"

  Scenario: Verify edit  Program Name in program details
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin

  Scenario: Verify edit  Program description in program details
    When Admin edits the program description and click on save button
    Then Updated program description is seen by the Admin

  Scenario: Verify edit  Program status in program details
    When Admin edits the program status and click on save button
    Then Updated program status is seen by the Admin
=======
  ################Sorting ends
>>>>>>> a9bade0eeb3f672cbf7fe9a8e419e39a2ea8d497
