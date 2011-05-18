package PalmWrapper.Filters;

import java.util.ArrayList;
import java.util.Iterator;

import PalmWrapper.CommandParsers.FsInfo;

public class FsFilter
{    
    public ArrayList<String> GetBlackList(ArrayList<FsInfo> fsList)
    {
        ArrayList<String> result = new ArrayList<String>(0);
        
        FsFilterResult split1 = ExcludeRootMounts(fsList);
        ArrayList<FsInfo> badRoots = split1.badItems_;

        //ArrayList<FsInfo> noRoots = RemoveRoots(split1.goodItems_);
        ArrayList<FsInfo> noRoots = split1.goodItems_;
        FsFilterResult split2 = ExcludeCyclicMounts(noRoots); 
        
        
        ArrayList<FsInfo> blackList = new ArrayList<FsInfo>(0);
        blackList.addAll(badRoots);
        blackList.addAll(split2.badItems_);
        
        result = GetMountPoints(blackList);
        
        ArrayList<String> knownProblems = GetKnownProblems();
        result.addAll(knownProblems);
        
        return result;
    }
    
    private FsFilterResult ExcludeRootMounts(ArrayList<FsInfo> fsList)
    {
        FsFilterResult result = new FsFilterResult();
        
        Iterator<FsInfo> it = fsList.iterator();
        while (it.hasNext())
        {
            FsInfo item = it.next();
            if (item.GetDevice().equals("/dev/hda1"))
            {
                result.badItems_.add(item);
            }
            else
            {
                result.goodItems_.add(item);
            }
        }
        
        return result;
    }
    
    private FsFilterResult ExcludeCyclicMounts(ArrayList<FsInfo> fsList)
    {
        FsFilterResult result = new FsFilterResult();
        result.goodItems_ = fsList;
        
        return result;
    }

    private ArrayList<String> GetKnownProblems()
    {  
        ArrayList<String> result = new ArrayList<String>(0);
        result.add("/dev/");
        result.add("/etc/mtab"); //mounted FS
        result.add("/proc/");
        //result.add("/proc/kcore");//memory map. Acquires.
        //result.add("/proc/kmsg"); //hangs. size~13k
        //result.add("/proc/mounts"); //mounted FS (more up-to-date list)
        
        return result;
    }
    
    
    
//    ArrayList<FsInfo> RemoveRoots(ArrayList<FsInfo> fsList)
//    {
//        ArrayList<FsInfo> result = new ArrayList<FsInfo>(0);
//        
//        Iterator<FsInfo> it = fsList.iterator();
//        while (it.hasNext())
//        {
//            FsInfo item = it.next();
//            if (item.GetMountPoint().equals("/"))
//            {
//                continue;
//            }
//            
//            result.add(item);
//        }
//        
//        return result;
//    }
    
    private ArrayList<String> GetMountPoints(ArrayList<FsInfo> fsList)
    {
        ArrayList<String> result = new ArrayList<String>(0);
        
        Iterator<FsInfo> it = fsList.iterator();
        while (it.hasNext())
        {
            FsInfo item = it.next();
            result.add(item.GetMountPoint() + "/");
        }
        
        return result;
    }
}
