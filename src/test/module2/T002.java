package test.module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.environmentConstants.Parameters;
import Utilities.functionLibrary.CommonMethods;
import Utilities.reporter.Screenshotter;
import static org.junit.Assert.assertEquals;

public class T002 {
	
	public void T002_run(WebDriver driver)
	{
			System.out.println("Running T002");
			
			//initializing screenshot camera
			String testCaseName = this.getClass().getName();
			Screenshotter camera = new Screenshotter(driver, testCaseName);
			
			//navigate to home page
			driver = CommonMethods.navigateTo(Parameters.getParameter(Parameters.FILEINVITE_LOGIN_URL_KEY), driver);
			
			//login
			//driver = CommonMethods.loginToFileDriver(Parameters.getParameter(Parameters.FILEINVITE_LOGIN_KEY), Parameters.getParameter(Parameters.FILEINVITE_PASSWORD_KEY), driver);
			driver = CommonMethods.login(Parameters.getParameter(
					Parameters.FILEINVITE_LOGIN_KEY),
					Parameters.getParameter(Parameters.FILEINVITE_PASSWORD_KEY),
					Parameters.getXPath(Parameters.XPATH_FILEINVITE_LOGIN_NAME_FIELD_KEY), 
					Parameters.getParameter(Parameters.XPATH_FILEINVITE_PASSWORD_FIELD_KEY), 
											driver);
			
			camera.takeTestScreenshot(driver);
			
			//assert login
			
			String expectedLogin = Parameters.getParameter(Parameters.FILEINVITE_LOGIN_KEY);
			String actualLogin  = driver.findElement(By.xpath(Parameters.getXPath(Parameters.XPATH_FILEINVITE_USERNAME_DROPDOWN_KEY))).getText().trim();
			
			assertEquals(expectedLogin, actualLogin);
	}

}
