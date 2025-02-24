@batch_page
Feature: Batch feature

  Background: 
    Given Admin user is logged in with valid credentials  

  @batch_page_navigation_1
  Scenario: Verify Admin Navigates to Batch page successfully
   
    When Admin clicks Batch on the navigation bar
    Then Admin should be in the Manage Batch Page

  @batch_page_validation_1
  Scenario: Validate "Title" in Batch Page
    
    When Admin clicks Batch on the navigation bar
    Then Admin should see the "LMS - Learning Management System" Title in batch page

  @batch_page_validation_2
  Scenario: Validate "heading" in the Batch Page
    
    When Admin clicks Batch on the navigation bar
    Then Admin should see the "Manage Batch" Heading

  @batch_page_validation_3
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
   
    When Admin clicks Batch on the navigation bar
    Then Admin should see the disabled Delete Icon under the header in batch page

  @batch_page_validation_4
  Scenario: Validate pagination in the Batch Page
    
    When Admin clicks Batch on the navigation bar
    Then Admin should see the enabled pagination controls under the data table in batch page

  @batch_page_validation_5
  Scenario: Validate edit icon in each data rows
    
    When Admin clicks Batch on the navigation bar
    Then Admin should see the edit icon in each row in batch page

  @batch_page_validation_6
  Scenario: Validate delete icon in each data rows
   
    When Admin clicks Batch on the navigation bar
    Then Admin should see the delete icon in each row in batch page

  @batch_page_validation_7
  Scenario: Validate checkbox in each data rows
    
    When Admin clicks Batch on the navigation bar
    Then Admin should see the checkbox in each row in batch page

  @batch_page_validation_8
  Scenario: Validate Datatable headers
    
    When Admin clicks Batch on the navigation bar
    Then Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit/Delete

  @batch_page_validation_9
  Scenario: Validate "Checkbox" in the Datatable header row
   
    When Admin clicks Batch on the navigation bar
    Then Admin should see the checkbox  in the datatable header row in batch page

  @batch_page_validation_10
  Scenario: Validate "sort icon" next to all the datatable header
   
    When Admin clicks Batch on the navigation bar
    Then Admin should see the sort icon next to all Datatable headers in batch page

  @batch_add_new_batch_1
  Scenario: Verify sub menu displayed in batch menu bar
   
    When Admin clicks Batch on the navigation bar
    Then Admin should see sub menu in menu bar as "Add New Batch"

  @batch_add_new_batch_2
  Scenario: Validate Admin able to click on the Add new Batch Option
   
    When Admin clicks on "Add New batch" under the "batch" menu bar
    Then Admin should see the Batch Details pop up window

  @batch_add_new_batch_details_popup_1
  Scenario: Validate all the fields exist in pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin checks all the fields are enabled in batch pop up window
    Then The pop up should include the fields Batch Name, Number of classes and Description as text box, Program Name as drop downStatus as radio button

  @batch_add_new_batch_details_popup_2
  Scenario: Validate batchname prefix selected program name
    Given Admin is on the Batch Details Pop Up Window
    When Admin selects program name present in the dropdown of batch pop up window
    Then Admin should see selected program name in the batch name prefix box

  @batch_add_new_batch_details_popup_3
  Scenario: Validate batch name suffix box should accept only numbers
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters alphabets in batch name suffix box
    Then Admin should get error message below the text box of respective field on batch page

  @batch_add_new_batch_details_popup_4
  Scenario: Validate batch name prefix box is not editable
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters alphabets in batch name prefix box
    Then Admin should see empty text box on batch page

  @batch_add_new_batch_details_popup_5
  Scenario: Validate input data only for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the data only to the mandatory fields and clicks save button on batch page
    Then Admin should get a successful message on batch page

  @batch_add_new_batch_details_popup_6
  Scenario: Validate input data missing for mandatory fields
    Given Admin is on the Batch Details Pop Up Window
    When Admin leaves blank one of the mandatory fields on batch page
    Then Admin should get a error message on the respective mandatory field on batch page

  @batch_add_new_batch_details_popup_7
  Scenario: Validate save button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the valid data to all the mandatory fields and click save button on batch page
    Then Admin should get a successful message on batch page

  @batch_add_new_batch_details_popup_8
  Scenario: Validate cancel button in Batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin enters the valid data to all the mandatory fields and click cancel button on batch page
    Then Admin can see the batch details popup closes without creating any batch

  @batch_add_new_batch_details_popup_9
  Scenario: Validate close icon on the batch details pop up
    Given Admin is on the Batch Details Pop Up Window
    When Admin clicks on the close icon on batch page
    Then The batch details pop up closes

  @batch_edit_icon_validation_1
  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batch page
    When Admin clicks the edit icon on batch page
    Then Admin should see the Batch Details pop up window

  @batch_edit_icon_validation_2
  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batch page
    When Admin clicks the edit icon on batch page
    Then Admin should see Program name value field is disabled for editing on batch page

  @batch_edit_icon_validation_3
  Scenario: Validate Edit icon feature in any row
    Given Admin is on the Batch page
    When Admin clicks the edit icon on batch page
    Then Admin should see batch name value field is disabled for editing

  @batch_edit_icon_validation_4
  Scenario: Validate editing description and No. of classes fields with invalid data in the pop up
    Given Admin is on the Batch page
    When Admin clicks the edit icon on batch page
    And Admin Updates any fields with invalid data and click save button on batch page
    Then Admin should see batch name value field is disabled for editing

  @batch_edit_icon_validation_5
  Scenario: Validate save button in Batch details pop up
    Given Admin is on the Batch page
    When Admin clicks the edit icon on batch page
    And Admin enters the valid edit data to all the mandatory fields and click save button on batch page
    Then Admin should get a successful message for editing the batch

  @batch_edit_icon_validation_6
  Scenario: Validate cancel button in Batch details pop up
    Given Admin is on the Batch page
    When Admin clicks the edit icon on batch page
    And Admin enters the valid edit data to all the mandatory fields and click cancel button on batch page
    Then Admin can see the batch details popup closes without editing the batch

  @batch_delete_1
  Scenario: Validate delete Icon on any row
    Given Admin is on the Batch page
    When Admin clicks the delete Icon on any row on batch page
    Then Admin should see the confirm alert box with yes and no button on batch page

  @batch_delete_2
  Scenario: Validate yes button on the confirm alert box
    Given Admin is on the Batch page
    When Admin clicks the delete Icon on any row on batch page
		And Admin clicks yes button on the confirm alert box
    Then Admin should see the successful message and the batch should be deleted

  @batch_delete_3
  Scenario: Validate no button on the confirm alert box
    Given Admin is on the Batch page
    When Admin clicks the delete Icon on any row on batch page
    And Admin clicks no button on the confirm alert box
    Then Admin should see the alert box closed and the batch is not deleted

  @batch_delete_4
  Scenario: Validate close Icon on the alert box
    Given Admin is on the Batch page
    When Admin clicks the delete Icon on any row on batch page
    And Admin clicks on the close icon on confirm alert box
    Then Admin should see the alert box closed on batch page

  @batch_delete_5
  Scenario: Validate single row delete with checkbox
    Given Admin is on the Batch page
    When Admin selects one row on batch page
    And Admin clicks on the delete icon under the Manage batch header
		And Admin clicks yes button on the confirm alert box
    Then The respective row in the table should be deleted on batch page

  @batch_delete_6
  Scenario: Validate multiple row delete with checkbox
    Given Admin is on the Batch page
    When Admin selects two rows on batch page
    And Admin clicks on the delete icon under the Manage batch header
		And Admin clicks yes button on the confirm alert box
    Then The respective rows in the table should be deleted on batch page

  @batch_pagination_1
  Scenario: Validate the next page link
    Given Admin is on the Batch page
    When Admin clicks next page link on the data table on batch page
    Then Admin should see the Next enabled link on batch page

  @batch_pagination_2
  Scenario: Validate the last page link
    Given Admin is on the Batch page
    When Admin clicks last page link on the data table on batch page
    Then Admin should see the last page link with next page link disabled on the table on batch page

  @batch_pagination_3
  Scenario: Validate the previous page link
    Given Admin is on the Batch page
    When Admin clicks second page link on the data table on batch page
    And Admin clicks previous page link on the data table on batch page
    Then Admin should see the previous page on the table on batch page

  @batch_pagination_4
  Scenario: Validate the first page link
    Given Admin is on the Batch page
    When Admin clicks second page link on the data table on batch page
    And Admin clicks first page link on the data table on batch page
    Then Admin should see the very first page on the data table on batch page

  @batch_search_1
  Scenario: Validate the search box functionality
    Given Admin is on the Batch page
    When Admin enters the batch name in the search text box
    Then Admin should see the filtered batches in the data table

  @batch_logout_1
  Scenario: Validate logout option in the header is visible and enabled from the batch page
    Given Admin is on the Batch page
    When Admin clicks on the logout button on batch page
    Then Admin should see the Login screen Page
