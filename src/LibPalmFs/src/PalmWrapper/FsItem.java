package PalmWrapper;



public class FsItem
{
    public enum FsItemType
    {
        unknown(0),
        file(1),
        directory(2),
        symbolicLink(3),
        socket(4),
        executable(5);
        
        
        static String[] names_ = 
        {
            "unknown",
            "file",
            "directory",
            "symbolic link",
            "socket",
            "executable"
        };

        
        FsItemType(int index)
        {
            index_ = index;
        }
        
        public String Print()
        {
            return names_[index_];
        }
        
        private int index_ = 0;        
    };
    
    public FsItem(String name, FsItemType type)
    {
        SetName(name);
        SetType(type);
    }
    
    public FsItem()
    {
    }
    
    
    
    
    
    public void SetName(String name_)
    {
        this.name_ = name_;
    }
    
    public String GetName()
    {
        return name_;
    }
    
    
    
    
    
    public void SetType(FsItemType type_)
    {
        this.type_ = type_;
    }

    public FsItemType GetType()
    {
        return type_;
    }


    public static String TypeToString(FsItemType type)
    {
        return null;
    }

    public String Print()
    {
        String result = 
            "Name : " +
            GetName() +
            "Type : " + 
            type_.Print();
            
        return result;
    }

    

    private String name_ = "";
    private FsItemType type_ = FsItemType.unknown;
}
