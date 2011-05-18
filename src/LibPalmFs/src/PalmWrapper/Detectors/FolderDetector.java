package PalmWrapper.Detectors;

import PalmWrapper.FsItem;
import PalmWrapper.FsItem.FsItemType;

public class FolderDetector extends ADetector
{
    protected boolean DoDetect(String decoratedName, String pureName)
    {
        return decoratedName.endsWith("/");
    }

    protected FsItem DoParse(String decoratedName, String pureName)
    {
        return new FsItem(decoratedName, FsItemType.directory);
    }
}
