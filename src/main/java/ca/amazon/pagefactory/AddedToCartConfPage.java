package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import ca.amazon.utilities.FileUtils;

public class AddedToCartConfPage extends AbstractPage {
	
	//Locators
	@FindBy(xpath="//*[@id='hlb-next-steps']/a")
	private WebElement chkOutBtn;
	
	@FindBy(id="confirm-text")
	private WebElement addedToCartMsg;
	
	//Constructor
	public AddedToCartConfPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Click Checkout
	public CartViewPage clickChkOut() {
		try {
			wait.until(ExpectedConditions.visibilityOf(addedToCartMsg));
			chkOutBtn.click();
			Reporter.log("Checkout button clicked", true);
		} catch (Exception e) {
			Reporter.log(this.getClass().getName() + " page not completely loaded!", true);
			e.printStackTrace();
		}
		
		return new CartViewPage(driver, wait);
	}

}
