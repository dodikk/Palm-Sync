package Testing.PathFilterTest;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import Path.EmptyFilter;

public class TestEmptyFilter extends TestCase
{

    @Before
    public void setUp()
    {
    }
    
    @Test
    public void testWork()
    {
        EmptyFilter filter = new EmptyFilter();
        
        String expected = "Hello World";
        String actual = filter.DoFilter(expected);
        assertEquals(expected, actual);
        
        
        expected = null;
        actual = filter.DoFilter(expected);
        assertEquals(expected, actual);
    }

}
