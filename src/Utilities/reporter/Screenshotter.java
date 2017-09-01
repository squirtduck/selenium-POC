package Utilities.reporter;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utilities.environmentConstants.Parameters;
import Utilities.functionLibrary.CommonMethods;

public class Screenshotter {
	
	private String filepath;
	private String testCaseName;
	private int iterator;
	private String screenShotFileExtension;
	
	public Screenshotter(WebDriver driver, String testName )
	{
		filepath = Screenshotter.fileNameConstructor(driver);
		testCaseName = testName;
		iterator = 0;
		screenShotFileExtension = ".png";
	}
	
	public void takeTestScreenshot(WebDriver driver)
	{
		iterator++;
		Screenshotter.takeSnapShot(driver, filepath + testCaseName + "-" + iterator + screenShotFileExtension);
	}


	@Test
    public void testGuru99TakeScreenShot() throws Exception{

		WebDriver driver ;
    	System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
    	driver = new FirefoxDriver();

        //goto url

        driver.get("http://demo.guru99.com/V4/");
        this.takeSnapShot(driver, "C:\\Users\\marqu\\workspace\\POCSeleniumFramework\\screenshots\\test.png") ;   

    }
 

    /**

     * This function will take screenshot

     * @param webdriver

     * @param fileWithPath

     * @throws Exception

     */

    public static void takeSnapShot(WebDriver webdriver,String fileWithPath)
    {

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    }
    
    public static String fileNameConstructor(WebDriver driver)
    {
    	DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy, HHmmss");
    	Date date = new Date();
    	
    	
    	
    	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
    	
    	//String output = Parameters.getParameter(Parameters.SCREENSHOT_DIRECTORY_PATH_KEY) + browserName + "," + dateFormat.format(date);
    	
    	String output = System.getProperty("user.dir") + Parameters.getParameter(Parameters.SCREENSHOT_DIRECTORY_PATH_KEY) + browserName + "," + dateFormat.format(date);
    	
    	return output;
    	
    	
    }
}
