package PalmWrapper.Detectors;

import PalmWrapper.FsItem;

public abstract class AUnusualFileDetector extends ADetector
{

    protected boolean DoDetect(String decoratedName, String pureName) 
        throws PalmDetectException
    {
        PureFileDetector fDetect = new PureFileDetector();
        boolean isFile = fDetect.Detect(decoratedName, pureName);
        
        if (isFile)
        {
            return false;
        }
        else
        {
            return CheckSpecificCondition(decoratedName, pureName);
        }
    }

    protected abstract FsItem DoParse(String decoratedName, String pureName);
    
    
    abstract boolean CheckSpecificCondition(String decoratedName, String pureName);
}
