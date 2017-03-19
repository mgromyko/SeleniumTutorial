package page.classes;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.classes.TestNG_Test01;

public class TestNG_TestSuite {
	private WebDriver driver;
	private String baseUrl; 
	private static final Logger log = LogManager.getLogger(TestNG_TestSuite.class.getName());
	
	@BeforeClass
	public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void fillBasicInfo() throws InterruptedException {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "Chicago");
		SearchPage.fillDestinationTextBox(driver, "New York");
		SearchPage.fillDepartureDate(driver,"07/03/2017");
		SearchPage.fillReturnDate(driver, "09/03/2017");
		Thread.sleep(3000);
	}
	
	@Test
	public void fillAdvancedInfo() {
		SearchPage.clickOnAdvancedLink(driver);
		SearchPage.clickOnNonStopCheckBox(driver);
		SearchPage.selectPreferredClass(driver, 0);
	}
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();		
	}
}
