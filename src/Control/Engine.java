//Zertop™
//www.zertop.com
package Control;

import GUI.Dynamic;
import GUI.Interface;

public class Engine {

    private static GUI.Interface GUI = new GUI.Interface();
    private static GUI.Dynamic GUIDynamicInstance = new GUI.Dynamic(); //Dynamic Interface Thread
    private static Reporting.GenReport GenReportInstance = new Reporting.GenReport(); //Generate Report Thread
    private static String plainTxtPath = "";
    private static String formattedTxtPath = "";
    private static String intelligentReport = "";

    public static void main(String[] args) {
        System.out.println("Welcome to Zertop's LineTool V" + Config.getVersion());
        GUI.switchToPane(GUI.launcherPane); //Open Engine Pane
        GUI.setVisible(true);

        GUI.setLaunchStatus("Checking for updates..."); //Check for Updates
        checkForUpdate();

        GUI.switchToPane(GUI.startPane); //Open Start Pane
    }


    public static void beginTests() {
        GUI.switchToPane(GUI.testsPane); //Switch to the testing pane

        Thread GenReportThread = new Thread(GenReportInstance); //Start Generating Report
        GenReportThread.start();


        Thread GUIDynamicThread = new Thread(GUIDynamicInstance); //Start Dynamic GUI Thread
        GUIDynamicThread.start();
    }

    public static void goToResults() {
        Dynamic.setRunning(false);
        GUI.switchToPane(Interface.resultsPane);
    }

    public static void displayMessage(String header, String message) {
        GUI.setDisplayHeaderLabel(header);
        GUI.setDisplayTextArea(message);
        GUI.switchToPane(GUI.displayPane);
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
