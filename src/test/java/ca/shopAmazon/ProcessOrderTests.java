package ca.shopAmazon;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import ca.amazon.pagefactory.AmazonHomePage;
import ca.amazon.pagefactory.CartViewPage;
import ca.amazon.pagefactory.AddedToCartConfPage;
import ca.amazon.pagefactory.KindleProductPage;
import ca.amazon.pagefactory.SigninPage;
import ca.amazon.pagefactory.SiteDir;

public class ProcessOrderTests extends Base {
	
	@Test(description = "TC to check email is mandatory during order processing")
	public void orderEmailCheck() throws InterruptedException, IOException {
		
		AmazonHomePage home = new AmazonHomePage(driver, wait);
		
		SiteDir dir = home.clickShopByDptLnk();
		
		KindleProductPage prod = dir.invokeKindleProdPage();
		prod.selectProdQty("2");
		prod.addToCart();
		
		AddedToCartConfPage addedToCartConf = prod.closePopUp();
		
		CartViewPage cartView = addedToCartConf.clickChkOut();
		
		SigninPage signin = cartView.clickProceedToCheckout();
		
		String actAlertMsg = signin.clickContinue();
		Reporter.log("Email alert messge: " + actAlertMsg, true);
		String expAlertMsg = "Enter your e-mail address or mobile phone number";
		Assert.assertEquals(actAlertMsg, expAlertMsg, "Email alert not displayed!");
	}
}
