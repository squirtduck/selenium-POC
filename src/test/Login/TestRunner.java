package test.Login;



import org.junit.runner.JUnitCore;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.helpers.DefaultHandler;


//import javax.swing.text.Document;
//import javax.xml.parsers.SAXParser;
//import javax.xml.parsers.SAXParserFactory;
//import javax.xml.transform.Result;




import Utilities.XMLParser;
import Utilities.environmentConstants.Parameters;
//import tests.*;

//import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
//import java.util.Map;

//import static javax.xml.parsers.SAXParserFactory.*;


/**
 * Created by mgough on 9/9/2014.
 */



public class TestRunner extends DefaultHandler  {
	    //this is the test runner. It simply calls the JUnitCore module, which accepts string arguments and automatically runs all the methods in the
	    // given class, as long as they are annotated with @Test
	    //Each String parameter corresponds to a class, which corresponds to several test cases, identified by name.
	    //Additionally, we will override some methods from the DefaultHandler class in order to parse the xml configuration file

	    public static void main (String args[]) throws FileNotFoundException {

	        //XMLParser.readXML(args[0]);                                                              //processes the command line arguments and returns a filepath

	        @SuppressWarnings("unchecked")
			HashMap<String,String> configMap = XMLParser.initializeConfigurationMap(args[0]); //obtains a storage structure containing all of the configuration settings
	        //HashMap<String, ALMTestScript> testSuiteMap = ALMTestXMLParser.initializeTestSuiteMap(args[1]);
	        // obtains a storage structure containing all of the test script descriptions (navigation) and expected values, by test script step.


	        //initializes the parameters according to the map in the static Paramters class

	        Parameters.initialize(configMap);           //sets all of the configurable parameters which have been captured in the confby XMLParser. if a parameter fails to initialize, then the default value
	        //should be requested from Parameters
	        //Parameters.testInitialize(testSuiteMap);


	        //JUnitCore.main();
	        //JUnitCore.main(TestCases.class.getName());  //we pass the JUnitCore module the name of the class containing all the tests
	      
	        //JUnitCore.main(URLIterationLoop.class.getName());
	        //JUnitCore.main(ParamsTest.class.getName());
	        //JUnitCore.main(IntegratedSampleSauceTest.class.getName());
	        //JUnitCore.main(ParameterizedSauceTest.class.getName());
	        //JUnitCore.main(ConcurrentParameterizedSauceTest.class.getName());
	        //JUnitCore.main(CombinedSaucePOCTest.class.getName());
	        
	        //JUnitCore.main(GeneratedTestPOC.class.getName());
	        
	        //JUnitCore.main(ThrowawayPerformanceTest.class.getName());
	        
	        JUnitCore.main(TestCases.class.getName());


	    }

}

