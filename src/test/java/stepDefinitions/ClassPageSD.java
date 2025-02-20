package stepDefinitions;

import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import dependencyInjection.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ClassPageSD {

	TestContext testContext;
	private SoftAssert softAssert = new SoftAssert();

	public ClassPageSD (TestContext testContext) {
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

	}

	@Then("Admin sees the sort icon for the following data table headings on the Manage Class page:")
	public void admin_sees_the_sort_icon_for_the_following_data_table_headings(DataTable dataTable) {
		List<String> columnHeaders = dataTable.asList(String.class);
		for (String columnHeader: columnHeaders) {
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



}
