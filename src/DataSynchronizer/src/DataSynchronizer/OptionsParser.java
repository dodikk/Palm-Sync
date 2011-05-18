package DataSynchronizer;

import Utils.Utilities;

public class OptionsParser
{
    protected OptionsParser()
    {
    }
    
    public OptionsParser(String[] args)
    {
        backupPath_ = ParseBackupPath(args);
        ParseKeys(args);
    }

    
    public String GetBackupPath()
    {
        return backupPath_;
    }

    public boolean IsAcquireMedia()
    {
        return isMedia_;
    }

    public boolean IsAcquireApplication()
    {
        return isApplication_;
    }

    public boolean IsAcquireDataBase()
    {
        return isDataBase_;
    }

    public boolean IsAcquireJava()
    {
        return isJava_;
    }

    
    

    private void ParseKeys(String[] args)
    {
        int keysStart = 1;

        if (keysStart >= args.length)
        {
            ParseKey("--all");
            return;
        }
        
        for (int i = keysStart; i < args.length; ++i)
        {
            boolean exit = ParseKey(args[i]);
            if (exit)
            {
                return;
            }
        }
    }

    private boolean ParseKey(String key)
    {
        boolean result = false;

        key = key.toLowerCase();
        if (key.equals("--all"))
        {
            isMedia_        = true;
            isDataBase_     = true;
            isApplication_  = true;
            isJava_         = true;
            result = true;
        }
        else if (key.equals("--data"))
        {
            isDataBase_ = true;
        }
        else if (key.equals("--media"))
        {
            isMedia_ = true;
        }
        else if (key.equals("--app"))
        {
            isApplication_ = true;
        }
        else if (key.equals("--java"))
        {
            isJava_ = true;
        }

        return result;
    }
     
    private String ParseBackupPath(String[] args)
    {
        int offset = 0;
        int expectedLength = offset + 1;
        
        if (args.length >= expectedLength)
        {
            String result = Utilities.NormalizeName(args[offset]);
            return result;
        }

        return "c:/temp/";
    }
    
    
    
    
    
    protected String backupPath_ = null;
    
    protected boolean isMedia_       = false;
    protected boolean isDataBase_    = false;
    protected boolean isApplication_ = false;
    protected boolean isJava_        = false;
}
