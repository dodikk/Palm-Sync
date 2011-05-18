package Features;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.palm.novacom.INovacomDevice;
import com.palm.novacom.NovacomException;

import PalmWrapper.PalmSynchronizer;
import PalmWrapper.ParserException;
import PalmWrapper.Detectors.PalmDetectException;

public abstract class AFeature
{
    public AFeature(INovacomDevice device, String root)
    {
        backupRoot_ = root;
        device_ = device;
    }
    
    final public void Acquire() 
        throws FeatureException, NovacomException, IOException, PalmDetectException, ParserException
    {
        ArrayList<Location> locations = GetLocations();
        Iterator<Location> it = locations.iterator();
        
        while (it.hasNext())
        {
            Location current = it.next();
            
            String devicePath = current.devicePath_;
            String backupPath = current.backupPath_;

            sync_.AcquireItems(device_, devicePath, backupPath);
        }
    }
    
    protected abstract ArrayList<Location> GetLocations();
    
    protected INovacomDevice device_ = null;
    protected String backupRoot_ = null;
    
    
    private PalmSynchronizer sync_ = new PalmSynchronizer(); 
}
