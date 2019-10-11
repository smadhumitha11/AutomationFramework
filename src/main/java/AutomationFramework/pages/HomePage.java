/*Author : Madhumitha Sampath
 
 ************************************************************************* 
 
Elements of Home Page is identified and Actions for login page defined 

 ************************************************************************* 
 */
package AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AutomationFramework.Base.BaseTest;

public class HomePage extends BaseTest {
    	@FindBy(xpath = "//a[contains(text(),'SIGN')]")
    	WebElement signIn;
    	@FindBy(xpath = "//img[contains(@alt,'Mercury Tours')]")
    	WebElement companyLogo;
    	@FindBy(xpath = "//a[contains(text(),'your destination')]")
    	WebElement destinationSearch;
    	// Initializing the Page Objects:  	
    	public HomePage() {
    		PageFactory.initElements(driver, this);
    	}	
    	//Actions
    	public boolean validateCompanyLogo(){
    		return companyLogo.isDisplayed();
    	}
    	public boolean validatedestinationSearch(){
    		return destinationSearch.isDisplayed();
    	}
    	public boolean validateSignInClick(){
    		return signIn.isDisplayed();
    	}
    	public DestinationPage destinationClick(){
    		destinationSearch.click();  
    		return new DestinationPage(); 
    	} 	 
} 