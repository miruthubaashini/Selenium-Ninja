package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	
	//Should go in LoginPage.java
	@FindBy (id= "username") WebElement usernameField;
	@FindBy (id= "password") WebElement passwordField;
	@FindBy (id= "mat-select-value-1") WebElement roleField;
	@FindBy (className= "mat-option-text") List<WebElement> roleDropdown;
	@FindBy (id= "login") WebElement loginButton;
	
	public void enterUsername(String userName) {
		usernameField.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickRoleDD() {
		roleField.click();
	}
	
	public void selectUserRole(String role) {
		roleDropdown.stream().filter(r->r.getText().equals(role)).forEach(e->e.click());
	}
	
	public void clickLoginbtn() {
		loginButton.click();
	}
	
	
}
