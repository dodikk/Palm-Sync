package PalmWrapper.Detectors;

import java.util.ArrayList;
import PalmWrapper.FsItem;

public class FileDetector extends ACompositeDetector
{
    protected FsItem DoParse(String decoratedName, String pureName) 
        throws PalmDetectException
    {
        IDetector detector = GetSimpleDetector(decoratedName, pureName);
        return detector.Parse(decoratedName, pureName);
    }
    
    protected void DoInitializeDetectors()
    {
        detectors_ = new ArrayList<IDetector>(0);
        
        detectors_.add(new PureFileDetector());
        detectors_.add(new SymbolicLinkDetector());
        detectors_.add(new ExecutableDetector());
    }
}
