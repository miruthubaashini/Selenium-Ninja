package stepDefinitions;

import java.util.Properties;

import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.java.en.*;
import webDriverManager.DriverManager;

public class LogoutPageSD {
	Properties prop;
	TestContext testContext;
	
	public LogoutPageSD(TestContext testContext) {
		this.testContext=testContext;
	}
	
	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	  testContext.getLogoutPage().logoutClick();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		prop=testContext.getConfigReader().initProperties();
		String expUrl=prop.getProperty("url");
	Assert.assertEquals(testContext.getHelper().getPageUrl(), expUrl);   
	}

	
	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
	   DriverManager.getDriver().navigate().back();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		String expUrl=prop.getProperty("url");
		Assert.assertEquals(testContext.getHelper().getPageUrl(),expUrl);
		}
			}



