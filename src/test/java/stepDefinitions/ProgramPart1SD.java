package stepDefinitions;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dependencyInjection.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPart1SD {
	
	
	TestContext testContext;
	private SoftAssert softAssert = new SoftAssert();
	
	private String programname;
	private String programdescription;
	

	public ProgramPart1SD (TestContext testContext) {
		this.testContext = testContext;
	}
	
	
	@When("Admin click Program in bar menu")
	public void admin_click_program_in_bar_menu() {
	    
		testContext.getProgramPart1Page().clickOnProgram();
	    
	}

	@Then("Admim should be on Manage Program page")
	public void admim_should_be_on_manage_program_page() {
		
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedProgramsUrl = prop.getProperty("programUrl");
		String actualurl = testContext.getHelper().getPageUrl();
		Assert.assertEquals(actualurl, expectedProgramsUrl);  
	}

	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
	    
		boolean logOutText = testContext.getProgramPart1Page().logOut();
		assertTrue(logOutText, "Logout Bitton is not Displayed");   
		
	}

	@Then("Admin should see data table with page names in order Home,Program,Batch,Class on Mange program page")
	public void admin_should_see_data_table_with_page_names_in_order_home_program_batch_class_on_mange_program_page(DataTable dataTable) {
		
		List<String> columnHeaders = dataTable.asList(String.class);
		List<String> headings =testContext.getProgramPart1Page().pageHeading();  
		Assert.assertEquals(columnHeaders, headings);  
		
		
	}
	
	@Then("Admin sees the {string} header on Manage Program page")
	public void admin_sees_the_header_on_manage_Program_page(String header) {
	    
		Assert.assertTrue(testContext.getProgramPart1Page().manageProgram(header));	
	}
	
	
	@When("Admin clicks on Program option in menu bar")
	public void admin_clicks_on_program_option_in_menu_bar() {
		
		testContext.getProgramPart1Page().clickOnProgramOption();
	    
	}

	@Then("Admin should see sub menu in menu bar as Add New Program in Program page")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_program_in_program_page() {
		
		boolean text = testContext.getProgramPart1Page().addProgramIsDisplayed();
		assertTrue(text, "add new program is not Displayed");
	    
	}

	@Then("Admin should see a Delete button in left top is disabled in Manage Program")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled_in_manage_program() {
	    
		boolean status = testContext.getProgramPart1Page().deleteIconDisabled();
	    Assert.assertTrue(status, "Delete button is not enabled.");
	}
	

	@Then("Admin should see Search bar with text as Search in Program page")
	public void admin_should_see_search_bar_with_text_as_search_in_program_page() {
		
		Assert.assertTrue(testContext.getProgramPart1Page().searchBox(), "search bar in not available.");
		
	
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name on Manage Program")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_on_manage_program() {
		
		Assert.assertTrue(testContext.getProgramPart1Page().checkBoxStatus(), "Checkbox is not unchecked by default!");   
	}

	@Then("Admin should see the following sort icon beside to each header except Edit and Delete on Manage Program")
	public void admin_should_see_the_following_sort_icon_beside_to_each_header_except_edit_and_delete_on_manage_program(DataTable dataTable) {
	    
		List<String> columnHeaders = dataTable.asList(String.class);
		for (String columnHeader: columnHeaders) {
			softAssert.assertTrue(testContext.getProgramPart1Page().sortArrowForEachHeader(columnHeader).isDisplayed());
		}
	    
	}

	@Then("Admin should see the Edit buttons on each row of the data table on Manage Program")
	public void admin_should_see_the_edit_buttons_on_each_row_of_the_data_table_on_manage_program() {
	    
		Assert.assertTrue(testContext.getProgramPart1Page().editButtons(), "Edit button is not displayed" );
	}
	
	@Then("Admin should see the delete buttons on each row of the data table on Manage Program")
	public void admin_should_see_the_delete_buttons_on_each_row_of_the_data_table_on_manage_program() {
	
		Assert.assertTrue(testContext.getProgramPart1Page().deleteButtons(), "Delete button is not displayed");
	}


	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		
		testContext.getProgramPart1Page().clickOnProgram();
		testContext.getProgramPart1Page().addNewPgrmClick();
	}
	
	@Then("Admin sees the {string} on Program page")
	public void admin_sees_the_on_program_page(String footerText) {
		
		Assert.assertTrue(testContext.getProgramPart1Page().footerMessage(footerText));
	}

	@Then("Admin should see pop up of add new program")
	public void admin_should_see_pop_up_of_add_new_program() {
	   
		Assert.assertTrue(testContext.getProgramPart1Page().addNewProgramVisible(), "Pop up window does not appear");
	}
	
	@Given("Admin is on program page")
	public void admin_is_on_program_page() {
		
		testContext.getProgramPart1Page().clickOnProgram();
	}
	
	@When("Admin clicks on Add New Program under the Program menu bar")
	public void admin_clicks_on_add_new_program_under_the_program_menu_bar() {
		
		testContext.getProgramPart1Page().addNewPgrmClick();
	}

	@Then("Admin should see window title as {string} in program")
	public void admin_should_see_window_title_as_in_program(String string) {
		
		Assert.assertTrue(testContext.getProgramPart1Page().programDetailsTitleOnPopup(string),"Program details title is not correct");
	   
	    
	}
	
	@Then("Admin gets error message")
	public void admin_gets_error_message() {
	   
		Assert.assertTrue(testContext.getProgramPart1Page().errorMessage(),"Error message not displayed");
		
	}

	@Then("Admin should see red asterisk mark beside mandatory field {string}")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {
	
		Assert.assertTrue(testContext.getProgramPart1Page().asteriskPresence(),"Error message not displayed");
	    
	}
	
	@When("Admin clicks save button without entering mandatory field in program module")
	public void admin_clicks_save_button_without_entering_mandatory_field_in_program_module() throws InterruptedException {
	   
		testContext.getProgramPart1Page().clickOnSaveButton();
	}


	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
	   
		testContext.getProgramPart1Page().clickCancelButton();
	    
	}

	@Then("Admin can see program details form disappears")
	public void admin_can_see_program_details_form_disappears() {
		
		Assert.assertTrue(testContext.getProgramPart1Page().isPopupWindowClosed(), "Pop up window form is not closed");
	}
	

	@When("Admin enters the Name in the text box on form from from {string} and {int}")
	public void admin_enters_the_name_in_the_text_box_on_form_from_from_and(String sheetName, Integer rowNum) throws IOException {
	   
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		
		programname =data.get("programName");
		testContext.getProgramPart1Page().enterName(programname);
		
	}

	@Then("Admin can see the text entered in the program name field")
	public void admin_can_see_the_text_entered_in_the_program_name_field() {
		
		Assert.assertTrue(testContext.getProgramPart1Page().enteredNameVerify(),"Text is not entered");

	}
	
	@When("Admin enters the Description in text box on form from from {string} and {int}")
	public void admin_enters_the_description_in_text_box_on_form_from_from_and(String sheetName, Integer rowNum) throws IOException {
		
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		
		programdescription=data.get("description");
		
		testContext.getProgramPart1Page().enterDescription(programdescription);
	    
	}

	@Then("Admin can see the text entered in description box on form")
	public void admin_can_see_the_text_entered_in_description_box_on_form() {
	   
	    
	}

	@When("Admin selects the {string} of the program by clicking on the radio button Active\\/InActive on Program page")
	public void admin_selects_the_of_the_program_by_clicking_on_the_radio_button_active_in_active_on_program_page(String status) {
	   
		//testContext.getProgramPart1Page().activeRadioBtn();
		//testContext.getProgramPart1Page().inactiveRadioBtn();
		
		testContext.getProgramPart1Page().radioButton(status);
	}
	

	@Then("Admin can see {string} selected on Program page")
	public void admin_can_see_selected_on_program_page(String status) {
		
		Assert.assertTrue(testContext.getProgramPart1Page().isRadioButtonSelected(status), "Passed status buttons were not selected");
		
	}

	@Given("Admin enter valid details for mandatory from {string} and {int} fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_from_and_fields_and_click_on_save_button(String sheetName, Integer rowNum) throws IOException, InterruptedException {
	   
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		
		programname =data.get("programName");
		programdescription=data.get("description");
		
		testContext.getProgramPart1Page().fillProgramDetails(programname, programdescription); 
		
		testContext.getProgramPart1Page().radioClick("Active");
		testContext.getProgramPart1Page().clickOnSaveButton();
	}

	@Then("Admin gets message Successful Program created")
	public void admin_gets_message_successful_program_created() {
	   	
		Assert.assertEquals(testContext.getProgramPart1Page().programCreatedMessage(), "Program Created Successfully");
	    
	}

	@When("Admin searches {string} and {int} with newly created Program Name")
	public void admin_searches_and_with_newly_created_program_name(String sheetName, Integer rowNum) throws IOException {
		
		
		LinkedHashMap<String, String> data = testContext.getExcelReader().getTestData(sheetName, rowNum);
		
		programname = data.get("programName");
	   
		testContext.getProgramPart1Page().searchCreatedProgram(programname);
		
	}

	@Then("Records of the newly created Program Name is displayed and match the data entered")
	public void records_of_the_newly_created_program_name_is_displayed_and_match_the_data_entered() {
	   
	   String text = testContext.getProgramPart1Page().createdProgramDisplayed();
	   Assert.assertTrue(text.contains("class"), "Program doesnt match");
	   
	}
	

	@When("Admin Click on {string} button on form")
	public void admin_click_on_button_on_form(String string) {
		
		testContext.getProgramPart1Page().closeWindowByx();  
	}
	
	
}
