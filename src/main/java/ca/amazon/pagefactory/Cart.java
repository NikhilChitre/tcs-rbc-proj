package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Cart extends AbstractPage {
	
	//Locators
	@FindBy(xpath="//a[contains(@class, 'checkout')]")
	private WebElement chkOutBtn;
	
	//Constructor
	public Cart(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Click Checkout
	public Login clickChkOut() {
		chkOutBtn.click();
		Reporter.log("Checkout button clicked", true);
		return new Login(driver, wait);
	}
}
