package page.classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utility.WaitTypes;

public class SearchPage {
	public static WebElement element = null;
	
	/**
	 * Returns the flight origin text box element
	 * @param driver
	 * @return
	 */
	
	public static WebElement originTextBox(WebDriver driver){
		element = driver.findElement(By.id("flight-origin-hp-flight"));
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver, String origin){
		element = originTextBox(driver);
		element.sendKeys(origin);
	}
	
	/**
	 * Returns the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver){
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		return element;
	}
	
	public static void fillDestinationTextBox(WebDriver driver, String destination){
		element = destinationTextBox(driver);
		element.sendKeys(destination);
	}
	
	/**
	 * Returns the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver){
		element = driver.findElement(By.id("flight-departing-hp-flight"));
		return element;
	}
	
	public static void fillDepartureDate(WebDriver driver, String departureDate){
		element = departureDateTextBox(driver);
		element.sendKeys(departureDate);
	}
	
	/**
	 * Returns the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver){
		element = driver.findElement(By.id("flight-returning-hp-flight"));
		return element;
	}
	
	public static void fillReturnDate(WebDriver driver, String retutnDate){
		element = returnDateTextBox(driver);
		element.clear();
		element.sendKeys(retutnDate);
	}
	
	/**
	 * Returns the search button box element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver){
		element = driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[@class='btn-primary btn-action gcw-submit']"));
		return element;
	}
	
	/**
	 * Click on search button
	 * @param driver
	 */
	public static void clickOnSearchButton(WebDriver driver) {
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flights tab
	 * @param driver
	 */
	public static void navigateToFlightsTab(WebDriver driver) {
//		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab-hp"));
		element.click();
	}
	
	public static WebElement advancedLink(WebDriver driver){
		element = driver.findElement(By.id("flight-advanced-options-hp-flight"));
		return element;
	}
	
	public static void clickOnAdvancedLink(WebDriver driver) {
		element = advancedLink(driver);
		element.click();
	}
	
	public static WebElement nonStopCheckBox(WebDriver driver){
		element = driver.findElement(By.id("advanced-flight-nonstop-hp-flight"));
		return element;
	}

	public static void clickOnNonStopCheckBox(WebDriver driver) {
		element = nonStopCheckBox(driver);
		element.click();
	}
	
	public static void selectPreferredClass(WebDriver driver, int indexOfClass) {
//		element = driver.findElement(By.id(""));
		Select preferredClassSelectBox = new Select(driver.findElement(By.id("flight-advanced-preferred-class-hp-flight")));
//		List<WebElement> options = preferredClassSelectBox.getOptions();
		preferredClassSelectBox.selectByIndex(indexOfClass);
//		element.click();
	}
	
	//*[@id='outbound-departure-times']/label[2]
	
	public static void clickMoringFlightsCheckBox(WebDriver driver) {
		WebElement element = WaitTypes.getWhenVisible(driver, 
				By.xpath("//*[@id='outbound-departure-times']/label[2]"), 30);
		element.click();
	}
	
}
