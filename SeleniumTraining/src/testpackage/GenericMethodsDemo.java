package testpackage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testpackage.GenericMethodsOld;

public class GenericMethodsDemo {
	private WebDriver driver;
	private String baseUrl; 
	private GenericMethodsOld gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethodsOld(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		
		WebElement element = gm.getElement("name", "id");
		element.sendKeys("Test");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
