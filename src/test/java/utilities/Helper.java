package utilities;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class Helper {
	WebDriver driver;

	public Helper(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isScenarioTaggedWith(Scenario scenario, String tag) {
		return scenario.getSourceTagNames().contains(tag);
	}

	// To launch the application
	public void getApplication(String url) {
		driver.get(url);
	}

	// To get page title of any page
	public String getPageTitle() {
		return driver.getTitle();
	}

	// To get the url of current page
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

}
