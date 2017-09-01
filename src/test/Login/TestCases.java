package test.Login;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import test.module2.T001;
import test.module2.T002;
import test.module2.T003;
import test.module2.T003A;
import test.module2.T004;
import Utilities.environmentConstants.Parameters;
import Utilities.functionLibrary.PreConditionalMethods;
import Utilities.reporter.JUnitHTMLReporter;

public class TestCases extends JUnitHTMLReporter{
	
	WebDriver ffBrowser;
	WebDriver edgeBrowser;
	WebDriver chromeBrowser;

	@Before
	public void setupBrowsers()
	{
		ffBrowser = PreConditionalMethods.initializeFireFoxDriver();
		edgeBrowser = PreConditionalMethods.initializeEdgeDriver();
		chromeBrowser = PreConditionalMethods.initializeChromeDriver();
	}
//	@Test
//	public void T001_test()
//	{
//		T001 test = new T001();
//		
//		if(Parameters.getTest(Parameters.TEST_T001_KEY).equals("T"))
//		{
//			test.T001_run(ffBrowser);
//			test.T001_run(edgeBrowser);
//			test.T001_run(chromeBrowser);
//		}
//			
//				
//	}
//	
//	@Test
//	public void T002_test()
//	{
//		T002 test = new T002();
//		
//		if(Parameters.getTest(Parameters.TEST_T002_KEY).equals("T"))
//		{
//			test.T002_run(ffBrowser);
//			test.T002_run(edgeBrowser);
//			test.T002_run(chromeBrowser);
//		}
//				
//	}
	
//	@Test
//	public void T003_test()
//	{
//		T003 test = new T003();
//		
//		if(Parameters.getTest(Parameters.TEST_T003_KEY).equals("T"))
//		{
//			test.T003_run(chromeBrowser);
//		}
//			
//	}
	
	@Test
	public void T003A_test()
	{
		T003A test = new T003A();
		if(Parameters.getTest(Parameters.TEST_T003A_KEY).equals("T"))
		{
			//test.T003A_run(ffBrowser);
			test.T003A_run(chromeBrowser);
			
		}
	}
//	
//	@Test
//	public void T004_test()
//	{
//		if(Parameters.getTest(Parameters.TEST_T004_KEY).equals("T"))
//		{
//			ffBrowser = PreConditionalMethods.initializeFireFoxDriver();
//			T004 test = new T004();
//			test.T004_run(ffBrowser);
//			ffBrowser.close();
//		}
//	}
	
//	@Test
//	public void T005_test()
//	{
//		
//	}
	
	@After
	public void clean_up()
	{
		ffBrowser.close();
		edgeBrowser.close();
		chromeBrowser.close();
	}
	

}
