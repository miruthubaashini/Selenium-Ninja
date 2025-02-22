@class
Feature: Class feature
  To validate the features of Manage Class page
  
	Background: 
		Given Admin user is logged in with valid credentials
		
 	Scenario: Validate the navigation to Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin lands on Manage Class page

			
 	Scenario: Validate the title on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the "LMS - Learning Management System" title on Manage Class page
  	 
 	Scenario: Validate the header on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the "Manage Class" header on Manage Class page
  	
 	Scenario: Validate the search bar on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the Search bar on Manage Class page 
  	
 	Scenario: Validate the data table headers on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the following data table headings on the Manage Class page:
      | Batch Name   |
      | Class Topic |
      | Class Description |
      | Status      |
      | Class Date  |
      | Staff Name  |
      | Edit / Delete |  
  	  
 	Scenario: Validate the text and pagination icon on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the text "Showing x to x of x entries" below the data table on Manage Class page
    And admin sees the pagination controls below the data table on Manage Class page
  	
 	Scenario: Validate the sort icon of all the fields in datatable on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the sort icon for the following data table headings on the Manage Class page:
      | Batch Name   |
      | Class Topic |
      | Class Description |
      | Status      |
      | Class Date  |
      | Staff Name  |
		
 	Scenario: Validate the Delete button on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the Delete button on Manage Class page 
  	
 	Scenario: Validate the total number of classes on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the "In total there are x classes." on Manage Class page    
    
   # ===============================Add new class scenarios ===============================
  
  Scenario: Validate the Class Details popup
  	Given Admin is on Manage Class page
    When Admin clicks Add New Class from the Class dropdown
    Then Admin sees the Class Details popup with SAVE and CANCEL button and Close(X) Icon       
   
  Scenario: Validate input fields and their text boxes in Class Details form
  	Given Admin is on Manage Class page
    When Admin clicks Add New Class from the Class dropdown
    Then Admin sees few input fields and their respective text boxes in the Class Details form
      | Batch Name   |
      | Class Topic |
      | Class Description |
      | Select Class Dates |
      | No of Classes |
      | Staff Name    |
      | Status        |
      | Comments      |
      | Notes         |
      | Recording     |   
  
      
  Scenario Outline: Validate add new class with valid data in only mandatory fields
  	Given Admin is on the Class Details Popup window
    When Admin enters mandatory fields in the Class Details form from "<sheetName>" and <rowNum>
		And  admin clicks on Save button
    Then Admin gets the message "Class Created" on Manage Class page
    
   Examples: 
      | sheetName | rowNum | 
      | ClassData |     1 |
      | ClassData |     2 |   
      | ClassData |     3 | 
      | ClassData |     4 | 
      | ClassData |     5 | 
 
  Scenario: Validate updation of No of Classes on selecting class dates
  	Given Admin is on the Class Details Popup window
    When Admin selects class dates in date picker 
    	| 03/28/2025 |

    Then Admin sees the No of Classes value is added automatically  
        
  @toCheck  
  Scenario: Validate weekend dates are disabled in Class Dates calendar
  	Given Admin is on the Class Details Popup window
    When Admin clicks date picker 
    Then Admin sees weekends dates are disabled in the calender
  
    
  Scenario Outline: Validate add new class with valid data in only optional fields
  	Given Admin is on the Class Details Popup window
    When Admin enters only optional fields in the Class Details form from "<sheetName>" and <rowNum>
    And  admin clicks on Save button
    Then Admin sees error messages below each mandatory fields    
    
  Examples: 
      | sheetName | rowNum | 
      | ClassData |     6 |
         
 
 	#for invalid data scenario create test scripts to enter the values rather than selecting from dropdown or date picker
 	
  Scenario Outline: Validate add new class with invalid data
  	Given Admin is on the Class Details Popup window
    When Admin enters invalid data in all the fields in the Class Details form from "<sheetName>" and <rowNum>
    And  admin clicks on Save button
    Then Admin sees error messages below each fields    
    
  Examples: 
      | sheetName | rowNum | 
      | ClassData |     7 |
      | ClassData |     8 |   
      | ClassData |     9 | 
      | ClassData |     10 | 

     
  Scenario: Validate Cancel button on Class Details form
  	Given Admin is on the Class Details Popup window
    When Admin clicks Cancel button on Class Details form
    Then Admin sees the Class Details popup window getting closed      
     
  Scenario: Validate Close(X) button on Class Details form
  	Given Admin is on the Class Details Popup window
    When Admin clicks Close(X) button on Class Details form
    Then Admin sees the Class Details popup window getting closed  
          
   @toCheck   
  Scenario: Validate Save button on Class Details form
  	Given Admin is on the Class Details Popup window
  	When Admin enters the values for input fields on Class Details form
    When Admin clicks Save button on Class Details form
    Then Admin sees success message and new class is added to the data table       
      
   # ===============================Edit class===============================  
     
  Scenario: Validate row level Edit icon
  	Given Admin is on Manage Class page
    When Admin clicks on the edit icon on the Manage Class page
    Then Admin sees a pop up with class details displayed    
      
  Scenario: Validate batch Name is disabled in Class Details form 
  	Given Admin is on Manage Class page
    When Admin clicks on the edit icon on the Manage Class page
    Then Admin sees that batch Name field is disabled
  
  Scenario: Validate batch Name is disabled in Class Details form 
  	Given Admin is on Manage Class page
    When Admin clicks on the edit icon on the Manage Class page
    Then Admin sees that Class Topic field is disabled  
  
  Scenario Outline: Validate if the Class Details fields are updated with valid data 
  	Given Admin is on the Edit Class Popup window
    When Admin updates the fields with valid data from "<sheetName>" and <rowNum>
    And  admin clicks on Save button
    Then Admin gets message "Class Updated" and see the updated values in data table  
    
  Examples: 
      | sheetName | rowNum | 
      | ClassData |     11 |
      
  Scenario Outline: Validate if the Class Details fields are updated with invalid data 
  	Given Admin is on the Edit Class Popup window
    When Admin updates the fields with invalid data from "<sheetName>" and <rowNum>
    And  admin clicks on Save button
    Then Admin sees error messages below each fields
    
  Examples: 
      | sheetName | rowNum | 
      | ClassData |     12 | 
    
  Scenario Outline: Validate if the mandatory fields are updated with valid data 
  	Given Admin is on the Edit Class Popup window
    When Admin updates the mandatory fields with valid values from "<sheetName>" and <rowNum>
    And  admin clicks on Save button
    Then Admin gets message "Class Updated" and see the updated values in data table   
 
  Examples: 
      | sheetName | rowNum | 
      | ClassData |     13 | 
          
  Scenario Outline: Validate if the optional fields are updated with valid data 
  	Given Admin is on the Edit Class Popup window
    When Admin updates the optional fields with valid values from "<sheetName>" and <rowNum> 
    And  admin clicks on Save button
    Then Admin gets message "Class Updated" and see the updated values in data table  
 
   Examples: 
      | sheetName | rowNum | 
      | ClassData |     14 | 
         
  Scenario: Validate Cancel button on Edit popup 
  	Given Admin is on the Edit Class Popup window
    When Admin clicks Cancel button on edit popup 
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class
    
     # ===============================Sort class=============================== 
	
  Scenario: Validate sort class by Batch Name 
  	Given Admin is on Manage Class page
    When Admin clicks on Sort icon next to "Batch Name" table header 
    Then Admin sees that class details are sorted by "Batch Name"   
    
  Scenario: Validate sort class by Class Topic 
  	Given Admin is on Manage Class page
    When Admin clicks on Sort icon next to "Class Topic" table header 
    Then Admin sees that class details are sorted by "Class Topic"  
  
  Scenario: Validate sort class by Class Description 
  	Given Admin is on Manage Class page
    When Admin clicks on Sort icon next to "Class Description" table header 
    Then Admin sees that class details are sorted by "Class Description"  
    
  Scenario: Validate sort class by Status 
  	Given Admin is on Manage Class page
    When Admin clicks on Sort icon next to "Status" table header 
    Then Admin sees that class details are sorted by "Status"  
    
  Scenario: Validate sort class by Class Date 
  	Given Admin is on Manage Class page
    When Admin clicks on Sort icon next to "Class Date" table header 
    Then Admin sees that class details are sorted by "Class Date"  
    
  Scenario: Validate sort class by Staff Name 
  	Given Admin is on Manage Class page
    When Admin clicks on Sort icon next to "Staff Name" table header 
    Then Admin sees that class details are sorted by "Staff Name"                      
     
     
       # ===============================Delete class===============================    
     
  Scenario: Validate row level Delete icon
  	Given Admin is on Manage Class page
    When Admin clicks on the Delete icon on the Manage Class page
    Then Admin gets an alert with heading "Confirm" with Yes and No button
   
  Scenario: Validate Yes button on the delete dialog box
  	Given Admin is on delete Confirm dialog box
    When Admin clicks on the Yes button on the dialog box
    Then Admin gets "Successful" "Class Deleted" message and do not see that Class in the data table

  Scenario: Validate No button on the delete dialog box
  	Given Admin is on delete Confirm dialog box
    When Admin clicks on the No button on the dialog box
    Then Admin sees the dialog box disappears without deleting the record
    
  Scenario: Validate Close(X) icon on the delete dialog box
  	Given Admin is on delete Confirm dialog box
    When Admin clicks on the Close icon on the dialog box
    Then Admin sees the dialog box disappears without deleting the record    
     
         # ===============================Delete Multiple classes=============================== 
    
  Scenario: Validate the common Delete button enabled after clicking on any checkbox
  	Given Admin is on Manage Class page
    When Admin clicks 1 checkbox in the data table on the Manage Class page
    Then Admin sees the common delete button enabled under header Manage Class
	
  Scenario: Validate multiple class deletion by selecting single checkbox
  	Given Admin is on Manage Class page
    When Admin clicks 1 checkbox in the data table on the Manage Class page
    And admin clicks Delete button on top of the page
    And Admin clicks on the Yes button on the dialog box
    Then Admin lands on Manage Class page and can see the selected class is deleted from the data table
    
  Scenario: Validate multiple class deletion by selecting single checkbox
  	Given Admin is on Manage Class page
    When Admin clicks 1 checkbox in the data table on the Manage Class page
    And admin clicks Delete button on top of the page
    And Admin clicks on the No button on the dialog box
    Then Admin lands on Manage Class page and can see the selected class is not deleted from the data table
    
  Scenario: Validate multiple class deletion by selecting multiple check boxes
  	Given Admin is on Manage Class page
    When Admin clicks multiple 2 checkboxes in the data table on the Manage Class page
    And admin clicks Delete button on top of the page
    And Admin clicks on the Yes button on the dialog box
    Then Admin lands on Manage Class page and can see the selected class is deleted from the data table   
	
  Scenario: Validate multiple class deletion by selecting multiple check boxes
  	Given Admin is on Manage Class page
    When Admin clicks multiple 2 checkboxes in the data table on the Manage Class page
    And admin clicks Delete button on top of the page
    And Admin clicks on the No button on the dialog box
    Then Admin lands on Manage Class page and can see the selected class is not deleted from the data table








     
      