package PalmWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.palm.novacom.INovacomDevice;
import com.palm.novacom.NovacomException;

import PalmWrapper.NovacomWrapper;

import PalmWrapper.Detectors.FileDetector;
import PalmWrapper.Detectors.FolderDetector;
import PalmWrapper.Detectors.FoldersFilter;
import PalmWrapper.Detectors.PalmDetectException;
import PalmWrapper.FsItem.FsItemType;
//import Utils.Utilities;

public class FolderReader
{
    public ArrayList<String> GetSubFolderNames(INovacomDevice device,
            String path) throws NovacomException, IOException,
            PalmDetectException, ParserException
    {
        FoldersFilter filter = new FoldersFilter();

        ArrayList<FsItem> allItems = GetFolderItems(device, path);
        ArrayList<String> result = filter.GetFolders(allItems);

        return result;
    }

    public ArrayList<String> GetSubFileNames(INovacomDevice device, String path)
            throws NovacomException, IOException, PalmDetectException,
            ParserException
    {
        FoldersFilter filter = new FoldersFilter();

        ArrayList<FsItem> allItems = GetFolderItems(device, path);
        ArrayList<String> result = filter.GetFiles(allItems);

        return result;
    }

    public ArrayList<FsItem> GetFolderItems(INovacomDevice device, String path)
            throws NovacomException, IOException, PalmDetectException,
            ParserException
    {
        String dRawItems = GetDecoratedFolderItemsRaw(device, path);
        StringTokenizer dSplitter = new StringTokenizer(dRawItems, "\n");

        String pRawItems = GetPureFolderItemsRaw(device, path);
        StringTokenizer pSplitter = new StringTokenizer(pRawItems, "\n");

        // Fails on the same data - ???
        // if (dSplitter.countTokens() != pSplitter.countTokens())
        // {
        // throw new ParserException("Error getting folder entries.");
        // }

        ArrayList<FsItem> result = new ArrayList<FsItem>(0);
        while (dSplitter.hasMoreTokens() && pSplitter.hasMoreTokens())
        {
            String decoratedName = dSplitter.nextToken();
            String pureName = pSplitter.nextToken();

            FsItem item = ParseFsItem(decoratedName, pureName);
            if (null != item)
            {
                result.add(item);
            }
        }

        return result;
    }

    private FsItem ParseFsItem(String decoratedName, String pureName)
            throws PalmDetectException
    {
        try
        {
            FolderDetector dirDetect = new FolderDetector();
            if (dirDetect.Detect(decoratedName, pureName))
            {
                FsItem result = new FsItem(decoratedName, FsItemType.directory);
                return result;
            }

            FileDetector fDetect = new FileDetector();
            FsItem result = fDetect.Parse(decoratedName, pureName); // null if
            return result; // not valid FsItem
        }
        catch (PalmDetectException e)
        {
            return null;
        }
    }

    private String GetDecoratedFolderItemsRaw(INovacomDevice device, String path)
            throws PalmDetectException, NovacomException, IOException
    {
        NovacomWrapper deviceWrapper = new NovacomWrapper();

        //TODO : add support for the filenames fith spaces.
        //path = Utilities.WrapWithQuotes(path);
        
        String[] args = { "-1", "-A", "-F", path };
        String result = deviceWrapper.GetCommandAnswer(device, "/bin/ls", args);
        return result;
    }

    private String GetPureFolderItemsRaw(INovacomDevice device, String path)
            throws PalmDetectException, NovacomException, IOException
    {
        NovacomWrapper deviceWrapper = new NovacomWrapper();

        //TODO : add support for the filenames fith spaces.
        //path = Utilities.WrapWithQuotes(path);
        
        String[] args = { "-1", "-A", path };
        String result = deviceWrapper.GetCommandAnswer(device, "/bin/ls", args);
        return result;
    }
}
