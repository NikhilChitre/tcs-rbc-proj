package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Login extends AbstractPage {
	
	//Locators
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(xpath="//*[contains(text(),'Enter your e-mail')]")
	private WebElement emailAlert;
	
	//Constructor
	public Login(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Click Continue
	public String clickContinue() {
		continueBtn.click();
		Reporter.log("Continue button clicked", true);
		return emailAlert.getText();
	}

}