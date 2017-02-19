package testpackage;

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

public class GettersDemo {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testGetText() {
		driver.get(baseUrl);
		WebElement buttonElmnt = driver.findElement(By.id("opentab"));
		String elementText = buttonElmnt.getText();
		System.out.println("Text on the element is " + elementText);
	}
	
	@Test
	public void testGetAttributes() {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("name"));
		String attributeValue = element.getAttribute("class");
		System.out.println("Value of the element is " + attributeValue);
		String attributeValue2 = element.getAttribute("type");
		System.out.println("Value of the element is " + attributeValue2);
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
