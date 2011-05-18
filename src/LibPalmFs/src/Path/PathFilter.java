package Path;

public class PathFilter
{

    public static String DoFilter(String path)
    {
        IPathFilter filter = FiltersFactory.CreatePathFilter();
        return filter.DoFilter(path);
    }

}
