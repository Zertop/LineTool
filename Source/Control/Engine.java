//Zertop™
//www.zertop.com
package Control;

import GUI.Dynamic;
import GUI.Interface;
import Modules.ReportGenerate;

public class Engine {

    private static GUI.Interface GUI = new GUI.Interface();
    private static GUI.Dynamic GUIDynamicInstance = new GUI.Dynamic(); //Dynamic Interface Thread
    private static ReportGenerate GenReportInstance = new ReportGenerate(); //Generate Report Thread
    private static String plainTxtPath = "";
    private static String formattedTxtPath = "";
    private static String intelligentReport = "";

    public static void main(String[] args) {
        System.out.println("Welcome to Zertop's LineTool V" + Config.getVersion());
        GUI.switchToPane(Interface.launcherPane); //Open Engine Pane
        GUI.setVisible(true);

        GUI.setLaunchStatus("Checking for updates..."); //Check for Updates
        checkForUpdate();

        GUI.switchToPane(Interface.startPane); //Open Start Pane
    }


    public static void beginTests() {
        //Switch to the testing pane
        GUI.switchToPane(Interface.testsPane);

        //Start Generating Report
        Thread GenReportThread = new Thread(GenReportInstance);
        GenReportThread.start();

        //Start Dynamic GUI Thread
        Thread GUIDynamicThread = new Thread(GUIDynamicInstance);
        GUIDynamicThread.start();
    }

    public static void goToResults() {
        Dynamic.setRunning(false);
        GUI.switchToPane(Interface.resultsPane);
    }

    public static void displayMessage(String header, String message) {
        Interface.setDisplayHeaderLabel(header);
        Interface.setDisplayTextArea(message);
        GUI.switchToPane(Interface.displayPane);
    }

    public static void setIntelligentReport(String intelReport) {
        intelligentReport = intelReport;
    }

    public static String getIntelligentReport() {
        return intelligentReport;
    }

    public static void setPlainTxtPath(String pathPlain) {
        plainTxtPath = pathPlain;
    }

    public static void setFormattedTxtPath(String pathFormatted) {
        formattedTxtPath = pathFormatted;
    }

    public static String getPlainTxtPath() {
        return plainTxtPath;
    }

    public static String getFormattedTxtPath() {
        return formattedTxtPath;
    }

    private static void checkForUpdate() //Start Update Process
    {
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
}
