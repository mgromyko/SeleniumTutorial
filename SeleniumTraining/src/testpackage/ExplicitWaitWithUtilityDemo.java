package testpackage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.WaitTypes;

public class ExplicitWaitWithUtilityDemo {
	private WebDriver driver;
	private String baseUrl;
	WaitTypes wt; 
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		wt = new WaitTypes(driver);
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		driver.findElement(By.linkText("Login")).click();
		WebElement emailField = wt.waitForTheElement(By.id("user_email"), 3);
		emailField.sendKeys("test");	
		wt.clickWhenReady(By.name("commit"), 3);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
//		driver.quit();
	}
}
