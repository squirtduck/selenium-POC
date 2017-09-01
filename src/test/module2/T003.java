package test.module2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.environmentConstants.Parameters;
import Utilities.functionLibrary.CommonMethods;
import Utilities.reporter.Screenshotter;
import static org.junit.Assert.assertEquals;


// the navigation in this test case only works in chrome (specifically the dropdown menu when choosing an invite recipient)
public class T003 {
	
	public void T003_run(WebDriver driver)
	{
			System.out.println("Running T003");
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
			
			// create a new invite from me (click on menu)
			driver = CommonMethods.clickOnElement(
					Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_DROPDOWN_KEY), 
					driver);
			
			
			// create a new invite from me (select from menu)
			driver = CommonMethods.clickOnElement(
					Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_ORIGIN_SELECTION_KEY), 
					driver);
		
			// Create new invite
			WebDriverWait wait2 = new WebDriverWait(driver,10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
            		Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_RECIPIENT_FIELD_KEY))));
            	// open invite recipient list
            		driver = CommonMethods.clickOnElement(
            				Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_RECIPIENT_FIELD_KEY),
            				driver);
            	// select sample contact on recipient list
//            WebDriverWait wait3 = new WebDriverWait(driver,10);
//            wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(
//            		Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_RECIPIENT_SAMPLE_CONTACT_FIELD_KEY)
//                    )));
            		driver = CommonMethods.clickOnElement(
            				Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_RECIPIENT_SAMPLE_CONTACT_FIELD_KEY), 
            				driver);            		
				// select due date 
					driver = CommonMethods.fillOutFieldWithoutSubmission(
							Parameters.getParameter(Parameters.FILEINVITE_NEWINVITE_DATE_KEY), 
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_CALENDAR_FIELD_KEY), 
							driver);
				// fill out invite subject field
					driver = CommonMethods.fillOutFieldWithoutSubmission(
							Parameters.getParameter(Parameters.FILEINVITE_NEWINVITE_SUBJECT_KEY), 
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_TITLE_FIELD_KEY), 
							driver);
					camera.takeTestScreenshot(driver);
					
					
				// click on "Add Request"
					driver = CommonMethods.clickOnElement(
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWREQUEST_BUTTON_KEY),
							driver);
					
				// fill out request title or name field
					driver = CommonMethods.fillOutFieldWithoutSubmission(
							Parameters.getParameter(Parameters.FILEINVITE_NEWREQUEST_SUBJECT_KEY), 
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWREQUEST_TITLE_FIELD_KEY), 
							driver);
				// hit save button
					driver = CommonMethods.clickOnElement(
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWREQUEST_SAVE_BUTTON_KEY),
							driver);
					
					camera.takeTestScreenshot(driver);
					
				// click on Next Review button
					driver = CommonMethods.clickOnElement(
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_COMPLETE_BUTTON_KEY),
							driver);
					
					camera.takeTestScreenshot(driver);
					
				// click on send FileInvite button
					driver = CommonMethods.clickOnElement(
							Parameters.getXPath(Parameters.XPATH_FILEINVITE_NEWINVITE_SEND_BUTTON_KEY),
							driver);
					
					camera.takeTestScreenshot(driver);
		
	// validation
		// click on dashboard navigation button
		driver = CommonMethods.clickOnElement(
				Parameters.getXPath(Parameters.XPATH_FILEINVITE_DASHBOARD_LINK_KEY),
				driver);
		// assert that the newly created invite title appears on the invite list
		// assert that the newly created invite title due date is the same date that we input
		// assert that the newly created invite title status is sent, as we expected
		
		String expectedValue = Parameters.getParameter(Parameters.FILEINVITE_NEWINVITE_MESSAGE_STATUS_KEY);
		String actualValue = driver.findElement(By.xpath(
				Parameters.getXPath(
						Parameters.XPATH_FILEINVITE_NEWINVITE_MESSAGE_STATUS_LOCATION_KEY)))
						.getText().trim();
		
		camera.takeTestScreenshot(driver);
		
		assertEquals(expectedValue, actualValue);
				
	}

}
	