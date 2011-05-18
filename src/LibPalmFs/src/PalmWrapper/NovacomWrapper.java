package PalmWrapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.palm.novacom.INovacomDevice;
import com.palm.novacom.INovacomStream;
import com.palm.novacom.NovacomException;


public class NovacomWrapper
{
    public String GetCommandAnswer(
            INovacomDevice device, 
            String command, 
            String[] args) 
    throws NovacomException, IOException 
    {
        String result = null;
        INovacomStream answer = null;
        ByteArrayOutputStream stream = null;
        
        
        try
        {
            answer = device.runProgram(command, args);
            stream = new ByteArrayOutputStream();
    
            int offset = 0;
            int bytesRead = 0;
            byte buffer[] = new byte[4096];
            do
            {
                bytesRead = answer.read(buffer);
                stream.write(buffer, offset, bytesRead);
            }
            while (0 < bytesRead);
    
            result = stream.toString();
        }
        finally
        {
            answer.close();
            stream.close();
        }

        return result;
    }
}
