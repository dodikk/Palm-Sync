package Testing.BlackListTest;


import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import PalmWrapper.CommandParsers.FsInfo;
import PalmWrapper.CommandParsers.MountParser;
import PalmWrapper.Filters.FsFilter;
import Utils.DumpReader;

public class BlackListTest extends TestCase
{

    @Before
    public void setUp()
    {
        dump_ = new DumpReader();
        parser_ = new MountParser();
        filter_ = new FsFilter();
    }

    
    @Test
    public void testBlacklist() throws IOException
    {
        String rawData = dump_.DumpToString("dumps/BlackListDump.txt");
        ArrayList<FsInfo> fsList = parser_.Parse(rawData);
        
        ArrayList<String> result = filter_.GetBlackList(fsList);
        assertEquals(4, result.size());
        
        assertEquals("/OtherRoot/", result.get(0));
        assertEquals("/dev/", result.get(1));
    }
    
    private DumpReader dump_ = null;
    private MountParser parser_ = null;
    private FsFilter filter_ = null;
}
