package Path;

public class EmptyFilter implements IPathFilter
{
    public String DoFilter(String path)
    {
        return path;
    }
}
