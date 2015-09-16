//Zertop™
//www.zertop.com
package Control;

import Control.Config;

import java.io.*;
import java.net.URL;

public class DownloadFile {
    public static String getTextFile(String file) //Returns a text file as a string
    {
        try {
            URL website = new URL(Config.getReleasesURL() + file);
            InputStream websiteStream = website.openStream();
            BufferedReader websiteDataStream = new BufferedReader(new InputStreamReader(websiteStream));
            return websiteDataStream.readLine();
        } catch (Exception ex) {
            System.out.println("An error occurred whilst trying to download a file!\n" + ex);
        }
        return null;
    }

    public static int getTextFileAsInt(String file) {
        int result = -1;
        try {
            result = Integer.parseInt(getTextFile(file));
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result;
    }

    public static byte[] getBinaryFile(String file) //Returns a binary file as a byte array
    {
        try {
            URL link = new URL(file);

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

    public static void postQuery(String url) {

    }
}
