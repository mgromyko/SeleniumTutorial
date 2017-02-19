package testpackage;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testpackage.GenericMethodsOld;

public class ElementsListDemo {
	private WebDriver driver;
	private String baseUrl; 
	private GenericMethods gm;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		
		boolean result = gm.isElementPresent("name", "id");
		System.out.println(result);
		
		boolean result2 = gm.isElementPresent("name-not-present", "id");
		System.out.println(result2);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
