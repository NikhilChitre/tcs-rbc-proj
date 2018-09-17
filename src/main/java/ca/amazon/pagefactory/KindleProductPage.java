package ca.amazon.pagefactory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import ca.amazon.utilities.FileUtils;

public class KindleProductPage extends AbstractPage {

	//Locators
	@FindBy(id="quantity")
	private WebElement qtyDropDwn;
	
	@FindBy(id="add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//h4[text()='Add to your Kindle order']")
	private WebElement popUp;
	
	@FindBy(id="acrCustomerReviewLink")
	private WebElement custReviewsLnk;
	
	//Constructor
	public KindleProductPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.wait = new WebDriverWait(driver, 20);
	}
	
	//Select product quantity
	public void selectProdQty(String qty) throws IOException {
		try {
			wait.until(ExpectedConditions.visibilityOf(custReviewsLnk));
			Select select = new Select(qtyDropDwn);
			select.selectByValue(qty);
			Reporter.log("Product quantity selected", true);
		} catch (Exception e) {
			 Reporter.log(this.getClass().getName() + " page not completely loaded!", true);
			 e.printStackTrace();
		}
	}
	
	//Click add to cart
	public void addToCart() {
		addToCartBtn.click();
		Reporter.log("Add to cart button clicked", true);
	}
	
	//Dismiss popup
	public AddedToCartConfPage closePopUp() throws InterruptedException {
/*		WebElement popUpCloseBtn = driver.findElement(By.xpath("//*[contains(@class,'a-popover-modal')]"));
 		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartModal));
		WebElement popUpCloseBtn = driver.findElement(By.xpath("//button[@data-action='a-popover-close']"));
		driver.switchTo().activeElement();*/
		
		WebElement popUpCloseBtn = driver.findElement(By.xpath("//button[@data-action='a-popover-close']"));
		
		Thread.sleep(1000);
		popUpCloseBtn.click();
		Reporter.log("Popup up closed", true);
		return new AddedToCartConfPage(driver, wait);
	}

}
