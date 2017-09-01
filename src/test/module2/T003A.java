package test.module2;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.environmentConstants.Parameters;
import Utilities.functionLibrary.CommonMethods;
import Utilities.reporter.Screenshotter;

public class T003A {
	
	public void T003A_run(WebDriver driver)
	{
		System.out.println("Running T003A_cleanup");
		//initializing screenshot camera
		String testCaseName = this.getClass().getName();
		Screenshotter camera = new Screenshotter(driver, testCaseName);
		
		//navigate to home page
		driver = CommonMethods.navigateTo(Parameters.getParameter(Parameters.FILEINVITE_LOGIN_URL_KEY), driver);
		
		//login
		driver = CommonMethods.login(Parameters.getParameter(
				Parameters.FILEINVITE_LOGIN_KEY),
				Parameters.getParameter(Parameters.FILEINVITE_PASSWORD_KEY),
				Parameters.getXPath(Parameters.XPATH_FILEINVITE_LOGIN_NAME_FIELD_KEY), 
				Parameters.getParameter(Parameters.XPATH_FILEINVITE_PASSWORD_FIELD_KEY), 
										driver);
		
		camera.takeTestScreenshot(driver);
		
		// CLEANUP: remove the test message from the dashboard
		
		// click on the x icon to remove the message
		driver = CommonMethods.clickOnElement(
						Parameters.getXPath(Parameters.XPATH_FILEINVITE_DASHBOARD_REMOVE_NEW_MESSAGE_LINK_T003_KEY),
						driver);
				
		camera.takeTestScreenshot(driver);
				
				
		//confirming invite deletion
		driver = CommonMethods.clickOnElement(
						Parameters.getXPath(Parameters.XPATH_FILEINVITE_CONFIRM_CLEANUP_T003_KEY),
						driver);
		WebDriverWait wait3 = new WebDriverWait(driver,10);
		
		wait3.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(
		        		Parameters.getXPath(Parameters.XPATH_FILEINVITE_CONFIRM_CLEANUP_T003_KEY))));
		
		camera.takeTestScreenshot(driver);
		        
		// asserting that new invite has been deleted (by checking that new invite deletion button is NOT present)
		String xpath = Parameters.getXPath(Parameters.XPATH_FILEINVITE_DASHBOARD_REMOVE_NEW_MESSAGE_LINK_T003_KEY);
		assertTrue(CommonMethods.isElementGone(driver, xpath));
		        
		
		
		        
		     
	}

}
