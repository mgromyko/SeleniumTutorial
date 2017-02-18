package testpackage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatingOnThePages {

	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://api.desk-net.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseURL);
		Thread.sleep(5000);
		String title = driver.getTitle();
		System.out.println(title);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is " + currentUrl);	
		
		String urlToNavigate = "http://api.desk-net.com/#api-Attachment-UploadAttachment";
		driver.navigate().to(urlToNavigate);
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		System.out.println("Navigate back...");
		driver.navigate().back();
		Thread.sleep(3000);
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
		
		System.out.println("Navigate forward...");
		driver.navigate().forward();
		currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);	
		
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("Navigate refresh...");
		driver.navigate().refresh();
		
//		String pageSource = driver.getPageSource();
//		System.out.println(pageSource);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
