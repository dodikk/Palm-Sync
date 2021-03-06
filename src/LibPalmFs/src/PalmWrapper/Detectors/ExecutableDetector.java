package PalmWrapper.Detectors;

import PalmWrapper.FsItem;
import PalmWrapper.FsItem.FsItemType;

public class ExecutableDetector extends AUnusualFileDetector
{
    @Override
    boolean CheckSpecificCondition(String decoratedName, String pureName)
    {
        return decoratedName.endsWith("*");
    }

    @Override
    protected FsItem DoParse(String decoratedName, String pureName)
    {
        return new FsItem(pureName, FsItemType.executable);
    }
}
