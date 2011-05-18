package Testing.DetectorsTest;

import org.junit.Test;

import PalmWrapper.Detectors.IDetector;
import PalmWrapper.Detectors.PalmDetectException;
import junit.framework.TestCase;


public class TestDetectorAssertion extends TestCase
{
    @Test(expected = PalmDetectException.class)
    public void testNull1()
    {
        try
        {
            detector_.Detect(null, "/dev/1.txt");
            TestCase.fail("Error detecting null string");
        }
        catch (PalmDetectException e)
        {
            //OK
        }
    }

    @Test(expected = PalmDetectException.class)
    public void testNull2() throws PalmDetectException
    {
        try
        {
            detector_.Detect("/dev/1.txt", null);
            TestCase.fail("Error detecting null string");
        }
        catch (PalmDetectException e)
        {
            //OK
        }
    }

    @Test(expected = PalmDetectException.class)
    public void testNullBoth() throws PalmDetectException
    {
        try
        {
        detector_.Detect(null, null);
        TestCase.fail("Error detecting null string");
        }
        catch (PalmDetectException e)
        {
            //OK
        }
    }
    
    protected IDetector detector_ = null;
}
