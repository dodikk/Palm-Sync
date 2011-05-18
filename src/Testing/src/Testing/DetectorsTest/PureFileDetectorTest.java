package Testing.DetectorsTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import PalmWrapper.Detectors.PalmDetectException;
import PalmWrapper.Detectors.PureFileDetector;


public class PureFileDetectorTest
        extends TestDetectorAssertion
{
    @Before
    protected void setUp() throws Exception
    {
        detector_ = new PureFileDetector();
    }

    @After
    protected void tearDown()
    {
    }

    @Test
    public void testConditions() throws PalmDetectException
    {
        assertTrue(detector_.Detect("/dev/1.txt", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt", "/dev/1"));
        assertFalse(detector_.Detect("/dev/1.txt*", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt@", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt=", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/", "/dev"));
        assertFalse(detector_.Detect("/dev/", "/dev"));

        
        
        try
        {
            assertFalse(detector_.Detect("/dev/1", "/dev/1.txt"));
        }
        catch (PalmDetectException e)
        {
            //Ok
        }
    }
}
