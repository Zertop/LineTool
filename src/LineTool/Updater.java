package LineTool;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JOptionPane;

public class Updater {
    private static final int currentVersion = 21;
    private static int availableVersion = getAvailableVersion();
    
    public static void check ()
    {
        if (availableVersion > currentVersion)
        {
            int option = JOptionPane.showConfirmDialog(null, "There is a new version available. Would you like to go online to download the latest version?");
            
            if (option == JOptionPane.YES_OPTION)
            {
                try {
                    Desktop.getDesktop().browse(new URI("http://mybroadband.co.za/vb/showthread.php/607090-quot-Is-it-my-Line-quot-Report-Tool"));
                } catch (IOException ex) {} catch (URISyntaxException ex) {}
                System.exit(0);
            }
        }
    }
    
    public static int getAvailableVersion ()
    {
        try {
            URL website = new URL("http://latest.zertop.com/version.txt");
            InputStream websiteStream = website.openStream();
            DataInputStream websiteDataStream = new DataInputStream (new BufferedInputStream (websiteStream));
            return Integer.parseInt (websiteDataStream.readLine());            
        } catch (MalformedURLException ex) {} catch (IOException ex) {}
    return 0;
    }
}
