//Zertop™
//www.zertop.com
package LineTool.Control;

public class Engine {
    public static void main(String[] args) {
        System.out.println("Welcome to " + "Zertop's LineTool" + " V" + Config.getVersion());

        //Open Panel
        LineTool.Control.Variables.GUI = new LineTool.GUI.Interface();

        //Open Launch Pane
        LineTool.Control.Variables.GUI.switchToPane(LineTool.Control.Variables.GUI.launcherPane);
        LineTool.Control.Variables.GUI.setVisible(true);

        //Check for Updates
        LineTool.Control.Variables.GUI.setLaunchStatus("Checking for updates...");
        checkForUpdate();

        //Open Start Pane
        LineTool.Control.Variables.GUI.switchToPane(LineTool.Control.Variables.GUI.startPane);

    }

    public static void doTests ()
    {
        DoTests tests = new DoTests();
        Thread testing = new Thread(tests);
        testing.start();
    }

    private static void checkForUpdate() {
        Updater updaterInstance = new Updater();
        Thread updaterThread = new Thread(updaterInstance);
        updaterThread.start();
        System.out.println("At Latest Version.\n");
    }

    public static void displayMessage(String header, String message) {
        LineTool.Control.Variables.GUI.setDisplayHeaderLabel(header);
        LineTool.Control.Variables.GUI.setDisplayTextArea(message);
        LineTool.Control.Variables.GUI.switchToPane(LineTool.Control.Variables.GUI.displayPane);
    }
}
