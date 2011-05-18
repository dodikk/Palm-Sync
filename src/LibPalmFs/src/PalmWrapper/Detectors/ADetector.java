package PalmWrapper.Detectors;

import PalmWrapper.FsItem;

public abstract class ADetector implements IDetector
{
    public boolean Detect(String decoratedName, String pureName) throws PalmDetectException
    {
        DoAssert(decoratedName, pureName);
        return DoDetect(decoratedName, pureName);
    }
    
    public FsItem Parse(String decoratedName, String pureName) throws PalmDetectException
    {
        DoAssert(decoratedName, pureName);
        return DoParse(decoratedName, pureName);        
    }
    
    protected void DoAssert(String decoratedName, String pureName) throws PalmDetectException
    {
        if ( (decoratedName == null) || 
             (pureName == null) ||
             (false == decoratedName.startsWith(pureName))
           )
        {
            System.out.println("Error detecting file.");
            System.out.print("decoratedName : ");
            System.out.println(decoratedName);
            System.out.print("pureName : ");
            System.out.println(pureName);
            
            throw new PalmDetectException(); 
        }
    }
    
    protected abstract boolean DoDetect(String decoratedName, String pureName) throws PalmDetectException;    
    protected abstract FsItem DoParse(String decoratedName, String pureName) throws PalmDetectException;
}
