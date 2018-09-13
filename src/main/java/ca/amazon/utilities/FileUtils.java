package ca.amazon.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
}
