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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ListOfElements {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new InternetExplorerDriver();
		baseURL = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@Test
	public void testListOfElements() throws InterruptedException {
		boolean selectedItem = false;
		List<WebElement> radioButtons = driver.findElements(
				By.xpath("//input[contains(@type,'radio') and contains(@name,'cars')]"));
		
		int size = radioButtons.size();
		System.out.println("Size of the list is " + size);
		for (int i=0; i<size; i++){
			selectedItem = radioButtons.get(i).isSelected();
			
			if (!selectedItem){
				radioButtons.get(i).click();
				Thread.sleep(3000);
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
