package Testing.PathFilterTest;

import junit.framework.Test;
import junit.framework.TestSuite;


public class AllPathFilterTests
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for Testing.PathFilterTest");
        //$JUnit-BEGIN$
        
        suite.addTestSuite(TestEmptyFilter.class);
        suite.addTestSuite(TestWinFilter.class);
        
        //$JUnit-END$
        return suite;
    }

}
