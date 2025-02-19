package stepDefinitions;

import java.util.Properties;

import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class ClassPageSD {

	TestContext testContext;
	//private SoftAssert softAssert = new SoftAssert();

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
	    
	    
	}

	@Then("Admin sees the following data table headings:")
	public void admin_sees_the_following_data_table_headings(DataTable dataTable) {
	    
	    
	}

	@Then("Admin sees the text {string} and pagination controls below the data table")
	public void admin_sees_the_text_and_pagination_controls_below_the_data_table(String string) {
	    
	    
	}

	@Then("Admin sees the sort icon for the following data table headings:")
	public void admin_sees_the_sort_icon_for_the_following_data_table_headings(DataTable dataTable) {
	    
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
	}

	@Then("Admin sees the Delete button on Manage Class page")
	public void admin_sees_the_delete_button_on_manage_class_page() {
	    
	    
	}

	@Then("Admin sees the {string} on Manage Class page")
	public void admin_sees_the_on_manage_class_page(String string) {
	    
	    
	}



}
