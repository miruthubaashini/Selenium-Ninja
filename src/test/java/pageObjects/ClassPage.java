package pageObjects;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassPage extends BasePage {
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public ClassPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//mat-card-title/div[1]")
	private WebElement classHeader;
	@FindBy(className = "p-input-icon-left")
	private WebElement searchBox;
	@FindBy(xpath = "//tr/th")
	private List<WebElement> datatableHeaders;
	@FindBy(xpath = "//div[@class='box']//button")
	private WebElement deleteButton;
	@FindBy(css = "[role='menuitem']")
	private WebElement addNewClassButton;

	// Pagination and footer related objects
	@FindBy(xpath = "//p-paginator/div/span[contains(@class,'p-paginator-current')]")
	private WebElement datatablePaginationText;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]/span")
	private WebElement paginatorFirstButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-prev')]/span")
	private WebElement paginatorPreviousButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-next')]/span")
	private WebElement paginatorNextButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-last')]/span")
	private WebElement paginatorLastButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-page')]")
	private List<WebElement> paginatorPages;
	@FindBy(xpath = "//div[contains(@class,'p-datatable-footer')]/div")
	private WebElement datatableFooterText;

	// Class Details form related objects
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement classDetailsPupup;
	@FindBy(css = "[label='Cancel']")
	private WebElement cancelButton;
	@FindBy(css = "[label='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon')]")
	private WebElement closeIcon;
	@FindBy(xpath = "//label[text()='Batch Name']/following-sibling::p-dropdown/div/div[2]")
	private WebElement batchNameDropdownIcon;
	@FindBy(xpath = "//ul//span")
	private List<WebElement> batchNameDropdownItems;
	@FindBy(id = "classTopic")
	private WebElement classTopicInput;
	@FindBy(id = "classDescription")
	private WebElement classDescriptionInput;
	@FindBy(id = "classNo")
	private WebElement classNoInput;
	@FindBy(xpath = "//label[text()='Staff Name']/following-sibling::p-dropdown/div/div[2]")
	private WebElement staffNameDropdownIcon;
	@FindBy(xpath = "//p-dropdown[@id='staffId']//p-dropdownitem//span")
	private List<WebElement> staffNameDropdownItems;
	@FindBy(xpath = "//div[@class='radio ng-star-inserted']/div[@class='ng-star-inserted']")
	private List<WebElement> statusRadioButtons;
	@FindBy(id = "classComments")
	private WebElement classCommentsInput;
	@FindBy(id = "classNotes")
	private WebElement classNotesInput;
	@FindBy(id = "classRecordingPath")
	private WebElement classRecordingsInput;

	// date picker
	@FindBy(xpath = "//button[contains(@class,'p-datepicker-trigger')]")
	private WebElement calenderIcon;
	@FindBy(xpath = "//span[contains(@class,'p-datepicker-year')]")
	private WebElement calenderYear;
	@FindBy(xpath = "//span[contains(@class,'p-datepicker-month')]")
	private WebElement calenderMonth;
	@FindBy(className = "p-datepicker-next-icon")
	private WebElement datepickerNextIcon;
	@FindBy(xpath = "//table[contains(@class,'p-datepicker-calendar')]//tbody/tr/td[contains(@class, 'ng-tns-c92-193') and not(contains(@class, 'p-datepicker-other-month'))]")
	private List<WebElement> calenderDateList;

	public boolean getClassHeader(String header) {
		if (classHeader.getText().equals(header)) {
			return true;
		}
		return false;
	}

	public WebElement classSearchBox() {
		return searchBox;
	}

	public List<String> getDatatableHeaders() {
		return datatableHeaders.stream().map(h -> h.getText()).filter(text -> !text.isEmpty())
				.collect(Collectors.toList());
	}

	public WebElement checkSortIcon(String columnHeader) {
		for (WebElement header : datatableHeaders) {
			if (header.getText().equals(columnHeader)) {
				return header.findElement(By.tagName("p-sorticon"));
			}
		}
		return null;
	}

	// Method to check if the Delete button is displayed
	public boolean isDeleteButtonVisible() {
		return deleteButton.isDisplayed();
	}

	// Method to click on the Delete button
	public void clickDeleteButton() {
		deleteButton.click();
	}

	public void clickAddNewClassButton() {
		addNewClassButton.click();
	}
	// ------------------------------------------------------

	// Pagination and footer related methods
	public boolean checkPaginationTextMatches(String text) {
		String paginationText = datatablePaginationText.getText();
		String regexText = text.replace("x", "\\d+");
		Pattern pattern = Pattern.compile(regexText);
		Matcher matcher = pattern.matcher(paginationText);

		return matcher.matches();
	}

	public boolean isPaginationFirstButtonVisible() {
		return paginatorFirstButton.isDisplayed();
	}

	public boolean isPaginationPreviousButtonVisible() {
		return paginatorPreviousButton.isDisplayed();
	}

	public boolean isPaginationNextButtonVisible() {
		return paginatorNextButton.isDisplayed();
	}

	public boolean isPaginationLastButtonVisible() {
		return paginatorLastButton.isDisplayed();
	}

	public boolean isPaginationPagesButtonAvailable() {
		if (paginatorPages.size() >= 1) {
			return true;
		}
		return false;
	}

	public boolean checkFooterTextMatches(String text) {
		String footerText = datatableFooterText.getText();
		String regexText = text.replace("x", "\\d+");
		Pattern pattern = Pattern.compile(regexText);
		Matcher matcher = pattern.matcher(footerText);

		return matcher.matches();
	}
	// ------------------------------------------------------------

	// Class Details form related methods

	public boolean isClassDetailsPopupDisplayed() {
		return classDetailsPupup.isDisplayed();
	}

	public boolean isCancelButtonDisplayed() {
		return cancelButton.isDisplayed();
	}

	public boolean isSaveButtonDisplayed() {
		return saveButton.isDisplayed();
	}

	public boolean isCloseIconDisplayed() {
		return closeIcon.isDisplayed();
	}

	// To enter values in class details form
	public void fillClassDetailsForm(String batchName, String classTopic, String classDescription, String classDate,
			String staffName, String status, String classComments, String classNotes, String classRecordingPath) {
		// Select Batch Name from dropdown
		batchNameDropdownIcon.click();
		batchNameDropdownItems.stream().filter(batch -> batch.getText().equals(batchName)).forEach(b -> b.click());

		// Enter class topic
		classTopicInput.sendKeys(classTopic);

		// Enter class description
		classDescriptionInput.sendKeys(classDescription);

		// Select class dates
		datePicker(classDate);

		js.executeScript("document.body.click();");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Select staff name from dropdown
		staffNameDropdownIcon.click();
		staffNameDropdownItems.stream().filter(staff -> staff.getText().equals(staffName)).forEach(s -> s.click());

		// Select status radio button
		statusRadioButtons.stream().filter(s -> s.getText().trim().equals(status))
				.forEach(s -> s.findElement(By.xpath("/p-radiobutton/div/div[2]")).click());

		// Enter class comments
		classCommentsInput.sendKeys(classComments);

		// Enter class notes
		classNotesInput.sendKeys(classNotes);

		// Enter class recordings
		classRecordingsInput.sendKeys(classRecordingPath); 
	}
	
	public boolean isInputFieldPresent(String inputField) {		
		switch(inputField.trim()) {
		case "Batch Name": return batchNameDropdownIcon.findElement(By.xpath("/parent::div")).isDisplayed(); 
		case "Class Topic": return classTopicInput.isDisplayed();  
		case "Class Description": return classDescriptionInput.isDisplayed();  
		case "Select Class Dates": return calenderIcon.findElement(By.xpath("/parent::span")).isDisplayed(); 
		case "No of Classes": return classNoInput.isDisplayed(); 
		case "Staff Name": return staffNameDropdownIcon.findElement(By.xpath("/parent::div")).isDisplayed(); 
		case "Status": {
			for (WebElement status:statusRadioButtons) {
				if (status.isDisplayed()) {
					return true;
				}				
			} return false;
		}
			
		case "Comments": return classCommentsInput.isDisplayed(); 
		case "Notes": return classNotesInput.isDisplayed(); 
		case "Recording": return classRecordingsInput.isDisplayed();
		default: return false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

	public void datePicker(String classDate) {
		String[] classdate = classDate.split("/");
		String month = classdate[0];
		String date = classdate[1];
		String year = classdate[2];

		String monthName = null;

		switch (month) {
		case "01":
			monthName = "January";
			break;
		case "02":
			monthName = "February";
			break;
		case "03":
			monthName = "March";
			break;
		case "04":
			monthName = "April";
			break;
		case "05":
			monthName = "May";
			break;
		case "06":
			monthName = "June";
			break;
		case "07":
			monthName = "July";
			break;
		case "08":
			monthName = "August";
			break;
		case "09":
			monthName = "September";
			break;
		case "10":
			monthName = "October";
			break;
		case "11":
			monthName = "November";
			break;
		case "12":
			monthName = "December";
			break;
		default:
			System.out.println("Enter a valid month");
		}

		// Open date picker
		calenderIcon.click();

		// Select month and year
		while (true) {
			if (calenderYear.getText().equals(year) && calenderMonth.getText().equals(monthName)) {
				break;
			}
			datepickerNextIcon.click();
		}

		// Select date from calender
		calenderDateList.stream().filter(d -> d.getText().equals(date)).forEach(dt -> dt.click());
	}

}
