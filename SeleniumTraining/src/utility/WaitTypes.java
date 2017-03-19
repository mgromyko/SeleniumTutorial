package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	WebDriver driver; 
	
	public WaitTypes(WebDriver driver){
		this.driver = driver;
	}
	
	//Utility methods for explicit waits
	public WebElement waitForTheElement(By locator, int timeout){
		WebElement element = null;
		try{
			System.out.println("Waiting for max:: " + timeout + " seconds for the element to be availiable.");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.visibilityOfElementLocated(locator));
			System.out.println("The element appeared on the page");
		} catch (Exception e) {
			System.out.println("Element no appeared on the web page");
		}
		return element;
	}
	
	public void clickWhenReady(By locator, int timeout){
		try{
			WebElement element = null;
			System.out.println("Waiting for max:: " + timeout + " seconds for the element to be clickable.");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(
					ExpectedConditions.elementToBeClickable(locator));
			element.click();
			System.out.println("The element clicked on the page");
		} catch (Exception e) {
			System.out.println("Element no appeared on the web page");
		}
	}
	
	public static WebElement getWhenVisible(WebDriver driver, By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		return element;
	}
}
