package stepDefinitions;

import java.util.Properties;

import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.java.en.*;

public class HomePageSD {
	Properties prop;
	TestContext testContext;
	
	public HomePageSD(TestContext testContext)
	{
		this.testContext=testContext;
	}
	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	Assert.assertTrue(testContext.getHomePage().titleDispalyed());   
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		Assert.assertTrue(testContext.getHomePage().titlePosition());   
		
	}
	@Then("Admin should see {string} in {int}")
	public void admin_should_see_home_in_the_1st_place(String tab,int place) {
		Assert.assertTrue(testContext.getHomePage().navBarValidation(tab, place));   
	}
	@Then("Admin should see correct spelling in navigation bar text")
	public void Admin_should_see_correct_spelling_in_navigation_bar_text()
	{
		Assert.assertTrue(testContext.getHomePage().navBarSpellCheck());   

	}
	@Then("Admin should see piechart")
	public void admin_should_see_piechart() {
	    Assert.assertTrue(testContext.getHomePage().pieChartDisplayed());
	}

	@Then("Admin should see welcome message with user name and role")
	public void admin_should_see_welcome_message_with_user_name_and_role() {
		 prop = testContext.getConfigReader().initProperties();
		Assert.assertTrue(testContext.getHomePage().checkUserNameAndRole(prop.getProperty("username"), prop.getProperty("role")));
	}
	@Then("Admin should see bar chart for Active and inactive user")
	public void admin_should_see_bar_chart_for_active_and_inactive_user() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see user count")
	public void admin_should_see_user_count() {
	   Assert.assertTrue(testContext.getHomePage().UserwidgetDisplay());
	}

	@Then("Admin should see staff count")
	public void admin_should_see_staff_count() {
		Assert.assertTrue(testContext.getHomePage().staffwidgetDisplay());
	}

	@Then("Admin should see Program count")
	public void admin_should_see_program_count() {
		Assert.assertTrue(testContext.getHomePage().programwidgetDisplay());
	}

	@Then("Admin should see batch  count")
	public void admin_should_see_batch_count() {
		Assert.assertTrue(testContext.getHomePage().batchwidgetDisplay());
	}
	@Then("Admin should see staff table with pagination icons")
	public void admin_should_see_staff_table_with_pagination_icons() {
		Assert.assertTrue(testContext.getHomePage().StaffDataTableDisplay());
	}

	@Then("Admin should see {int} staff data in a page")
	public void admin_should_see_staff_data_in_a_page(Integer int1) {
		Assert.assertTrue(testContext.getHomePage().StaffDataRowsCheck());
	}

	@Then("admin should see previous page icon disabled")
	public void admin_should_see_previous_page_icon_disabled() {
		Assert.assertTrue(testContext.getHomePage().previousPageDisabled());
	}

	@Then("admin should see first page icon disabled")
	public void admin_should_see_first_page_icon_disabled() {
		Assert.assertTrue(testContext.getHomePage().firstPageDisabled());
	}




}
