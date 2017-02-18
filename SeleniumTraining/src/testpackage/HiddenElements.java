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
import org.openqa.selenium.firefox.FirefoxDriver;

public class HiddenElements {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;	
	// Adding code for JS
//	private JavascriptExecutor js;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl1 = "http://letskodeit.teachable.com/pages/practice";
		baseUrl2 = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testLetsCodeIt() throws InterruptedException {
		driver.get(baseUrl1);
		
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text box is displayed " + textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
		hideBtn.click();
		System.out.println("Clicked on hide button");
		System.out.println("Text box is displayed " + textBox.isDisplayed());
		Thread.sleep(3000);
		
		WebElement showBtn = driver.findElement(By.id("show-textbox"));
		showBtn.click();
		System.out.println("Clicked on \"show button");
		System.out.println("Text box is displayed " + textBox.isDisplayed());
	}
	
	@Test
	public void testExpedia() {
		driver.get(baseUrl2);
		
		WebElement childDropDown = driver.findElement(By.id("package-1-age-select-1"));
		System.out.println("Child drop down is displayed " + childDropDown.isDisplayed());
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

}
