/*Author : Madhumitha Sampath
 
 ************************************************************************* 
 
Elements of Login Page is identified and Actions for login page defined 

 ************************************************************************* 
 */
package AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AutomationFramework.Base.BaseTest;

public class LoginPage extends BaseTest {
	@FindBy(xpath = "//input[@name='login']")
	WebElement signIn;
	@FindBy(xpath = "//input[@name='userName']")
	WebElement userName;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passWord;
	// Initializing the Page Objects:  	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}	
	//Actions
	public void login(String un, String pwd) {
		userName.sendKeys(un);
		passWord.sendKeys(pwd);
		signIn.click();
	}
}