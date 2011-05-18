package Testing.PathFilterTest;


import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import Path.WinPathFilter;

public class TestWinFilter extends TestCase
{

    @Before
    public void setUp()
    {
        filter_ = new WinPathFilter();
    }

    
    @Test
    public void testWork()
    {       
        String expected = "Hello World";
        String actual = filter_.DoFilter(expected);
        assertEquals(expected, actual);
        
        
        expected = null;
        actual = filter_.DoFilter(expected);
        assertEquals(expected, actual);
    }
    

    @Test
    public void testDecoration()
    {       
        String src = "H<e>l*l|o W?o\"r:ld";
        String actual = filter_.DoFilter(src);
        String expected = "H_LESS_e_MORE_l_STAR_l_BAR_o W_QUESTION_o_QUOTE_r_DDOT_ld";
        assertEquals(expected, actual);
    }

    WinPathFilter filter_ = null;
}
