package Path;

class FiltersFactory
{
    public static IPathFilter CreatePathFilter()
    {
        if (IsOsWindows())
        {
            return new WinPathFilter();
        }
        else
        {
            return new EmptyFilter();
        }
    }
    
    private static boolean IsOsWindows()
    {
        String osName = System.getProperty("os.name").toUpperCase();
        return osName.contains("WINDOWS"); 
    }
}
