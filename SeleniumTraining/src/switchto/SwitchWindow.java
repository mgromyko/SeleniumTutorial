package switchto;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void testSwitchWindows() throws InterruptedException {
		//get the handle 
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent handle is: " + parentHandle);
		
		//find the "Open Window" button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		//Get all handles 
		Set<String> allHandles = driver.getWindowHandles();
		
		//Switch between handles 
		for (String handle: allHandles){
			System.out.println(handle);
			if (!handle.equals(parentHandle)){
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("Java");
				Thread.sleep(2000);
				driver.close();
				break;
			} 
		}
		//Switch back to the parent handle
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("test");		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
