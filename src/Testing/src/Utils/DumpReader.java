package Utils;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DumpReader
{
    public String DumpToString(String fileName) 
        throws IOException
    {
        String result = "";

        FileInputStream fstream = new FileInputStream(fileName);
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        try
        {
            String strLine = null;
            do
            {
                strLine = br.readLine();
                
                if (strLine != null)
                {
                    result = result + strLine + "\n";
                }
                else
                {
                    break;
                }
            }
            while (true);
        }
        finally
        {
            in.close();
        }

        return result;
    }
}
