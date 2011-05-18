package PalmWrapper.Detectors;

import java.util.ArrayList;
import java.util.Iterator;

import PalmWrapper.FsItem;
import PalmWrapper.FsItem.FsItemType;

public class FoldersFilter
{
    public ArrayList<String> GetFolders(ArrayList<FsItem> items)
    {      
        ArrayList<String> result = new ArrayList<String>(0);
        Iterator<FsItem> it = items.iterator();
        
        
        while(it.hasNext())
        {
            FsItem item = it.next();
            if (IsDirectory(item))
            {
                result.add(item.GetName());
            }
        }
        
        return result;
    }
    
    public ArrayList<String> GetFiles(ArrayList<FsItem> items)
    {      
        ArrayList<String> result = new ArrayList<String>(0);
        Iterator<FsItem> it = items.iterator();
        
        
        while(it.hasNext())
        {
            FsItem item = it.next();
            if (IsFile(item))
            {
                result.add(item.GetName());
            }
        }
        
        return result;
    }
    
    private boolean IsDirectory(FsItem item)
    {
        return item.GetType() == FsItemType.directory;
    }
    
    private boolean IsFile(FsItem item)
    {
        return !IsDirectory(item);
    }
}
