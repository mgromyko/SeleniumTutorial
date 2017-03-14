package page.classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageFactory {
	WebDriver driver;
	
	@FindBy(id="tab-flight-tab-hp")
	WebElement flightTab;
	
	@FindBy(id="flight-origin-hp-flight")
	WebElement flightOrigin;
	
	@FindBy(id="flight-destination-hp-flight")
	WebElement flightDestination;
	
	@FindBy(id="flight-departing-hp-flight")
	WebElement departureDate;
	
	@FindBy(id="flight-returning-hp-flight")
	WebElement returnDate;
	
	@FindBy(id="flight-type-roundtrip-label-hp-flight")
	WebElement roundTrip;
	
	@FindBy(id="flight-type-multi-dest-label-hp-flight")
	WebElement multiDestination;
	
	public SearchPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickFlightsTab() {
		flightTab.click();
	}
	
	public void setFlightOrigin(String origin) {
		flightOrigin.sendKeys(origin);
	}

	public void setFlightDestination(String destination) {
		flightDestination.sendKeys(destination);
	}
	
	public void setDepartureDate(String departure){
		departureDate.sendKeys(departure);
	}
	
	public void setReturnDate(String returnD){
		returnDate.sendKeys(returnD);
	}
	
	public void clickRoundTrip(){
		roundTrip.click();
	}
	
	public void clickMultiDestination(){
		multiDestination.click();
	}
}
