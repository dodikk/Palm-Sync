package PalmWrapper.Detectors;

public class PalmDetectException
        extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = -3794522058428948252L;

    public PalmDetectException()
    {
        super("Error detecting FsItem type");
    }

    public PalmDetectException(String message)
    {
        super(message);
    }

    public PalmDetectException(Throwable cause)
    {
        super(cause);
    }

    public PalmDetectException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
