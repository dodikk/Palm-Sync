package PalmWrapper.Detectors;

import PalmWrapper.FsItem;
import PalmWrapper.FsItem.FsItemType;

public class PureFileDetector extends ADetector
{
    /* (non-Javadoc)
     * @see PalmWrapper.Detectors.IDetector#Detect(java.lang.String)
     */
    protected boolean DoDetect(String decoratedName, String pureName)
    {
        return decoratedName.equals(pureName);
    }

    protected FsItem DoParse(String decoratedName, String pureName)
    {
        return new FsItem(pureName, FsItemType.file);
    }

}
