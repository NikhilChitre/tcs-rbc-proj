package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonHomePage extends AbstractPage {
	
	//Check user is on Amazon home page
	public void chkNavigationOrRedirectToHome() {
		if (!driver.getTitle().contains("Amazon.ca Online shopping in Canada")) {
			driver.navigate().to("https://www.amazon.ca/");
		}
	}
	
	//Locators
	@FindBy(xpath="//*[@id='nav-link-shopall']")
	private WebElement shopByDeptLnk;
	
	@FindBy(className="navFooterBackToTopText")
	private WebElement backToTopBtn;
	
	//Constructor
	public AmazonHomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Click Shop By Department link
	public SiteDir clickShopByDptLnk() {
		try {
			wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(backToTopBtn));
			shopByDeptLnk.click();
			Reporter.log("Shop By Department link clicked", true);
		} catch (Exception e) {
			Reporter.log(this.getClass().getName() + " page not completely loaded!", true);
			e.printStackTrace();
		}
		return new SiteDir(driver, wait);
	}

}
