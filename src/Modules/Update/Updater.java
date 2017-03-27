//Zertop™
//www.zertop.com
package Modules.Update;

import LineTool.Control.Vars;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Updater implements Runnable {

    public void run() {
        checkUpgrade();
    }

    public void checkUpgrade() {
        String JSON = null;
        try {
            JSON = IOUtils.toString(new URL("https://api.github.com/repos/Zertop/LineTool/releases/latest"));
        } catch (IOException e) {
            System.err.println("Could not detect new version.");
        }
        JSONObject downloadPath = new JSONObject(JSON);
        String[] version = downloadPath.getString("name").replace("V", "").split("\\.");
        int major = Integer.parseInt(version[0]);
        int minor = Integer.parseInt(version[1]);
        int micro = Integer.parseInt(version[2]);

        System.out.println("Latest Available Version: V" + major + "." + minor + "." + micro);

        int option = JOptionPane.NO_OPTION;
        if (major > Vars.getCurrentVersion()[0]) {
            option = JOptionPane.showConfirmDialog(null, "There is a new major version available. Would you like to download and run the latest version?");
        } else if (minor > Vars.getCurrentVersion()[1]) {
            option = JOptionPane.showConfirmDialog(null, "There is a new minor version available. Would you like to download and run the latest version?");
        } else if (micro > Vars.getCurrentVersion()[2]) {
            option = JOptionPane.showConfirmDialog(null, "There is a new micro version available. Would you like to download and run the latest version?");
        }

        if (option == JOptionPane.YES_OPTION) {
            doUpgrade(downloadPath.getJSONArray("assets").getJSONObject(0).getString("browser_download_url"));
        }
    }

    private void doUpgrade(String latestVersionPath) {
        try {
            //Get and assign file to temp file
            File newVersionFile = File.createTempFile("LineTool", ".jar");
            FileOutputStream fos = new FileOutputStream(newVersionFile.getAbsolutePath());
            fos.write(DownloadFile.getBinaryFile(latestVersionPath));
            fos.close();

            //Launch new version
            Runtime.getRuntime().exec(" java -jar " + newVersionFile.getAbsolutePath());
            System.exit(0);

        } catch (IOException ex) {
            System.out.println("Unable to download update!\n" + ex);
        }
    }
}
