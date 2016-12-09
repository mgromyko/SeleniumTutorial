
package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverDemo {

	public static void main(String[] args) {

		WebDriver driver;
		String pathToGecko1 = "\\Users\\m.troegubova\\Downloads\\geckodriver\\geckodriver.exe";
		String pathToGecko2 = "\\Users\\Slava\\workspace\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathToGecko2);
		driver = new FirefoxDriver();
		String baseURL = "http://www.google.com";
		
		driver.get(baseURL);
	}
}