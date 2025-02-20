@class
Feature: Class feature
  To validate the features of Manage Class page
  
	Background: 
		Given Admin user is logged in with valid credentials
		
 	Scenario: Validating the navigation to Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin lands on Manage Class page
	
	
 	Scenario: Validating the title on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the "LMS - Learning Management System" title on Manage Class page
   
 	Scenario: Validating the header on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the "Manage Class" header on Manage Class page
  
 	Scenario: Validating the search bar on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the Search bar on Manage Class page 
  
 	Scenario: Validating the data table headers on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the following data table headings on the Manage Class page:
      | Batch Name   |
      | Class Topic |
      | Class Description |
      | Status      |
      | Class Date  |
      | Staff Name  |
      | Edit / Delete |  
    
 	Scenario: Validating the text and pagination icon on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the text "Showing x to x of x entries" below the data table on Manage Class page
    And admin sees the pagination controls below the data table on Manage Class page
  
 	Scenario: Validating the sort icon of all the fields in datatable on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the sort icon for the following data table headings on the Manage Class page:
      | Batch Name   |
      | Class Topic |
      | Class Description |
      | Status      |
      | Class Date  |
      | Staff Name  |
	
 	Scenario: Validating the Delete button on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the Delete button on Manage Class page 
  
 	Scenario: Validating the total number of classes on the Manage Class page
    When Admin clicks the Class link on navigation bar on Home page
    Then Admin sees the "In total there are x classes." on Manage Class page    
    
    
    
    
    
    
    
    
    
    
      