package ca.shopAmazon;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ca.amazon.pagefactory.AmazonHome;
import ca.amazon.pagefactory.Cart;
import ca.amazon.pagefactory.KindleProduct;
import ca.amazon.pagefactory.Login;
import ca.amazon.pagefactory.SiteDir;
import ca.amazon.setup.Base;

public class ProcessOrderTests extends Base {
	
	@Test(description = "TC to check email is mandatory during order processing")
	public void orderEmailCheck() throws InterruptedException {
		
		AmazonHome home = new AmazonHome(driver, wait);
		
		SiteDir dir = home.clickShopByDptLnk();
		
		KindleProduct prod = dir.invokeKindleProdPage();
		prod.selectProdQty("2");
		prod.addToCart();
		
		Cart cart = prod.closePopUp();
		
		Login login = cart.clickChkOut();
		
		String actAlertMsg = login.clickContinue();
		Reporter.log("Email alert messge: " + actAlertMsg, true);
		String expAlertMsg = "Enter your e-mail address or mobile phone number";
		Assert.assertEquals(actAlertMsg, expAlertMsg, "Email alert not displayed!");
	}
}
