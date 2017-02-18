package testpackage;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDownsAndMultiSelect {
	private WebDriver driver;
	private String baseUrl1;
	private String baseUrl2;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl1 = "https://www.expedia.com/";
		baseUrl2 = "http://www.htmlcodetutorial.com/forms/_SELECT_MULTIPLE.html";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void testDropDown() {
		driver.get(baseUrl1);
		Select sel1 = new Select(driver.findElement(By.id("package-1-adults")));
		Select sel2 = new Select(driver.findElement(By.id("package-1-children")));
		List<WebElement> options = sel1.getOptions();
		int size = options.size();
		
		for (int i=0; i<size; i++){
			String optionName = sel1.getOptions().get(i).getText();
			System.out.println("Option name is " + optionName);
		}
		
		//by value
		sel1.selectByValue("2");
		
		//by index
		sel2.selectByIndex(2);
	}
	
	@Test
	public void testMultiSelect() throws InterruptedException {
		driver.get(baseUrl2);
		
		Select sel3 = new Select(driver.findElement(By.xpath("//*[@id='wrapper']/article/section/div[3]/select")));
		sel3.selectByValue("Greater");
		Thread.sleep(3000);
		sel3.deselectByValue("Greater");
		sel3.selectByIndex(1);
		sel3.selectByIndex(4);
		Thread.sleep(2000);
		sel3.deselectAll();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(6000);
		driver.quit();
	}
}
