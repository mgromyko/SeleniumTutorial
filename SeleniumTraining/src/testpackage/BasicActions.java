package testpackage;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicActions {
	
	WebDriver driver;
	String baseURL;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseURL = "https://desk-net.com/login.htm";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath("//*[@id='username']")).click();
		System.out.println("Clicked login page...");
		driver.findElement(By.id("username")).sendKeys("m.troegubova@intetics.com");
		driver.findElement(By.id("password")).sendKeys("tomcattom");
		driver.findElement(By.id("username")).clear();
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
