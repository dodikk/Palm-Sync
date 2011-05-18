package Testing.DetectorsTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import PalmWrapper.Detectors.FolderDetector;
import PalmWrapper.Detectors.PalmDetectException;

public class TestFolderDetector
        extends TestDetectorAssertion
{
    @Before
    protected void setUp() throws Exception
    {
        detector_ = new FolderDetector();
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
        assertFalse(detector_.Detect("/dev/1.txt*", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt@", "/dev/1.txt"));
        assertFalse(detector_.Detect("/dev/1.txt=", "/dev/1.txt"));
        assertTrue(detector_.Detect("/dev/", "/dev/"));
        assertTrue(detector_.Detect("/dev/", "/dev"));

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


