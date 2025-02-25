package pageObjects;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.imageio.ImageIO;
import org.languagetool.language.English;
import org.languagetool.JLanguageTool;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class LoginPage extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	public LoginPage(WebDriver driver) {
		super(driver);	

	}

	@FindBy (xpath="//div[@class=\'signin-content\']") WebElement SignInPage;
	@FindBy (xpath="//p[normalize-space()='Please login to LMS application']") WebElement signInContent;
	@FindBy(xpath="//div[@class=\"signin-content\"]") WebElement FormContent;
	@FindBy (id= "username") WebElement usernameField;
	@FindBy (id= "password") WebElement passwordField;
	@FindBy (id= "mat-select-value-1") WebElement roleField;
	@FindBy (className= "mat-option-text") List <WebElement> roleDropdown;
	@FindBy (id= "login") WebElement loginButton;

	@FindBy (xpath="//*[@id=\'mat-form-field-label-1\']/span[2]") WebElement userStar;
	@FindBy (xpath="//*[@id=\'mat-form-field-label-3\']/span[2]") WebElement pwdStar;

	@FindBy(xpath="//img[@src=\'assets/img/LMS-logo.jpg\']") WebElement appImage;

	@FindBy(xpath="//mat-error[@id='mat-error-3']") WebElement userNameErrorMsg;
	@FindBy(xpath="//mat-error[@id='mat-error-4']") WebElement passwordErrorMsg;
	@FindBy(xpath="//img[@class='images']") WebElement imgClick;

	@FindBy(xpath=("//div[@routerlink='/user']")) WebElement homepageElt;
	@FindBy(xpath="//*[@class=\"mat-card-content\"]") WebElement inputFieldsLocation;

	public void enterUsername(String userName) {
		usernameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickRoleDD() {
		roleField.click();
	}

	public void selectUserRole(String role) {
		roleDropdown.stream().filter(r->r.getText().equals(role)).forEach(e->e.click());
	}

	public void clickLoginbtn() {
		//wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@role='listbox']")));
		js.executeScript("arguments[0].click();", loginButton);
		// loginButton.click();	
		//		Actions actions = new Actions(driver);
		//		actions.moveToElement(loginButton).moveByOffset(10, 10).click().perform();
	}

	public boolean formLabelDisplayed() {
		signInContent.isDisplayed();
		return true;
	}

	@SuppressWarnings("deprecation")
	public int textFields()
	{

		List<WebElement> inputFields=SignInPage.findElements(By.tagName("input"));
		return inputFields.size();
	}
	public boolean dropDownDisplay()
	{
		return roleField.isDisplayed();
	}

	@SuppressWarnings("deprecation")
	public String usernamePlaceholder()
	{
		return usernameField.getAttribute("data-placeholder");
	}
	@SuppressWarnings("deprecation")
	public String passwordPlaceholder()
	{
		return passwordField.getAttribute("data-placeholder");
	}

	public boolean userStarDisplayed()
	{
		return userStar.isDisplayed();
	}

	public boolean pwdStarDisplayed()
	{
		return pwdStar.isDisplayed();
	}
	public String rolePlaceHolder()
	{
		System.out.println(roleField.getText());
		return roleField.getText();
	}

	public boolean dropDownElementstsDisplayed(String roleName)
	{

		List<WebElement> roleOptions=roleField.findElements(By.tagName("mat-option-text"));
		for(WebElement roles:roleOptions)
		{
			String role=roles.getText();

			return role.contains(roleName);
		}
		return false;
	}

	public boolean signInContentPosition() 
	{
		try{
			Dimension inputFieldSize = inputFieldsLocation.getSize();
			Point inputFieldPosition = inputFieldsLocation.getLocation();

			Dimension viewportSize = driver.manage().window().getSize();

			int viewportCenterX = viewportSize.width / 2;
			int viewportCenterY = viewportSize.height / 2;

			int inputFieldCenterX = inputFieldPosition.getX() + (inputFieldSize.width / 2);
			int inputFieldCenterY = inputFieldPosition.getY() + (inputFieldSize.height / 2);
			System.out.println("inputFieldCenterX:"+inputFieldCenterX+",inputFieldCenterY"+inputFieldCenterY);
			System.out.println("viewportCenterX:"+viewportCenterX+",viewportCenterY"+viewportCenterY);

			int tolerance = 50; 
			boolean isCenteredHorizontally = Math.abs(viewportCenterX - inputFieldCenterX) <= tolerance;
			boolean isCenteredVertically = Math.abs(viewportCenterY - inputFieldCenterY) <= tolerance;

			if (isCenteredHorizontally && isCenteredVertically) {
				System.out.println("The input field is approximately centered on the webpage.");
				return true;
			} else {
				System.out.println("The input field is NOT centered on the webpage.");
					}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean loginBtnDispalyed()
	{
		return loginButton.isDisplayed();
	}

	public boolean usertextColour()
	{

		String rgbFormat = usernameField.getCssValue("color");
		System.out.println(rgbFormat);
		return (rgbFormat.equals("rgba(0, 0, 0, 0.87)")) ? true : false ;

	}
	public boolean pwdtextColour()
	{

		String rgbFormat = usernameField.getCssValue("color");
		System.out.println(rgbFormat);

		return (rgbFormat.equals("rgba(0, 0, 0, 0.87)")) ? true : false ;

	}

	public String appNameOnLogo() throws IOException, TesseractException {

		String imageURL = appImage.getAttribute("src");
		URL url = new URL(imageURL);
		BufferedImage image1 = ImageIO.read(url);
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
		tesseract.setLanguage("eng");
		String extractedText = tesseract.doOCR(image1);

		System.out.println("Extracted Text: " + extractedText);
		return extractedText;
	}

	public boolean spellCheckSignInContents()
	{
		return checkSpelling(FormContent);
	}

	public boolean checkSpelling(WebElement elt)
	{
		try {
			String pageText = elt.getText();
			System.out.println(pageText);
			@SuppressWarnings("deprecation")
			JLanguageTool langTool = new JLanguageTool(new English());

			List<RuleMatch> matches = langTool.check(pageText);

			if (matches.isEmpty()) {
				System.out.println("No spelling errors found!");
				return true;
			} else {
				for (RuleMatch match : matches) {
					System.out.println("Potential error at characters " + match.getFromPos() + "-" + match.getToPos() + ": " + match.getMessage());
					System.out.println("Suggested correction: " + match.getSuggestedReplacements());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}

	public void LoginBtnKeyboardClick()
	{
		//imgClick.click();
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		Actions clickaction=new Actions(driver);
		clickaction.moveToElement(loginButton).sendKeys(Keys.ENTER).click().perform();
		wait.until(ExpectedConditions.elementToBeClickable(homepageElt));

	}

	public void fillLoginDetails(String username, String password, String userRole) {
		System.out.println("values from sheet:username:"+username);
		System.out.println("values from sheet:pwd"+password);
		System.out.println("values from sheet:role:"+userRole);


		enterUsername(username);
		enterPassword(password);
		clickRoleDD();
		selectUserRole(userRole);
		clickLoginbtn();

	}

	public boolean checkLoginErrorMsg(String errorMsg) {
		List<WebElement> errorAlert= FormContent.findElements(By.tagName("mat-error"));
		for(WebElement err : errorAlert)
		{
			System.out.println("error msg from webpage"+err.getText());
			err.getText().equals(errorMsg);
			return true;
		}
		return false;
	}

}
