package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		// http://chromedriver.storage.googleapis.com/index.html
		
		String baseURL = "http://google.com";
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "\\Users\\Slava\\workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(baseURL);

	}

}
