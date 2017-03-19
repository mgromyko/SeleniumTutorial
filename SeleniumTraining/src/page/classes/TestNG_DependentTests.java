package page.classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class TestNG_DependentTests {
	private WebDriver driver;
	private String baseUrl; 
	
  @BeforeClass
  public void beforeClass() {
		driver = new ChromeDriver();
		baseUrl = "https://www.expedia.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
  }

  @Test
  public void searchFlights() throws InterruptedException {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.fillDestinationTextBox(driver, "Chicago");
		SearchPage.fillDepartureDate(driver,"07/03/2017");
		SearchPage.fillReturnDate(driver, "09/03/2017");
		SearchPage.clickOnSearchButton(driver);
		Thread.sleep(3000);
  }
  
  @Test(dependsOnMethods={ "searchFlights" })
  public void selectMorningFlights() {
	  SearchPage.clickMoringFlightsCheckBox(driver);	  
  }
  
  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
