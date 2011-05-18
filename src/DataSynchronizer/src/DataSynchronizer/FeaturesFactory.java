package DataSynchronizer;

import Features.*;
import java.util.ArrayList;

import com.palm.novacom.INovacomDevice;

public class FeaturesFactory
{
    public static ArrayList<AFeature> GetFeatures(
        OptionsParser options, 
        INovacomDevice device)
    {
        ArrayList<AFeature> result = new ArrayList<AFeature>(0);
        String root = options.GetBackupPath();
        String featureRoot = null;
        
        if (options.IsAcquireApplication())
        {
            featureRoot = root + "Applications/";
            result.add(new ApplicationsFeature(device, featureRoot));
        }
        if (options.IsAcquireDataBase())
        {
            featureRoot = root + "Databases/";
            result.add(new DataBaseFeature(device, featureRoot));
        }
        if (options.IsAcquireJava())
        {
            featureRoot = root + "Java/";
            result.add(new JavaFeature(device, featureRoot));
        }
        if (options.IsAcquireMedia())
        {
            featureRoot = root + "Media/";
            result.add(new MediaFeature(device, featureRoot));
        }
        
        return result;
    }
}
