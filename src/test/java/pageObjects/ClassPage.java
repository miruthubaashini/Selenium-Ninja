package pageObjects;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClassPage extends BasePage {

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
	@FindBy(xpath = "//div[contains(@class,'p-datatable-footer')]/div")
	private WebElement datatableFooterText;

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

	//------------------------------------------------------
	
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

	public boolean checkFooterTextMatches(String text) {
		String footerText = datatableFooterText.getText();
		String regexText = text.replace("x", "\\d+");
		Pattern pattern = Pattern.compile(regexText);
		Matcher matcher = pattern.matcher(footerText);

		return matcher.matches();
	}
	//------------------------------------------------------------
}
