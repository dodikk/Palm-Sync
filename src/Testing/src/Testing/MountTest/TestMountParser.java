package Testing.MountTest;


import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import PalmWrapper.CommandParsers.FsInfo;
import PalmWrapper.CommandParsers.MountParser;
import Utils.DumpReader;

public class TestMountParser extends TestCase
{

    @Before
    public void setUp()
    {
        dump_ = new DumpReader();
        parser_ = new MountParser();
    }

    
    @Test
    public void testParse() throws IOException
    {
        String rawData = dump_.DumpToString("dumps/mount1.txt");
        ArrayList<FsInfo> result = parser_.Parse(rawData);

        assertEquals(8, result.size());
        
        FsInfo item = result.get(0);
        assertEquals("rootfs", item.GetDevice());
        assertEquals("/", item.GetMountPoint());
        assertEquals("rootfs", item.GetType());
        assertEquals(" (rw)", item.GetOptions());
        
        
        item = result.get(7);
        assertEquals("extractfs", item.GetDevice());
        assertEquals("/var/luna/data/extractfs", item.GetMountPoint());
        assertEquals("fuse.extractfs", item.GetType());
        assertEquals(" (rw,nosuid,nodev,user_id=0,group_id=0)", item.GetOptions());
    }
    
    
    @Test
    public void testNull() throws IOException
    {
        try
        {
            parser_.Parse(null);
            fail();
        }
        catch (Throwable ex)
        {
            //OK
        }
    }
    
    @Test
    public void testCorrupted() throws IOException
    {
        String rawData = dump_.DumpToString("dumps/mount_corrupt1.txt");
        
        try
        {
            parser_.Parse(rawData);
            fail();
        }
        catch (Throwable ex)
        {
            //OK
        }
    }
    
    private DumpReader dump_ = null;
    private MountParser parser_ = null;
}
