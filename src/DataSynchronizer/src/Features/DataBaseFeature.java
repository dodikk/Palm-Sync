package Features;

import java.util.ArrayList;

import com.palm.novacom.INovacomDevice;

public class DataBaseFeature extends AFeature
{

    public DataBaseFeature(INovacomDevice device, String root)
    {
        super(device, root);
    }


    @Override
    protected ArrayList<Location> GetLocations()
    {
        ArrayList<Location> result = new ArrayList<Location>(0);
        
        result.add(new Location("/var/luna/data/", backupRoot_));
        
        return result;
    }

}
