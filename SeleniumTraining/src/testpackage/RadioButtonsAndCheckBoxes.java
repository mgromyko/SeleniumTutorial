package testpackage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButtonsAndCheckBoxes {	
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@Test
	public void test() throws InterruptedException {
		WebElement bmwRadio = driver.findElement(By.id("bmwradio"));
		bmwRadio.click();
		Thread.sleep(2000);
		
		WebElement benzRadio = driver.findElement(By.id("benzradio"));
		benzRadio.click();
		Thread.sleep(2000);
		
		WebElement bmwCheck = driver.findElement(By.id("bmwcheck"));
		bmwCheck.click();
		
		WebElement hondaCheck = driver.findElement(By.id("hondacheck"));
		hondaCheck.click();
		
		System.out.println("BMW radio is selected? " + bmwRadio.isSelected());
		System.out.println("Benz radio is selected? " + benzRadio.isSelected());
		System.out.println("BMW check-box is selected? " + bmwCheck.isSelected());
		System.out.println("Honda check-box is selected? " + hondaCheck.isSelected());
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}
}
