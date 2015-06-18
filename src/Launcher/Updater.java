//Zertop™
//www.zertop.com
package Launcher;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

public class Updater implements Runnable {
    private int availableVersion;
    public void run ()
    {
        availableVersion = getAvailableVersion();
        if (availableVersion > Information.getVersion())
        {
            int option = JOptionPane.showConfirmDialog(null, "There is a new version available. Would you like to download and run the latest version?");
            
            if (option == JOptionPane.YES_OPTION)
            {
                upgradeProgram();
            }
        }
    }

    private void upgradeProgram ()
    {
        try {
            URL link = new URL(Information.getReleasesURL());
            File newVersionFile = File.createTempFile("LineTool", ".jar");
            
            //DOWNLOAD CODE
		 InputStream in = new BufferedInputStream(link.openStream());
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 byte[] buf = new byte[1024];
		 int n = 0;
		 while (-1!=(n=in.read(buf)))
		 {
		    out.write(buf, 0, n);
		 }
		 out.close();
		 in.close();
		 byte[] response = out.toByteArray();
 
		 FileOutputStream fos = new FileOutputStream(newVersionFile.getAbsolutePath());
		 fos.write(response);
		 fos.close();
            //DOWNLOAD CODE
                 
            //LAUNCH NEW VERSION
                Process proc = Runtime.getRuntime().exec(" java -jar " + newVersionFile.getAbsolutePath() );
                System.exit(0);
            //LAUNCH NEW VERSION
            } catch (IOException ex) {}
    }
    
    private int getAvailableVersion ()
    {
        try {
            URL website = new URL(Information.getReleasesURL() + "version.txt");
            InputStream websiteStream = website.openStream();
            DataInputStream websiteDataStream = new DataInputStream (new BufferedInputStream (websiteStream));
            return Integer.parseInt (websiteDataStream.readLine());            
        } catch (MalformedURLException ex) {} catch (IOException ex) {}
    return 0;
    }
}
