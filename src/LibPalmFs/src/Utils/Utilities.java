package Utils;

public class Utilities
{
    public static String NormalizeName(String name)
    {
        name = name.replace("\\", "/");
        
        if (false == name.endsWith("/"))
        {
            return name + "/";
        }
        else
        {
            return name;
        }
    }
    
    
    public static String WrapWithQuotes(String str)
    {
        String result = "\"" + str + "\"";
        return result;
    }
}
