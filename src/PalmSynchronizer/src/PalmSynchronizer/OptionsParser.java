package PalmSynchronizer;

import Utils.Utilities;

public class OptionsParser
{
    public OptionsParser(String[] args)
    {
        devicePath_ = ParseDevicePath(args);
        backupPath_ = ParseBackupPath(args);
    }
    
    public String GetDevicePath()
    {
        return devicePath_;
    }
    
    public String GetBackupPath()
    {
        return backupPath_;
    }
    
    
    
    private String ParseDevicePath(String[] args)
    {
        int offset = 0;
        int expectedLength = offset + 1;
        
        if (args.length >= expectedLength)
        {
            String result = Utilities.NormalizeName(args[offset]);
            return result;
        }

        return "/";
    }
    
    private String ParseBackupPath(String[] args)
    {
        int offset = 1;
        int expectedLength = offset + 1;
        
        if (args.length >= expectedLength)
        {
            String result = Utilities.NormalizeName(args[offset]);
            return result;
        }

        return "c:/temp/";
    }
        
    protected String devicePath_ = null;
    protected String backupPath_ = null;
}
