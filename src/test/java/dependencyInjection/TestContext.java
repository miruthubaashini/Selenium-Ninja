package dependencyInjection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.Helper;
import webDriverManager.DriverManager;

public class TestContext {
	
	private DriverManager driverManager;
	
	private ExcelReader excelReader = new ExcelReader();
	private ConfigReader configReader;
	private Helper helper;
	
	public DriverManager getDriverManager() {
		return driverManager==null ? driverManager=new DriverManager() : driverManager;
	}
	
	public ExcelReader getExcelReader() {
		return excelReader==null ? excelReader=new ExcelReader() : excelReader;
	}
	
	public Logger getLogger() {
		return LogManager.getLogger(this.getClass());
	}
	
	public ConfigReader getConfigReader() {
		return configReader==null ? configReader=new ConfigReader() : configReader;
	}
	
	public Helper getHelper() {
		return helper==null ? helper=new Helper(DriverManager.getDriver()) : helper;
	}
}
