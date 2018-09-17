package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import ca.amazon.utilities.FileUtils;

public class CartViewPage extends AbstractPage {
	
	//Locators
	@FindBy(name="proceedToCheckout")
	private WebElement proceedToCheckoutBtn;
	
	@FindBy(xpath="//h2[text()[normalize-space()='Shopping Cart']]")
	private WebElement shoppingCartLbl;
	
	//Constructor
		public CartViewPage(WebDriver driver, WebDriverWait wait) {
			super(driver, wait);
		}
	
	//Click Proceed to checkout button
		public SigninPage clickProceedToCheckout() {
			try {
				wait.until(ExpectedConditions.visibilityOf(shoppingCartLbl));
				proceedToCheckoutBtn.click();
				Reporter.log("Proceed to Checkout button clicked", true);
			} catch (Exception e) {
				Reporter.log(this.getClass().getName() + " page not completely loaded!", true);
				e.printStackTrace();
			}
			return new SigninPage(driver, wait);
			
		}
		
}
