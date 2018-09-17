package ca.amazon.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

/**
 * 
 * @author Nikhil Chitre
 * Class for reading properties from config.properties file
 *
 */
public class FileUtils {
	
	static Properties props = new Properties();
	static FileInputStream fileInput = null;
	static Map<String, String> propMap  = new HashMap<String, String>();
	
	/**
	 * Method to return a Map with WebDriver path & base URL
	 * @return		HashMap
	 */
	public static Map<String, String> getProps () {
		try {
			fileInput = new FileInputStream("config.properties");
			
			//load properties file
			props.load(fileInput);
			
			//add properties to map
			propMap.put("ChromeDriverPath", props.getProperty("chromeDriverPath"));
			propMap.put("FFDriverPath", props.getProperty("ffDriverPath"));
			propMap.put("BaseURL", props.getProperty("baseURL"));
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}	finally {
			if (fileInput != null) {
				try {
					fileInput.close();
				}	catch (IOException e) {
					 e.printStackTrace();
				}
			}
		}
		return propMap;
	}
	
	/**
	 * Method to take screen shot
	 * @throws IOException 
	 */
	public static void getScreenShot(WebDriver driver) throws IOException {
		String screenShotsDir = props.getProperty("screenShotsDir") + "/" + driver.getTitle() + ".jpeg";
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(scrFile, new File(screenShotsDir));
		Reporter.log("Screen shot file located at " + screenShotsDir);
	}
}
