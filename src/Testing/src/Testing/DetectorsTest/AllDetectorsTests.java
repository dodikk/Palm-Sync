package Testing.DetectorsTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllDetectorsTests extends TestSuite
{
    public AllDetectorsTests()
    {
        super("Test for Testing.DetectorsTest");
        Initialize();
    }
    
    private void Initialize()
    {
        this.addTestSuite(TestSymLinkDetector.class);
        this.addTestSuite(TestFolderDetector.class);
        this.addTestSuite(SocketDetectorTest.class);
        this.addTestSuite(PureFileDetectorTest.class);
        this.addTestSuite(TestExeDetector.class);
    }
    
    
    public static Test suite()
    {
        TestSuite suite = new AllDetectorsTests();
        return suite;
    }

}
