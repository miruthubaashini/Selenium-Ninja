package pageObjects;

import java.util.List;


import org.languagetool.JLanguageTool;
import org.languagetool.language.English;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//span[normalize-space()='LMS - Learning Management System']") WebElement home_LMS_Title;
	@FindBy(xpath="//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']/div[1]") WebElement toolBar;
	@FindBy(xpath="//mat-card[@class='mat-card mat-focus-indicator container']//div[@class='value']") WebElement homeUserCard;
	@FindBy(xpath="//mat-card[@class='mat-card mat-focus-indicator container']//mat-grid-tile[2]//figure[1]") WebElement BarChart;
	@FindBy(xpath="//app-doughnutchart//div[@class='chartjs-size-monitor']") WebElement pieChart;
	
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

	    if (place < 0 || place >= toolbar.size()) {
	        System.out.println("Invalid place index: " + place);
	        return false; 
	    }

	    String actualTab = toolbar.get(place).getText().trim();
	    System.out.println("Tab at position " + place + ": " + actualTab);
	    if (!actualTab.equals(tab)) {
	        System.out.println("Tab does not match. Expected: " + tab + ", Found: " + actualTab);
	        return false;
	    }
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
		wait.until(ExpectedConditions.elementToBeClickable(BarChart));
			return BarChart.isDisplayed();
	}
	
	public boolean pieChartDisplayed()
	{
		wait.until(ExpectedConditions.elementToBeClickable(pieChart));
		
		return pieChart.isDisplayed();
	}
	
	public boolean UserwidgetDisplay()
	{
		return UserWidget.isDisplayed();
	}
	public boolean staffwidgetDisplay()
	{
		return StaffWidget.isDisplayed();
	}
	public boolean batchwidgetDisplay()
	{
		return BatchWidget.isDisplayed();
	}
	public boolean programwidgetDisplay()
	{
		return ProgramWidget.isDisplayed();
	}

	public boolean StaffDataTableDisplay()
	{
		return staffDataTable.isDisplayed(); 
		}
	public boolean StaffDataPaginationDisplay()
	{
		return staffDataPagination.isDisplayed();
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
		if(FirstPage.getDomAttribute("disabled").equals("true"))
			return true;
		return false;	
	}
	public boolean previousPageDisabled()
	{
		if(PreviousPage.getDomAttribute("disabled").equals("true"))
			return true;
		return false;	
	}

}
	
