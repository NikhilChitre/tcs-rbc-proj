package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import ca.amazon.utilities.FileUtils;

public class SigninPage extends AbstractPage {
	//Screen shots directory
	private static final String screenShotsDir = FileUtils.getProps().get("screenShotsDir");
	
	//Locators
	@FindBy(id="continue")
	private WebElement continueBtn;
	
	@FindBy(xpath="//*[contains(text(),'Enter your e-mail')]")
	private WebElement emailAlert;
	
	@FindBy(xpath="//h1")
	private WebElement signinEle;
	
	//Constructor
	public SigninPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	//Click Continue
	public String clickContinue() {
		try {
			wait.until(ExpectedConditions.visibilityOf(signinEle));
			continueBtn.click();
			Reporter.log("Continue button clicked", true);
			FileUtils.getScreenShot(driver);
		} catch (Exception e) {
			Reporter.log(this.getClass().getName() + " page not completely loaded!", true);
			e.printStackTrace();
		}
		return emailAlert.getText();
	}

}