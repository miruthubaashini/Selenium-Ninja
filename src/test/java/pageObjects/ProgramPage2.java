package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ExcelReader;

public class ProgramPage2 {

	private WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;

	public ProgramPage2(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
		dataSetup();
	}

	// data=driven setup
	String deleteSingleData = "";
	String[] delMultiData = new String[2];
	String searchData = "";
	String[] editData = new String[3];
	String[] addData;

	// search
	@FindBy(xpath = "//span[normalize-space()='Program']")
	private WebElement menuBarProgram;
	@FindBy(xpath = "//div[normalize-space()='Programs']")
	private WebElement bodyProgram;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement searchProgram;
	@FindBy(xpath = "//tbody")
	private WebElement searchTable;
	@FindBy(xpath = "//tbody//tr")
	private List<WebElement> searchTableRows;
	@FindBy(xpath = "//p-paginator/div/span[contains(@class,'p-paginator-current')]")
	private WebElement countText;
	@FindBy(xpath = "//app-batch/p-confirmdialog")
	WebElement deleteProgramPopupWindow;

	// delete
	@FindBy(xpath = "//div[@class='p-toast-summary ng-tns-c20-11']")
	private WebElement alertBox;
	@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c118-10 ng-star-inserted']")
	private WebElement delConfirmText;
	@FindBy(xpath = "//app-batch/p-confirmdialog/div/div/div[1]/div/button")
	WebElement deleteprogramConfirmCloseIcon;
	@FindBy(xpath = "//mat-card-title/div[2]/div[1]/button")
	WebElement deleteButtonMultiple;
	@FindBy(xpath = "//div[contains(@class, 'p-confirm-dialog')]")
	private WebElement delConfirmBox;
	By delConfirmBoxX = By.xpath("//div[contains(@class, 'p-confirm-dialog')]");

	// Delete Multiple
	String xpathValue = "//td[(text()='" + deleteSingleData + "')]";
	String xpathValueDel = "//td[(text()='" + deleteSingleData
			+ "')]/following-sibling::td//button[@id='deleteProgram']";
	String xpathValueDelNo = "//button[@class='ng-tns-c118-10 p-confirm-dialog-reject p-ripple p-button p-component ng-star-inserted']";
	String xpathValueDelYes = "//button[@class='ng-tns-c118-10 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']";
	@FindBy(xpath = "//p-dialog[1]/div/div")
	WebElement addProgramPopupWindow;
	
	String xpathDelX = "//button[contains(@class,'p-dialog-header-close')]";
	
	
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
	@FindBy(xpath = "//tr[1]//button[@icon='pi pi-trash']")
	private WebElement deleteIcon;

	// Pagination
	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]")
	private WebElement paginatorFirstButton;

	@FindBy(xpath = "//button[contains(@class,'p-paginator-prev')]")
	private WebElement paginatorPreviousButton;

	@FindBy(xpath = "//button[contains(@class,'p-paginator-next')]")
	private WebElement paginatorNextButton;

	@FindBy(xpath = "//p-paginator/div/span[2]/button[2]")
	private WebElement nextEnabledButton;

	@FindBy(xpath = "//button[contains(@class,'p-paginator-last')]")
	private WebElement paginatorLastButton;

	// sorting
	@FindBy(xpath = "//tbody//td[2]")
	private List<WebElement> programList;

	@FindBy(xpath = "//tbody//td[3]")
	private List<WebElement> programDescriptionList;

	@FindBy(xpath = "//tbody//td[4]")
	private List<WebElement> programStatusList;

	@FindBy(xpath = "//th[@psortablecolumn='programName']//p-sorticon//i")
	private WebElement programNameSort;

	@FindBy(xpath = "//th[@psortablecolumn='programDescription']//p-sorticon//i")
	private WebElement programDescriptionSort;

	@FindBy(xpath = "//th[@psortablecolumn='programStatus']//p-sorticon//i")
	private WebElement programStatusSort;
	@FindBy(xpath = "//tr/th")
	private List<WebElement> datatableHeaders;

	// Edit Program
	@FindBy(xpath = "//input[@id='programName']")
	private WebElement programNameInput;
	@FindBy(xpath = "//input[@id='programDescription']")
	private WebElement programDescriptionInput;
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement programDetailsPopup;
	@FindBy(css = "[label='Cancel']")
	private WebElement cancelButton;
	@FindBy(css = "[label='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//span[contains(@class,'p-dialog-header-close-icon')]")
	private WebElement closeIcon;
	@FindBy(xpath = "//input[@id='programDescription']")
	private WebElement programDescInput;

	@FindBy(xpath = "//div[@class='radio ng-star-inserted']/div[@class='ng-star-inserted']")
	private List<WebElement> statusRadioButtons;
	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[2]/div[4]/div[3]/p-radiobutton")
	WebElement addBatchStatusInactive;
	@FindBy(xpath = "//span[@id='pr_id_3-label']")
	private WebElement programPopUpTitle;
	@FindBy(xpath = "//label[@for='programName']/span[@style='color: red !important;']")
	private WebElement nameMandatoryIcon;
	@FindBy(xpath = "//p-radiobutton[@name='category']//input[@id='Active']")
	private WebElement activeRadioButton;
	@FindBy(xpath = "//p-radiobutton[@name='category']//input[@id='Inactive']")
	private WebElement inActiveRadioButton;
	@FindBy(xpath = "//tbody/tr//div[@role='checkbox']")
	private List<WebElement> checkboxList;
	@FindBy(xpath = "//div[@class='box']//button[@icon='pi pi-trash']")
	private WebElement headerDeleteIcon;
	
	//
	public boolean pagination(int page) {
		try {
			WebElement pageButton = driver.findElement(By.xpath("//button[text()='" + page + "']"));
			if(pageButton.isEnabled()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", pageButton);
			wait.until(ExpectedConditions.elementToBeClickable(pageButton));
			pageButton.click();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	public void clickYesDelete() {
		driver.findElement(By.xpath(xpathValueDelYes)).click();
	}

	public void clickNoDelete() {
		driver.findElement(By.xpath(xpathValueDelNo)).click();
	}

	public void clickXDelete() {
		driver.findElement(By.xpath(xpathDelX)).click();
	}
//
	public boolean isDialogDisappeared(By dialogLocator) {
		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(dialogLocator));
		} catch (Exception e) {
			return true;
		}
	}
//
	public boolean isDialogDisapearTrue() {
		boolean flag = false;
		if (isDialogDisappeared(delConfirmBoxX)) {
			flag = true;
		}
		return flag;
	}
//
	public boolean isDeleteConfirmationVisible() {
		return delConfirmText.getText().equalsIgnoreCase("Confirm");
	}
//
	public boolean isDeleteMultipleVisible() {
		return deleteButtonMultiple.isEnabled();
	}
//
	public void clickDeleteMultiple() {
		deleteButtonMultiple.click();
	}

	//
	public void selectSingleDelete() {	
		CallDeleteData(deleteSingleData);
			js.executeScript("arguments[0].click();", deleteIcon);
	}
	
	//delete multiple recent
	public List<String> selectCheckBoxMultiple() {		
		List<String> programToBeDeleted=searchAndClickCheckboxForProgram(2);
		return programToBeDeleted;
	}
	//
	public void clickHeaderDeleteIcon() {
		js.executeScript("arguments[0].click()", headerDeleteIcon);
	}
	//
	public void clickDialogDeleteIcon() {
		js.executeScript("arguments[0].click()", deleteConfirmCloseIcon);
	}
	
	//
	public List<String> searchAndClickCheckboxForProgram(int noOfRows) {
		// checkboxList.stream().limit(noOfRows).forEach(checkbox ->
		// js.executeScript("arguments[0].click()", checkbox));
		List<String> programToBeDeleted = new ArrayList<String>();
		for (int i = 0; i < noOfRows; i++) {
			String programNames = checkboxList.get(i).findElement(By.xpath("ancestor::td/following-sibling::td[1]"))
					.getText();
			programToBeDeleted.add(programNames);
			js.executeScript("arguments[0].click()", checkboxList.get(i));
			// checkboxList.get(i).click();
		}
		return programToBeDeleted;
	}
	//
	public boolean isprogramDeleted(List<String> programForDeletion) {
		List<String> allProgramList = getAllProgramListed();
		Set<String> delMultiDataSet = new HashSet<>(Arrays.asList(delMultiData));
		boolean programDeleted = allProgramList.stream().noneMatch(topic -> delMultiDataSet.contains(topic));
		return programDeleted;
	}
	
	//
	public List<String> getAllProgramListed() {
		List<String> allProgramList = new ArrayList<String>();
		while (true) {
			wait.until(ExpectedConditions.visibilityOfAllElements(programList));
			List<String> pList = programList.stream().map(c -> c.getText()).collect(Collectors.toList());
			System.out.println(pList);
			allProgramList.addAll(pList);
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			if (!paginatorNextButton.isEnabled()) {
				break;
			}
			js.executeScript("arguments[0].click();", paginatorNextButton);
		}
		return allProgramList;
	}

	
	
//
	public void clickSortIcon(String columnHeader) {
		for (WebElement header : datatableHeaders) {
			if (header.getText().trim().equals(columnHeader)) {
				WebElement sortIcon = header.findElement(By.xpath("p-sorticon/i"));
				js.executeScript("arguments[0].click();", sortIcon);
				break;
			}
		}
	}
//
	public void clickProgramButton() {
		bodyProgram.click();
	}
//
	public void searchProgram() {
		searchProgram.clear();
		searchProgram.sendKeys(searchData);
	}
	//
	public void searchEditProgram() {
		searchProgram.clear();
		String searchEditedData = editData[0] + " " + "test";
		searchProgram.sendKeys(searchEditedData);
	}

	//
	public List<WebElement> getSearchElement() {
		List<WebElement> elements = searchTable
				.findElements(By.xpath("//tr[td[contains(text(), '" + searchData + "')]]"));
		return elements;
	}
//
	public String getCountMsg() {		
		String countMsg = countText.getText();
		return countMsg;
	}

	//
	public boolean isDeleteConfirmDialogBoxDisplayed() {
		if (deleteConfirmDialogBox.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	//
	public boolean deleteSuccessDialogCheck(String type) {
		boolean setResult = false;
	if (type.equalsIgnoreCase("Yes")) {
		System.out.println("in yes click");
		searchTable.findElement(By.xpath(xpathValueDelYes)).click();
		System.out.println("came out yes");
		String alertTxt = alertBox.getText();
		if (alertTxt.equalsIgnoreCase("Successful")) {
			setResult = true;
		}
	}
		return setResult;
	
	}
	
	

	// pagination
	public boolean isPreviousPage() {
		return paginatorPreviousButton.isDisplayed();
	}
//
	public boolean isNextEnabled() {
		return paginatorNextButton.isEnabled();
	}
	//
	public void CallEditData() {
		searchProgram.clear();
		searchProgram.sendKeys(searchData);
	}
	//
	public void CallDeleteData(String value) {
		searchProgram.clear();
		searchProgram.sendKeys(value);
	}
	//
	public void searchDeleteData() {
		searchProgram.clear();
		searchProgram.sendKeys(deleteSingleData);
	}
	//
	public void clickPreviousPage() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paginatorPreviousButton);
		wait.until(ExpectedConditions.elementToBeClickable(paginatorPreviousButton));
		paginatorPreviousButton.click();
	}
//
	public void clickNextPage() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paginatorNextButton);
		wait.until(ExpectedConditions.elementToBeClickable(paginatorNextButton));
		paginatorNextButton.click();
	}
//
	public void clickLastPage() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", paginatorLastButton);
		wait.until(ExpectedConditions.elementToBeClickable(paginatorLastButton));
		paginatorLastButton.click();
	}

	
	//
	public boolean isExpected() {
		return (driver.getTitle().equalsIgnoreCase("LMS"));
	}

	
//
	public void dataSetup() {
		try {
			ExcelReader rdr = new ExcelReader();
			LinkedHashMap<String, String> searchDataMap = rdr.getTestData("Program2", 3);
			searchData = searchDataMap.get("program_name");

			LinkedHashMap<String, String> deleteSingleDataMap = rdr.getTestData("Program2", 4);
			deleteSingleData = deleteSingleDataMap.get("program_name");

			LinkedHashMap<String, String> editDataMap = rdr.getTestData("Program2", 2);
			editData = new String[] { editDataMap.get("program_name"), editDataMap.get("program_descption"),
					editDataMap.get("status") };


			LinkedHashMap<String, String> deleteMultipleDataMap = rdr.getTestData("Program2", 6);
			delMultiData = new String[] { deleteMultipleDataMap.get("program_name"),
					deleteMultipleDataMap.get("program_descption") };

		} catch (IOException e) {

		}
	}
//
	public boolean checkSortedAscending(String columnHeader) {
		switch (columnHeader.trim()) {
		case "{Program Name": {
			List<String> programNames = programList.stream().map(b -> b.getText().trim()).collect(Collectors.toList());
			List<String> sortedProgramNames = programNames.stream().sorted().collect(Collectors.toList());

			if (programNames.equals(sortedProgramNames)) {
				return true;
			}
			return false;
		}
		case "Program Description": {
			List<String> despList = programDescriptionList.stream().map(b -> b.getText().trim())
					.collect(Collectors.toList());
			List<String> sortedDesp = despList.stream().sorted().collect(Collectors.toList());

			if (despList.equals(sortedDesp)) {
				return true;
			}
			return false;
		}

		case "Program Status": {
			List<String> statusList = programStatusList.stream().map(b -> b.getText().trim())
					.collect(Collectors.toList());
			List<String> sortedStatus = statusList.stream().sorted().collect(Collectors.toList());

			if (statusList.equals(sortedStatus)) {
				return true;
			}
			return false;
		}

		default:
			return false;
		}
	}


//
	public boolean isProgramPopupDisplayed() {
		return programDetailsPopup.isDisplayed();
	}
//
	public boolean programPopupNameCheck() {
		String popTitle = programPopUpTitle.getText();
		return popTitle.equalsIgnoreCase("Program Details");
	}
	
//
	public void programNameInput(String type) {
		String updateProgramNameTxt = editData[0] + " " + "test";
		programNameInput.clear();
		programNameInput.sendKeys(updateProgramNameTxt);
		if(type.equalsIgnoreCase("SAVE"))
		{
		saveButton.click();
		}
		if(type.equalsIgnoreCase("CANCEL"))
		{
		cancelButton.click();
		}
		if(type.equalsIgnoreCase("CLOSE"))
		{
		closeIcon.click();
		}
	}
	//
	public void dataSelectProgramEditNavigation() {
		CallEditData();
		String xpathValueEdit = "//td[(text()='" + editData[0] + "')]/following-sibling::td//button[@id='editProgram']";
		String xpathValueEditInPage = "//td[(text()='" + editData[0] + "')]";
		int pagetotal = 1;
		for (int p = 1; p <=pagetotal; p++) {
			try {
				WebElement searchElement = searchTable.findElement(By.xpath(xpathValueEditInPage));
				if (searchElement.isDisplayed()) {
					searchTable.findElement(By.xpath(xpathValueEdit)).click();
				}
			} catch (Exception e) {

			}
		}
			
		}
	//	
		public void dataSelectProgramEditStatusNavigation() {
			CallEditData();
			String xpathValueEdit = "//td[(text()='" + editData[0] + " " +"test"+"')]/following-sibling::td//button[@id='editProgram']";
			String xpathValueEditInPage = "//td[(text()='" + editData[0] + " " +"test"+ "')]";
			int pagetotal = 1;
			for (int p = 1; p <=pagetotal; p++) {
				try {
					WebElement searchElement = searchTable.findElement(By.xpath(xpathValueEditInPage));
					if (searchElement.isDisplayed()) {
						searchTable.findElement(By.xpath(xpathValueEdit)).click();
					}
				} catch (Exception e) {

				}
			}
	}

	public void programDespInput() {
		String updateProgramDespTxt = editData[1] + " " + "test";
		programDescriptionInput.clear();
		programDescriptionInput.sendKeys(updateProgramDespTxt);
		saveButton.click();
	}
//
	public void programStatusInput() {
		String updateProgramStatusTxt = editData[2]+" "+ "test";
		if (updateProgramStatusTxt.equalsIgnoreCase("Active")) {
			js.executeScript("arguments[0].click();", activeRadioButton);
		}
		if (updateProgramStatusTxt.equalsIgnoreCase("InActive")) {
			js.executeScript("arguments[0].click();", inActiveRadioButton);
		}
		saveButton.click();
	}
	
	//program name update
	public boolean checkProgramNameInputUpdated() {
		boolean isUpdated = false;
		String updateProgramNameTxt = editData[0] + " " + "test";
		try {
			String xpathValueEditInPage = "//td[(text()='" + updateProgramNameTxt + "')]";
			WebElement searchElement = searchTable.findElement(By.xpath(xpathValueEditInPage));
			if (searchElement.isDisplayed()) {
				isUpdated = true;
			}
		} catch (Exception e) {

		}
		return isUpdated;
	}
	
	
//program description update
	public boolean checkProgramDespInputUpdated() {
		boolean isUpdated = false;
		String updateProgramDespTxt = editData[1] + " " + "test";
		try {
			String xpathValueEditInPage = "//td[(text()='" + updateProgramDespTxt + "')]";
			System.out.println(xpathValueEditInPage);
			WebElement searchElement = searchTable.findElement(By.xpath(xpathValueEditInPage));
			System.out.println(searchElement.getText());
			if (searchElement.isDisplayed()) {
				isUpdated = true;
			}
		} catch (Exception e) {

		}
		return isUpdated;
	}
	
	public boolean checkProgramStatusInputUpdated() {
		boolean isUpdated = false;
		String updateProgramStatusTxt = editData[2] ;
		try {
			String xpathValueEditInPage = "//td[(text()='" + updateProgramStatusTxt + "')]";
			System.out.println(xpathValueEditInPage);
			WebElement searchElement = searchTable.findElement(By.xpath(xpathValueEditInPage));
			System.out.println(searchElement.getText());
			if (searchElement.isDisplayed()) {
				isUpdated = true;
			}
		} catch (Exception e) {

		}
		return isUpdated;
	}
	
	public void deleteSingleProgram() {
		CallEditData();
		String xpathValueEdit = "//td[(text()='" + editData[0] + "')]/following-sibling::td//button[@id='editProgram']";
		String xpathValueEditInPage = "//td[(text()='" + editData[0] + "')]";
		int pagetotal = 1;
		for (int p = 1; p <=pagetotal; p++) {
			try {
				System.out.println("entering for loop");
				System.out.println("xpathValueEdit");
				System.out.println("xpathValueEditInPage");
				WebElement searchElement = searchTable.findElement(By.xpath(xpathValueEditInPage));
				System.out.println(searchElement.getText());
				if (searchElement.isDisplayed()) {
					searchTable.findElement(By.xpath(xpathValueEdit)).click();
					System.out.println("edit button clicked");
				}
			} catch (Exception e) {

			}
		}
			
		}
}