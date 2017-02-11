package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NameSelectorDemo {

public static void main(String[] args) throws InterruptedException {
		
//		WebDriver driver = new FirefoxDriver(); //there's a bug with direction in FF.
		WebDriver driver = new ChromeDriver();
		
		String baseURL = "http://api.desk-net.com/";
		
		driver.manage().window().maximize();
		driver.get(baseURL);
//		driver.wait();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='scrollingNav']/ul/li[2]/a")).click();
//		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div[3]/center/input[1]")).click();
		}
}
