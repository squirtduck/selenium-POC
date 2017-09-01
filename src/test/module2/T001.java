package test.module2;

import org.openqa.selenium.WebDriver;

import Utilities.functionLibrary.CommonMethods;
import Utilities.reporter.Screenshotter;
import static org.junit.Assert.assertEquals;

public class T001 {
	
	
	public void T001_run(WebDriver driver)
	{
			
			System.out.println("Running T001");
			
			//initializing screenshotter
			String testCaseName = this.getClass().getName();
			Screenshotter camera = new Screenshotter(driver, testCaseName);
			
			
			
			driver = CommonMethods.navigateTo("https://accounts.google.com", driver);
			assertEquals("Sign in - Google Accounts", driver.getTitle());
			camera.takeTestScreenshot(driver);

	}

}
