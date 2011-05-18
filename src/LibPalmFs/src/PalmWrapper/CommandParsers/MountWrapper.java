package PalmWrapper.CommandParsers;

import java.io.IOException;
import java.util.ArrayList;

import PalmWrapper.NovacomWrapper;
import com.palm.novacom.INovacomDevice;
import com.palm.novacom.NovacomException;

public class MountWrapper
{
    public ArrayList<FsInfo> GetMountedFileSystems(INovacomDevice device)
        throws NovacomException, IOException 
    {
        String rawData = GetMountedFileSystemsRaw(device);
        
        MountParser parser = new MountParser();
        ArrayList<FsInfo> result = parser.Parse(rawData);
        
        return result;
    }
    
    private String GetMountedFileSystemsRaw(INovacomDevice device) 
        throws NovacomException, IOException
    {
        NovacomWrapper deviceWrapper = new NovacomWrapper();

        String[] args = {""};
        String result = deviceWrapper.GetCommandAnswer(device, "/bin/mount", args);
        
        return result;
    }
    

}
