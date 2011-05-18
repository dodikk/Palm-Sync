package Testing.DetectorsTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PalmWrapper.Detectors.ExecutableDetector;
import PalmWrapper.Detectors.PalmDetectException;

public class TestExeDetector
        extends TestDetectorAssertion
{
    @Before
    protected void setUp()
    {
        detector_ = new ExecutableDetector();
    }

    @After
    protected void tearDown() 
    {
    }

    @Test
    public void testConditions() throws PalmDetectException
    {
        assertFalse(detector_.Detect("/dev/1.txt", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt", "/dev/1"));
        assertTrue(detector_.Detect("/dev/1.txt*", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt@", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt=", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/", "/dev/"));
        assertFalse(detector_.Detect("/dev/", "/dev"));

        try
        {
            assertFalse(detector_.Detect("/dev/1", "/dev/1.txt"));
        }
        catch (PalmDetectException e)
        {
            // Ok
        }
    }
}
