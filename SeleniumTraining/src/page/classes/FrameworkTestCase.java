package page.classes;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameworkTestCase {
	WebDriver driver;
	String baseUrl;
	SearchPageFactory searchPage;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		searchPage = new SearchPageFactory(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void test() {
		searchPage.clickFlightsTab();
		searchPage.setFlightOrigin("Chicago");
		searchPage.setFlightDestination("New York");
		searchPage.setDepartureDate("2018-05-05");
		searchPage.setReturnDate("201-05-07");
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

}
