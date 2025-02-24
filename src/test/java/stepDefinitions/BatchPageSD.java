package stepDefinitions;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BatchPageSD {

	TestContext testContext;

	public BatchPageSD(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("Admin is on the Batch page")
	public void admin_is_on_the_batch_page() {
		admin_clicks_on_the_batch_menu_from_the_header();
	}

	@Given("Admin is on the Home page")
	public void admin_is_on_the_home_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("homeUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@When("Admin clicks Batch on the navigation bar")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		testContext.getBatchPage().clickBatchMenuLink();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("batchUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@Then("Admin should see the {string} Title in batch page")
	public void admin_should_see_the_title_in_batch_page(String expectedTitle) {
		String title = testContext.getBatchPage().getPageTitle();

		Assert.assertEquals(title, expectedTitle);
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String expectedHeading) {
		String heading = testContext.getBatchPage().getPageHeading();

		Assert.assertEquals(heading, expectedHeading);

	}

	@Then("Admin should see the disabled Delete Icon under the header in batch page")
	public void admin_should_see_the_disabled_under_the_header_in_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isDisabledDeleteIconDisplayed());

	}

	@Then("Admin should see the enabled pagination controls under the data table in batch page")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table_in_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isPaginationFirstIconDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isPaginationPreviousIconDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isPaginationNextIconDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isPaginationLastIconDisplayed());
	}

	@Then("Admin should see the edit icon in each row in batch page")
	public void admin_should_see_the_edit_icon_in_each_row_in_batch_page() {
		for(int i=1;i<=10;i++) {
			Assert.assertTrue(testContext.getBatchPage().areEditIconsDisplayed());	
		}
	}

	@Then("Admin should see the delete icon in each row in batch page")
	public void admin_should_see_the_delete_icon_in_each_row_in_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().areDeleteIconsDisplayed());
	}

	@Then("Admin should see the checkbox in each row in batch page")
	public void admin_should_see_the_checkbox_in_each_row_in_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().areCheckboxesDisplayed());
	}

	@Then("Admin should see the datatable headers Batch name, Batch Description,Batch Status, No Of classes, Program Name, Edit\\/Delete")
	public void admin_should_see_the_datatable_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {

		String batchNameHeader = testContext.getBatchPage().getTableHeaderText(2);
		String batchDescriptionHeader = testContext.getBatchPage().getTableHeaderText(3);
		String batchStatusHeader = testContext.getBatchPage().getTableHeaderText(4);
		String numberOfClassesHeader = testContext.getBatchPage().getTableHeaderText(5);
		String programNameHeader = testContext.getBatchPage().getTableHeaderText(6);
		String actionsHeader = testContext.getBatchPage().getTableHeaderText(7);

		Assert.assertEquals(batchNameHeader, "Batch Name");
		Assert.assertEquals(batchDescriptionHeader, "Batch Description");
		Assert.assertEquals(batchStatusHeader, "Batch Status");
		Assert.assertEquals(numberOfClassesHeader, "No Of Classes");
		Assert.assertEquals(programNameHeader, "Program Name");
		Assert.assertEquals(actionsHeader, "Edit / Delete");
	}

	@Then("Admin should see the checkbox  in the datatable header row in batch page")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row_in_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isTableHeaderCheckboxDisplayed());
	}

	@Then("Admin should see the sort icon next to all Datatable headers in batch page")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers_in_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isTableHeaderSortIconDisplayed(2));
		Assert.assertTrue(testContext.getBatchPage().isTableHeaderSortIconDisplayed(3));
		Assert.assertTrue(testContext.getBatchPage().isTableHeaderSortIconDisplayed(4));
		Assert.assertTrue(testContext.getBatchPage().isTableHeaderSortIconDisplayed(5));
		Assert.assertTrue(testContext.getBatchPage().isTableHeaderSortIconDisplayed(6));
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String subMenuText) {
		Assert.assertEquals(testContext.getBatchPage().getSubMenuText(), subMenuText);

	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_AddNewBatch_under_the_batch_menu_bar(String string, String string2) {
		testContext.getBatchPage().clickBatchMenuLink();
		testContext.getBatchPage().clickAddNewBatch();

	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		testContext.getBatchPage().isAddBatchPopupWindowVisible();
	}

	@Given("Admin is on the Batch Details Pop Up Window")
	public void admin_is_on_the_batch_details_pop_up_window() {
		testContext.getBatchPage().clickBatchMenuLink();
		testContext.getBatchPage().clickAddNewBatch();

	}

	@When("Admin checks all the fields are enabled in batch pop up window")
	public void admin_checks_all_the_fields_are_enabled_in_batch_pop_up_window() {
		waitForMillis(500);
	}

	@Then("The pop up should include the fields Batch Name, Number of classes and Description as text box, Program Name as drop downStatus as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {

		Assert.assertTrue(testContext.getBatchPage().isAddBatchProgramNameDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchNamePrefixDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchNameSuffixDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchDescriptionDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchStatusActiveDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchStatusInactiveDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchNumberOfClassesDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchCancelButtonDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isAddBatchSaveButtonDisplayed());
	}

	@When("Admin selects program name present in the dropdown of batch pop up window")
	public void admin_selects_program_name_present_in_the_dropdown_of_batch_pop_up_window() {
		testContext.getBatchPage().clickProgramNameDropDownFirstItem();
	}
 
	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		testContext.getBatchPage().selectedProgramNameIsDisplayedInPrefix();

	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		testContext.getBatchPage().enterTextInBatchNameSuffix("abcd");

	}

	@Then("Admin should get error message below the text box of respective field on batch page")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field_on_batch_page() {
		String error = testContext.getBatchPage().getBatchNameSuffixError();
		Assert.assertEquals(error, "This field accept only numbers and max 5 count.");
	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		testContext.getBatchPage().enterTextInBatchNamePrefix("abcd");
	}

	@Then("Admin should see empty text box on batch page")
	public void admin_should_see_empty_text_box_on_batch_page() {
		String text = testContext.getBatchPage().getTextInBatchNamePrefix();
		Assert.assertEquals(text, "");
	}

	@When("Admin enters the data only to the mandatory fields and clicks save button on batch page")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button_on_batch_page() {
		testContext.getBatchPage().clickProgramNameDropDownFirstItem();
		int suffix = new Random().nextInt(99999);
		testContext.getBatchPage().enterTextInBatchNameSuffix("" + suffix);
		testContext.getBatchPage().enterTextInBatchDescription("Test batch");
		testContext.getBatchPage().setBatchActiveStatus(true);
		testContext.getBatchPage().enterTextInBatchNumberOfClasses("12");
		testContext.getBatchPage().clickAddBatchSaveButton();
	}

	@Then("Admin should get a successful message on batch page")
	public void admin_should_get_a_successful_message_on_batch_page() {
		String text = testContext.getBatchPage().getAddBatchSaveMessage();
		Assert.assertEquals(text, "Batch Created Successfully");
	}

	@When("Admin leaves blank one of the mandatory fields on batch page")
	public void admin_leaves_blank_one_of_the_mandatory_fields_on_batch_page() {
		testContext.getBatchPage().clickProgramNameDropDownFirstItem();
		testContext.getBatchPage().enterTextInBatchDescription("Test batch mandatory fields");
		testContext.getBatchPage().setBatchActiveStatus(true);
		int numberOfClasses = new Random().nextInt(99);
		testContext.getBatchPage().enterTextInBatchNumberOfClasses("" + numberOfClasses);
		testContext.getBatchPage().clickAddBatchSaveButton();
	}

	@Then("Admin should get a error message on the respective mandatory field on batch page")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field_on_batch_page() {
		String error = testContext.getBatchPage().getBatchNameSuffixError();
		Assert.assertEquals(error, "Batch Name is required.");
	}
	
	@When("Admin enters the valid data to all the mandatory fields and click save button on batch page")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button_on_batch_page() {
		testContext.getBatchPage().clickProgramNameDropDownFirstItem();
		int suffix = new Random().nextInt(99999);
		testContext.getBatchPage().enterTextInBatchNameSuffix("" + suffix);
		testContext.getBatchPage().enterTextInBatchDescription("Test batch all fields");
		testContext.getBatchPage().setBatchActiveStatus(true);
		int numberOfClasses = new Random().nextInt(99);
		testContext.getBatchPage().enterTextInBatchNumberOfClasses("" + numberOfClasses);
		testContext.getBatchPage().clickAddBatchSaveButton();
	}
	
	@When("Admin enters the valid data to all the mandatory fields and click cancel button on batch page")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button_on_batch_page() {
		testContext.getBatchPage().clickProgramNameDropDownFirstItem();
		int suffix = new Random().nextInt(99999);
		testContext.getBatchPage().enterTextInBatchNameSuffix("" + suffix);
		testContext.getBatchPage().enterTextInBatchDescription("Test batch all fields");
		testContext.getBatchPage().setBatchActiveStatus(true);
		int numberOfClasses = new Random().nextInt(99);
		testContext.getBatchPage().enterTextInBatchNumberOfClasses("" + numberOfClasses);
		testContext.getBatchPage().clickAddBatchCancelButton();
	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		waitForMillis(500);
		try {
			Assert.assertFalse(testContext.getBatchPage().isAddBatchPopupWindowVisible());
		} catch (NoSuchElementException e) {
		}
	}

	@When("Admin clicks on the close icon on batch page")
	public void admin_clicks_on_the_close_icon_on_batch_page() {
		testContext.getBatchPage().clickAddBatchCloseIcon();
	}

	@Then("The batch details pop up closes")
	public void the_batch_details_pop_up_closes() {
		waitForMillis(500);
		try {
			Assert.assertFalse(testContext.getBatchPage().isAddBatchPopupWindowVisible());
		} catch (NoSuchElementException e) {
		}
	}

	@When("Admin clicks the edit icon on batch page")
	public void admin_clicks_the_edit_icon_on_batch_page() {
		testContext.getBatchPage().clickFirstRowEditIcon();

	}

	@Then("Admin should see Program name value field is disabled for editing on batch page")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing_on_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isEditBatchProgramNameDisabledForEditing());
	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		Assert.assertTrue(testContext.getBatchPage().isEditBatchNamePrefixDisabledForEditing());
	}


	@When("Admin enters the valid edit data to all the mandatory fields and click save button on batch page")
	public void admin_enters_the_valid_edit_data_to_all_the_mandatory_fields_and_click_save_button_on_batch_page() {
		testContext.getBatchPage().enterTextInBatchDescription("Test batch all fields");
		testContext.getBatchPage().setBatchActiveStatus(true);
		testContext.getBatchPage().clickAddBatchSaveButton();
	}

	@When("Admin enters the valid edit data to all the mandatory fields and click cancel button on batch page")
	public void admin_enters_the_valid_edit_data_to_all_the_mandatory_fields_and_click_cancel_button_on_batch_page() {
		testContext.getBatchPage().enterTextInBatchDescription("Test batch all fields");
		testContext.getBatchPage().setBatchActiveStatus(true);
		testContext.getBatchPage().clickAddBatchCancelButton();
	}

	@When("Admin Updates any fields with invalid data and click save button on batch page")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button_on_batch_page() {
		testContext.getBatchPage().clearTextInBatchDescription();
		testContext.getBatchPage().enterTextInBatchDescription("a");
		testContext.getBatchPage().clickAddBatchSaveButton();
		String error = testContext.getBatchPage().getBatchDescriptionError();
		Assert.assertEquals(error, "This field should start with an alphabet and min 2 character.");
	}

	@Then("Admin should get a successful message for editing the batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch() {
		String text = testContext.getBatchPage().getAddBatchSaveMessage();
		Assert.assertEquals(text, "batch Updated");
	}

	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		waitForMillis(500);
		try {
			Assert.assertFalse(testContext.getBatchPage().isAddBatchPopupWindowVisible());
		} catch (NoSuchElementException e) {
		}
	}

	@When("Admin clicks the delete Icon on any row on batch page")
	public void admin_clicks_the_delete_icon_on_any_row_on_batch_page() {
		testContext.getBatchPage().clickFirstRowDeleteIcon();
	}

	@Then("Admin should see the confirm alert box with yes and no button on batch page")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button_on_batch_page() {
		testContext.getBatchPage().isDeleteBatchPopupWindowVisible();
		testContext.getBatchPage().isDeleteBatchPopupButtonsVisible();
	}

	@Given("Admin clicks yes button on the confirm alert box")
	public void admin_clicks_yes_button_on_confirm_popup_page() {
		testContext.getBatchPage().clickBatchPopupYesButton();
	}

	@Given("Admin clicks no button on the confirm alert box")
	public void admin_clicks_no_button_on_confirm_popup_page() {
		testContext.getBatchPage().clickBatchPopupNoButton();
	}

	@Then("Admin should see the successful message and the batch should be deleted")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() {
		String text = testContext.getBatchPage().getAddBatchSaveMessage();
		Assert.assertEquals(text, "batch Deleted");	
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		waitForMillis(500);
		try {
			Assert.assertFalse(testContext.getBatchPage().isDeleteBatchPopupWindowVisible());
		} catch (NoSuchElementException e) {
		}
	}

	@When("Admin clicks on the close icon on confirm alert box")
	public void admin_clicks_on_the_close_icon_on_confirm_alert_box() {
		testContext.getBatchPage().clickConfirmAlertCloseIcon();
	}

	@Then("Admin should see the alert box closed on batch page")
	public void admin_should_see_the_alert_box_closed_on_batch_page() {
		waitForMillis(500);
		try {
			Assert.assertFalse(testContext.getBatchPage().isDeleteBatchPopupWindowVisible());
		} catch (NoSuchElementException e) {
		}
	}
	
	@When("Admin selects one row on batch page")
	public void admin_selects_one_row_on_batch_page() {
		testContext.getBatchPage().clickFirstRowCheckbox();
	}
	
	@When("Admin selects two rows on batch page")
	public void admin_selects_two_rows_on_batch_page() {
		testContext.getBatchPage().clickFirstRowCheckbox();
		testContext.getBatchPage().clickSecondRowCheckbox();
	}
	
	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
		testContext.getBatchPage().clickDeleteButton();
	}

	@Then("The respective row in the table should be deleted on batch page")
	public void the_respective_row_in_the_table_should_be_deleted_on_batch_page() {
		String text = testContext.getBatchPage().getAddBatchSaveMessage();
		Assert.assertEquals(text, "Batches Deleted");	
	}

	@Then("The respective rows in the table should be deleted on batch page")
	public void the_respective_rows_in_the_table_should_be_deleted_on_batch_page() {
		String text = testContext.getBatchPage().getAddBatchSaveMessage();
		Assert.assertEquals(text, "Batches Deleted");	
	}

	@When("Admin clicks next page link on the data table on batch page")
	public void admin_clicks_next_page_link_on_the_data_table_on_batch_page() {
		testContext.getBatchPage().clickPaginationNextIcon();
	}

	@Then("Admin should see the Next enabled link on batch page")
	public void admin_should_see_the_next_enabled_link_on_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isPaginationSecondPageIconHighlighted());
	}

	@When("Admin clicks last page link on the data table on batch page")
	public void admin_clicks_last_page_link_on_the_data_table_on_batch_page() {
		testContext.getBatchPage().clickPaginationLastIcon();
	}

	@Then("Admin should see the last page link with next page link disabled on the table on batch page")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table_on_batch_page() {
		Assert.assertTrue(testContext.getBatchPage().isPaginationLastPageIconDisabled());
	}

	@When("Admin clicks previous page link on the data table on batch page")
	public void admin_clicks_previous_page_link_on_the_data_table_on_batch_page() {
		testContext.getBatchPage().clickPaginationPreviousIcon();
	}

	@Then("Admin should see the previous page on the table on batch page")
	public void admin_should_see_the_previous_page_on_the_table_on_batch_page() {
		testContext.getBatchPage().isPaginationFirstPageIconHighlighted();
	}

	@When("Admin clicks first page link on the data table on batch page")
	public void admin_clicks_first_page_link_on_the_data_table_on_batch_page() {
		testContext.getBatchPage().clickPaginationFirstPageIcon();
	}

	@When("Admin clicks second page link on the data table on batch page")
	public void admin_clicks_second_page_link_on_the_data_table_on_batch_page() {
		testContext.getBatchPage().clickPaginationSecondPageIcon();
	}

	@Then("Admin should see the very first page on the data table on batch page")
	public void admin_should_see_the_very_first_page_on_the_data_table_on_batch_page() {
		testContext.getBatchPage().isPaginationFirstPageIconHighlighted();
	}

	@When("Admin enters the batch name in the search text box")
	public void admin_enters_the_batch_name_in_the_search_text_box() {
		testContext.getBatchPage().enterTextInSearchBox("test");
		
	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
		testContext.getBatchPage().getFirstRowBatchName().contains("test");
		
	}

	@When("Admin clicks on the logout button on batch page")
	public void admin_clicks_on_the_logout_button_on_batch_page() throws InterruptedException {
		testContext.getBatchPage().clickLogoutButton();
	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() throws InterruptedException {
		waitForMillis(500);
		Properties prop = testContext.getConfigReader().initProperties();
		
		String expectedUrl = prop.getProperty("loginUrl");
		String actualUrl = testContext.getHelper().getPageUrl();
         
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	private void waitForMillis(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
		}
	}
}