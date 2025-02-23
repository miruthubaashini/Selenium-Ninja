package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClassPage extends BasePage {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public ClassPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='Class']")
	private WebElement classLink;
	@FindBy(xpath = "//mat-card-title/div[1]")
	private WebElement classHeader;
	@FindBy(id = "filterGlobal")
	private WebElement searchBox;
	@FindBy(xpath = "//tr/th")
	private List<WebElement> datatableHeaders;
	@FindBy(xpath = "//div[@class='box']//button")
	private WebElement deleteButton;
	@FindBy(css = "[role='menuitem']")
	private WebElement addNewClassButton;
	@FindBy(xpath = "//tbody/tr")
	private List<WebElement> tableRowsList;

	// Pagination and footer related elements
	@FindBy(xpath = "//p-paginator/div/span[contains(@class,'p-paginator-current')]")
	private WebElement datatablePaginationText;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]/span")
	private WebElement paginatorFirstButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-prev')]/span")
	private WebElement paginatorPreviousButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-next')]")
	private WebElement paginatorNextButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-last')]/span")
	private WebElement paginatorLastButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-page')]")
	private List<WebElement> paginatorPages;
	@FindBy(xpath = "//div[contains(@class,'p-datatable-footer')]/div")
	private WebElement datatableFooterText;

	// Class Details form related elements
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement classDetailsPopup;
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

	// Toast message related elements
	@FindBy(xpath = "//p-toastitem//div[contains(@class,'p-toast-detail')]")
	private WebElement successToastMessage;
	@FindBy(xpath = "//p-toastitem//div[contains(@class,'p-toast-summary')]")
	private WebElement successToastSummary;

	// date picker
	@FindBy(xpath = "//button[contains(@class,'p-datepicker-trigger')]")
	private WebElement calenderIcon;
	@FindBy(xpath = "//span[contains(@class,'p-datepicker-year')]")
	private WebElement calenderYear;
	@FindBy(xpath = "//span[contains(@class,'p-datepicker-month')]")
	private WebElement calenderMonth;
	@FindBy(className = "p-datepicker-next-icon")
	private WebElement datepickerNextIcon;
	@FindBy(xpath = "//table[contains(@class,'p-datepicker-calendar')]//td[not(contains(@class, 'p-datepicker-other-month'))]")
	private List<WebElement> calenderDateList;

	// Mandatory field error message
	@FindBy(xpath = "//label[text()='Batch Name']/following-sibling::small")
	private WebElement batchNameFieldErrorMessage;
	@FindBy(xpath = "//label[text()='Class Topic ']/following-sibling::small")
	private WebElement classTopicFieldErrorMessage;
	@FindBy(xpath = "//label[text()=' Select Class Dates ']/following-sibling::small")
	private WebElement classDatesFieldErrorMessage;
	@FindBy(xpath = "//label[text()='No of Classes']/following-sibling::small")
	private WebElement noOfClassesFieldErrorMessage;
	@FindBy(xpath = "//label[text()='Staff Name']/following-sibling::small")
	private WebElement staffNameFieldErrorMessage;
	@FindBy(xpath = "//div[contains(@class,'radio')]/following-sibling::small")
	private WebElement statusFieldErrorMessage;

	// Sort related elements
	@FindBy(xpath = "//tbody//td[2]")
	private List<WebElement> batchNameList;
	@FindBy(xpath = "//tbody//td[3]")
	private List<WebElement> classTopicList;
	@FindBy(xpath = "//tbody//td[4]")
	private List<WebElement> classDescriptionList;
	@FindBy(xpath = "//tbody//td[5]")
	private List<WebElement> statusList;
	@FindBy(xpath = "//tbody//td[6]")
	private List<WebElement> classDateList;
	@FindBy(xpath = "//tbody//td[7]")
	private List<WebElement> staffNameList;

	// Edit related elements
	@FindBy(xpath = "//tr[2]//button[@icon='pi pi-pencil']")
	private WebElement editIcon;

	// Delete class related elements
	@FindBy(xpath = "//tr[2]//button[@icon='pi pi-trash']")
	private WebElement deleteIcon;
	@FindBy(xpath = "//div[contains(@class,'p-confirm-dialog')]")
	private WebElement deleteConfirmDialogBox;
	@FindBy(xpath = "//div[contains(@class,'p-confirm-dialog')]//span[contains(@class,'p-dialog-title')]")
	private WebElement deleteConfirmDialogHeader;
	@FindBy(xpath = "//button[contains(@class,'p-confirm-dialog-accept')]")
	private WebElement deleteConfirmYesButton;
	@FindBy(xpath = "//button[contains(@class,'p-confirm-dialog-reject')]")
	private WebElement deleteConfirmNoButton;
	@FindBy(xpath = "//button[contains(@class,'p-dialog-header-close')]")
	private WebElement deleteConfirmCloseIcon;
	@FindBy(xpath = "//tbody/tr//div[@role='checkbox']")
	private List<WebElement> checkboxList;
	@FindBy(xpath = "//div[@class='box']//button[@icon='pi pi-trash']")
	private WebElement headerDeleteIcon;

	//
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

	// Sorting
	public WebElement checkSortIcon(String columnHeader) {
		for (WebElement header : datatableHeaders) {
			if (header.getText().equals(columnHeader)) {
				return header.findElement(By.tagName("p-sorticon")); // header.findElement(By.tagName("p-sorticon"));
			}
		}
		return null;
	}

	public void clickSortIcon(String columnHeader) {
		System.out.println("==========ColumnHeader from feature: " + columnHeader);
		for (WebElement header : datatableHeaders) {
			System.out.println("==========ColumnHeader from app: " + header.getText().trim());
			if (header.getText().trim().equals(columnHeader)) {
				WebElement sortIcon = header.findElement(By.xpath("p-sorticon/i"));
				js.executeScript("arguments[0].click();", sortIcon);
				break;
			}
		}
	}

	public boolean checkSortedAscending(String columnHeader) {
		switch (columnHeader.trim()) {
		case "Batch Name": {
			List<String> batchNames = batchNameList.stream().map(b -> b.getText().trim()).collect(Collectors.toList());
			List<String> sortedBatchNames = batchNames.stream().sorted().collect(Collectors.toList());

			if (batchNames.equals(sortedBatchNames)) {
				return true;
			}
			return false;
		}
		case "Class Topic": {
			List<String> classTopics = classTopicList.stream().map(b -> b.getText().trim())
					.collect(Collectors.toList());
			List<String> sortedClassTopics = classTopics.stream().sorted().collect(Collectors.toList());

			if (classTopics.equals(sortedClassTopics)) {
				return true;
			}
			return false;
		}

		case "Class Description": {
			List<String> classDescriptions = classDescriptionList.stream().map(b -> b.getText().trim())
					.collect(Collectors.toList());
			List<String> sortedClassDescriptions = classDescriptions.stream().sorted().collect(Collectors.toList());

			if (classDescriptions.equals(sortedClassDescriptions)) {
				return true;
			}
			return false;
		}
		case "Class Date": {
			List<String> classDates = classDateList.stream().map(b -> b.getText().trim()).collect(Collectors.toList());
			List<String> sortedClassDates = classDates.stream().sorted().collect(Collectors.toList());

			if (classDates.equals(sortedClassDates)) {
				return true;
			}
			return false;
		}
		case "Staff Name": {
			List<String> staffNames = staffNameList.stream().map(b -> b.getText().trim()).collect(Collectors.toList());
			List<String> sortedStaffNames = staffNames.stream().sorted().collect(Collectors.toList());

			if (staffNames.equals(sortedStaffNames)) {
				return true;
			}
			return false;
		}
		case "Status": {
			List<String> statusL = statusList.stream().map(b -> b.getText().trim()).collect(Collectors.toList());
			List<String> sortedStatus = statusL.stream().sorted().collect(Collectors.toList());

			if (statusL.equals(sortedStatus)) {
				return true;
			}
			return false;
		}
		default:
			return false;
		}
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (addNewClassButton.isDisplayed()) {
			addNewClassButton.click();
		} else {
			classLink.click();
			addNewClassButton.click();
		}
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
		return classDetailsPopup.isDisplayed();
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
		wait.until(ExpectedConditions.elementToBeClickable(batchNameDropdownIcon)).click();

		for (WebElement batchNameItem : batchNameDropdownItems) {
			if (batchNameItem.getText().equals(batchName)) {
				batchNameItem.click();
				break;
			}
		}

		// Enter class topic
		if (classTopic != null) {
			classTopicInput.sendKeys(classTopic);
		}

		// Enter class description
		if (classDescription != null) {
			classDescriptionInput.sendKeys(classDescription);
		}

		// Select class dates
		System.out.println("======================== > " + classDate);
		if (classDate != null && !classDate.isEmpty()) {
			// Open date picker
			js.executeScript("arguments[0].click();", calenderIcon);
			// calenderIcon.click();
			datePicker(classDate);

			// to close the date picker popup
			js.executeScript("document.body.click();");
		}

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// Select staff name from dropdown
		if (staffName != null) {
			staffNameDropdownIcon.click();
			for (WebElement staffNameItem : staffNameDropdownItems) {
				if (staffNameItem.getText().equals(staffName)) {
					staffNameItem.click();
					break;
				}
			}
		}

		// Select status radio button
		if (status != null) {
			statusRadioButtons.stream().filter(s -> s.getText().trim().equals(status))
					.forEach(s -> s.findElement(By.xpath("p-radiobutton/div/div[2]")).click());
		}
		// Enter class comments
		classCommentsInput.sendKeys(classComments);

		// Enter class notes
		classNotesInput.sendKeys(classNotes);

		// Enter class recordings
		classRecordingsInput.sendKeys(classRecordingPath);
	}

	// To check if input field text box is present
	public boolean isInputFieldPresent(String inputField) {
		switch (inputField.trim()) {
		case "Batch Name":
			return batchNameDropdownIcon.findElement(By.xpath("..")).isDisplayed();
		case "Class Topic":
			return classTopicInput.isDisplayed();
		case "Class Description":
			return classDescriptionInput.isDisplayed();
		case "Select Class Dates":
			return calenderIcon.findElement(By.xpath("..")).isDisplayed();
		case "No of Classes":
			return classNoInput.isDisplayed();
		case "Staff Name":
			return staffNameDropdownIcon.findElement(By.xpath("..")).isDisplayed();
		case "Status": {
			for (WebElement status : statusRadioButtons) {
				if (status.isDisplayed()) {
					return true;
				}
			}
			return false;
		}

		case "Comments":
			return classCommentsInput.isDisplayed();
		case "Notes":
			return classNotesInput.isDisplayed();
		case "Recording":
			return classRecordingsInput.isDisplayed();
		default:
			return false;
		}
	}

	// To check if input field label is present
	public boolean isInputFieldLabelPresent(String inputField) {
		switch (inputField.trim()) {
		case "Batch Name":
			return batchNameDropdownIcon.findElement(By.xpath("ancestor::p-dropdown/preceding-sibling::label"))
					.isDisplayed();
		case "Class Topic":
			return classTopicInput.findElement(By.xpath("preceding-sibling::label")).isDisplayed();
		case "Class Description":
			return classDescriptionInput.findElement(By.xpath("preceding-sibling::label")).isDisplayed();
		case "Select Class Dates":
			return calenderIcon.findElement(By.xpath("ancestor::p-calendar/preceding-sibling::label")).isDisplayed();
		case "No of Classes":
			return classNoInput.findElement(By.xpath("preceding-sibling::label")).isDisplayed();
		case "Staff Name":
			return staffNameDropdownIcon.findElement(By.xpath("ancestor::p-dropdown/preceding-sibling::label"))
					.isDisplayed();
		case "Status":
			return statusRadioButtons.get(0).findElement(By.xpath("preceding-sibling::div/lable")).isDisplayed();
		case "Comments":
			return classCommentsInput.findElement(By.xpath("preceding-sibling::label")).isDisplayed();
		case "Notes":
			return classNotesInput.findElement(By.xpath("preceding-sibling::label")).isDisplayed();
		case "Recording":
			return classRecordingsInput.findElement(By.xpath("preceding-sibling::label")).isDisplayed();
		default:
			return false;
		}
	}

	public void clickSaveButton() {
		js.executeScript("arguments[0].click();", saveButton);
		// saveButton.click();
	}

	public void clickCancelButton() {
		js.executeScript("arguments[0].click();", cancelButton);
		// cancelButton.click();
	}

	public void clickCloseIcon() {
		closeIcon.click();
	}

	// Toast messages related methods
	public String getSuccessToastMessage() {
		return successToastMessage.getText();
	}

	public String getSuccessToastSummary() {
		System.out.println("==========toast summary " + successToastSummary.getText());
		return successToastSummary.getText();
	}

	// To select Class Dates from date picker
	public void selectClassDates(String classDate) {
		wait.until(ExpectedConditions.elementToBeClickable(calenderIcon)).click();

		datePicker(classDate);
	}

	// To check if No of Classes field is auto-populated after dates selection
	public boolean isNoOfClassesPopulated() {
		if (classNoInput.getDomAttribute("class").contains("p-filled")) {
			return true;
		}
		return false;
	}

	// Mandatory fields error message
	public boolean isBatchNameFieldErrorMessageDisplayed() {
		if (batchNameFieldErrorMessage.getText().equals("Batch Name is required.")) {
			return true;
		}
		return false;
	}

	public boolean isClassTopicFieldErrorMessageDisplayed() {
		if (classTopicFieldErrorMessage.getText().equals("Class Topic is required.")) {
			return true;
		}
		return false;
	}

	public boolean isClassDatesFieldErrorMessageDisplayed() {
		if (classDatesFieldErrorMessage.getText().equals("Class Date is required.")) {
			return true;
		}
		return false;
	}

	public boolean isNoOfClassesFieldErrorMessageDisplayed() {
		if (noOfClassesFieldErrorMessage.getText().equals("No. of Classes is required.")) {
			return true;
		}
		return false;
	}

	public boolean isStaffNameFieldErrorMessageDisplayed() {
		if (staffNameFieldErrorMessage.getText().equals("Staff Name is required.")) {
			return true;
		}
		return false;
	}

	public boolean isStatusFieldErrorMessageDisplayed() {
		if (statusFieldErrorMessage.getText().equals("Status is required.")) {
			return true;
		}
		return false;
	}

	// To check Class Details Form is closed upon clicking Close/Cancel button
	public boolean isClassDetailsDialogClosed() {
		wait.until(ExpectedConditions.invisibilityOf(classDetailsPopup));
		return true;
	}

	// Edit related methods

	public void clickEditIcon() {
		js.executeScript("arguments[0].click();", editIcon);
	}

	public boolean isBatchNameFieldDisabled() {
		if (batchNameDropdownIcon.findElement(By.xpath("..")).getDomAttribute("class").contains("p-disabled")) {
			return true;
		}
		return false;
	}

	public boolean isClassTopicFieldDisabled() {
		if (classTopicInput.isEnabled()) {
			return false;
		}
		return true;
	}

	// to update class details in Edit form
	public void updateClassDetailsForm(String classDescription, String classDate, String staffName, String status,
			String classComments, String classNotes, String classRecordingPath) {

		// Enter class description
		if (classDescription != null) {
			classDescriptionInput.clear();
			classDescriptionInput.sendKeys(classDescription);
		}

		// Select class dates
		System.out.println("======================== > " + classDate);
		if (classDate != null && !classDate.isEmpty()) {
			// Open date picker
			js.executeScript("arguments[0].click();", calenderIcon);
			datePicker(classDate);
		}

		// Select staff name from dropdown
		try {
			if (staffName != null) {
				js.executeScript("arguments[0].click();", staffNameDropdownIcon);
				// staffNameDropdownIcon.click();
				for (WebElement staffNameItem : staffNameDropdownItems) {
					if (staffNameItem.getText().equals(staffName)) {
						staffNameItem.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// Select status radio button
		if (status != null) {
			statusRadioButtons.stream().filter(s -> s.getText().trim().equals(status))
					.forEach(s -> s.findElement(By.xpath("p-radiobutton/div/div[2]")).click());
		}
		// Enter class comments
		// classCommentsInput.clear();
		classCommentsInput.sendKeys(classComments);

		// Enter class notes
		// classNotesInput.clear();
		classNotesInput.sendKeys(classNotes);

		// Enter class recordings
		// classRecordingsInput.clear();
		classRecordingsInput.sendKeys(classRecordingPath);
	}

	// To get the list of class topics present in the table
	public List<String> getAllClassTopicsListed() {
		List<String> allClassTopics = new ArrayList<String>();
		while (true) {
			wait.until(ExpectedConditions.visibilityOfAllElements(classTopicList));
			List<String> classTopicsList = classTopicList.stream().map(c -> c.getText()).collect(Collectors.toList());
			allClassTopics.addAll(classTopicsList);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

			if (!paginatorNextButton.isEnabled()) {
				System.out.println("4");

				break;
			}

			js.executeScript("arguments[0].click();", paginatorNextButton);
		}
		return allClassTopics;
	}

	// Delete class related methods
	public void clickDeleteIconOnAnyRow() {
		js.executeScript("arguments[0].click();", deleteIcon);
	}

	public boolean isDeleteConfirmDialogBoxDisplayed() {
		if (deleteConfirmDialogBox.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean isDeleteConfirmYesButtonDisplayed() {
		if (deleteConfirmYesButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean isDeleteConfirmNoButtonDisplayed() {
		if (deleteConfirmNoButton.isDisplayed()) {
			return true;
		}
		return false;
	}

	public String getdeleteConfirmDialogHeader() {
		return deleteConfirmDialogHeader.getText();
	}

	public void clickDeleteConfirmYesButton() {
		js.executeScript("arguments[0].click();", deleteConfirmYesButton);
	}

	public void clickDeleteConfirmNoButton() {
		js.executeScript("arguments[0].click();", deleteConfirmNoButton);
	}

	public void clickDeleteConfirmCloseIcon() {
		js.executeScript("arguments[0].click();", deleteConfirmCloseIcon);
	}

	public String getClassTopicOfToBeDeletedClass() {
		String classTopic = deleteIcon.findElement(By.xpath("ancestor::td/preceding-sibling::td[5]")).getText();
		return classTopic;
	}

	public boolean isClassDeleted(String classTopicToBeDeleted) {
		List<String> allClassTopics = getAllClassTopicsListed();
		boolean classDeleted = allClassTopics.stream().noneMatch(topic -> topic.equals(classTopicToBeDeleted));

		return classDeleted;
	}

	public List<String> getClassTopicAndClickCheckbox(int noOfRows) {
		// checkboxList.stream().limit(noOfRows).forEach(checkbox ->
		// js.executeScript("arguments[0].click()", checkbox));
		List<String> classTopicsToBeDeleted = new ArrayList<String>();
		for (int i = 0; i < noOfRows; i++) {
			String classTopic = checkboxList.get(i).findElement(By.xpath("ancestor::td/following-sibling::td[2]"))
					.getText();
			classTopicsToBeDeleted.add(classTopic);
			js.executeScript("arguments[0].click()", checkboxList.get(i));
			// checkboxList.get(i).click();
		}
		return classTopicsToBeDeleted;
	}

	public void clickCheckBox(int noOfRows) {

	}

	public boolean isMultipleClassesDeleted(List<String> classTopicsToBeDeleted) {
		List<String> allClassTopics = getAllClassTopicsListed();
		boolean classDeleted = classTopicsToBeDeleted.stream().noneMatch(topic -> allClassTopics.contains(topic));
		System.out.println("================classDeleted " + classDeleted);
		System.out.println("================classTopicsToBeDeleted " + classTopicsToBeDeleted);

		return classDeleted;
	}

	public boolean isHeaderDeleteIconEnabled() {
		if (headerDeleteIcon.isEnabled()) {
			return true;
		}
		return false;
	}

	public void clickHeaderDeleteIcon() {
		js.executeScript("arguments[0].click()", headerDeleteIcon);
	}

	// Search related methods
	public void enterSearchText(String input) {
		int initialRowCount = tableRowsList.size(); // Initial row count
		searchBox.sendKeys(input);

		// Wait for the number of rows to change after the input
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until((WebDriver driver) -> {
			int updatedRowCount = tableRowsList.size();
			return initialRowCount != updatedRowCount;
		});
	}

	public boolean areClassDetailsFilteredByValidSearchText(String input) {

		System.out.println("=======showing " + datatablePaginationText.getText());

		if (!datatablePaginationText.getText().equals("Showing 0 to 0 of 0 entries")) {

			for (WebElement eachRow : tableRowsList) {
				String batchName = eachRow.findElement(By.xpath("td[2]")).getText();
				String classTopic = eachRow.findElement(By.xpath("td[3]")).getText();
				String staffName = eachRow.findElement(By.xpath("td[7]")).getText();

				System.out.println("===========batchName " + batchName.toLowerCase());
				System.out.println("===========classTopic " + classTopic.toLowerCase());
				System.out.println("===========staffName " + staffName.toLowerCase());

				if (!(batchName.toLowerCase().contains(input) || classTopic.toLowerCase().contains(input)
						|| staffName.toLowerCase().contains(input))) {
					return false;
				}
			}
		} else {
			return false;
		}

		// If all rows matched, return true
		return true;
	}

	// Date picker logic to select date from calender
	public void datePicker(String classDate) {
		System.out.println("====================================== " + classDate);
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

		// Select month and year
		while (true) {
			if (calenderYear.getText().equals(year) && calenderMonth.getText().equals(monthName)) {
				break;
			}
			datepickerNextIcon.click();
		}

		// Select date from calender
		if (calenderDateList.isEmpty()) {
			System.out.println("No calendar dates found.");
		} else {
			for (WebElement calenderDate : calenderDateList) {
				if (calenderDate.getText().equals(date)) {
					calenderDate.click();
					break;
				}
			}
		}
	}

}
