package page.classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Prio {
	@BeforeClass
	public void beforeClass() {
		System.out.println("This method runs before class");
	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println();
		System.out.println("This method runs before every method");
	}
	
	@Test(priority = 0)
	public void BMW3Series() {
		System.out.println("Running Test - BMW 3 Series");
	}
	@Test(priority = 1, enabled = false)
	public void BMWX3() {
		System.out.println("Running Test - BMW X3");
	}
	@Test(priority = 2)
	public void AudiA6() {
		System.out.println("Running Test - Audi A6");
	}
	@Test(priority = 3)
	public void HondaAccord() {
		System.out.println("Running Test - Honda Accord");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("This method runs after every method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This method runs after class");
	}
}
