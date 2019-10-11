package AutomationFramework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.Base.BaseTest;

public class DestinationPage extends BaseTest {
	@FindBy(xpath = "//img[contains(@src,'constr')]")
	WebElement underCons;
	@FindBy(xpath = "//img[contains(@src,'home')]")
	WebElement backToHome;
	// Initializing the Page Objects:  	
	public DestinationPage() {
		PageFactory.initElements(driver, this);
	}	
	//Actions
	public boolean validateUnderCons(){
		return underCons.isDisplayed();
	}
	public HomePage validateBackToHomeClick(){
		backToHome.click();
		return new HomePage();
	}
}
