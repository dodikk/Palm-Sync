package Testing.TestOptions;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

import PalmSynchronizer.OptionsParser;




public class OptionsParserTest extends TestCase
{
    @Before
    protected void setUp()
    {        
    }
    
    @Test
    public void testFunctionality()
    {       
        {
            args = new String[] { "/dev", "c:/temp/ha ha ha" };
            OptionsParser parser = new OptionsParser(args);

            actualDev = parser.GetDevicePath();
            expectedDev = "/dev/";
            assertEquals(expectedDev, actualDev);
            
            expectedBkp = "c:/temp/ha ha ha/";
            actualBkp = parser.GetBackupPath();
        }
        
        
        {
            args = new String[] { "", "c:/temp/ha ha ha/" };
            OptionsParser parser = new OptionsParser(args);

            actualDev = parser.GetDevicePath();
            expectedDev = "/";
            assertEquals(expectedDev, actualDev);
            
            expectedBkp = "c:/temp/ha ha ha/";
            actualBkp = parser.GetBackupPath();
        }
        
        {
            args = new String[] {""};
            OptionsParser parser = new OptionsParser(args);

            actualDev = parser.GetDevicePath();
            expectedDev = "/";
            assertEquals(expectedDev, actualDev);
            
            expectedBkp = "c:/temp/";
            actualBkp = parser.GetBackupPath();
        }
        
        
        {
            args = new String[] {};
            OptionsParser parser = new OptionsParser(args);

            actualDev = parser.GetDevicePath();
            expectedDev = "/";
            assertEquals(expectedDev, actualDev);
            
            expectedBkp = "c:/temp/";
            actualBkp = parser.GetBackupPath();
        }
    }

    @Test
    public void testNull()
    {
        args = null;
        
        try
        {
            new OptionsParser(args);
            fail();
        }
        catch(Exception e)
        {
            //OK
        }
    }
    
    String[] args = null;
    String expectedDev = null;
    String actualDev = null;
    
    String expectedBkp = null;
    String actualBkp = null;
}
