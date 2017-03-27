//Zertop™
//www.zertop.com
package Modules.Update;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class DownloadFile {
    public static byte[] getBinaryFile(String filePath) //Returns a binary file as a byte array
    {
        try {
            URL link = new URL(filePath);

            //Download Code
            InputStream in = new BufferedInputStream(link.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n = 0;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            //Download Code

            return out.toByteArray();
        } catch (Exception ex) {
            System.out.println("An error occured whilst trying to download a file!\n" + ex);
        }
        return null;
    }
}
