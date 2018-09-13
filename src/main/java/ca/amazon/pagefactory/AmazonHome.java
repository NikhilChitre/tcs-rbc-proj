package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AmazonHome extends AbstractPage {
	
	//Check user is on Amazon home page
	public void chkNavigation() {
		if (!driver.getTitle().contains("Amazon.ca Online shopping in Canada")) {
			driver.navigate().to("https://www.amazon.ca/");
		}
	}
	
	//Locators
	@FindBy(xpath="//*[@id='nav-link-shopall']//*[contains(text(),'Department')]")
	private WebElement shopByDeptLnk;
	
	//Constructor
	public AmazonHome(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Click Shop By Department link
	public SiteDir clickShopByDptLnk() {
		shopByDeptLnk.click();
		Reporter.log("Shop By Department link clicked", true);
		return new SiteDir(driver, wait);
	}
}
