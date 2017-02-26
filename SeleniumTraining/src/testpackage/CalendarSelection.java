package testpackage;

import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelection {
	private WebDriver driver;
	private String baseUrl; 

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@Test
	public void test01() throws InterruptedException {
		driver.get(baseUrl);
		//click on the flights tab 
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		//find the element for departing field 
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		//click the field
		departingField.click();
		Thread.sleep(3000);
		//find the date to be selected 
		WebElement dateToBeSelected = driver.findElement(By.xpath("//*[@class='datepicker-cal-month'][position()=1]//button[text()=28]"));
		//click the date button 
		dateToBeSelected.click();
	}
	
	@Test
	public void test02() throws InterruptedException {
		driver.get(baseUrl);
		driver.findElement(By.id("tab-flight-tab-hp")).click();
		WebElement departingField = driver.findElement(By.id("flight-departing-hp-flight"));
		departingField.click();
		Thread.sleep(3000);
		//find all available dates
		WebElement calMonth = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][position()=1]"));
		List<WebElement> allValidDates = calMonth.findElements(By.tagName("button"));
		for (WebElement date : allValidDates){
			if (date.getText().equals("28")){
				date.click();
				break;
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
