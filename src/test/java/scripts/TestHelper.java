package scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.text.SimpleDateFormat;
import java.util.Date;
import constants.Constants;

public class TestHelper {
	WebDriver driver;
	public static Properties prop = null;
	String driverPath = "C:\\chromedriver.exe";
	
	//function to read configuration file
	public static void basefn() throws IOException {
		//Below line creates an object of Properties called 'prop'
		prop = new Properties();  
		
		//Below line creates an object of FileInputStream called 'fi'. Give the path of the properties file which you have created
		FileInputStream fi = new FileInputStream("D:\\Java\\workspace\\Buffalocart\\src\\test\\resources\\config.properties");
		
		//Below line of code will load the property file
		prop.load(fi);				
	}
	
	@BeforeTest
	//@BeforeMethod
	public void setup() throws Exception {
		basefn();
		String browser = prop.getProperty("browser");
		
		// If the browser is Firefox, then do this 
		if(browser.equalsIgnoreCase(Constants.BROWSER_FIREFOX)) { 
			//Initializing the firefox driver 
			// (Gecko) driver = new FirefoxDriver(); 
			 }
		else if (browser.equalsIgnoreCase(Constants.BROWSER_CHROME)) {
			//Initialize the chrome driver 
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver(); 
		}
	 else{ //If no browser passed throw exception 
		throw new Exception("Browser is not correct"); 
		} 
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
	
	 @AfterMethod
	 public void tearDownFailure(ITestResult iTestResult) throws IOException {
	        if (iTestResult.getStatus()==ITestResult.FAILURE) {
	            takeScreenshot(iTestResult.getName());
	        }
	     //   driver.quit();
	    }
	 
	 public String takeScreenshot(String name) throws IOException {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

	      //Take the screenshot
	        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        String destination =  System.getProperty("user.dir") + "\\target\\" + name + dateName
	                + ".png";
	       
	        File finalDestination = new File(destination);
	     
	     
	        FileHandler.copy(source, finalDestination);
	        return destination;  
	}
	
}
