package PalmWrapper.Detectors;

import PalmWrapper.FsItem;
import PalmWrapper.FsItem.FsItemType;

public class SocketDetector extends AUnusualFileDetector
{
    protected FsItem DoParse(String decoratedName, String pureName)
    {
        return new FsItem(pureName, FsItemType.socket);
    }
    
    boolean CheckSpecificCondition(String decoratedName, String pureName)
    {
        return decoratedName.endsWith("=");
    }
}
