package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BatchPage extends BasePage {

	public BatchPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"logout\"]") 
	WebElement logoutButton;

	@FindBy(xpath = "//span[text()='Class']")
	WebElement classLink;

	@FindBy(xpath = "//button[contains(@class,'mat-menu-item')]")
	WebElement subMenuLink;

	@FindBy(xpath = "//mat-card-title/div[2]/div[1]/button")
	WebElement deleteButton;

	@FindBy(className = "p-input-icon-left") // *[@id="filterGlobal"]
	WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"dashboard\"]")
	WebElement homeMenuLink;

	@FindBy(xpath = "//*[@id=\"program\"]")
	WebElement program;

	@FindBy(xpath = "//app-header/mat-toolbar/div/button[3]")
	WebElement batchMenuLink;

	@FindBy(xpath = "//app-header/mat-toolbar/span[1]")
	WebElement pageTitle;

	@FindBy(xpath = "//app-batch/div/mat-card/mat-card-title/div[1]")
	WebElement pageHeading;
	
	@FindBy(xpath = "//mat-card/mat-card-title/div[2]/div[1]/button[contains(@icon, 'pi pi-trash')]")
	WebElement disabledDeleteIcon;
	
	@FindBy(xpath = "//p-dialog[1]/div/div")
	WebElement addBatchPopupWindow;
	
	@FindBy(xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
	WebElement addNewBatch;

	// Add batch popup related elements
	@FindBy(xpath = "//*[@id=\"programName\"]")
	WebElement addBatchProgramName;

	@FindBy(xpath = "//input[@id=\"batchProg\"]")
	WebElement addBatchNamePrefix;
	
	@FindBy(xpath = "//input[@id=\"batchName\"]")
	WebElement addBatchNameSuffix;
	
	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[2]/div[2]/small")
	WebElement addBatchNameSuffixError;
	
	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[2]/div[3]/small")
	WebElement addBatchDescriptionError;

	@FindBy(xpath = "//input[@id=\"batchDescription\"]")
	WebElement addBatchDescription;
	
	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[2]/div[4]/div[2]/p-radiobutton")
	WebElement addBatchStatusActive;

	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[2]/div[4]/div[3]/p-radiobutton")
	WebElement addBatchStatusInactive;

	@FindBy(xpath = "//*[@id=\"batchNoOfClasses\"]")
	WebElement addBatchNumberOfClasses;

	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[3]/button[1]")
	WebElement addBatchCancelButton;

	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[3]/button[2]")
	WebElement addBatchSaveButton;
	
	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[2]/span")
	WebElement programNameDropDown;
	
	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[1]/li/span")
	WebElement programNameDropDownFirstItem;
	
	@FindBy(xpath = "//p-toastitem/div/div/div/div[2]")
	WebElement addBatchSaveMessage;
	
	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div/div[1]/div/button/span")
	WebElement addBatchCloseIcon;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/div/span[1]")
	WebElement firstRowEditIcon;
	
	@FindBy(xpath = "//table/tbody/tr[1]/td[7]/div/span[2]")
	WebElement firstRowDeleteIcon;
	
	@FindBy(xpath = "//app-batch/p-dialog[1]/div/div")
	WebElement editBatchPopupWindow;
	
	@FindBy(xpath = "//app-batch/p-confirmdialog")
	WebElement deleteBatchPopupWindow;
	
	@FindBy(xpath = "//app-batch/p-confirmdialog/div/div/div[3]/button[2]")
	WebElement deleteBatchConfirmYes;
	
	@FindBy(xpath = "//app-batch/p-confirmdialog/div/div/div[3]/button[1]")
	WebElement deleteBatchConfirmNo;
	
	@FindBy(xpath = "//app-batch/p-confirmdialog/div/div/div[1]/div/button")
	WebElement deleteBatchConfirmCloseIcon;
	
	@FindBy(xpath = "//app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div")
	WebElement firstRowCheckbox;
	
	@FindBy(xpath = "//app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div")
	WebElement secondRowCheckbox;
	

	// Pagination and footer related objects

	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]")
	private WebElement paginatorFirstButton;
	
	@FindBy(xpath = "//button[contains(@class,'p-paginator-prev')]")
	private WebElement paginatorPreviousButton;
	
	@FindBy(xpath = "//button[contains(@class,'p-paginator-next')]")
	private WebElement paginatorNextButton;
	
	@FindBy(xpath ="//p-paginator/div/span[2]/button[2]")
	private WebElement nextEnabledButton;
	
	@FindBy(xpath = "//button[contains(@class,'p-paginator-last')]")
	private WebElement paginatorLastButton;

	public WebElement classSearchBox() {
		return searchBox;
	}

	public boolean isDeleteButtonVisible() {
		return deleteButton.isDisplayed();
	}
	public boolean isAddBatchPopupWindowVisible() {
		return addBatchPopupWindow.isDisplayed();
	}

	public void clickDeleteButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(deleteButton).moveByOffset(10, 10).click().perform();
	}
	
	
	public void clickNextPageLinkButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(paginatorNextButton).moveByOffset(10, 10).click().perform();
	}
	
	public void clickLastPageLinkButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(paginatorLastButton).moveByOffset(10, 10).click().perform();
	}
	
	public void clickLogoutButton() {
		waitUntilElementIsClickableAndClick(logoutButton);
	}

	// Pagination
	public boolean isPaginationFirstButtonDisplayed() {
		return paginatorFirstButton.isDisplayed();
	}

	public boolean isPaginationPreviousButtonDisplayed() {
		return paginatorPreviousButton.isDisplayed();
	}

	public boolean isPaginationNextButtonDisplayed() {
		return paginatorNextButton.isDisplayed();
	}

	public boolean isPaginationLastButtonDisplayed() {
		return paginatorLastButton.isDisplayed();
	}

	public void clickHomeMenuLink() {
		waitUntilElementIsClickableAndClick(homeMenuLink);
	}

	public void clickBatchMenuLink() {
		waitUntilElementIsClickableAndClick(batchMenuLink);

		waitForMillis(1000);
	}
	
	public void clickAddNewBatch() {
		waitUntilElementIsClickableAndClick(addNewBatch);
	}
	
	public String getSubMenuText() {
		waitUntilElementIsClickable(subMenuLink);
		return subMenuLink.getText();
	}

	public String getPageTitle() {
		waitUntilElementIsClickable(pageTitle);
		return pageTitle.getText();
	}

	public String getPageHeading() {
		waitUntilElementIsClickable(pageHeading);
		return pageHeading.getText();
	}

	public boolean isDisabledDeleteIconDisplayed() {
		return disabledDeleteIcon.isDisplayed();
	}

	public boolean areEditIconsDisplayed() {
		for(int i = 0; i < 10; i++) {
			WebElement editIcon = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[7]/div/span[1]/button[contains(@icon, 'pi pi-pencil')]"));

			if(!editIcon.isDisplayed()) {
				return false;
			}
		}
		
		return true;
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

	public boolean areCheckboxesDisplayed() {
		for(int i = 0; i < 10; i++) {
			WebElement checkbox = driver.findElement(By.xpath("//table/tbody/tr[" + (i + 1) + "]/td[1]/p-tablecheckbox/div/div[2][@role='checkbox']"));
			if(!checkbox.isDisplayed()) {
				return false;
			}
		}

		return true;
	}

	public String getTableHeaderText(int column) {
		return driver.findElement(By.xpath("//p-table/div/div[1]/table/thead/tr/th[" + column + "]")).getText();
	}

	public boolean isTableHeaderCheckboxDisplayed() {
		return driver.findElement(By.xpath("//p-table/div/div[1]/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2][@role='checkbox']")).isDisplayed();
	}

	public boolean isTableHeaderSortIconDisplayed(int column) {
		return driver.findElement(By.xpath("//p-table/div/div[1]/table/thead/tr/th[" + column + "]/p-sorticon")).isDisplayed();
	}

	public boolean isAddBatchProgramNameDisplayed() {
		return addBatchProgramName.isDisplayed();
	}

	public boolean isAddBatchNamePrefixDisplayed() {
		return addBatchNamePrefix.isDisplayed();
	}

	public boolean isAddBatchNameSuffixDisplayed() {
		return addBatchNameSuffix.isDisplayed();
	}

	public boolean isAddBatchDescriptionDisplayed() {
		return addBatchDescription.isDisplayed();
	}

	public boolean isAddBatchStatusActiveDisplayed() {
		return addBatchStatusActive.isDisplayed();
	}

	public boolean isAddBatchStatusInactiveDisplayed() {
		return addBatchStatusInactive.isDisplayed();
	}

	public boolean isAddBatchNumberOfClassesDisplayed() {
		return addBatchNumberOfClasses.isDisplayed();
	}

	public boolean isAddBatchCancelButtonDisplayed() {
		return addBatchCancelButton.isDisplayed();
	}

	public boolean isAddBatchSaveButtonDisplayed() {
		return addBatchSaveButton.isDisplayed();
	}

	public void clickProgramNameDropDownFirstItem() {
		waitUntilElementIsClickableAndClick(programNameDropDown);
		waitUntilElementIsClickableAndClick(programNameDropDownFirstItem);
	}
	
	public void selectedProgramNameIsDisplayedInPrefix() {
		String actualProgramName = programNameDropDown.getText();	
		String expectedProgramName = addBatchNamePrefix.getText();
		
		Assert.assertEquals(actualProgramName, expectedProgramName);
	}
	
	public void enterTextInBatchNameSuffix(String text) {
		waitUntilElementIsClickable(addBatchNameSuffix);
		addBatchNameSuffix.sendKeys(text);
	}
	
	public String getBatchNameSuffixError() {
		waitUntilElementIsClickable(addBatchNameSuffixError);
		return addBatchNameSuffixError.getText();
	}
	
	public String getBatchDescriptionError() {
		waitUntilElementIsClickable(addBatchDescriptionError);
		return addBatchDescriptionError.getText();
	}
	
	public void enterTextInBatchNamePrefix(String text) {
		waitUntilElementIsClickable(addBatchNamePrefix);
		addBatchNamePrefix.sendKeys(text);
	}
	
	public String getTextInBatchNamePrefix() {
		waitUntilElementIsClickableAndClick(addBatchNamePrefix);
		return addBatchNamePrefix.getText();
	}
	
	public void clearTextInBatchDescription() {
		waitUntilElementIsClickable(addBatchDescription);
		addBatchDescription.clear();
	}
	
	public void enterTextInBatchDescription(String text) {
		waitUntilElementIsClickable(addBatchDescription);
		addBatchDescription.sendKeys(text);
	}
	
	public void setBatchActiveStatus(boolean active) {
		if(active) {
			waitUntilElementIsClickableAndClick(addBatchStatusActive);
		} else {
			waitUntilElementIsClickableAndClick(addBatchStatusInactive);
		}
	}
	
	public void enterTextInBatchNumberOfClasses(String text) {
		waitUntilElementIsClickable(addBatchNumberOfClasses);
		addBatchNumberOfClasses.sendKeys(text);
	}

	public void clickAddBatchSaveButton() {
		waitUntilElementIsClickableAndClick(addBatchSaveButton);
	}

	public void clickAddBatchCancelButton() {
		waitUntilElementIsClickableAndClick(addBatchCancelButton);
	}

	public String getAddBatchSaveMessage() {
		waitUntilElementIsClickable(addBatchSaveMessage);
		return addBatchSaveMessage.getText();
	}

	public void clickAddBatchCloseIcon() {
		waitUntilElementIsClickableAndClick(addBatchCloseIcon);
	}

	public void clickFirstRowEditIcon() {
		Actions actions = new Actions(driver);
		actions.moveToElement(firstRowEditIcon).moveByOffset(10, 10).click().perform();
		waitUntilElementIsClickableAndClick(firstRowEditIcon);
	}

	public void clickFirstRowDeleteIcon() {
		Actions actions = new Actions(driver);
		actions.moveToElement(firstRowDeleteIcon).moveByOffset(10, 10).click().perform();
		waitUntilElementIsClickableAndClick(firstRowDeleteIcon);
	}

	public void clickFirstRowCheckbox() {
		Actions actions = new Actions(driver);
		actions.moveToElement(firstRowCheckbox).moveByOffset(5, 5).click().perform();
		waitUntilElementIsClickableAndClick(firstRowCheckbox);
	}

	public void clickSecondRowCheckbox() {
		Actions actions = new Actions(driver);
		actions.moveToElement(secondRowCheckbox).moveByOffset(5, 5).click().perform();
	}

	public boolean isEditBatchPopupWindowVisible() {
		return editBatchPopupWindow.isDisplayed();
	}

	public boolean isDeleteBatchPopupWindowVisible() {
		return deleteBatchPopupWindow.isDisplayed();
	}

	public boolean isDeleteBatchPopupButtonsVisible() {
		waitUntilElementIsClickable(deleteBatchConfirmNo);
		waitUntilElementIsClickable(deleteBatchConfirmYes);
		
		return deleteBatchConfirmNo.isDisplayed() 
				&& deleteBatchConfirmYes.isDisplayed();
	}

	public void clickBatchPopupYesButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(deleteBatchConfirmYes).moveByOffset(10, 10).click().perform();
	}

	public void clickBatchPopupNoButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(deleteBatchConfirmNo).moveByOffset(10, 10).click().perform();
	}

	public void clickConfirmAlertCloseIcon() {
		waitUntilElementIsClickableAndClick(deleteBatchConfirmCloseIcon);
	}
	

	public boolean isEditBatchProgramNameDisabledForEditing() {
		String before = addBatchProgramName.getText();
		
		try {
			addBatchProgramName.sendKeys("abcd");
		} catch (ElementNotInteractableException e) {
			return true;
		}
		
		String after = addBatchProgramName.getText();
		return before.equals(after);
	}

	public boolean isEditBatchNamePrefixDisabledForEditing() {
		String before = addBatchNamePrefix.getText();
		
		try {
			addBatchNamePrefix.sendKeys("abcd");
		} catch (ElementNotInteractableException e) {
			return true;
		}

		String after = addBatchNamePrefix.getText();
		return before.equals(after);
	}
	
	public boolean isNextEnabledButtonEnabled() {
		return paginatorNextButton.isEnabled();
	}
	

	private void waitUntilElementIsClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	private void waitUntilElementIsClickableAndClick(WebElement element) {
		waitForMillis(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	private void waitForMillis(long millis) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
	}
}
