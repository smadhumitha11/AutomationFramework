/*Author : Madhumitha Sampath
 
 ************************************************************************* 
 
Browser invocation is defined here

 ************************************************************************* 
 */
package AutomationFramework.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import AutomationFramework.util.TestUtil;
import AutomationFramework.util.WebEventListener;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static FileInputStream fileStream=null;
	static{
		try {
			prop = new Properties();
			fileStream = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\AutomationFramework\\config"
					+ "\\config.properties");
			prop.load(fileStream);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
    public static void initialization() {
    try{
	String browserName = prop.getProperty("Browser");
	String URL=prop.getProperty("URL");
	System.out.println("Started Executing Testcase in :" +browserName );
	if(browserName.equals("Chrome")){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe") ; 
		driver = new ChromeDriver(); 
	}
	else if(browserName.equals("FF")){
  		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "\\drivers\\geckodriver.exe") ; 
		driver = new FirefoxDriver(); 
	}
	if(browserName.equals("IE")){
		System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+ "\\drivers\\msedgedriver.exe") ; 
		driver = new EdgeDriver(); 
	}
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(URL);
    }catch(Exception e){
    	e.printStackTrace();
    }
    }
}