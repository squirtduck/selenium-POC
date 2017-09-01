package Utilities.environmentConstants;
//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Map;

/**
 * Created by mgough on 9/24/2014.
 */
public abstract class Parameters { //this class is a container for configurable string variables, including xpaths

    //!IMPORTANT!
    //The names for each of the key strings should be the same as the name for the corresponding default string

    //Map for storing configured values
    private static HashMap<String,String> masterParameterMap;



    //public map keys for parameters -- public because they are used to retrieve the parameters from the configuration map
    //FORMAT public static final String *****_KEY = "PARAMETER_*****";
    
    public static final String PAGELOAD_TIME_KEY = "PARAMETER_PAGELOAD_TIME";
    
    public static final String CHROME_PATH_KEY = "PARAMETER_CHROME_PATH";
    public static final String FF_PATH_KEY = "PARAMETER_FF_PATH";
    public static final String IE_PATH_KEY = "PARAMETER_IE_PATH";
    public static final String FILEINVITE_LOGIN_URL_KEY = "PARAMETER_FILEINVITE_LOGIN_URL";
    public static final String FILEINVITE_LOGIN_KEY = "PARAMETER_FILEINVITE_LOGIN";
    public static final String FILEINVITE_PASSWORD_KEY = "PARAMETER_FILEINVITE_PASSWORD";
    public static final String FILEINVITE_NEWINVITE_DATE_KEY = "PARAMETER_FILEINVITE_NEWINVITE_DATE";
    public static final String FILEINVITE_NEWINVITE_RECIPIENT_KEY = "PARAMETER_FILEINVITE_NEWINVITE_RECIPIENT";
    public static final String FILEINVITE_NEWINVITE_SUBJECT_KEY = "PARAMETER_FILEINVITE_NEWINVITE_SUBJECT";
    public static final String FILEINVITE_NEWREQUEST_SUBJECT_KEY = "PARAMETER_FILEINVITE_NEWREQUEST_SUBJECT";
    public static final String FILEINVITE_NEWINVITE_MESSAGE_STATUS_KEY = "PARAMETER_FILEINVITE_NEWINVITE_MESSAGE_STATUS";
    
    public static final String FILEINVITE_LOGO_LOCALPATH_KEY = "PARAMETER_FILEINVITE_LOGO_LOCALPATH";
    public static final String FILEINVITE_LOGO_URL_KEY = "PARAMETER_FILEINVITE_LOGO_URL";
    public static final String SCREENSHOT_DIRECTORY_PATH_KEY = "PARAMETER_SCREENSHOT_DIRECTORY_PATH";
    
//    public static final String LANDING_URL_KEY = "PARAMETER_LANDING_URL";
//    public static final String URL_REPOSITORY_PATH_KEY = "PARAMETER_URL_REPOSITORY_PATH";
//    public static final String BROWSER_REPOSITORY_PATH_KEY = "PARAMETER_BROWSER_REPOSITORY_PATH";
//    
//    public static final String REMOTE_USERNAME_KEY = "PARAMETER_REMOTE_USERNAME";
//    public static final String REMOTE_ACCESSKEY_KEY = "PARAMETER_REMOTE_ACCESSKEY";
    
    
    
    
    
    
    

    //public map keys for xpaths -- public because they are used to retrieve the xpaths from the configuration map
    //FORMAT public static final String XPATH_*****_KEY = "XPATH_*****";
    public static final String XPATH_FILEINVITE_LOGIN_NAME_FIELD_KEY = "XPATH_FILEINVITE_LOGIN_NAME_FIELD";
    public static final String XPATH_FILEINVITE_PASSWORD_FIELD_KEY = "XPATH_FILEINVITE_PASSWORD_FIELD";
    public static final String XPATH_FILEINVITE_USERNAME_DROPDOWN_KEY = "XPATH_FILEINVITE_USERNAME_DROPDOWN";
    public static final String XPATH_FILEINVITE_NEWINVITE_DROPDOWN_KEY = "XPATH_FILEINVITE_NEWINVITE_DROPDOWN";
    public static final String XPATH_FILEINVITE_NEWINVITE_ORIGIN_SELECTION_KEY = "XPATH_FILEINVITE_NEWINVITE_ORIGIN_SELECTION";
    public static final String XPATH_FILEINVITE_NEWINVITE_RECIPIENT_FIELD_KEY = "XPATH_FILEINVITE_NEWINVITE_RECIPIENT_FIELD";
    public static final String XPATH_FILEINVITE_NEWINVITE_RECIPIENT_SAMPLE_CONTACT_FIELD_KEY = "XPATH_FILEINVITE_NEWINVITE_RECIPIENT_SAMPLE_CONTACT_FIELD";
    public static final String XPATH_FILEINVITE_NEWINVITE_CALENDAR_FIELD_KEY = "XPATH_FILEINVITE_NEWINVITE_CALENDAR_FIELD";
    public static final String XPATH_FILEINVITE_NEWREQUEST_BUTTON_KEY = "XPATH_FILEINVITE_NEWREQUEST_BUTTON";
    public static final String XPATH_FILEINVITE_NEWINVITE_TITLE_FIELD_KEY = "XPATH_FILEINVITE_NEWINVITE_TITLE_FIELD";
    public static final String XPATH_FILEINVITE_NEWREQUEST_TITLE_FIELD_KEY = "XPATH_FILEINVITE_NEWREQUEST_TITLE_FIELD";
    public static final String XPATH_FILEINVITE_NEWREQUEST_SAVE_BUTTON_KEY = "XPATH_FILEINVITE_NEWREQUEST_SAVE_BUTTON";
    public static final String XPATH_FILEINVITE_NEWINVITE_COMPLETE_BUTTON_KEY = "XPATH_FILEINVITE_NEWINVITE_COMPLETE_BUTTON";   
    public static final String XPATH_FILEINVITE_NEWINVITE_SEND_BUTTON_KEY = "XPATH_FILEINVITE_NEWINVITE_SEND_BUTTON";
    public static final String XPATH_FILEINVITE_DASHBOARD_LINK_KEY = "XPATH_FILEINVITE_DASHBOARD_LINK";
    public static final String XPATH_FILEINVITE_NEWINVITE_MESSAGE_STATUS_LOCATION_KEY = "XPATH_FILEINVITE_NEWINVITE_MESSAGE_STATUS_LOCATION";
    public static final String XPATH_FILEINVITE_DASHBOARD_REMOVE_NEW_MESSAGE_LINK_T003_KEY = "XPATH_FILEINVITE_DASHBOARD_REMOVE_NEW_MESSAGE_LINK_T003";
    public static final String XPATH_FILEINVITE_CONFIRM_CLEANUP_T003_KEY = "XPATH_FILEINVITE_CONFIRM_CLEANUP_T003";

    
    
    //    public static final String XPATH_HEADER_WHYBUY_LOCATION_KEY = "XPATH_HEADER_WHYBUY_LOCATION";
//    public static final String XPATH_HEADER_WHYBUY_OVERVIEW_LINK_KEY = "XPATH_HEADER_WHYBUY_OVERVIEW_LINK";

   
    // public map keys for test cases- public because they are used to retrieve the test case run status from the configuration file
    
    public static final String TEST_T001_KEY = "TEST_T001";
    public static final String TEST_T002_KEY = "TEST_T002";
    public static final String TEST_T003_KEY = "TEST_T003";
    public static final String TEST_T003A_KEY = "TEST_T003A";
    public static final String TEST_T004_KEY = "TEST_T004";

    public static void initialize(HashMap<String, String> parameterMapInput){ //This method initializes each of the parameters supplied in the configuration map. the keys should be supplied from the above
        //default map keys

        masterParameterMap = new HashMap<String,String>();

        for (String key : parameterMapInput.keySet()){

            masterParameterMap.put(key, parameterMapInput.get(key));
            //System.out.println("Storing " + parameterMapInput.get(key) + " at " + key );
            

        }

    }


    public static String getParameter(String parameterKey){ //this method returns a parameter from the map. if there is no initialized value for the requested parameter, then this method returns the default or null

        String parameterValue = null;
        String defaultStringName = null;

        if (masterParameterMap.containsKey(parameterKey)) {
            parameterValue = masterParameterMap.get(parameterKey);
        }
        else
        {
            defaultStringName = parameterKey.replace("PARAMETER_","") + "_DEFAULT";

            try {
                parameterValue = (String) Parameters.class.getField(defaultStringName).get(parameterValue);
            }
            catch (Exception noSuchField)
            {

                return null;
            }
            // Stubbing out default parameter output to clean up report
            //System.out.println("\nParameter \"" + parameterKey.replace("PARAMETER_", "") + "\"" + " is not configured; using default value: " + parameterValue);

        }


        return parameterValue;
    }
    
   


    public static String getXPath(String xPathKey){ //this method returns a parameter from the map. if there is no initialized value for the requested parameter, then this method returns the default or null

        String xPathValue = null;
        String defaultXPathName = null;

        if (masterParameterMap.containsKey(xPathKey)) {
            xPathValue = masterParameterMap.get(xPathKey);
        }
        else
        {
            defaultXPathName = xPathKey.replace("XPATH_","") + "_XPATH_DEFAULT";

            try {
                xPathValue = (String) Parameters.class.getField(defaultXPathName).get(xPathValue);
            }
            catch (Exception noSuchField)
            {

                return null;
            }

            // Stubbing out default xpath output to clean up report
            //System.out.println("\nNo XPATH configured for \"" + xPathKey.replace("XPATH_", "") + "\"" + "; using the default value: " + xPathValue);

        }

        return xPathValue;
    }


    /*public static void testInitialize(HashMap<String, ALMTestScript> testMapInput)
    {
        masterTestSuiteMap = new HashMap<String,ALMTestScript>();

        for (String key : testMapInput.keySet())
        {
            masterTestSuiteMap.put(key, testMapInput.get(key));
        }

    }

    public static ALMTestScript getTestScript(String testScriptIDKey)
    {

        ALMTestScript retrievedTestScript; // = new ALMTestScript("",ArrayList <ALMTestStep>);
        try
        {
            retrievedTestScript = masterTestSuiteMap.get(testScriptIDKey);
        }
        catch (Exception noSuchField)
        {
            return null;
        }

        return retrievedTestScript;
    }*/



    // deprecated, the flag for whether a test case should be executed is now in test configuration xml (tag executionflag)
    public static String getTest(String testKey){ //this method returns a parameter from the map. if there is no initialized value for the requested parameter, then this method returns the default or null

        String testValue = null;
        String defaultTestName = null;

        if (masterParameterMap.containsKey(testKey)) {
            testValue = masterParameterMap.get(testKey);
        }
        else
        {
            defaultTestName = testKey.replace("TEST_","") + "_DEFAULT";

            try {
                testValue = (String) Parameters.class.getField(defaultTestName).get(testValue);
            }
            catch (Exception noSuchField)
            {

                return "FALSE";
            }
            // Stubbing out default test output to clean up report
            //System.out.println("\n" + "Parameter \"" + testKey.replace("TEST_", "") + "\" is not configured;" + "; using the default value: " + testValue);

        }
        return testValue;
    }

}
