/*Author : Madhumitha Sampath
 
 ************************************************************************* 
 
 Test cases of Home Page and Data provider for the test cases is defined here

 ************************************************************************* 
 */
package AutomationFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AutomationFramework.Base.BaseTest;
import AutomationFramework.pages.HomePage;
import AutomationFramework.pages.LoginPage;

public class HomePageTest extends BaseTest {
	LoginPage loginPage;
	HomePage homePage;	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		homePage = new HomePage();
	}
	@Test(priority=1)
	public void homePageValidation(){
		 boolean logoflag = homePage.validateCompanyLogo();
		 Assert.assertTrue(logoflag);
		 boolean prodsearchflag = homePage.validatedestinationSearch();
		 Assert.assertTrue(prodsearchflag);
		 boolean searchiconflag = homePage.validateSignInClick();
		 Assert.assertTrue(searchiconflag);
	}
	@Test(priority=1)
	public void destinationClick(){
		homePage.destinationClick();
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();	
	}
}