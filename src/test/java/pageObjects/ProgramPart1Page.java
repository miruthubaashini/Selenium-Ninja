package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProgramPart1Page {
	
	private WebDriver driver;
	
	
	public ProgramPart1Page(WebDriver driver) {
		super();
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//span[normalize-space()='Logout']") WebElement logout;
	@FindBy (xpath ="//span[normalize-space()='LMS - Learning Management System']") WebElement LMStext;
	@FindBy (xpath ="//thead[@class='p-datatable-thead']//tr//th") List<WebElement> pageHeading;
	@FindBy (xpath ="//div[normalize-space()='Manage Program']")WebElement ManageProgramText;
	@FindBy (xpath ="//span[normalize-space()='Program']")WebElement clickProgram;
	@FindBy (xpath ="//button[normalize-space()='Add New Program']")WebElement addNewProgram;
	@FindBy (xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")WebElement deleteIcon;
	@FindBy (xpath = "//span[@class='p-input-icon-left']")WebElement searchBoxText;
	
	
	
	
	
	
	public boolean logOut() {
		
        try {
        	
            return logout.isDisplayed();
        } catch (Exception e) {
        	 
        	System.out.println("Element Not Found: " + e.getMessage());
            return false;
        }
	}
	
	public String LMSText() {
		
		return LMStext.getText();
	}
	
	
	public List<WebElement> pageHeadings() {
		
		List<WebElement> headings= pageHeading;
		return headings;
		
	}
	
	public String manageProgram() {
		
		return ManageProgramText.getText();
		
	}
	
	public void clickOnProgramOption() {
		
		clickProgram.click();
	}
	
	public boolean addProgramIsDisplayed() {
		
		boolean text = addNewProgram.isDisplayed();
		return text ;	
	}
	
	public boolean deleteIconDisabled() {
		
	    return !deleteIcon.isEnabled();
	}
	
	public String searchBoxText() {
		
		return searchBoxText.getAttribute("placeholder");
	}
	
}
