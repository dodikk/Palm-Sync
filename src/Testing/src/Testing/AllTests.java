package Testing;

import Testing.BlackListTest.BlackListTest;
import Testing.DetectorsTest.AllDetectorsTests;
import Testing.PathFilterTest.AllPathFilterTests;
import Testing.TestOptions.OptionsParserTest;
import Testing.TestOptions.DOptionsParserTest;
import Testing.MountTest.TestMountParser;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests
{

    public static Test suite()
    {
        TestSuite suite = new TestSuite("Test for Palm Sync");
        //$JUnit-BEGIN$
        suite.addTest(AllDetectorsTests.suite());
        suite.addTest(AllPathFilterTests.suite());
        suite.addTestSuite(TestMountParser.class);
        suite.addTestSuite(BlackListTest.class);
        suite.addTestSuite(OptionsParserTest.class);
        suite.addTestSuite(DOptionsParserTest.class);
        //$JUnit-END$
        return suite;
    }

}
