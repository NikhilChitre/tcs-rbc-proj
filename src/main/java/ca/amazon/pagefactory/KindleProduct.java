package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class KindleProduct extends AbstractPage {

	//Locators
	@FindBy(id="quantity")
	private WebElement qtyDropDwn;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//button[@data-action='a-popover-close']")
	private WebElement popUpCloseBtn;
	
	@FindBy(xpath="//h4[text()='Add to your Kindle order']")
	private WebElement popUp;
	
	//Constructor
	public KindleProduct(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Select product quantity
	public void selectProdQty(String qty) {
		Select select = new Select(qtyDropDwn);
		select.selectByValue(qty);
		Reporter.log("Product quantity selected", true);
	}
	
	//Click add to cart
	public void addToCart() {
		addToCartBtn.click();
		Reporter.log("Add to cart button clicked", true);
	}
	
	//Dismiss popup
	public Cart closePopUp() throws InterruptedException {
		Thread.sleep(1000);
		popUpCloseBtn.click();
		Reporter.log("Popup up closed", true);
		return new Cart(driver, wait);
	}
	
}
