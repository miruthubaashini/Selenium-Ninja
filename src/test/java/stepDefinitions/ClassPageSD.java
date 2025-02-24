package stepDefinitions;

import java.io.IOException;
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

	public ClassPageSD(TestContext testContext) {
		this.testContext = testContext;
	}

	@When("Admin clicks the Class link on navigation bar on Home page")
	public void admin_clicks_the_class_link_on_navigation_bar_on_home_page() {
		testContext.getBasePage().clickClass();
	}

	@Then("Admin lands on Manage Class page")
	public void admin_lands_on_manage_class_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedClassUrl = prop.getProperty("classUrl");
		String actualClassURL = testContext.getHelper().getPageUrl();

		Assert.assertEquals(actualClassURL, expectedClassUrl);
	}

	@Then("Admin sees the {string} title on Manage Class page")
	public void admin_sees_the_title_on_manage_class_page(String title) {

		Assert.assertTrue(testContext.getBasePage().getPortalTitle(title));
	}

	@Then("Admin sees the {string} header on Manage Class page")
	public void admin_sees_the_header_on_manage_class_page(String header) {

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
		testContext.getBasePage().clickClass();
	}

	@When("Admin clicks Add New Class from the Class dropdown")
	public void admin_clicks_add_new_class_from_the_class_dropdown() {
		testContext.getClassPage().clickAddNewClassButton();
	}

	@Then("Admin sees the Class Details popup with SAVE and CANCEL button and Close\\(X) Icon")
	public void admin_sees_the_class_details_popup_with_save_and_cancel_button_and_close_x_icon() {
		softAssert.assertTrue(testContext.getClassPage().isClassDetailsPopupDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isSaveButtonDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isCancelButtonDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isCloseIconDisplayed());
	}

	@Then("Admin sees few input fields and their respective text boxes in the Class Details form")
	public void admin_sees_few_input_fields_and_their_respective_text_boxes_in_the_class_details_form(
			DataTable dataTable) {
		List<String> inputFieldNames = dataTable.asList(String.class);
		for (String inputField : inputFieldNames) {
			softAssert.assertTrue(testContext.getClassPage().isInputFieldLabelPresent(inputField));
			softAssert.assertTrue(testContext.getClassPage().isInputFieldPresent(inputField));
		}

	}

	@Given("Admin is on the Class Details Popup window")
	public void admin_is_on_the_class_details_popup_window() {
		testContext.getBasePage().clickClass();
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

		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);
	}

	@When("admin clicks on Save button")
	public void admin_clicks_on_save_button() {
		testContext.getClassPage().clickSaveButton();
	}

	@Then("Admin gets the message {string} on Manage Class page")
	public void admin_gets_the_message_on_manage_class_page(String expectedToastMessage) {
		Assert.assertEquals(testContext.getClassPage().getSuccessToastMessage(), expectedToastMessage);
	}

	@When("Admin selects class dates in date picker")
	public void admin_selects_class_dates_in_date_picker(DataTable dataTable) {
		classDatesList = dataTable.asList(String.class);
		for (String classDate : classDatesList) {
			testContext.getClassPage().selectClassDates(classDate);
		}

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("document.body.click();");
	}

	@Then("Admin sees the No of Classes value is added automatically")
	public void admin_sees_the_no_of_classes_value_is_added_automatically() {
		Assert.assertTrue(testContext.getClassPage().isNoOfClassesPopulated());
	}

	@When("Admin clicks date picker")
	public void admin_clicks_date_picker() {

	}

	@Then("Admin sees weekends dates are disabled in the calender")
	public void admin_sees_weekends_dates_are_disabled_in_the_calender() {

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

		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);
	}

	@Then("Admin sees error messages below each mandatory fields")
	public void admin_sees_error_messages_below_each_mandatory_fields() {
		softAssert.assertTrue(testContext.getClassPage().isBatchNameFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isClassTopicFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isClassDatesFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isNoOfClassesFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isStaffNameFieldErrorMessageDisplayed());
		softAssert.assertTrue(testContext.getClassPage().isStatusFieldErrorMessageDisplayed());

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

		testContext.getClassPage().fillClassDetailsForm(batchname, classtopic, classdescription, classdates, staffname,
				classstatus, classcomments, classnotes, recordingpath);

	}

	@Then("Admin sees error messages below each fields")
	public void admin_sees_error_messages_below_each_field() {
		Assert.fail();
	}

	@When("Admin clicks Cancel button on Class Details form")
	public void admin_clicks_cancel_button_on_class_details_form() {
		testContext.getClassPage().clickCancelButton();
	}

	@Then("Admin sees the Class Details popup window getting closed")
	public void admin_sees_the_class_details_popup_window_getting_closed() {
		System.out.println(
				"-----------------Is dialog box closed? " + testContext.getClassPage().isClassDetailsDialogClosed());
		Assert.assertTrue(testContext.getClassPage().isClassDetailsDialogClosed());
	}

	@When("Admin clicks Close\\(X) button on Class Details form")
	public void admin_clicks_close_x_button_on_class_details_form() {
		testContext.getClassPage().clickCloseIcon();
	}

	@When("Admin enters the values for input fields on Class Details form")
	public void admin_enters_the_values_for_input_fields_on_class_details_form() {

	}

	@When("Admin clicks Save button on Class Details form")
	public void admin_clicks_save_button_on_class_details_form() {

	}

	@Then("Admin sees success message and new class is added to the data table")
	public void admin_sees_success_message_and_new_class_is_added_to_the_data_table() {

	}

}
