package pageObjects;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ProgramPart1Page {
	
	private WebDriver driver;
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	public ProgramPart1Page(WebDriver driver) {
		super();

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (xpath="//span[normalize-space()='Logout']")
	private WebElement logout;
	
	@FindBy (xpath = "//span[normalize-space()='Program']")
	private WebElement clickOnProgram;
	
	@FindBy (xpath ="//span[normalize-space()='LMS - Learning Management System']")
	private WebElement LMStext;
	
	@FindBy (xpath ="//div[@class='ng-star-inserted']//button")
	private List<WebElement> pageHeading;
	
	@FindBy (xpath ="//div[normalize-space()='Manage Program']")
	private WebElement ManageProgramText;
	
	@FindBy (xpath ="//span[normalize-space()='Program']")
	private WebElement clickProgram;
	
	@FindBy (xpath ="//button[normalize-space()='Add New Program']")
	private WebElement addNewProgram;
	
	@FindBy (xpath = "//button[@class='p-button-danger p-button p-component p-button-icon-only']")
	private WebElement deleteIcon;
	
	@FindBy (xpath = "//span[@class='p-input-icon-left']")
	private WebElement searchBoxText;
	
	@FindBy (xpath = "//div[@class='p-checkbox-box']")
	private WebElement checkBox;
	
	@FindBy (xpath = "//tr[@class='ng-star-inserted']//th")
	private List<WebElement> managePageHeadings;
	
	@FindBy (xpath = "//tbody[@class='p-datatable-tbody']//tr//td[5]//div")
	private List<WebElement> editDeleteButton;
	
	@FindBy (xpath = "//div[@class='p-datatable-footer ng-star-inserted']")
	private WebElement footerMsg;
	
	@FindBy (xpath = "//div[contains(@class,'mat-menu-content ng-tns')]")
	private WebElement addNewPgrText;
	
	@FindBy (xpath = "//button[contains(@class,'mat-focus-indicator mat-menu-item')]")
	private WebElement addNewPgrButton;
	
	@FindBy (xpath = "//div[@role='dialog']")
	private WebElement popUpWindowForm;
	
	@FindBy (xpath = "//span[normalize-space()='Program Details']")
	private WebElement pgrmDetailsTitle;
	
	@FindBy (xpath = "//button[@id='saveProgram']")
	private WebElement saveButton;
	
	@FindBy (xpath = "//small[normalize-space()='Description is required.']")
	private WebElement descriptionErrorMsg;
	
	@FindBy (xpath = "//small[normalize-space()='Program name is required.']")
	private WebElement nameErrorMsg;
	
	@FindBy (xpath = "//span[contains(text(),'*')]")
	private List<WebElement> asterisk;
	
	@FindBy (xpath = "//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']")
	private WebElement cancelButton;
	
	@FindBy (xpath = "//div[@class='radio ng-star-inserted']/div[2]//input")
	private WebElement activeRadioButton;
	
	@FindBy (xpath = "//input[@id='Inactive']")
	private WebElement inactiveRadioButton;
	
	@FindBy (xpath = "//span[contains(@class,'p-dialog-header-close-icon')]")
	private WebElement closeSign;
	
	@FindBy (xpath = "//input[@id='programName']")
	private WebElement programNameInput;
	
	@FindBy (xpath = "//input[@id='programDescription']")
	private WebElement programDescriptionInput;
	
	@FindBy (xpath = "//div[normalize-space()='Program Created Successfully']")
	private WebElement toastMessage;
	
	@FindBy (xpath = "//input[@id='filterGlobal']")
	private WebElement searchText;
	
	@FindBy (xpath = "//table/tbody/tr[1]/td[2]")
	private WebElement firstRowProgram;
	
	@FindBy(xpath = "//div[@class='radio ng-star-inserted']/div[@class='ng-star-inserted']")
	private List<WebElement> statusRadioButtons;
	
	@FindBy (xpath = "//button[@id='editProgram']")
	private List<WebElement> areEditButtonsVisible;
	
	@FindBy (xpath = "//button[@id='deleteProgram']")
	private List<WebElement> areDeleteButtonsVisible;
	
	@FindBy (xpath = "//p-radiobutton/div/div[2]")
	private List<WebElement> radioButton;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[2]")
	WebElement firstRowProgramhName;

	
	
	
	
	public boolean logOut() {
		
        try {
        	
            return logout.isDisplayed();
        } catch (Exception e) {
        	 
        	System.out.println("Element Not Found: " + e.getMessage());
            return false;
        }
	}
	
	public void clickOnProgram() {
		
		clickOnProgram.click();
	}
	
	
	public String LMSText() {
		
		return LMStext.getText();
	}
	
	
//	public List<WebElement> pageHeading() {
//		
//		List<WebElement> headings= pageHeading;
//		
//		for (WebElement heading : headings) {
//	        System.out.println(heading.getText());
//		}
//		return pageHeading;
//	}
	
	public List<String> pageHeading() {
		return pageHeading.stream().map(h -> h.getText()).filter(text -> !text.isEmpty())
				.collect(Collectors.toList());
	}
	
	
	
	
	public boolean manageProgram(String header) {
		if (ManageProgramText.getText().equals(header)) {
			return true;
		}
		return false;
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
	
	public boolean searchBox() {
		
		if (searchBoxText.isDisplayed()) {
			return true;
		}
		return false;
	}
		
		

	
	public boolean checkBoxStatus() {
		
		return !checkBox.isSelected();
		
	
	}
	
	public WebElement sortArrowForEachHeader(String columnHeader) {
		
			for (WebElement header : managePageHeadings) {
				if (header.getText().equals(columnHeader)) {
					return header.findElement(By.tagName("p-sorticon"));
				}
			}
			return null;
		}
		
	
	public boolean editButtons() {
		
		List<WebElement> editButtons = areEditButtonsVisible;
		 
	    for (WebElement editButton : editButtons) {
	        if (editButton.isDisplayed()) {  
	            return true;  
	        }
	    }
		return false;
	}
	
	public boolean deleteButtons() {
		
		List<WebElement> editButtons = areDeleteButtonsVisible;
		 
	    for (WebElement editButton : editButtons) {
	        if (editButton.isDisplayed()) {  
	            return true;  
	        }
	    }
		return false;
	}
	
	
	public boolean footerMessage(String text){
		
	String footerText = footerMsg.getText();
	String regexText = text.replace("z", "\\d+");
	Pattern pattern = Pattern.compile(regexText);
	Matcher matcher = pattern.matcher(footerText);
		
		return matcher.matches();
	}
	
	public boolean addNewProgramClick() {
	
		if (addNewPgrText.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public String addNewPgrmSearch() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button=wait.until(ExpectedConditions.visibilityOf(addNewPgrButton));
		return button.getText();	
	}
	
	public boolean popupWindowForm() {
		
		if(popUpWindowForm.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public boolean programDetailsTitleOnPopup(String title) {
		 
		if (pgrmDetailsTitle.getText().equals(title)) {
			return true;
		}
		return false;
	}
	
	public void clickOnSaveButton() throws InterruptedException {
		
		saveButton.click();
	}
	
	
	public boolean errorMessage() {
		
	    if (nameErrorMsg.getText().equals("Program name is required.")) {
	        return true;
	    }

	    if (descriptionErrorMsg.getText().equals("Description is required.")) {
	        return true;
	    }

	    return false;
	}
	
	public boolean asteriskPresence() {
		
	    List<WebElement> elements = asterisk;
	    for (WebElement Asterisk : elements) {
	        if (Asterisk.getText().contains("*")) {  
	            System.out.println("Asterisk found: " + Asterisk.getText());
	            return true;  
	        }
	    }
	    System.out.println("No asterisk found.");
	    return false;
	}
	
	public void clickCancelButton() {
		
		cancelButton.click();
		
	}
	
	public void activeRadioBtn() {
		
		if(!(activeRadioButton.isSelected())){
			
			activeRadioButton.click();
		}
		System.out.println("After clicking:" + activeRadioButton.isSelected() );
	}
	
	
	public void inactiveRadioBtn() {
		
		if(!(inactiveRadioButton.isSelected())){
			
			inactiveRadioButton.click();
		}
		System.out.println("After clicking:" + inactiveRadioButton.isSelected() );
	}
	
	public void closeWindowByx() {
		
		closeSign.click();
		
	}
	
	public void radioButton(String status) {
		
		if (status != null)
		statusRadioButtons.stream().filter(s -> s.getText().trim().equals(status))
		.forEach(s -> s.findElement(By.xpath("p-radiobutton/div/div[2]")).click());
	}
	

//	public boolean isRadioButtonSelected(String status) {
//	    if (status != null) {
//	        
//	        return statusRadioButtons.stream()
//	            .filter(s -> s.getText().trim().equals(status))
//	            .anyMatch(s -> s.findElement(By.xpath("//div[@class='p-radiobutton p-component p-radiobutton-checked p-radiobutton-focused']")).isSelected());
//	    }
//	    return false;  
//	}

	
	public boolean isRadioButtonSelected(String status) {
	    if (status != null) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Waiting up to 10 seconds

	        return statusRadioButtons.stream()
	            .filter(s -> s.getText().trim().equals(status))
	            .anyMatch(s -> {
	                WebElement radioButton = wait.until(ExpectedConditions.visibilityOf(s)); // Wait for the radio button to be visible
	                return radioButton.findElement(By.xpath("//div[@class='p-radiobutton p-component p-radiobutton-checked p-radiobutton-focused']")).isSelected();
	            });
	    }
	    return false;  
	}

	
	
	public void addNewPgrmClick() {
		
		addNewPgrButton.click();
	
	}
	
	public boolean addNewProgramVisible() {
		
		if(addNewPgrButton.isDisplayed()){
			return true;
		}
		return false;
	}
	
	

	
	public void fillProgramDetails(String programName, String programDescription) {
		
		if (programName != null) {
			programNameInput.sendKeys(programName);
		}
		
		if (programDescription != null) {
			programDescriptionInput.sendKeys(programDescription);
		}
		
	}
	
	public void radioClick(String status) {	
		if (status != null)
			statusRadioButtons.stream().filter(s -> s.getText().trim().equals("Active"))
			.forEach(s -> s.findElement(By.xpath("p-radiobutton/div/div[2]")).click());
		
		
	}
	
	
	public String programCreatedMessage() {
		
		return toastMessage.getText();
	}	
			
	
	
	public void searchCreatedProgram(String programName ) {
		
		searchText.sendKeys(programName);
		
		
	}
	
	public String createdProgramDisplayed() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstRowProgramName = wait.until(ExpectedConditions.visibilityOf(firstRowProgramhName));
		String Text =firstRowProgramName.getText();
		System.out.println("New created program:" + Text);
		return Text;
	
	}
	
	public void enterName(String programName) {
		
		if (programNameInput != null) {
		programNameInput.sendKeys(programName);
		}

	}
	
	public boolean enteredNameVerify() {
		
		String descriptionInput = programNameInput.getDomAttribute("class");
		if(descriptionInput.contains("p-inputtext p-component ng-touched ng-dirty p-filled ng-valid")) {
			return true;
		
		}
		return false;
	}

	public void enterDescription(String programDescription) {
		
		if (programDescription != null) {
			programDescriptionInput.sendKeys(programDescription);
		}
	}
	
	
	
	///Below method with hard coded program name
	
//	public boolean searchProgram() {
//		
//		searchText.sendKeys("NewProgram");
//		if(newProgramSearch.isDisplayed()) {
//			return true;
//		}
//		return false;
//	}
	
	
	
	 public boolean isPopupWindowClosed() {
		 
		 try {
			 popUpWindowForm.isDisplayed();
	            return true; // Form still exists
	        } catch (Exception e) {
	            return false; // Form is not found, so it is closed
	        }
	    }
	 
	public boolean areDeleteIconsDisplayed() {
			for(int i = 0; i < 10; i++) {
				WebElement editIcon = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[7]/div/span[2]/button[contains(@icon, 'pi pi-trash')]"));

				if(!editIcon.isDisplayed()) {
					return false;
				}
			}
			
			return true;
		}
	
	
	public boolean areEditIconsDisplayed() {
		
	    List<WebElement> editIcons = areEditButtonsVisible; 
	    
	    for (WebElement editIcon : editIcons) {
	        if (editIcon.isDisplayed()) {
	            return true;  // Return true immediately if any icon is displayed.
	        }
	    }
	    
	    return false;  
	}

}
		 
	

	

		

