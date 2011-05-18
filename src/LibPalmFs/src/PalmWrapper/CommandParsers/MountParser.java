package PalmWrapper.CommandParsers;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class MountParser
{
    public ArrayList<FsInfo> Parse(String rawData)
    {
        ArrayList<FsInfo> result = new ArrayList<FsInfo>(0);
        
        StringTokenizer splitter = new StringTokenizer(rawData, "\n");
        while (splitter.hasMoreTokens())
        {
            String rawItem = splitter.nextToken();
            FsInfo item = ParseSingleItem(rawItem);
            result.add(item);
        }
        
        return result;
    }
    
    private FsInfo ParseSingleItem(String rawDataChunk)
    {
        StringTokenizer splitter = new StringTokenizer(rawDataChunk, " ");
        
        FsInfo result = new FsInfo();
        
        String device = splitter.nextToken(); // /dev/hdb
        result.SetDevice(device);
        
        splitter.nextToken(); // on 
        
        
        String mountPoint = splitter.nextToken(); // /media/hdb
        result.SetMountPoint(mountPoint);
        
        splitter.nextToken(); // type
        
        
        String fsType = splitter.nextToken(); // ext3 
        result.SetType(fsType);
     
        String options = splitter.nextToken("\n");
        result.SetOptions(options);
        
        return result;
    }
}
