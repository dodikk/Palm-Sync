package PalmSynchronizer;
import com.palm.novacom.INovacomController;
import com.palm.novacom.INovacomDevice;
import com.palm.novacom.Novacom;


import PalmWrapper.PalmSynchronizer;


public class CMain
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Program started...");
            
            System.out.println("Parsing command line arguments...");
            OptionsParser options = new OptionsParser(args);
            System.out.println("Parsing command line arguments ended.");
            
            
            System.out.println("Connecting to device...");
            INovacomController controller = Novacom.getController();
            INovacomDevice device = controller.connectDefaultDevice();
            System.out.println("Connected to device successfully.");
            
            
            System.out.println("Acquiring filesystem...");
            PalmSynchronizer sync = new PalmSynchronizer();
            String devicePath = options.GetDevicePath();
            String backupPath = options.GetBackupPath();

            sync.AcquireItems(device, devicePath, backupPath);


            System.out.println("Acquiring filesystem finished.");
            System.out.println("Program ended successfully.");
        }
        catch (Exception e)
        {
            System.out.println("Program failed.");
            e.printStackTrace();
        }
    }

}
