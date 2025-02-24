package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

	
	public LogoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\'logout\']") WebElement logoutBtn;
	
	public void logoutClick()
	{
		logoutBtn.click();
	}
	
	
}
