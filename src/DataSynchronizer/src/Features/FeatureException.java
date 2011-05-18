package Features;

public class FeatureException extends Exception
{

    /**
     * 
     */
    private static final long serialVersionUID = 6098734037390363518L;

    public FeatureException()
    {
        super("Error creating feature.");
    }

    public FeatureException(String arg0)
    {
        super(arg0);
    }

    public FeatureException(Throwable arg0)
    {
        super(arg0);
    }

    public FeatureException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }
}
