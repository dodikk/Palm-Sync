package PalmWrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import PalmWrapper.CommandParsers.FsInfo;
import PalmWrapper.CommandParsers.MountWrapper;
import PalmWrapper.Detectors.FoldersFilter;
import PalmWrapper.Detectors.PalmDetectException;
import PalmWrapper.Filters.FsFilter;
import Path.PathFilter;

import com.palm.novacom.INovacomDevice;
import com.palm.novacom.NovacomException;


public class PalmSynchronizer
{
    public void AcquireItems(
            INovacomDevice device, 
            String devicePath, 
            String backupPath) 
    throws NovacomException, IOException, PalmDetectException, ParserException 
    {
        UpdateBlackList(device);
        DoAcquireItems(device, devicePath, backupPath);
    }
    
    
    private void DoAcquireItems(
        INovacomDevice device, 
        String devicePath, 
        String backupPath) 
    throws NovacomException, IOException, PalmDetectException, ParserException 
    {
        System.out.print("Acquiring directory : \"");
        System.out.print(devicePath);
        System.out.println("\" ...");
        
        File root = new File(backupPath);
        root.mkdirs();
        
        FolderReader reader = new FolderReader();   
        ArrayList<FsItem> items = reader.GetFolderItems(device, devicePath);
        
        FoldersFilter filter = new FoldersFilter();
        ArrayList<String> files = filter.GetFiles(items);      
        ArrayList<String> folders = filter.GetFolders(items);
        
        AcquireFiles(device, devicePath, backupPath, files);
        AcquireFolders(device, devicePath, backupPath, folders);
        
        System.out.print("Acquiring directory : \"");
        System.out.print(devicePath);
        System.out.println("\" ended.");
    }
    
    private void AcquireFiles(
            INovacomDevice device, 
            String devicePath, 
            String backupPath,
            ArrayList<String> files) 
    throws NovacomException, IOException
    {
        FileReader reader = new FileReader();
        
        Iterator<String> it = files.iterator();
        
        while (it.hasNext())
        {
            String file = it.next();
            
            AcquireSingleFile(device, devicePath, backupPath, reader, file);
        }
    }


    private void AcquireSingleFile(INovacomDevice device, String devicePath,
            String backupPath, FileReader fileReader, String fileName)
            throws NovacomException, IOException
    {   	       
        try
        {           
            String deviceName = devicePath + fileName;
            
            System.out.print("Acquiring file : \"");
            System.out.print(deviceName);
            System.out.println("\" ...");
            
            
        	if (blackList_.contains(deviceName))
            {
                System.out.print("The file is in the blacklist.");
                return;
            }
            
            
            String backupName = backupPath + PathFilter.DoFilter(fileName);
            
            fileReader.ReadBinaryFile(device, deviceName, backupName);
            
            System.out.print("Acquiring file : \"");
            System.out.print(deviceName);
            System.out.println("\"   ended.");
        }
        catch(Exception e)
        {
            String msg = 
                "Unable to acquire file. Skipping file :" + 
                fileName;
            
            System.out.print(msg);
            e.printStackTrace();
        }
    }
    
    private void AcquireFolders(
            INovacomDevice device, 
            String devicePath, 
            String backupPath,
            ArrayList<String> folders) 
    throws NovacomException, IOException, PalmDetectException, ParserException 
    {
        Iterator<String> it = folders.iterator();
        
        while (it.hasNext())
        {
            String folder = it.next();
            
            String deviceName = devicePath + folder;
            String backupName = backupPath + PathFilter.DoFilter(folder);
            
            if (blackList_.contains(deviceName))
            {
                System.out.print("The folder is in the blacklist : ");
                System.out.println(deviceName);
                continue;
            }
            
            DoAcquireItems(device, deviceName, backupName);
        }    
    }

    
    private void UpdateBlackList(INovacomDevice device)
        throws NovacomException, IOException 
    {
        MountWrapper mountParser = new MountWrapper();
        ArrayList<FsInfo> fileSystems = mountParser.GetMountedFileSystems(device);
        
        FsFilter filter = new FsFilter();
        blackList_ = filter.GetBlackList(fileSystems);
    }
    
    private ArrayList<String> blackList_ = null;
}
