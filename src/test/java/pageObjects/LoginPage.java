package pageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);	
	}
	
//	@FindBy(xpath="//input[@id=\'username\']")
//	private WebElement UserName;
//
//	@FindBy(xpath="//input[@id=\'password\']")
//	private WebElement Password;
//
//	@FindBy(xpath="//*[@role=\'combobox\']")
//	private WebElement Role;
//	
//	@FindBy(xpath="//button[@id=\"login\"]")
//	private WebElement Login;
//

	@FindBy (id= "username") WebElement usernameField;
	@FindBy (id= "password") WebElement passwordField;
	@FindBy (id= "mat-select-value-1") WebElement roleField;
	@FindBy (className= "mat-option-text") List <WebElement> roleDropdown;
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
