package switchto;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchFrame {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(2000);
		//Switch to frame by Id
		driver.switchTo().frame("courses-iframe");
		// Switch to frame by name
//		driver.switchTo().frame("iframe-name");
		// Switch to frame by numbers
//		driver.switchTo().frame(0);
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("Java");
		
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		WebElement textBox = driver.findElement(By.id("name"));
		textBox.sendKeys("text entered");

	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
