package stepDefinitions;

import dependencyInjection.TestContext;

public class BaseSD {
	
	TestContext testContext;
	//private SoftAssert softAssert = new SoftAssert();

	public BaseSD (TestContext testContext) {
		this.testContext = testContext;
	}
	
}
