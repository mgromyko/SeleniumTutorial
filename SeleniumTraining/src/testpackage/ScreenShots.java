package testpackage;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.io.*;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ScreenShots {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testTakeScreenShot() {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		
		// Find Elements
		WebElement flight_origin = driver.findElement(By.id("flight-origin-hp-flight"));
		WebElement flight_destination = driver.findElement(By.id("flight-destination-hp-flight"));
		WebElement departure_date = driver.findElement(By.id("flight-departing-hp-flight"));
		WebElement return_date = driver.findElement(By.id("flight-returning-hp-flight"));
		WebElement search = driver.findElement(By.xpath("//*[@id='gcw-flights-form-hp-flight']/div[7]/label/button"));
		
		// Send data to elements
		flight_origin.sendKeys("New York");
		departure_date.sendKeys("09/03/2017");
		return_date.clear();
		return_date.sendKeys("09/10/2017");
		flight_destination.sendKeys("New York");
		search.click();
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		String fileName = getRandomString(10) + ".png";
		String directory = "C:\\Users\\Slava\\Desktop\\New\\";
		File sourceFile = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory+fileName));
		Thread.sleep(3000);
		driver.quit();
	}
}
