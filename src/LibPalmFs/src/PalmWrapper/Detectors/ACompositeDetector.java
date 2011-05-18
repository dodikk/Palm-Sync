package PalmWrapper.Detectors;

import java.util.ArrayList;
import java.util.Iterator;

import PalmWrapper.FsItem;

public abstract class ACompositeDetector extends ADetector
{  
    protected boolean DoDetect(String decoratedName, String pureName) throws PalmDetectException
    {
        IDetector detector = GetSimpleDetector(decoratedName, pureName);
        return (null != detector);
    }
    
    final public IDetector GetSimpleDetector(String decoratedName, String pureName) throws PalmDetectException
    {
        InitializeDetectors();
        
        Iterator<IDetector> it = detectors_.iterator();
        
        while (it.hasNext())
        {
            IDetector detector = it.next();
            if (detector.Detect(decoratedName, pureName))
            {
                return detector;
            }
        }
        
        return null;
    }

    final public void InitializeDetectors()
    {
        if (detectors_.isEmpty())
        {
        	DoInitializeDetectors();
        }
        else
        {
        	return;
        }
    }
    
    protected abstract FsItem DoParse(String decoratedName, String pureName) throws PalmDetectException;
    
    
    
    protected abstract void DoInitializeDetectors();
    
    protected ArrayList<IDetector> detectors_ = new ArrayList<IDetector>(0);
}
