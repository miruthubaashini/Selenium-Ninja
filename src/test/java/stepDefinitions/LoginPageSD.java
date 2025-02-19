package stepDefinitions;

import java.util.Properties;

import dependencyInjection.TestContext;
import io.cucumber.java.en.*
 ;

public class LoginPageSD {

	TestContext testContext;
	
	public LoginPageSD(TestContext testContext)
	{
		this.testContext=testContext;
	}
	@Given("Admin user is logged in with valid credentials")
	public void admin_user_is_logged_in_with_valid_credentials() {
	    
		Properties prop = testContext.getConfigReader().initProperties();
		String userName = prop.getProperty("username");
		String passWord = prop.getProperty("password");
		String userRole = prop.getProperty("role");

		testContext.getLoginPage().enterUsername(userName);
		testContext.getLoginPage().enterPassword(passWord);
		testContext.getLoginPage().clickRoleDD();
		testContext.getLoginPage().selectUserRole(userRole);
		testContext.getLoginPage().clickLoginbtn();
	}
	
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



	
}
