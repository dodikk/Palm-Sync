package PalmWrapper;

import java.io.FileOutputStream;
import java.io.IOException;

import com.palm.novacom.INovacomDevice;
import com.palm.novacom.INovacomStream;
import com.palm.novacom.NovacomException;



public class FileReader
{
    public void ReadTextFile(INovacomDevice device, String devicePath)
            throws NovacomException, IOException
    {
        INovacomStream hFile = device.getFile(devicePath);

        String tmp = null;
        do
        {
            tmp = hFile.readLine();
            System.out.println(tmp);
        }
        while (false == tmp.isEmpty());
        hFile.close();
    }

    public void ReadBinaryFile(
            INovacomDevice device, 
            String devicePath,
            String backupPath) 
    throws NovacomException, IOException
    {
        try
        {
            INovacomStream hFile = device.getFile(devicePath);
            FileOutputStream localFile = new FileOutputStream(backupPath);

            int offset = 0;
            int bytesRead = 0;
            byte buffer[] = new byte[200];
            do
            {
                bytesRead = hFile.read(buffer);
                localFile.write(buffer, offset, bytesRead);
            }
            while (0 < bytesRead);

            hFile.close();
            localFile.close();
        }
        catch (NovacomException e)
        {
            System.out.print("Error reading file : ");
            System.out.println(devicePath);
            throw e;
        }
    }
}
