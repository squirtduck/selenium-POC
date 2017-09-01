package Utilities.functionLibrary;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.environmentConstants.Parameters;

// Very often, we are suppose to perform certain procedures 
// prior and aftermath to the actual test execution like login to the application, 
// setting up environments, activities related to user roles, data manipulations, 
// writing results, methods those generate pre/post-conditions to other methods. 
// Since we tend to perform these activities for all or most of the test script, 
// thus it is always recommended to create a separate class for such activities instead of 
// coding them repeatedly in each of the test script.

public class PreConditionalMethods {
	
	public static WebDriver initializeChromeDriver()
	{
//		System.setProperty("webdriver.chrome.driver", Parameters.getParameter(Parameters.CHROME_PATH_KEY));
//		//System.setProperty("webdriver.chrome.driver","C:\\Users\\marqu\\workspace\\SeleniumPOC\\drivers\\chromedriver.exe"); // parameterize second argument
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//    	
//        return driver;
        
        String chromePath = Parameters.getParameter(Parameters.CHROME_PATH_KEY);//Parameters.getParameter(Parameters.IE_PATH_KEY);
       
        
        File file = new File(chromePath);
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        return driver;
	}
	
	public static WebDriver initializeFireFoxDriver()
	{
		System.setProperty("webdriver.firefox.marionette", Parameters.getParameter(Parameters.FF_PATH_KEY));
		//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
 	   	WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver initializeEdgeDriver()
	{
//		System.setProperty("webdriver.edge.driver", Parameters.getParameter(Parameters.EDGE_PATH_KEY));
//		//System.setProperty("webdriver.edge.driver", "C:\\Users\\marqu\\workspace\\SeleniumPOC\\drivers\\MicrosoftWebDriver.exe"); // parameterize second argument
//		WebDriver driver = new EdgeDriver();
//		
//		driver.manage().window().maximize();
//		return driver;
		
		String edgePath = Parameters.getParameter(Parameters.IE_PATH_KEY);//Parameters.getParameter(Parameters.IE_PATH_KEY);
       
        
        File file = new File(edgePath);
        System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        
        return driver;
        
	}

}
