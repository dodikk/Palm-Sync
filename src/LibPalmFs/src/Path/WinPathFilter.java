package Path;

public class WinPathFilter implements IPathFilter
{

    public String DoFilter(String path)
    {
        if (null == path)
        {
            return null;
        }
        
        String result = 
            path.replace("*", "_STAR_").
            replace("\"", "_QUOTE_").
            replace("?", "_QUESTION_").
            replace(":", "_DDOT_").
            replace("<", "_LESS_").
            replace(">", "_MORE_").
            replace("|", "_BAR_");

        return result;
    }

}
