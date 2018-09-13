package ca.amazon.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ca.amazon.utilities.FileUtils;

/**
 * 
 * @author Nikhil Chitre
 * Base class for initializing & closing the WebDriver
 *
 */

public class Base {
	
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	private static final String chromeDriverPath = FileUtils.getProps().get("ChromeDriverPath");
	private static final String ffDriverPath = FileUtils.getProps().get("FFDriverPath");
	private static final String baseURL = FileUtils.getProps().get("BaseURL");
	
	@Parameters("browser")
	@BeforeClass
	public void setUp(String browser) {
		
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			Reporter.log("===== Chrome browser Session Started =====", true);
		}
		else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.geco.driver", ffDriverPath);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", false);
			driver = new FirefoxDriver(firefoxOptions);
			Reporter.log("===== Firefox browser Session Started =====", true);
		}
		else {
			throw new IllegalArgumentException ("Invalid broser specified"); 
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
		Reporter.log("===== Amazon Canada Session Started =====", true);
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		Reporter.log("===== Browser Session Ended =====", true);
	}

}
