package PalmWrapper;

public class ParserException extends Exception
{
    /**
     * 
     */
    private static final long serialVersionUID = -7759722304935997334L;

    public ParserException()
    {
        super("<PalmWrapper.ParserException> : Unable to parse data from the device.");
    }

    public ParserException(String arg0)
    {
        super(arg0);
    }

    public ParserException(Throwable arg0)
    {
        super(arg0);
    }

    public ParserException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }
}
