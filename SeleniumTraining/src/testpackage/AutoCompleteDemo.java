package testpackage;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteDemo {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "https://belavia.by/home/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@Test
	public void testAutoComplete() throws InterruptedException {
		driver.get(baseUrl);
		String cityInput = "A";
		String neededCity = "Аликанте (ALC), ES";
		WebElement fromTextBox = driver.findElement(By.id("OriginLocation_Combobox"));
		fromTextBox.sendKeys(cityInput);
		
		WebElement resultsDrop = driver.findElement(By.id("ui-id-2"));
		List<WebElement> citiesList = resultsDrop.findElements(By.tagName("li"));
		int citesListSize = citiesList.size();
		Thread.sleep(3000);
		
		for (int i=0; i<citesListSize; i++){
			System.out.println(citiesList.get(i).getText());
		}
		
		for (WebElement result : citiesList){
			if (result.getText().equals("Аликанте (ALC), ES")){
				result.click();
			}
		}
	}

	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}
