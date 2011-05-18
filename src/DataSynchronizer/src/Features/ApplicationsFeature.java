/**
 * 
 */
package Features;

import java.util.ArrayList;

import com.palm.novacom.INovacomDevice;

/**
 * @author dodikk
 * 
 */
public class ApplicationsFeature extends AFeature
{

    /**
     * @param device
     * @param root
     */
    public ApplicationsFeature(INovacomDevice device, String root)
    {
        super(device, root);
    }

    @Override
    protected ArrayList<Location> GetLocations()
    {
        ArrayList<Location> result = new ArrayList<Location>(0);

        result.add(
            new Location(
             "/usr/palm/applications/", 
             backupRoot_ + "applications/"));

        result.add(
            new Location(
                "/usr/palm/patches/", 
                backupRoot_ + "patches/"
        ));

        return result;
    }

}
