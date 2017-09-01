package test.module2;

import java.io.IOException;
import java.net.MalformedURLException;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import Utilities.environmentConstants.Parameters;
import Utilities.functionLibrary.CommonMethods;

public class T004 {
	
	@SuppressWarnings("deprecation")
	public void T004_run(WebDriver driver)
	{
		System.out.println("Executing T004");
		//navigate to home page
		driver = CommonMethods.navigateTo(Parameters.getParameter(Parameters.FILEINVITE_LOGIN_URL_KEY), driver);
		
		//login
		driver = CommonMethods.login(Parameters.getParameter(
				Parameters.FILEINVITE_LOGIN_KEY),
				Parameters.getParameter(Parameters.FILEINVITE_PASSWORD_KEY),
				Parameters.getXPath(Parameters.XPATH_FILEINVITE_LOGIN_NAME_FIELD_KEY), 
				Parameters.getParameter(Parameters.XPATH_FILEINVITE_PASSWORD_FIELD_KEY), 
										driver);
	
		
		// assert some image on page
		try {
			Assert.assertTrue("webimage matched local image as expected", CommonMethods.compareWebImages(
					Parameters.getParameter(Parameters.FILEINVITE_LOGO_LOCALPATH_KEY), 
					Parameters.getParameter(Parameters.FILEINVITE_LOGO_URL_KEY)));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
