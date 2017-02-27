package testpackage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingElementsIntoView {
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor js;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		//Scroll down
		js.executeScript("window.scrollBy(0, 1900);");
		Thread.sleep(2000);
		
		//Scroll up 
		js.executeScript("window.scrollBy(0, -1900);");
		Thread.sleep(2000);
		
		//Scroll the element into view
		WebElement elementToScrollTo = driver.findElement(By.id("mousehover")); 
		js.executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -200);");
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}