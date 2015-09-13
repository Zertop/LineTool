//Zertop™
//www.zertop.com
package Control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Updater implements Runnable {
    private int availableVersion;

    public void run() {
        availableVersion = HTTP.getTextFileAsInt("version.php");
        System.out.println("Latest Available Version: V" + availableVersion);
        if (availableVersion > Config.getVersion()) {
            int option = JOptionPane.showConfirmDialog(null, "There is a new version available. Would you like to download and run the latest version?");

            if (option == JOptionPane.YES_OPTION) {
                upgradeProgram();
            }
        }
    }

    private void upgradeProgram() {
        try {
            //Get and assign file to temp file
            File newVersionFile = File.createTempFile("LineTool", ".jar");
            FileOutputStream fos = new FileOutputStream(newVersionFile.getAbsolutePath());
            fos.write(HTTP.getBinaryFile(Config.getReleasesURL()));
            fos.close();

            //Launch new version
            Runtime.getRuntime().exec(" java -jar " + newVersionFile.getAbsolutePath());
            System.exit(0);

        } catch (IOException ex) {
            System.out.println("Unable to download update!\n" + ex);
        }
    }
}
