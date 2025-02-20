package runner;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;

@CucumberOptions(features = "src/test/resources/features", glue = { "stepDefinitions", "hooks" },
		// tags="@wip",
		monochrome = false, publish = true, plugin = { "pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"html:target/test-output/htmlReport/report.html" })

public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeTest
	@Parameters("BrowserType")
	public void defineBrowser(String browser) {
		ConfigReader.setBrowserType(browser);
	}
}
