package ca.amazon.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract page class to initialize page navigation
 * @author Nikhil Chitre
 *
 */

public class AbstractPage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	//Constructor
	public AbstractPage (WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

}
