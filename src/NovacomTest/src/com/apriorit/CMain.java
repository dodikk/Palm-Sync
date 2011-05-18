//package com.apriorit;


import PalmWrapper.FileReader;
import PalmWrapper.FolderReader;
import PalmWrapper.FsItem;
import PalmWrapper.ParserException;
import PalmWrapper.Detectors.PalmDetectException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.palm.novacom.Novacom;
import com.palm.novacom.NovaDeviceInfo;
import com.palm.novacom.INovacomDevice;
import com.palm.novacom.NovacomException;
import com.palm.novacom.INovacomController;
import com.palm.novacom.Novacom.DeviceState;


public class CMain
{

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args)
    {
        _TRW1("Program started ...");
        INovacomController controller = Novacom.getController();
        try
        {
            _TRW1("Creating device ...");
            INovacomDevice device = CreateDevice(controller);
            PrintDeviceState(device);
            
            FileReader fileReader = new FileReader();
            
            
            String textFileDevicePath = "/tmp/optware-bootstrap.sh.log";
            fileReader.ReadTextFile(device, textFileDevicePath);
            
            
            String devicePath = "/var/luna/data/dbdata/PalmDatabase.db3";
            //String backupPath = "/home/dodikk/Документы/__RESEARCH__/palm/Data/PalmDatabase.db3";
            String backupPath = "c:/temp/PalmDatabase.db3";
            fileReader.ReadBinaryFile(device, devicePath, backupPath);
                        
            TestChangeDir(device);

            device.close();
            System.out.println("Program ended successfully.");
        }
        catch (IOException e)
        {
            System.out.println("IOException occured.");
            e.printStackTrace();
        }
        catch (NovacomException e)
        {
            System.out.println("NovacomException occured.");
            e.printStackTrace();
        }
        catch (PalmDetectException e)
        {
            System.out.println("PalmDetectException occured.");
            e.printStackTrace();
        }
        catch (ParserException e)
        {
            System.out.println("ParserException occured.");
            e.printStackTrace();
        }
    }

    
    
    
    private static void TestChangeDir(INovacomDevice device) 
        throws NovacomException, IOException, PalmDetectException, ParserException
    {
        FolderReader reader = new FolderReader();
        
        String path = "/";
        PrintFolderInfo(device, path);      

        ArrayList<String> subfolders = reader.GetSubFolderNames(device, path);
        String newDir = path + subfolders.get(0);        
        Print("Changing dir to" + newDir);       
        
        PrintFolderInfo(device, newDir);
    }

    
    

    private static void PrintFolderInfo(INovacomDevice device, String path) 
        throws NovacomException, IOException, PalmDetectException, ParserException
    {
        FolderReader reader = new FolderReader();
        
        Print("Current dir is /");
        ArrayList<FsItem> items = reader.GetFolderItems(device, path);
        Print("Contents : ");
        PrintFsItems(items);
        
        
        ArrayList<String> folders = reader.GetSubFolderNames(device, path);
        Print("SubFolders : ");
        Print(folders);
        
        ArrayList<String> files = reader.GetSubFileNames(device, path);
        Print("SubFiles : ");
        Print(files);
    }
    
    private static void PrintDeviceState(INovacomDevice device)
            throws IOException
    {
        DeviceState devState = device.getState();
        String stateName = devState.name();
        
        System.out.print("Device state : ");
        System.out.println(stateName);
    }

    
    
    private static INovacomDevice CreateDevice(INovacomController controller)
            throws IOException, NovacomException
    {
        NovaDeviceInfo devices[] = controller.getDeviceList();
        NovaDeviceInfo devInfo = devices[0];
        INovacomDevice device = controller.connectToDevice(devInfo);
        return device;
    }
    
    
    
    
    private static void _TRW1(String message)
    {
        System.out.println(message);
    }

    private static void Print(String message)
    {
        System.out.println(message);
    }
    
    private static void Print(ArrayList<String> strings)
    {
        int stringsSize = strings.size();
        
        for (int i = 0; i < stringsSize; ++i)
        {
            Print(strings.get(i));
        }
    }

    private static void PrintFsItems(ArrayList<FsItem> items)
    {
        Iterator<FsItem> it = items.iterator();
        
        while(it.hasNext())
        {
            FsItem item = it.next();
            String message = item.Print();
            Print(message);
        }
    }
}

  