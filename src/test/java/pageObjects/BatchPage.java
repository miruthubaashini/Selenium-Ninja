package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BatchPage extends BasePage {

	public BatchPage(WebDriver driver) {
		super(driver);
		// PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//app-header/mat-toolbar/div/button[3]")
	WebElement Batch;

	@FindBy(xpath = "//*[@id=\"dashboard\"]")
	WebElement Home;

	// @FindBy(xpath="//*[@id=\"program\"]") WebElement Program;
	// @FindBy(xpath="//mat-toolbar/div/button[4]")
	// WebElement Class;

	@FindBy(xpath = "//*[@id=\"logout\"]]")
	WebElement Logout;

	@FindBy(xpath = "//span[text()='Class']")
	WebElement classLink;

	@FindBy(xpath = "//*[@id=\"mat-menu-panel-1\"]/div/button")
	WebElement AddNewBatch;

	@FindBy(xpath = "//mat-card-title/div[2]/div[1]/button")
	WebElement Delete;

	@FindBy(className = "p-input-icon-left") // *[@id="filterGlobal"]
	WebElement searchBox;

	@FindBy(xpath = "//mat-card-title/div[1]/text()")
	WebElement batchHeader;

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

	@FindBy(xpath = "//tr/th")
	private List<WebElement> datatableHeaders;
	
	@FindBy(xpath = "//mat-card/mat-card-title/div[2]/div[1]/button[contains(@icon, 'pi pi-trash')]")
	WebElement disabledDeleteIcon;
	
	
	
	// Pagination and footer related objects

	@FindBy(xpath = "//button[contains(@class,'p-paginator-first')]")
	private WebElement paginatorFirstButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-prev')]")
	private WebElement paginatorPreviousButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-next')]")
	private WebElement paginatorNextButton;
	@FindBy(xpath = "//button[contains(@class,'p-paginator-last')]")
	
	private WebElement paginatorLastButton;

	public boolean getBatchHeader(String header) {
		if (batchHeader.getText().equals(header)) {
			return true;
		}
		return false;
	}

	public WebElement classSearchBox() {
		return searchBox;
	}

	// Method to check if the Delete button ised
	public boolean isDeleteButtonVisible() {
		return Delete.isDisplayed();
	}

	// Method to click on the Delete button
	public void clickDeleteButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Delete)); 
		Delete.click();
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(homeMenuLink)); 
		homeMenuLink.click();
	}

	public void clickBatchMenuLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(batchMenuLink)); 
		batchMenuLink.click();
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public String getPageHeading() {
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
	
	
	
}
