package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassPage extends BasePage {

	public ClassPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy (xpath= "//mat-card-title/div[1]") WebElement classHeader;
	@FindBy (className= "p-input-icon-left") WebElement searchBox;
	
	
	
	
	
	
	public boolean getClassHeader(String header) {
		if(classHeader.getText().equals(header)) {
			return true;
			} 
			return false;
		}
	
}
