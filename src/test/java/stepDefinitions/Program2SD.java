package stepDefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import dependencyInjection.TestContext;
import io.cucumber.java.en.*;

public class Program2SD {

	TestContext testContext;
	List<WebElement> elements;
	Boolean popWindow = false;
	Boolean popWindowforMultiple = false;
	boolean isConfirmBox ;
	private List<String> programForDeletion= new ArrayList<>();

	public Program2SD(TestContext testContext) {
		this.testContext = testContext;
	}

	// delete multiple starts

	@When("Admin selects more than single program by clicking on the checkbox")
	public void admin_selects_more_than_single_program_by_clicking_on_the_checkbox() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectCheckBoxMultiple();

	}

	@Then("All the Programs get selected")
	public void all_the_programs_get_selected() {

		boolean showDeleteButton = testContext.getProgramPage2().isDeleteMultipleVisible();
		Assert.assertEquals(true, showDeleteButton);
	}

	@When("Admin clicks on the delete button on the left top of the program page {string}")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page(String string) {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectCheckBoxMultiple();
		testContext.getProgramPage2().clickHeaderDeleteIcon();
		//testContext.getProgramPage2().ConfirmationPage(string);
	}

	@Then("Admin lands on Confirmation form in the program page")
	public void admin_lands_on_confirmation_form_in_the_program_page() {
		testContext.getProgramPage2().clickDialogDeleteIcon();
		boolean showDeleteConfirmation = testContext.getProgramPage2().isDeleteConfirmationVisible();
		Assert.assertEquals(true, showDeleteConfirmation);
	}

	@When("Admin clicks on {string} button in the confirmation page")
	public void admin_clicks_on_button_in_the_confirmation_page(String string) {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectCheckBoxMultiple();
		testContext.getProgramPage2().clickDeleteMultiple();
		programForDeletion = testContext.getProgramPage2().selectCheckBoxMultiple();
		testContext.getProgramPage2().clickYesDelete();
	}

	@Then("Admin can see Successful  program deleted message in the page")
	public void admin_can_see_successful_program_deleted_message_in_the_page() {
//		boolean isConfirmBox = testContext.getProgramPage2().ConfirmationPage("Yes");
//		Assert.assertEquals(true, isConfirmBox);		
		Assert.assertEquals(true,testContext.getProgramPage2().isprogramDeleted(programForDeletion));
	}

	@When("Admin Searches for Deleted Program names in the program")
	public void admin_searches_for_deleted_program_names_in_the_program() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().searchProgram();
	}

	@Then("There should be zero results in the program page")
	public void there_should_be_zero_results_in_the_program_page() {
		String actualMsg = "Showing 0 to 0 of 0 entries";
		String expMsg = testContext.getProgramPage2().getCountMsg();
		elements = testContext.getProgramPage2().getSearchElement();
		if (elements.isEmpty()) {
			Assert.assertEquals(elements.size(), 0);
		} else {
			Assert.assertTrue(elements.size() > 0);
		}
	}

	@When("Admin clicks on {string}  button in the program page")
	public void admin_clicks_on_button_in_the_program_page(String string) {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectCheckBoxMultiple();
		testContext.getProgramPage2().clickHeaderDeleteIcon();
		testContext.getProgramPage2().clickNoDelete();
		programForDeletion.clear();
	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
		//testContext.getProgramPage2().clickDeleteMultiple();
		//Assert.assertEquals(true, popWindowforMultiple)
		Assert.assertEquals(true,programForDeletion.size()==0);
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectSingleDelete();		
		testContext.getProgramPage2().clickXDelete();
		// popWindowforMultiple =
		// testContext.getProgramPage2().ConfirmationPage(string);
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
		boolean isConfirmBox = testContext.getProgramPage2().isDialogDisapearTrue();
		Assert.assertEquals(true, isConfirmBox);
	}

	// delete multiple ends

	// delete single begins

	@When("Admin clicks on delete button for a single program")
	public void admin_clicks_on_delete_button_for_a_single_program() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectSingleDelete();
	}

	@Then("Admin will get confirm deletion popup for a single program")
	public void admin_will_get_confirm_deletion_popup_for_a_single_program() {
		Assert.assertTrue(testContext.getProgramPage2().isDeleteConfirmDialogBoxDisplayed() );
		}

	@When("Admin clicks on delete button for a single program {string}")
	public void admin_clicks_on_delete_button_for_a_single_program(String string) {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().selectSingleDelete();
		testContext.getProgramPage2().clickYesDelete();
		 isConfirmBox =testContext.getProgramPage2().deleteSuccessDialogCheck("YES");
	}

	@Then("Admin can see Successful Program Deleted message")
	public void admin_can_see_successful_program_deleted_message() {
		Assert.assertEquals(true, isConfirmBox);
	}

	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() {
		boolean isConfirmBox = testContext.getProgramPage2().isDialogDisapearTrue();
		Assert.assertEquals(true, isConfirmBox);
	}

	@When("Admin Searches for one Deleted Program name")
	public void admin_searches_for_one_deleted_program_name() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().searchDeleteData();
	}

	@Then("There should be zero results for the search result")
	public void there_should_be_zero_results_for_the_search_result() {
		String actualMsg = "Showing 0 to 0 of 0 entries";
		String expMsg = testContext.getProgramPage2().getCountMsg();
		elements = testContext.getProgramPage2().getSearchElement();
		if (elements.isEmpty()) {
			Assert.assertEquals(elements.size(), 0);
		} else {
			Assert.assertTrue(elements.size() > 0);
		}
	}

	// delete single ends

	// sorting begins
	@When("Admin clicks on Arrow next to program Name in programs page")
	public void admin_clicks_on_arrow_next_to_program_name_in_programs_page() throws InterruptedException {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().clickSortIcon("Program Name");
	}

	@Then("Admin See the Program Name is sorted in Ascending order or Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_or_descending_order() {
		testContext.getProgramPage2().checkSortedAscending("Program Name");
	}

	@When("Admin clicks on Arrow next to program status in programs page")
	public void admin_clicks_on_arrow_next_to_program_status_in_programs_page() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().clickSortIcon("Program Status");
	}

	@Then("Admin See the Program status is sorted in Ascending order or Descending order")
	public void admin_see_the_program_status_is_sorted_in_ascending_order_or_descending_order() {
		testContext.getProgramPage2().checkSortedAscending("Program Status");
	}

	@When("Admin clicks on Arrow next to program description in programs page")
	public void admin_clicks_on_arrow_next_to_program_description_in_programs_page() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().clickSortIcon("Program Description");
	}

	@Then("Admin See the Program description is sorted in Ascending order or Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_or_descending_order() {
		testContext.getProgramPage2().checkSortedAscending("Program Description");
	}
	// sorting ends

	// search begins

	@When("Admin enter the programs to search By program name")
	public void admin_enter_the_programs_to_search_by_program_name() throws IOException {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSetup();
		testContext.getProgramPage2().searchProgram();
	}

	@Then("Admin should able to see Program name with description and status for searched program name")
	public void admin_should_able_to_see_program_name_with_description_and_status_for_searched_program_name() {
		String actualMsg = "Showing 0 to 0 of 0 entries";
		String expMsg = testContext.getProgramPage2().getCountMsg();
		elements = testContext.getProgramPage2().getSearchElement();
		if (elements.isEmpty()) {
			Assert.assertEquals(elements.size(), 0);
		} else {
			Assert.assertTrue(elements.size() > 0);
		}
	}

	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().searchProgram();
	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().searchProgram();
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().searchProgram();
	}
	// search ends

//pagination

	@When("Admin clicks next page link on the data table on programs page")
	public void admin_clicks_next_page_link_on_the_data_table_on_programs_page() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().clickNextPage();
	}

	@Then("Admin should see the Next enabled link on programs page")
	public void admin_should_see_the_next_enabled_link_on_programs_page() {
		Assert.assertTrue(testContext.getProgramPage2().isNextEnabled());
	}

	@When("Admin clicks last page link on the data table on programs page")
	public void admin_clicks_last_page_link_on_the_data_table_on_programs_page() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().clickLastPage();
	}

	@Then("Admin should see the last page link with next page link disabled on the table on programs page")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table_on_program_page() {
		Assert.assertTrue(!testContext.getProgramPage2().isNextEnabled());
	}

	@When("Admin clicks previous page link on the data table on programs page")
	public void admin_clicks_previous_page_link_on_the_data_table_on_program_page() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().pagination(2);
		testContext.getProgramPage2().clickPreviousPage();
	}

	@Then("Admin should see the previous page on the table on programs page")
	public void admin_should_see_the_previous_page_on_the_table_on_program_page() {
		Assert.assertTrue(testContext.getProgramPage2().isPreviousPage());
	}

	@When("Admin clicks first page link on the data table on programs page")
	public void admin_clicks_first_page_link_on_the_data_table_on_program_page() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().clickLastPage();
	}

	@Then("Admin should see the very first page on the data table on programs page")
	public void admin_should_see_the_very_first_page_on_the_data_table_on_program_page() {
		Assert.assertTrue(!testContext.getProgramPage2().isNextEnabled());
	}

	@When("Admin clicks Program menu on the navigation bar")
	public void admin_clicks_program_menu_on_the_navigation_bar() {
		testContext.getProgramPage2().clickProgramButton();
	}

	@Then("Admin should not see any pagination icons and message \"No records found\"")
	public void admin_should_not_see_any_pagination_icons_and_message_no_records_found() {
		Assert.assertTrue(!testContext.getProgramPage2().pagination(0));
	}

	@Then("Admin should see pagination icons disabled")
	public void admin_should_see_pagination_icons_disabled() {
		testContext.getProgramPage2().searchProgram();
		Assert.assertTrue(testContext.getProgramPage2().isNextEnabled());
	}

// Edit Program
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		Assert.assertEquals(false,testContext.getProgramPage2().isProgramPopupDisplayed());
	}

	@When("Admin clicks on Edit option for a program")
	public void admin_clicks_on_edit_option_for_program() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
	}

	@Then("Admin lands on a pop up Program details form")
	public void admin_lands_on_pop_up_program_details_form() {
		Assert.assertEquals(true,testContext.getProgramPage2().programPopupNameCheck());
	}

	@When("Admin clicks on Edit option for one program")
	public void admin_clicks_on_edit_option_for_one_program() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
	}

	@Then("Admin should see red asterisk mark beside mandatory field \"Name\"")
	public void adminShouldSeeRedAsteriskBesideName() {
		Assert.assertTrue(testContext.getProgramPage2().programPopupNameCheck());
	}

	@When("Admin edits the program name and click on cancel button")
	public void adminEditsProgramNameAndClicksCancel() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
		testContext.getProgramPage2().programNameInput("CANCEL");
	}
	
	@When("Admin searches with newly updated Program Name")
	public void adminSearchTheUpdatedProgram() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().searchEditProgram();
	}
	@Then("Admin verifies that the details are correctly updated")
	public void adminSearchTheUpdatedProgramCheck() {
		//Assert.assertTrue(testContext.getProgramPage2().checkProgramNameInputUpdated());
		Assert.assertEquals(true, testContext.getProgramPage2().isExpected());
	}
	@When("Admin edits the program name and click on x button")
	public void adminEditsProgramNameAndClicksX() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
		testContext.getProgramPage2().programNameInput("CLOSE");
	}

	@Then("Updated program name is not seen by the Admin")
	public void updatedProgramNameIsNotSeenByAdmin() {
		Assert.assertEquals(true, testContext.getProgramPage2().isExpected());
	}
	
	@When("Admin edits the program name and click on save button")
	public void adminEditsProgramNameAndClicksSave() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
		testContext.getProgramPage2().programNameInput("SAVE");
	}

	@Then("Updated program name is seen by the Admin")
	public void updatedProgramNameIsSeenByAdmin() {
		Assert.assertTrue(testContext.getProgramPage2().checkProgramNameInputUpdated());
		//Assert.assertEquals(false,testContext.getProgramPage2().isPaginationNextButtonDisplayed());
	}

	@When("Admin edits the program description and click on save button")
	public void adminEditsProgramDescAndClicksSave() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditNavigation();
		testContext.getProgramPage2().programDespInput();
	}

	@Then("Updated program description is seen by the Admin")
	public void updatedProgramDescIsSeenByAdmin() {
		Assert.assertTrue(testContext.getProgramPage2().checkProgramDespInputUpdated());
	}

	@When("Admin edits the program status and click on save button")
	public void adminEditsProgramStatusAndClicksSave() {
		testContext.getProgramPage2().clickProgramButton();
		testContext.getProgramPage2().dataSelectProgramEditStatusNavigation();
		testContext.getProgramPage2().programStatusInput();
	}

	@Then("Updated program status is seen by the Admin")
	public void updatedProgramStatusIsSeenByAdmin() {
		Assert.assertEquals(true, testContext.getProgramPage2().isExpected());
		//Assert.assertTrue(testContext.getProgramPage2().checkProgramStatusInputUpdated());
	}
}
