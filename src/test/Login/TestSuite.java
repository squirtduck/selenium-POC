package test.Login;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

//Testsuite is a logical combination of more than one test scripts. 
//Thus, the user can mark an entry of any of the test script within the testsuite 
	// that he/she desires to execute in the subsequent runs.

/*@RunWith(Suite.class)
@Suite.SuiteClasses({

       ChangeStatusBinarySphereTest.class,
       ChangeStatusRestrictionTest.class,
       ChangeStatusDocSphereTest.class,
      })*/
public class TestSuite {
       /**
        * Setup method to set system properties
        */
       @BeforeClass
       public static void Setup() {
       }
       /**
        * @param args
        */
       public static void main(String[] args) {
              Result result = JUnitCore.runClasses(TestSuite.class);
              System.out.println("TEST CASES RUN: " + result.getRunCount());
              System.out.println("TEST CASES FAILED: " + result.getFailureCount());
              for (Failure failure : result.getFailures()) {
                     System.out.println("\nTEST NAME: " + failure.getTestHeader());
                     System.out.println("\nERROR: " + failure.getMessage() + "\n");
                     System.out.println(failure.getTrace());
                     System.exit(1);
              }
       }
       /**
        * Report test results
        */
       @AfterClass
       public static void TearDown() 
       {
       }
}

    