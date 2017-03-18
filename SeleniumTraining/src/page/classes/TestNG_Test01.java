package page.classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG_Test01 {
	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(TestNG_Test01.class.getName());
	
  @Test
  public void f() {
		SearchPage.navigateToFlightsTab(driver);
		SearchPage.fillOriginTextBox(driver, "New York");
		SearchPage.fillDestinationTextBox(driver, "Chikago");
		SearchPage.fillDepartureDate(driver, "12/25/2017");
		SearchPage.fillReturnDate(driver, "12/31/2017");
		SearchPage.clickOnSearchButton(driver);	
  }
  @BeforeMethod
  public void beforeMethod() {
		driver = new ChromeDriver();
		log.trace(driver);
		baseUrl = "https://www.expedia.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
