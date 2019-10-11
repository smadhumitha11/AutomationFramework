/*Author : Madhumitha Sampath
 
 ************************************************************************* 
 
 Test cases of Login Page and Data provider for the test cases is defined here

 ************************************************************************* 
 */
package AutomationFramework.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import AutomationFramework.Base.BaseTest;
import org.testng.annotations.DataProvider;
import AutomationFramework.pages.LoginPage;
import AutomationFramework.util.TestUtil;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	TestUtil testUtil;
	String sheetName = "Login";
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage= new LoginPage();
		testUtil = new TestUtil();
	}
	//Data Provider
	@DataProvider
	public Object[][] gettestdata() throws Exception{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1, dataProvider="gettestdata")
	public void loginPageValidation(String usrName, String passWord){	
		loginPage.login(usrName, passWord);
	}
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();	
	}
}
