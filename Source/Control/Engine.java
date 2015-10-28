//Zertop™
//www.zertop.com
package Control;

import Config.Config;
import Modules.FileToString;
import Modules.ReportGenerate;

import java.io.File;

public class Engine {

    private static boolean isHeadless = false;
    private static GUI.Interface GUI;
    private static String plainTxtPath = "";
    private static String formattedTxtPath = "";
    private static String intelligentReport = "";

    public static void main(String[] args) {
        System.out.println("Welcome to " + Config.getAppName() + " V" + Config.getVersion());
        try {
            GUI = new GUI.Interface();
            interfaceMode();
        } catch (java.awt.HeadlessException e) { //Run as headless mode if no display driver found!
            headlessMode();
            System.out.println("No Display Driver Found, Running in Headless Mode");
        }
    }

    public static void interfaceMode() {
        GUI = new GUI.Interface(); //Generate Interface

        GUI.switchToPane(GUI.launcherPane); //Open Engine Pane
        GUI.setVisible(true);

        GUI.setLaunchStatus("Checking for updates..."); //Check for Updates
        checkForUpdate();

        GUI.switchToPane(GUI.startPane); //Open Start Pane
    }

    public static void headlessMode() {
        isHeadless = true;
        checkForUpdate();
        beginTests();
    }

    private static void checkForUpdate() {
        Updater updaterInstance = new Updater();
        Thread updaterThread = new Thread(updaterInstance);
        updaterThread.start();
        while (updaterThread.isAlive())//Stops thread moving forward if still updating
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            } //Sleep Execution for 1s
        }
        System.out.println("At Latest Version.\n");
    }

    public static void beginTests() {
        //Start Generating Report
        Thread GenReportThread = new Thread(new ReportGenerate());
        GenReportThread.start();

        if (!isHeadless) {
            //Switch to the testing pane
            GUI.switchToPane(GUI.testsPane);
        }
    }

    public static void goToResults() {
        if (isHeadless) {
            System.out.println("-----------" + FileToString.FileToString(new File(getPlainTxtPath())));
        } else {
            GUI.switchToPane(GUI.resultsPane);
        }
    }

    public static void displayMessage(String header, String message) {
        if (!isHeadless) {
            GUI.setDisplayHeaderLabel(header);
            GUI.setDisplayTextArea(message);
            GUI.switchToPane(GUI.displayPane);
        } else {
            System.out.println("ERROR: " + header + "\n\n" + message);
        }
    }

    //Gets and Sets
    public static void setIntelligentReport(String intelReport) {
        intelligentReport = intelReport;
    }

    public static String getIntelligentReport() {
        return intelligentReport;
    }

    public static void setPlainTxtPath(String pathPlain) {
        plainTxtPath = pathPlain;
    }

    public static String getPlainTxtPath() {
        return plainTxtPath;
    }

    public static void setFormattedTxtPath(String pathFormatted) {
        formattedTxtPath = pathFormatted;
    }

    public static String getFormattedTxtPath() {
        return formattedTxtPath;
    }


    //GUI Updates
    public static void setDeterminingIPToPingComplete() {
        if (!isHeadless)
            GUI.setDeterminingIPToPingComplete();
    }

    public static void setPingingTelkomEquipmentComplete() {
        if (!isHeadless)
            GUI.setPingingTelkomEquipmentComplete();
    }

    public static void setGeneratingReportComplete() {
        if (!isHeadless)
            GUI.setGeneratingReportComplete();
    }

    public static void setFinishedComplete() {
        if (!isHeadless)
            GUI.setFinishedComplete();
    }

    public static void setRunningTestsLabel(String text) {
        if (!isHeadless)
            GUI.setRunningTestsLabel(text);
    }

}
