package dependencyInjection;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import pageObjects.BasePage;
import pageObjects.BatchPage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.ClassPage;
import pageObjects.HomePage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.Helper;
import webDriverManager.DriverManager;

public class TestContext {

	private DriverManager driverManager;

	private ExcelReader excelReader = new ExcelReader();
	private ConfigReader configReader;
	private Helper helper;
	private BasePage basePage;
	private LoginPage loginPage;
	private ClassPage classPage;
	private HomePage homePage;
	private LogoutPage logoutPage;
	private BatchPage batchPage;
	public DriverManager getDriverManager() {
		return driverManager == null ? driverManager = new DriverManager() : driverManager;
	}

	public ExcelReader getExcelReader() {
		return excelReader == null ? excelReader = new ExcelReader() : excelReader;
	}

	public Logger getLogger() {
		return LogManager.getLogger(this.getClass());
	}

	public ConfigReader getConfigReader() {
		return configReader == null ? configReader = new ConfigReader() : configReader;
	}

	public Helper getHelper() {
		return helper == null ? helper = new Helper(driverManager.getDriver()) : helper;

	}

	public BasePage getBasePage() {
		return basePage == null ? basePage = new BasePage(driverManager.getDriver()) : basePage;
	}

	public LoginPage getLoginPage() {
		return loginPage == null ? loginPage = new LoginPage(driverManager.getDriver()) : loginPage;
	}

	public ClassPage getClassPage() {
		return classPage == null ? classPage = new ClassPage(driverManager.getDriver()) : classPage;
	}

	public BatchPage getBatchPage() {
		return batchPage == null ? batchPage = new BatchPage(driverManager.getDriver()) : batchPage;
	}

	public HomePage getHomePage() {
		return homePage==null ? homePage=new HomePage(DriverManager.getDriver()) : homePage;
	}

	public LogoutPage getLogoutPage() {
		return logoutPage==null ? logoutPage=new LogoutPage(DriverManager.getDriver()) : logoutPage;
	}

}
