package ca.amazon.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SiteDir extends AbstractPage {
	
	//Locators
	@FindBy(linkText="Kindle Paperwhite")
	private WebElement kindleProdLnk;
	
	@FindBy(linkText="Sell on Amazon")
	private WebElement sellOnAmznLnk;
	
	//Constructor
	public SiteDir(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
		
	//Invoke Kindle product page from Amazon home page
	public KindleProductPage invokeKindleProdPage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(sellOnAmznLnk));
			kindleProdLnk.click();
			Reporter.log("Kindle Paper White clink clicked", true);
		} catch (Exception e) {
			Reporter.log(this.getClass().getName() + " page not completely loaded!", true);
			e.printStackTrace();
		}
		return new KindleProductPage(driver, wait);	
	}
	
}
