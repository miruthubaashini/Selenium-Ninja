package webDriverManager;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	//private static WebDriver driver;

	public WebDriver initDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			tlDriver.set(new ChromeDriver(options));
			// driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			tlDriver.set(new FirefoxDriver(options));
		}

		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--headless");
			tlDriver.set(new EdgeDriver(options));
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().setSize(new Dimension(1440, 900));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		// return driver;
	}
}
