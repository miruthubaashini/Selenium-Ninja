package pageObjects;

import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.English;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//span[normalize-space()='LMS - Learning Management System']") WebElement home_LMS_Title;
	@FindBy(xpath="//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/div[1]") WebElement toolBar;
	@FindBy(xpath="//mat-card[@class='mat-card mat-focus-indicator container']//div[@class='value']") WebElement homeUserCard;
	@FindBy(xpath="//mat-card[@class='mat-card mat-focus-indicator container']//mat-grid-tile[2]//figure[1]") WebElement BarChart;
	@FindBy(xpath="//app-doughnutchart//div[@class=\'chartjs-size-monitor\']") WebElement pieChart;
	
	@FindBy(xpath="//div[@routerlink='/user']") WebElement UserWidget;
	@FindBy(xpath="//div[@class='widget yellow']//div[@class='value']") WebElement StaffWidget;
	@FindBy(xpath="//div[@routerlink='/batch']") WebElement BatchWidget ;
	@FindBy(xpath="//div[@routerlink='//program']") WebElement ProgramWidget;
	
	@FindBy(xpath="//mat-table[@role='grid']") WebElement staffDataTable;
	@FindBy(xpath="//div[@class='mat-paginator-range-actions']") WebElement staffDataPagination;
	
	@FindBy(xpath="//button[@aria-label=\'First page\']") WebElement FirstPage;
	@FindBy(xpath="//button[@aria-label=\'Previous page\']") WebElement PreviousPage;
	public boolean titleDispalyed()
	{
		return home_LMS_Title.isDisplayed();
	}
	
	public boolean titlePosition()
	{
		//Point positionxy=home_LMS_Title.getLocation();
		int x = home_LMS_Title.getLocation().getX();
        int y = home_LMS_Title.getLocation().getY();
        System.out.println("position of title"+x + y);
        if(x==16 && y==16)
        	return true;
        return false;

	}
	public boolean navBarValidation(String tab, int place)
	{
	
	 List<WebElement> toolbar = toolBar.findElements(By.tagName("button"));

	    // Check if the place is valid (i.e., within the range of the toolbar list)
	    if (place < 0 || place >= toolbar.size()) {
	        System.out.println("Invalid place index: " + place);
	        return false; // Invalid place index
	    }

	    // Get the button text at the specified place
	    String actualTab = toolbar.get(place).getText().trim();
	    System.out.println("Tab at position " + place + ": " + actualTab);

	    // Compare the button text at the specified place with the expected tab
	    if (!actualTab.equals(tab)) {
	        System.out.println("Tab does not match. Expected: " + tab + ", Found: " + actualTab);
	        return false;
	    }

	    // If it reaches here, the specified tab exists at the specified position
	    return true;
	}
	
	public boolean navBarSpellCheck()
	{
		try {
	        String pageText = toolBar.getText();
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
	
	public boolean checkUserName(String uname)
	{
		String UserText=homeUserCard.getText().toLowerCase();
		System.out.println(UserText);
		
		if(UserText.contains(uname))
			return true;
		return false;
	}
	public boolean checkRole(String roleName)
	{
		String role1=roleName.toLowerCase();
		String UserText=homeUserCard.getText().toLowerCase();
		if(UserText.contains(role1))
			return true;
		return false;
		
	}
	public boolean barChartDisplayed()
	{
		return BarChart.isDisplayed();
	}
	
	public boolean pieChartDisplayed()
	{
		return pieChart.isDisplayed();
	}
	
	public boolean UserwidgetDisplay()
	{
		System.out.println(UserWidget.getText());
		return UserWidget.isDisplayed();
	}
	public boolean staffwidgetDisplay()
	{
		System.out.println(StaffWidget.getText());
		return StaffWidget.isDisplayed();
	}
	public boolean batchwidgetDisplay()
	{
		System.out.println(BatchWidget.getText());
		return BatchWidget.isDisplayed();
	}
	public boolean programwidgetDisplay()
	{
		System.out.println(ProgramWidget.getText());
		return ProgramWidget.isDisplayed();
	}

	public boolean StaffDataTableDisplay()
	{
		return staffDataTable.isDisplayed() && staffDataPagination.isDisplayed();
	}

	public boolean StaffDataRowsCheck()
	{
		List <WebElement> row=staffDataTable.findElements(By.tagName("mat-row"));
		if(row.size()==5) 
			return true;
		return false;
	}
	public boolean firstPageDisabled()
	{
		if(FirstPage.getAttribute("disabled").equals("true"))
			return true;
		return false;	
	}
	public boolean previousPageDisabled()
	{
		if(PreviousPage.getAttribute("disabled").equals("true"))
			return true;
		return false;	
	}

}
	

