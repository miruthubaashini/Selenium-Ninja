package stepDefinitions;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.java.en.*;

public class BatchPageSD {

	TestContext testContext;

	public BatchPageSD(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("Admin successfully Logged on to the LMS Portal")
	public void admin_successfully_logged_on_to_the_lms_portal() {
		Properties prop = testContext.getConfigReader().initProperties();
		String userName = prop.getProperty("username");
		String passWord = prop.getProperty("password");
		String userRole = prop.getProperty("role");

//		testContext.getBasePage().enterUsername(userName);
//		testContext.getBasePage().enterPassword(passWord);
//		testContext.getBasePage().clickRoleDD();
//		testContext.getBasePage().selectUserRole(userRole);
//		
//		testContext.getBasePage().clickLoginbtn();
//		waitUntilElementIsClickable("//div[contains(text(), \"Dashboard\")]");
	}

	@Given("Admin is on the Batch page")
	public void admin_is_on_the_batch_page() {
		admin_should_be_in_the_manage_batch_page();
	}

	@Given("Admin is on the Home page")
	public void admin_is_on_the_home_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("homeUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl);
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		testContext.getBatchPage().clickBatchMenuLink();
		waitUntilElementIsClickable("//div[contains(text(), \"Manage Batch\")]");
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
		Assert.assertTrue(testContext.getBatchPage().isPaginationFirstButtonDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isPaginationPreviousButtonDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isPaginationNextButtonDisplayed());
		Assert.assertTrue(testContext.getBatchPage().isPaginationLastButtonDisplayed());
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

	@Given("Admin is on batch page")
	public void admin_is_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("Admin is on the Batch Details Pop Up Window")
	public void admin_is_on_the_batch_details_pop_up_window() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin checks all the fields are enabled in batch pop up window")
	public void admin_checks_all_the_fields_are_enabled_in_batch_pop_up_window() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box, Program Name as drop downStatus as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin selects program name present in the dropdown	of batch pop up window")
	public void admin_selects_program_name_present_in_the_dropdown_of_batch_pop_up_window() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin enters alphabets in batch name suffix box")
	public void admin_enters_alphabets_in_batch_name_suffix_box() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should get error message below the text box of respective field on batch page")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin enters alphabets in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see empty text box on batch page")
	public void admin_should_see_empty_text_box_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin enters the data only to the mandatory fields and clicks save button on batch page")
	public void admin_enters_the_data_only_to_the_mandatory_fields_and_clicks_save_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should get a successful message on batch page")
	public void admin_should_get_a_successful_message_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin leaves blank one of the mandatory fields	on batch page")
	public void admin_leaves_blank_one_of_the_mandatory_fields_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should get a error message on the respective mandatory field on batch page")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin enters the valid data to all the mandatory fields and click save button on batch page")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button on batch page")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin can see the batch details popup closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks on the close icon on batch page")
	public void admin_clicks_on_the_close_icon_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("The batch details pop up closes")
	public void the_batch_details_pop_up_closes() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks the edit icon on batch page")
	public void admin_clicks_the_edit_icon_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see Program name value field is disabled for editing on batch page")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_batch_details_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin Updates any fields with invalid data and click save button on batch page")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should get a error message under the respective field on batch page")
	public void admin_should_get_a_error_message_under_the_respective_field_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should get a successful message for editing the batch")
	public void admin_should_get_a_successful_message_for_editing_the_batch() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks the delete Icon on any row on batch page")
	public void admin_clicks_the_delete_icon_on_any_row_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the confirm alert box with yes and no button on batch page")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("Admin is on the batch confirm popup page")
	public void admin_is_on_the_batch_confirm_popup_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks on the delete icon and click yes button on batch page")
	public void admin_clicks_on_the_delete_icon_and_click_yes_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the successful message and the batch should be deleted")
	public void admin_should_see_the_successful_message_and_the_batch_should_be_deleted() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks on the delete icon and click no button on batch page")
	public void admin_clicks_on_the_delete_icon_and_click_no_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the alert box closed on batch page")
	public void admin_should_see_the_alert_box_closed_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("The respective row in the table should be deleted on batch page")
	public void the_respective_row_in_the_table_should_be_deleted_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks next page link on the data table on batch page")
	public void admin_clicks_next_page_link_on_the_data_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the Next enabled link on batch page")
	public void admin_should_see_the_next_enabled_link_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks last page link on the data table	on batch page")
	public void admin_clicks_last_page_link_on_the_data_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the last page link with next page link disabled on the table on batch page")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks previous page link on the data table	on batch page")
	public void admin_clicks_previous_page_link_on_the_data_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the previous page on the table on batch page")
	public void admin_should_see_the_previous_page_on_the_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks first page link on the data table on batch page")
	public void admin_clicks_first_page_link_on_the_data_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the very first page on the data table on batch page")
	public void admin_should_see_the_very_first_page_on_the_data_table_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin enters the batch name in the search text box")
	public void admin_enters_the_batch_name_in_the_search_text_box() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the filtered batches in the data table")
	public void admin_should_see_the_filtered_batches_in_the_data_table() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("Admin clicks on the logout button	on batch page")
	public void admin_clicks_on_the_logout_button_on_batch_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("Admin should see the Login screen Page")
	public void admin_should_see_the_login_screen_page() {
		// Write code here that turns the phrase above into concrete actions

	}
	
	private WebElement waitUntilElementIsClickable(String xpath) {
		WebDriverWait wait = new WebDriverWait(testContext.getDriverManager().getDriver(), Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); 
	}

}
