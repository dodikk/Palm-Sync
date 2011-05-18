package Testing.TestOptions;

import junit.framework.TestCase;
import org.junit.Test;

import DataSynchronizer.OptionsParser;

public class DOptionsParserTest extends TestCase
{
    @Test
    public void testFunctionality()
    {
        {
            args = new String[] {};
            OptionsParser parser = new OptionsParser(args);
            
            assertEquals("c:/temp/", parser.GetBackupPath());
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertTrue(isMedia);
            assertTrue(isDataBase);
            assertTrue(isApplication);
            assertTrue(isJava);
        }
        
        {
            args = new String[] { "c:/temp" };
            OptionsParser parser = new OptionsParser(args);
            
            assertEquals("c:/temp/", parser.GetBackupPath());
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertTrue(isMedia);
            assertTrue(isDataBase);
            assertTrue(isApplication);
            assertTrue(isJava);
        }
        
        {
            args = new String[] { "c:/temp", "--all" };
            OptionsParser parser = new OptionsParser(args);
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertTrue(isMedia);
            assertTrue(isDataBase);
            assertTrue(isApplication);
            assertTrue(isJava);
        }
        
        {
            args = new String[] { "c:/temp"};
            OptionsParser parser = new OptionsParser(args);
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertTrue(isMedia);
            assertTrue(isDataBase);
            assertTrue(isApplication);
            assertTrue(isJava);
        }
        
        
        {
            args = new String[] { "c:/temp", "", "--data" };
            OptionsParser parser = new OptionsParser(args);
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertFalse(isMedia);
            assertTrue(isDataBase);
            assertFalse(isApplication);
            assertFalse(isJava);
        }
        
        {
            args = new String[] { "c:/temp", "", "--media" };
            OptionsParser parser = new OptionsParser(args);
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertTrue(isMedia);
            assertFalse(isDataBase);
            assertFalse(isApplication);
            assertFalse(isJava);
        }
        
        {
            args = new String[] { "/dev", "", "--java" };
            OptionsParser parser = new OptionsParser(args);
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertFalse(isMedia);
            assertFalse(isDataBase);
            assertFalse(isApplication);
            assertTrue(isJava);
        }
        
        {
            args = new String[] { "/dev", "", "--app" };
            OptionsParser parser = new OptionsParser(args);
            
            isMedia = parser.IsAcquireMedia();
            isDataBase = parser.IsAcquireDataBase();
            isApplication = parser.IsAcquireApplication();
            isJava = parser.IsAcquireJava();
            
            assertFalse(isMedia);
            assertFalse(isDataBase);
            assertTrue(isApplication);
            assertFalse(isJava);
        }
    }

    @Test
    public void testNull()
    {
        try
        {
            args = null;
            new OptionsParser(args);
            fail();
        }
        catch (Exception e)
        {
            // OK
        }
    }

    String[] args = null;
    String expectedDev = null;
    String actualDev = null;

    boolean isMedia = false;
    boolean isDataBase = false;
    boolean isApplication = false;
    boolean isJava = false;
}
