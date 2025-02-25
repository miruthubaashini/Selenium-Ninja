package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dependencyInjection.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import webDriverManager.DriverManager;

public class ClassPageSD {

	TestContext testContext;
	private SoftAssert softAssert = new SoftAssert();
	private Properties prop;
	private String batchname;
	private String classtopic;
	private String classdescription;
	private String classdates;
	private String staffname;
	private String classstatus;
	private String classcomments;
	private String classnotes;
	private String recordingpath;
	private List<String> classDatesList;
	private String classTopicToBeDeleted;
	private List<String> classTopicsToBeDeleted;
	private String searchText;

	public ClassPageSD(TestContext testContext) {
		this.testContext = testContext;
	}

	@When("Admin clicks the Class link on navigation bar on Home page")
	public void admin_clicks_the_class_link_on_navigation_bar_on_home_page() {
		testContext.getLogger().info("Admin clicks the Class link");
		testContext.getClassPage().clickClassLink();
	}

	@Then("Admin is redirected to Manage Class page")
	public void admin_lands_on_manage_class_page() {
		prop = testContext.getConfigReader().initProperties();
		String expectedClassUrl = prop.getProperty("classUrl");
		String actualClassURL = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualClassURL, expectedClassUrl);
		testContext.getLogger().info("Admin is on Manage Class page");
	}

	@Then("Admin sees the {string} title on Manage Class page")
	public void admin_sees_the_title_on_manage_class_page(String title) {
		testContext.getLogger().info("Admin should see page titile");
		Assert.assertTrue(testContext.getBasePage().getPortalTitle(title));
	}

	@Then("Admin sees the {string} header on Manage Class page")
	public void admin_sees_the_header_on_manage_class_page(String header) {
		testContext.getLogger().info("Admin should see the header of class page");
		Assert.assertTrue(testContext.getClassPage().getClassHeader(header));
	}

	@Then("Admin sees the Search bar on Manage Class page")
	public void admin_sees_the_search_bar_on_manage_class_page() {
		Assert.assertTrue(testContext.getClassPage().classSearchBox().isDisplayed());
	}

	@Then("Admin sees the following data table headings on the Manage Class page:")
	public void admin_sees_the_following_data_table_headings(DataTable dataTable) {
		List<String> columnHeaders = dataTable.asList(String.class);
		List<String> actualColumnHeaders = testContext.getClassPage().getDatatableHeaders();

		Assert.assertEquals(actualColumnHeaders, columnHeaders);
	}

	@Then("Admin sees the text {string} below the data table on Manage Class page")
	public void admin_sees_the_text_below_the_data_table(String paginationText) {
		Assert.assertTrue(testContext.getClassPage().checkPaginationTextMatches(paginationText));
	}

	@Then("admin sees the pagination controls below the data table on Manage Class page")
	public void admin_sees_the_pagination_controls_below_the_data_table() {
		softAssert.assertTrue(testContext.getClassPage().isPaginationFirstButtonVisible());
		softAssert.assertTrue(testContext.getClassPage().isPaginationPreviousButtonVisible());
		softAssert.assertTrue(testContext.getClassPage().isPaginationNextButtonVisible());
		softAssert.assertTrue(testContext.getClassPage().isPaginationLastButtonVisible());
		softAssert.assertTrue(testContext.getClassPage().isPaginationPagesButtonAvailable());
		softAssert.assertAll();
	}

	@Then("Admin sees the sort icon for the following data table headings on the Manage Class page:")
	public void admin_sees_the_sort_icon_for_the_following_data_table_headings(DataTable dataTable) {
		List<String> columnHeaders = dataTable.asList(String.class);
		for (String columnHeader : columnHeaders) {
			softAssert.assertTrue(testContext.getClassPage().checkSortIcon(columnHeader).isDisplayed());
		}
	}

	@Then("Admin sees the Delete button on Manage Class page")
	public void admin_sees_the_delete_button_on_manage_class_page() {
		Assert.assertTrue(testContext.getClassPage().isDeleteButtonVisible());
	}

	@Then("Admin sees the {string} on Manage Class page")
	public void admin_sees_the_on_manage_class_page(String footerText) {
		Assert.assertTrue(testContext.getClassPage().checkFooterTextMatches(footerText));

	}

	// ---------------Add new class test cases-------------

	@Given("Admin is on Manage Class page")
	public void admin_is_on_manage_class_page() {
		testContext.getLogger().info("User is on Manage Class page");
		testContext.getClassPage().clickClassLink();
	}

	@When("Admin clicks Add New Class from the Class dropdown")
	public void admin_clicks_add_new_class_from_the_class_dropdown() {
		testContext.getLogger().info("User clicks Add New Class link");
		testContext.getClassPage().clickAddNewClassButton();
	}

	@Then("Admin sees the Class Details popup with SAVE and CANCEL button and Close\\(X) Icon")
	public void admin_sees_the_class_details_popup_with_save_and_cancel_button_and_close_x_icon() {
		testContext.getLogger().info("User is on Class Details popup");
		softAssert.assertTrue(testContext.getClassPage().isClassDetailsPopupDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isSaveButtonDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isCancelButtonDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isCloseIconDisplayed());
		softAssert.assertAll();
	}

	@Then("Admin sees few input fields and their respective text boxes in the Class Details form")
	public void admin_sees_few_input_fields_and_their_respective_text_boxes_in_the_class_details_form(
			DataTable dataTable) {
		List<String> inputFieldNames = dataTable.asList(String.class);
		for (String inputField : inputFieldNames) {
			softAssert.assertTrue(testContext.getClassPage().isInputFieldLabelPresent(inputField));
			softAssert.assertTrue(testContext.getClassPage().isInputFieldPresent(inputField));
			softAssert.assertAll();
		}

	}

	@Given("Admin is on the Class Details Popup window")
	public void admin_is_on_the_class_details_popup_window() {
		testContext.getLogger().info("User is on Class Details popup");
		testContext.getClassPage().clickClassLink();
		testContext.getClassPage().clickAddNewClassButton();
	}

	@When("Admin enters mandatory fields in the Class Details form from {string} and {int}")
	public void admin_enters_mandatory_fields_in_the_class_details_form_from_and(String sheetName, int rowNum)
			throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		batchname = data.get("batchName");
		classtopic = data.get("classTopic");
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getLogger().info("Admin enters mandatory fields in the form");
		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);
	}

	@When("admin clicks on Save button on Class Details popup")
	public void admin_clicks_on_save_button() {
		testContext.getLogger().info("Admin clicks Save button");
		testContext.getClassPage().clickSaveButton();
	}

	@Then("Admin gets the message {string} on Manage Class page")
	public void admin_gets_the_message_on_manage_class_page(String expectedToastMessage) {
		testContext.getLogger().info("Admin gets Class Created success message");
		Assert.assertEquals(testContext.getClassPage().getSuccessToastMessage(), expectedToastMessage);
	}

	@When("Admin selects class dates in date picker")
	public void admin_selects_class_dates_in_date_picker(DataTable dataTable) {
		testContext.getLogger().info("Admin selects class dates on date picker");
		classDatesList = dataTable.asList(String.class);
		for (String classDate : classDatesList) {
			testContext.getClassPage().selectClassDates(classDate);
		}

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("document.body.click();");
	}

	@Then("Admin sees the No of Classes value is added automatically")
	public void admin_sees_the_no_of_classes_value_is_added_automatically() {
		testContext.getLogger().info("Admin should see No. of classes auto-populated");
		Assert.assertTrue(testContext.getClassPage().isNoOfClassesPopulated());
	}

	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() {
		testContext.getLogger().info("Admin clicks date picker");
		testContext.getClassPage().clickDatePicker();
	}

	@Then("Admin sees weekends dates are disabled in the calender")
	public void admin_sees_weekends_dates_are_disabled_in_the_calender() {
		testContext.getLogger().info("Admin sees weekend dates are disabled");
		Assert.assertTrue(testContext.getClassPage().isCalenderWeekendDatesDisabled());
	}

	@When("Admin enters only optional fields in the Class Details form from {string} and {int}")
	public void admin_enters_only_optional_fields_in_the_class_details_form_from_and(String sheetName, Integer rowNum)
			throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		batchname = data.get("batchName");
		classtopic = data.get("classTopic");
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");
		
		testContext.getLogger().info("Admin enters only optional fields in class form");
		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);
	}

	@Then("Admin sees error messages below each mandatory fields")
	public void admin_sees_error_messages_below_each_mandatory_fields() {
		testContext.getLogger().info("Admin sees error messages for mandatory fields in the class form");
		softAssert.assertTrue(testContext.getClassPage().isBatchNameFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isClassTopicFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isClassDatesFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isNoOfClassesFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isStaffNameFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isStatusFieldErrorMessageDisplayed());
		softAssert.assertAll();
	}

	@When("Admin enters invalid data in all the fields in the Class Details form from {string} and {int}")
	public void admin_enters_invalid_data_in_all_the_fields_in_the_class_details_form_from_and(String sheetName,
			int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		batchname = data.get("batchName");
		classtopic = data.get("classTopic");
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getLogger().info("Admin enters invalid data in all the fields");
		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);

	}

	@Then("Admin sees error messages below each fields")
	public void admin_sees_error_messages_below_each_field() {
		Assert.fail();
	}

	@When("Admin clicks Cancel button on Class Details form")
	public void admin_clicks_cancel_button_on_class_details_form() {
		testContext.getLogger().info("Admin clicks Cancel button");
		testContext.getClassPage().clickCancelButton();
	}

	@Then("Admin sees the Class Details popup window getting closed")
	public void admin_sees_the_class_details_popup_window_getting_closed() {
		Assert.assertTrue(testContext.getClassPage().isClassDetailsDialogClosed());
	}

	@When("Admin clicks Close\\(X) button on Class Details form")
	public void admin_clicks_close_x_button_on_class_details_form() {
		testContext.getClassPage().clickCloseIcon();
	}

	@When("Admin enters the values for input fields on Class Details form from {string} and {int}")
	public void admin_enters_the_values_for_input_fields_on_class_details_form(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		batchname = data.get("batchName");
		classtopic = data.get("classTopic");
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);
	}

	@Then("Admin gets the message {string} and new class is added to the data table")
	public void admin_sees_success_message_and_new_class_is_added_to_the_data_table(String expectedToastMessage) {
		softAssert.assertEquals(testContext.getClassPage().getSuccessToastMessage(), expectedToastMessage);
		softAssert.assertTrue(testContext.getClassPage().isNewClassListedInClassTable(classtopic));
	}

	// ---------------Edit class test cases-------------

	@When("Admin clicks on the edit icon on the Manage Class page")
	public void admin_clicks_on_the_edit_icon_on_the_manage_class_page() {
		testContext.getClassPage().clickEditIcon();
	}

	@Then("Admin sees a pop up with class details displayed")
	public void admin_sees_a_pop_up_with_class_details_displayed() {
		Assert.assertTrue(testContext.getClassPage().isClassDetailsPopupDisplayed());
	}

	@Then("Admin sees that batch Name field is disabled")
	public void admin_sees_that_batch_name_field_is_disabled() {
		Assert.assertTrue(testContext.getClassPage().isBatchNameFieldDisabled());
	}

	@Then("Admin sees that Class Topic field is disabled")
	public void admin_sees_that_class_topic_field_is_disabled() {
		Assert.assertTrue(testContext.getClassPage().isClassTopicFieldDisabled());
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
		testContext.getClassPage().clickClassLink();
		testContext.getClassPage().clickEditIcon();
	}

	@When("Admin updates the fields with valid data from {string} and {int}")
	public void admin_updates_the_fields_with_valid_data(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getClassPage().updateClassDetailsForm(classdescription, classdates, staffname, classstatus,
				classcomments, classnotes, recordingpath);
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String expectedToastMessage) {
		Assert.assertEquals(testContext.getClassPage().getSuccessToastMessage(), expectedToastMessage);
	}

	@When("Admin updates the fields with invalid data from {string} and {int}")
	public void admin_updates_the_fields_with_invalid_data(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getClassPage().updateClassDetailsForm(classdescription, classdates, staffname, classstatus,
				classcomments, classnotes, recordingpath);
	}

	@When("Admin updates the mandatory fields with valid values from {string} and {int}")
	public void admin_updates_the_mandatory_fields_with_valid_values(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getClassPage().updateClassDetailsForm(classdescription, classdates, staffname, classstatus,
				classcomments, classnotes, recordingpath);
	}

	@When("Admin updates the optional fields with valid values from {string} and {int}")
	public void admin_updates_the_optional_fields_with_valid_values(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		classdescription = data.get("classDescription");
		classdates = data.get("classDates");
		staffname = data.get("staffName");
		classstatus = data.get("status");
		classcomments = data.get("comments");
		classnotes = data.get("notes");
		recordingpath = data.get("recording");

		testContext.getClassPage().updateClassDetailsForm(classdescription, classdates, staffname, classstatus,
				classcomments, classnotes, recordingpath);
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		testContext.getClassPage().clickCancelButton();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
		Assert.assertTrue(testContext.getClassPage().isClassDetailsDialogClosed());
	}

	// ---------------Sort class test cases-------------

	@When("Admin clicks on Sort icon next to {string} table header")
	public void admin_clicks_on_sort_icon_next_to_table_header(String columnHeader) {
		testContext.getClassPage().clickSortIcon(columnHeader);
	}

	@Then("Admin sees that class details are sorted by {string}")
	public void admin_sees_that_class_details_are_sorted_by_column_header(String columnHeader) {
		Assert.assertTrue(testContext.getClassPage().checkSortedAscending(columnHeader));
	}

	// ---------------Delete Class test cases-------------

	@When("Admin clicks on the Delete icon on the Manage Class page for Class Topic from {string} and {int}")
	public void admin_clicks_on_the_delete_icon_on_the_manage_class_page(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		classtopic = data.get("classTopic");
		System.out.println("=============classtopic "+ classtopic);
		testContext.getClassPage().clickDeleteIconOnRow(classtopic);
	}

	@Then("Admin gets an alert with heading {string} with Yes and No button")
	public void admin_gets_an_alert_with_heading_with_yes_and_no_button(String deleteConfirmHeader) {
		softAssert.assertTrue(testContext.getClassPage().isDeleteConfirmDialogBoxDisplayed());
		softAssert.assertEquals(testContext.getClassPage().getdeleteConfirmDialogHeader(), deleteConfirmHeader);
		softAssert.assertTrue(testContext.getClassPage().isDeleteConfirmYesButtonDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isDeleteConfirmNoButtonDisplayed());
		softAssert.assertAll();
	}

	@Given("Admin is on delete Confirm dialog box")
	public void admin_is_on_delete_confirm_dialog_box() {
		testContext.getClassPage().clickClassLink();
		classTopicToBeDeleted = testContext.getClassPage().getClassTopicOfToBeDeletedClass();

	}

	@When("Admin clicks on the Yes button on the dialog box")
	public void admin_clicks_on_the_yes_button_on_the_dialog_box() {
		try {
			testContext.getClassPage().clickDeleteConfirmYesButton();
		} catch (Exception e) {
			
		}
	}

	@Then("Admin gets {string} {string} message and do not see that Class in the data table")
	public void admin_gets_message_and_do_not_see_that_class_in_the_data_table(String toastSummary,
			String toastMessage) {

		softAssert.assertEquals(testContext.getClassPage().getSuccessToastMessage(), toastMessage);
		softAssert.assertTrue(testContext.getClassPage().isClassDeleted(classTopicToBeDeleted));
		softAssert.assertAll();
	}

	@When("Admin clicks on the No button on the dialog box")
	public void admin_clicks_on_the_no_button_on_the_dialog_box() {
		try {
			testContext.getClassPage().clickDeleteConfirmNoButton();
		} catch (Exception e) {
			
		}
	}

	@Then("Admin sees the dialog box disappears without deleting the record")
	public void admin_sees_the_dialog_box_disappears_without_deleting_the_record() {
		softAssert.assertFalse(testContext.getClassPage().isDeleteConfirmDialogBoxDisplayed());
	}

	@When("Admin clicks on the Close icon on the dialog box")
	public void admin_clicks_on_the_close_icon_on_the_dialog_box() {
		testContext.getClassPage().clickDeleteConfirmCloseIcon();
	}

	// ---------------Delete Classes from header delete icon test cases-------------

	@When("Admin clicks checkboxs in the data table on the Manage Class page from {string} and {int}")
	public void admin_clicks_any_checkbox_in_the_data_table_on_the_manage_class_page(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		classtopic = data.get("classTopic");
		
		System.out.println("=============classtopic "+ classtopic);
		if (classtopic.contains(",")) {
			classTopicsToBeDeleted= new ArrayList<>(Arrays.asList(classtopic.split(",")));
		}
		else {
            classTopicsToBeDeleted = new ArrayList<>();
            classTopicsToBeDeleted.add(classtopic);
        }		
		System.out.println("============classTopicsToBeDeleted " + classTopicsToBeDeleted);
		testContext.getClassPage().clickCheckboxForClassTopics(classTopicsToBeDeleted);
		
	}

	@Then("Admin sees the common delete button enabled under header Manage Class")
	public void admin_sees_the_common_delete_button_enabled_under_header_manage_class() {
		System.out.println("=============Assertion");
		Assert.assertTrue(testContext.getClassPage().isHeaderDeleteIconEnabled());
	}

	@When("admin clicks Delete button on top of the page")
	public void admin_clicks_delete_button_on_top_of_the_page() {
		testContext.getClassPage().clickHeaderDeleteIcon();
	}

	@Then("Admin lands on Manage Class page and can see the selected class is deleted from the data table")
	public void admin_lands_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
		Assert.assertTrue(testContext.getClassPage().isMultipleClassesDeleted(classTopicsToBeDeleted));
	}

	@Then("Admin lands on Manage Class page and can see the selected class is not deleted from the data table")
	public void admin_lands_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
		//softAssert.assertFalse(testContext.getClassPage().isDeleteConfirmDialogBoxDisplayed());
	
		softAssert.assertFalse(testContext.getClassPage().isMultipleClassesDeleted(classTopicsToBeDeleted));
		
		softAssert.assertAll();
	}


//  ---------------Search Box in Class--------------

	@When("Admin enters a Batch Name in Search textbox from {string} and {int}")
	public void admin_enters_a_batch_name_in_search_textbox(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		searchText = data.get("batchName");
		System.out.println("==========searchText" + searchText);
		testContext.getClassPage().enterSearchText(searchText);
	}

	@Then("Admin sees Class details are searched by {string}")
	public void admin_sees_class_details_are_searched_by_batch_name(String columnName) {
		Assert.assertTrue(testContext.getClassPage().areClassDetailsFilteredByValidSearchText(searchText));
	}

	@When("Admin enters a Class Topic in Search textbox from {string} and {int}")
	public void admin_enters_a_class_topic_in_search_textbox(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		searchText = data.get("classTopic");
		System.out.println("==========searchText" + searchText);

		testContext.getClassPage().enterSearchText(searchText);
	}

	@When("Admin enters a Staff Name in Search textbox from {string} and {int}")
	public void admin_enters_a_staff_name_in_search_textbox(String sheetName, int rowNum) throws IOException {
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		searchText = data.get("staffName");
		System.out.println("==========searchText" + searchText);

		testContext.getClassPage().enterSearchText(searchText);
	}
	
//  ---------------Pagination in Class--------------
	
	@When("Admin clicks the Next page link on the class table")
	public void admin_clicks_the_next_page_link_on_the_class_table() {
		testContext.getClassPage().clickPaginatorNextButton();	    
	}

	@Then("Admin sees the next page record on the class table")
	public void admin_sees_the_next_page_record_on_the_class_table() {
	    if (!testContext.getClassPage().isPaginationNextButtonDisabled()) {
	        Assert.assertTrue(testContext.getClassPage().isNewPageRecordsDisplayed(), "Next page records are not displayed as expected");
	    } else {
	        Assert.assertTrue(testContext.getClassPage().getClassTopics().size() > 0, "There should be records to display on the page");
	        System.out.println("No next page available, as expected.");
	    }	}

	@When("Admin clicks the Last page link on the class table")
	public void admin_clicks_the_last_page_link_on_the_class_table() {
		testContext.getClassPage().clickPaginatorLastButton();	    
	}

	@Then("Admin sees the last page record on the class table with Next page link disabled")
	public void admin_sees_the_last_page_record_on_the_class_table_with_next_page_link_disabled() {
		  if (!testContext.getClassPage().isPaginationLastButtonDisabled()) {
		        softAssert.assertTrue(testContext.getClassPage().isNewPageRecordsDisplayed(), "Next page records are not displayed as expected");
		    } else {
		        softAssert.assertTrue(testContext.getClassPage().getClassTopics().size() > 0, "There should be records to display on the page");
		        System.out.println("No next page available, as expected.");
		    }
			softAssert.assertTrue(testContext.getClassPage().isPaginationNextButtonDisabled());
			softAssert.assertAll();
		  }		


	@When("Admin clicks the Previous page link on the class table")
	public void admin_clicks_the_previous_page_link_on_the_class_table() {
		testContext.getClassPage().clickPaginatorPreviousButton();	    
	}

	@Then("Admin sees the previous page record on the class table")
	public void admin_sees_the_previous_page_record_on_the_class_table() {
		Assert.assertTrue(testContext.getClassPage().isNewPageRecordsDisplayed());	 	    
	}
	
	@When("Admin clicks the First page link on the class table")
	public void admin_clicks_the_first_page_link_on_the_class_table() {
		testContext.getClassPage().clickPaginatorFirstButton();
	}  
	
	@Then("Admin sees the very first page record on the table with Previous page link are disabled")
	public void admin_sees_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		softAssert.assertTrue(testContext.getClassPage().isNewPageRecordsDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isPaginationPreviousButtonDisabled());
		softAssert.assertAll();	    
	}
	
	// ---------------Navigation to other pages from Class page--------------
	
	
	@When("Admin clicks on Batch link on Manage Class page")
	public void admin_clicks_on_batch_link_on_manage_class_page() {
		testContext.getClassPage().clickBatchLink();	    
	}

	@Then("Admin is redirected to Batch page")
	public void admin_is_redirected_to_batch_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("batchUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl);	    
	}

	@When("Admin clicks on Program link on Manage Class page")
	public void admin_clicks_on_program_link_on_manage_class_page() {
		testContext.getClassPage().clickProgramLink();	    
	}

	@Then("Admin is redirected to Program page")
	public void admin_is_redirected_to_program_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("programUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl);    
	    
	}

	@When("Admin clicks on Home link on Manage Class page")
	public void admin_clicks_on_home_link_on_manage_class_page() {
		testContext.getClassPage().clickHomeLink();  
	}

	@Then("Admin is redirected to Home page")
	public void admin_is_redirected_to_home_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("homeUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl);  	    
	}

	@When("Admin clicks on Logout link on Manage Class page")
	public void admin_clicks_on_logout_link_on_manage_class_page() {
		 testContext.getLogoutPage().logoutClick();	    
	}

	@Then("Admin is redirected to Login page")
	public void admin_is_redirected_to_logout_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("loginUrl");
		String actualUrl = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualUrl, expectedUrl); 
	    
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
