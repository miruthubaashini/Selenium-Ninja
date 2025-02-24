package pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Should go in HomePage.java
	@FindBy (xpath= "//span[text()='Class']") WebElement classLink;
	@FindBy (xpath= "//app-header/mat-toolbar/span[1]") WebElement pageTitle;
	
	public void clickClass() {
		classLink.click();
	}
	
	public boolean getPortalTitle(String title) {
		String actualTitle = pageTitle.getText();
		if (actualTitle.equals(title)) {
			return true;
		} 
		return false;

	}
	
	
	}
