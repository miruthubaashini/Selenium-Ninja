package stepDefinitions;

import java.util.Properties;
import io.cucumber.java.en.Given;
import dependencyInjection.TestContext;

public class BaseSD {
	
	TestContext testContext;
	//private SoftAssert softAssert = new SoftAssert();

	public BaseSD (TestContext testContext) {
		this.testContext = testContext;
	}
	
//	@Given("Admin user is logged in with valid credentials")
//	public void admin_user_is_logged_in_with_valid_credentials() {
//	    
//		Properties prop = testContext.getConfigReader().initProperties();
//		String userName = prop.getProperty("username");
//		String passWord = prop.getProperty("password");
//		String userRole = prop.getProperty("role");
//
//		testContext.getBasePage().enterUsername(userName);
//		testContext.getBasePage().enterPassword(passWord);
//		testContext.getBasePage().clickRoleDD();
//		testContext.getBasePage().selectUserRole(userRole);
//		testContext.getBasePage().clickLoginbtn();
//	}
}
