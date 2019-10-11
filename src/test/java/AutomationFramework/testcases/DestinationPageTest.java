package AutomationFramework.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AutomationFramework.Base.BaseTest;
import AutomationFramework.pages.DestinationPage;
import AutomationFramework.pages.HomePage;

public class DestinationPageTest extends BaseTest {
	DestinationPage destPage;
	HomePage homePage;
	public DestinationPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		destPage= new DestinationPage();
		homePage= new HomePage(); 
	}
	@Test(priority=1)
	public void destinationClick(){
		homePage.destinationClick();
		destPage.validateBackToHomeClick();
		
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();	
	}
}
