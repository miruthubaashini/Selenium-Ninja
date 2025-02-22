package stepDefinitions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import org.testng.Assert;

import dependencyInjection.TestContext;
import io.cucumber.java.en.*
 ;
import net.sourceforge.tess4j.TesseractException;

public class LoginPageSD {
	Properties prop;
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
	@Given("The browser is open")
	public void the_browser_is_open() {
	   
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		prop = testContext.getConfigReader().initProperties();
		String portalUrl = prop.getProperty("url");
		testContext.getHelper().getApplication(portalUrl);

		
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Properties prop = testContext.getConfigReader().initProperties();
		String expectedUrl = prop.getProperty("url");
		String actualClassURL = testContext.getHelper().getPageUrl();
		
	    Assert.assertEquals(actualClassURL, expectedUrl);
		}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		prop = testContext.getConfigReader().initProperties();
		String portalUrl = prop.getProperty("invalidUrl");
		testContext.getHelper().getApplication(portalUrl);

	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() {
		try {
		URL link = new URL(prop.getProperty("invalidUrl"));
		HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
		httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
		httpURLConnection.connect();
		Assert.assertEquals(httpURLConnection.getResponseCode() == 200 ,false);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Then("HTTP response >= {int},the link is broken")
	public void http_response_the_link_is_broken(Integer int1) {
		try {
			URL link = new URL(prop.getProperty("url"));
			HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
			httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
			httpURLConnection.connect();


			Assert.assertEquals(httpURLConnection.getResponseCode() >= 400 ,false);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	   Assert.assertTrue(testContext.getLoginPage().spellCheckSignInContents());
	}

	@Then("Admin should see appName {string}")                          //tesserect
	public void admin_should_see_appName(String exp) throws IOException, TesseractException {
	   Assert.assertEquals(testContext.getLoginPage().appNameOnLogo().contains(exp),true);
	}

	@Then("Admin should see company name below the app name")                    //tesserect
	public void admin_should_see_company_name_below_the_app_name() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
		Assert.assertTrue(testContext.getLoginPage().formLabelDisplayed(),"Please Login to LMS-Application is dispalyed");

	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	   testContext.getLoginPage().textFields();
	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String placeholder) {
	   Assert.assertEquals(testContext.getLoginPage().usernamePlaceholder(), placeholder);
	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
	   Assert.assertEquals(testContext.getLoginPage().dropDownDisplay(), true);
	}

	@Then("Admin should see asterisk mark symbol next to text for user field")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_user_field() {
		
		Assert.assertEquals(testContext.getLoginPage().userStarDisplayed(), true);
		
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String placeholder) {
		   Assert.assertEquals(testContext.getLoginPage().passwordPlaceholder(), placeholder);
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		
		Assert.assertEquals(testContext.getLoginPage().pwdStarDisplayed(), true);
		
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String placeholder) {
	   
	    Assert.assertTrue(testContext.getLoginPage().rolePlaceHolder().contains(placeholder));
	}

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String string) {

		Assert.assertEquals(testContext.getLoginPage().dropDownElementstsDisplayed(), true);
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		Assert.assertEquals(testContext.getLoginPage().signInContentPosition(), true);
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	   Assert.assertEquals(testContext.getLoginPage().loginBtnDispalyed(), true);
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
	Assert.assertTrue(testContext.getLoginPage().usertextColour());    
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		Assert.assertTrue(testContext.getLoginPage().pwdtextColour());    
		
	}
}
