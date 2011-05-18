package DataSynchronizer;

import java.util.ArrayList;
import java.util.Iterator;

import com.palm.novacom.INovacomDevice;

import Features.AFeature;



public class DataSync
{
    public DataSync(
        OptionsParser options, 
        INovacomDevice device,
        String backupRoot)
    {
        features_ = FeaturesFactory.GetFeatures(options, device);
    }
    
    public void Acquire()
    {
        Iterator<AFeature> it = features_.iterator();
        while (it.hasNext())
        {
            AFeature feature = it.next(); 
            
            try
            {
                feature.Acquire();
            }
            catch (Exception e)
            {
                System.out.print("Feature acquisition has failed.");
                e.printStackTrace();
            }
        }
    }
    
    private ArrayList<AFeature> features_ = null;
}
