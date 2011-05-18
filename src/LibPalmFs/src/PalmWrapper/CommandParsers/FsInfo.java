package PalmWrapper.CommandParsers;

public class FsInfo
{
    public void SetDevice(String device_)
    {
        this.device_ = device_;
    }
    
    public String GetDevice()
    {
        return device_;
    }
    
    
    
    
    public void SetMountPoint(String mountPoint_)
    {
        this.mountPoint_ = mountPoint_;
    }
    
    public String GetMountPoint()
    {
        return mountPoint_;
    }
    
    
    
    
    public void SetOptions(String options)
    {
        this.options_ = options;
    }
    
    public String GetOptions()
    {
        return options_;
    }  
    
  
    
    
    public void SetType(String type_)
    {
        this.type_ = type_;
    }

    public String GetType()
    {
        return type_;
    }




    private String device_ = null;
    private String mountPoint_ = null;
    private String type_ = null;
    private String options_ = null;
}
