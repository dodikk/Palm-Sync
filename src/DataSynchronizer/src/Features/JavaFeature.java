package Features;

import java.util.ArrayList;

import com.palm.novacom.INovacomDevice;

public class JavaFeature extends AFeature
{

    public JavaFeature(INovacomDevice device, String root)
    {
        super(device, root);
    }

    @Override
    protected ArrayList<Location> GetLocations()
    {
        ArrayList<Location> result = new ArrayList<Location>(0);
        
        result.add(
            new Location(
                "/usr/share/dbus-1/system-services/",
                backupRoot_ + "services/"
        ));

        
        result.add(
            new Location(
                "/usr/lib/luna/java/",
                backupRoot_ + "libraries/"
        ));

        
        return result;
    }

}
