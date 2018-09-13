package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SiteDir extends AbstractPage {
	
	//Locators
	@FindBy(linkText="Kindle Paperwhite")
	private WebElement kindleProdLnk;
	
	//Constructor
	public SiteDir(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
		
	//Invoke Kindle product page from Amazon home page
	public KindleProduct invokeKindleProdPage() {
		kindleProdLnk.click();
		Reporter.log("Kindle Paper White clink clicked", true);
		return new KindleProduct(driver, wait);
	}
}
