/**
 * 
 */
package UI;

import DataSynchronizer.OptionsParser;

/**
 * @author dodikk
 *
 */
public class OptionsManager extends OptionsParser
{

    /**
     * @param args
     */
    public OptionsManager()
    {
        super();
    }

    public void SetBackupPath(String value)
    {
        backupPath_ = value;
    }

    public void SetAcquireMedia(boolean value)
    {
        isMedia_ = value;
    }

    public void SetAcquireApplication(boolean value)
    {
        isApplication_ = value;
    }

    public void SetAcquireDataBase(boolean value)
    {
        isDataBase_ = value;
    }

    public void SetAcquireJava(boolean value)
    {
        isJava_ = value;
    }

    
}
