package stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Properties;

import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramPart1SD {
	
	
	TestContext testContext;
	
	Properties prop = testContext.getConfigReader().initProperties();
	
	public ProgramPart1SD(TestContext testContext)
	{
		this.testContext=testContext;
	}
	
	
	@Given("Admin is on home page after login")
	public void admin_is_on_home_page_after_login() {
	    
	    
	}

	@When("Admin click Program in bar menu")
	public void admin_click_program_in_bar_menu() {
	    
		testContext.getProgramPart1Page().clickOnProgram();
	    
	}

	@Then("Admim should be on Manage Program page")
	public void admim_should_be_on_manage_program_page() {
	    
		String expectedProgramsUrl = prop.getProperty("programUrl");
		String actualurl = testContext.getHelper().getPageUrl();
		Assert.assertEquals(actualurl, expectedProgramsUrl);  
	}

	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
	    
		boolean logOutText = testContext.getProgramPart1Page().logOut();
		assertTrue(logOutText, "Logout Bitton is Displayed");
		
		//Assert.assertEquals(logOutText, prop.getProperty("logOut"));
	    
	}

	@Then("Admin should be able to see LMS - Learning Management System")
	public void admin_should_be_able_to_see_lms_learning_management_system() {
		
		String actualText=testContext.getProgramPart1Page().LMSText();
		Assert.assertEquals(actualText, prop.getProperty("lmsText")); 
	}

	@Then("Admin should see the page names in order Home,Program,Batch,Class,Edit\\/delete on Mange program page")
	public void admin_should_see_the_page_names_in_order_home_program_batch_class_edit_delete_on_mange_program_page() {
		
	 
		List<WebElement> headings =testContext.getProgramPart1Page().pageHeadings();  
		
	    for (WebElement heading : headings) {
	        System.out.println(heading.getText());
	    } 
	}

	@Then("Admin should be able to see Manage Program heading")
	public void admin_should_be_able_to_see_manage_program_heading() {
	    
		String manageProgramText = testContext.getProgramPart1Page().manageProgram();
		Assert.assertEquals(manageProgramText, prop.getProperty("managePgrm"));    
	}

	@When("Admin clicks on Program option in menu bar")
	public void admin_clicks_on_program_option_in_menu_bar() {
		
		testContext.getProgramPart1Page().clickOnProgramOption();
	    
	}

	@Then("Admin should see sub menu in menu bar as Add New Program in Program page")
	public void admin_should_see_sub_menu_in_menu_bar_as_add_new_program_in_program_page() {
		
		boolean text = testContext.getProgramPart1Page().addProgramIsDisplayed();
		assertTrue(text, "Logout Bitton is Displayed");
	    
	}

	@Then("Admin should see a Delete button in left top is disabled in Manage Program")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled_in_manage_program() {
	    
		boolean status = testContext.getProgramPart1Page().deleteIconDisabled();
	    Assert.assertTrue(status, "Delete button is not enabled.");
	}
	

	@Then("Admin should see Search bar with text as Search in Program page")
	public void admin_should_see_search_bar_with_text_as_search_in_program_page() {
	 
		String searchText = testContext.getProgramPart1Page().searchBoxText();
		Assert.assertEquals(searchText, prop.getProperty("searchText"),"Search...");

		
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name on Manage Program")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_on_manage_program() {
	    
	    
	}

	@Then("Admin should see the sort arrow icon beside to each header except Edit and Delete on Manage Program")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_header_except_edit_and_delete_on_manage_program() {
	    
	    
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table on Manage Program")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table_on_manage_program() {
	    
	    
	}


}
