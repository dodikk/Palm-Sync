package PalmWrapper.Detectors;

import PalmWrapper.FsItem;

public interface IDetector
{

    public abstract boolean Detect(String decoratedName, String pureName) throws PalmDetectException;
    
    public abstract FsItem Parse(String decoratedName, String pureName) throws PalmDetectException;

}
