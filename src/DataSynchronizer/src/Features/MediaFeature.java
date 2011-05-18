package Features;

import java.util.ArrayList;

import com.palm.novacom.INovacomDevice;

public class MediaFeature extends AFeature
{

    public MediaFeature(INovacomDevice device, String root)
    {
        super(device, root);
    }


    @Override
    protected ArrayList<Location> GetLocations()
    {
        ArrayList<Location> result = new ArrayList<Location>(0);
        
        result.add
        (
            new Location
            (
                "/media/internal/",
                backupRoot_ + "internal/"
            )
        );

        
        result.add
        (
            new Location
            (
                "/usr/palm/sysmgr/images/",
                backupRoot_ + "sysmgr/"
            )
        );

        result.add
        (
            new Location
            (
                "/usr/palm/images/",
                backupRoot_ + "images/"
            )
        );

        result.add
        (
            new Location
            (
                "/usr/palm/sounds/",
                backupRoot_ + "sounds/"
            )
        );

        
        result.add
        (
            new Location
            (
                "/usr/palm/emoticons/",
                backupRoot_ + "emoticons/"
            )
        );

        
        return result;
    }

}
