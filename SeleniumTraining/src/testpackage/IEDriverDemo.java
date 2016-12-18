package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {

	public static void main(String[] args) {
		//http://selenium-release.storage.googleapis.com/index.html
		
		String baseURL = "http://google.com";
		WebDriver driver;
		
		//System.setProperty("webdriver.ie.driver", "\\Users\\Slava\\workspace\\IEDriverServer.exe");
		
		driver = new InternetExplorerDriver();
		
		driver.get(baseURL);
		
		//TO DO Add system variables (add location of the folder)

	}

}
