package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectorsDemo {

	public static void main(String[] args) {
		
//		WebDriver driver = new FirefoxDriver(); there's a bug with direction in FF.
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "http://www.google.com/";
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.findElement(By.id("lst-ib")).sendKeys("tut.by");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
		
//		WebDriver driver;
//		driver = new FirefoxDriver();
//		String baseURL = "http://www.google.com";
//		driver.manage().window().maximize();
//		driver.get(baseURL);
//		
//		driver.findElement(By.id("lst-ib")).sendKeys("letskodeit");
//		driver.findElement(By.id("sblsbb")).click();

	}

}
