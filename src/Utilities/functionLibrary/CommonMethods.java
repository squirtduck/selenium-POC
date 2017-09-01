package Utilities.functionLibrary;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelReader;
import Utilities.dataSetters.TestData;
import Utilities.environmentConstants.Parameters;
import home.*;

/**
* Read the test data from excel file
* @param data The TestData data object
*/
public class CommonMethods
{
	public static WebDriver login(String username, String password, String usernamexpathlocator, String passwordxpathlocator, WebDriver driver)
	{
		// enter username
		WebElement userName = driver.findElement(By.xpath(usernamexpathlocator));
		userName.clear();
		userName.sendKeys(username);
				
		// Enter Password
		WebElement passWord = driver.findElement(By.xpath(passwordxpathlocator));
		passWord.clear();
		passWord.sendKeys(password);
				
		passWord.submit();
				
		return driver;
	}
	
	public static WebDriver dropdownSelection(String choice, String dropdownxpathlocator, WebDriver driver)
	{
		//click on dropdown
		Select dropdown = new Select(driver.findElement(By.xpath(dropdownxpathlocator)));
		
		//select from dropdown
		dropdown.selectByValue(choice);		
		return driver;
	}
	
	public static WebDriver navigateTo(String url, WebDriver driver)
	{
		driver.get(url);
		return driver;
	}
	
	public static WebDriver clickOnElement(String elementxpathlocator, WebDriver driver)
	{
		// create webelement to be clicked
		WebElement elementToBeClickedOn = driver.findElement(By.xpath(elementxpathlocator));
		
		// click on webelement
		elementToBeClickedOn.click();
		
		return driver;
	}
	
	public static WebDriver fillOutField(String fieldContent, String fieldxpathlocator, WebDriver driver)
	{
		// enter field
		WebElement field = driver.findElement(By.xpath(fieldxpathlocator));
		field.clear();
		field.sendKeys(fieldContent);

		field.submit();
		return driver;
	}
	
	public static WebDriver fillOutFieldWithoutSubmission(String fieldContent, String fieldxpathlocator, WebDriver driver)
	{
		// enter field
		WebElement field = driver.findElement(By.xpath(fieldxpathlocator));
		field.clear();
		field.sendKeys(fieldContent);
		return driver;
	}
	
	public static boolean compareWebImages(String localImageLocation, String webImageURL) throws MalformedURLException, IOException
	{
		//Main class object comes from ImgzCmp project that was added to this project's build path
			//this method compares the image located at the first argument with the webimage located 
			//at the second argument's url
		return Main.compareWebImageToLocalFile(localImageLocation, webImageURL);
	}
	
	public static boolean isElementGone(WebDriver driver, String xpathOfElement)
	{
		return driver.findElements(By.xpath(xpathOfElement)).size() < 1;
	}
//	public static WebDriver hoverOnElement(String elementxpathlocator, WebDriver driver)
//	{
//		WebElement elementToBeHoveredOver = driver.findElement(By.xpath(elementxpathlocator));
//		
//		return driver;
//	}
//	
	
	public void readExcelData (TestData data) 
	{
	       ArrayList<String> browser = new ArrayList<String>();
	       ArrayList<String> username = new ArrayList<String>();
	       ArrayList<String> password = new ArrayList<String>();
	       ArrayList<String> element1 = new ArrayList<String>();
	       ArrayList<String> element2 = new ArrayList<String>();
	       ArrayList<String> element3 = new ArrayList<String>();
	       
	       // Get the data from excel file
	       for (int rowCnt = 1; rowCnt < ExcelReader.RowCount(); rowCnt++) 
	       {
	    	   browser.add(ExcelReader.ReadCell(ExcelReader.GetCell("Browser"), rowCnt));
	    	   username.add(ExcelReader.ReadCell(ExcelReader.GetCell("User ID"), rowCnt));
	    	   password.add(ExcelReader.ReadCell(ExcelReader.GetCell("Password"), rowCnt));
	    	   element1.add(ExcelReader.ReadCell(ExcelReader.GetCell("Element1"), rowCnt));
	    	   element2.add(ExcelReader.ReadCell(ExcelReader.GetCell("Element2"), rowCnt));
	    	   element3.add(ExcelReader.ReadCell(ExcelReader.GetCell("Element3"), rowCnt));
	       }
	       data.setBrowser(browser);
	       data.setLoginUser(username);
	       data.setPassword(password);
	       data.setElement1(element1);
	       data.setElement2(element2);
	       data.setElement3(element3);
	}
	
//	public void login(String username, String password) {
//		try {
//		// Enter User Name
//		WebElement userName = driver.findElement(By.id("loginID"));
//		userName.clear();
//		userName.sendKeys(username);
//		// Enter Password
//
//		WebElement passWord = driver.findElement(By.id("Password"));
//		passWord.clear();
//		passWord.sendKeys(password);
//		// Click on the Sign In Button
//		WebElement signin = driver.findElement(By.id("SignIn_button"));
//		signin.click();
//		driver.manage().window().maximize();
//		} catch (Exception e) {
//		e.printStackTrace();
//		}
//		}

}

