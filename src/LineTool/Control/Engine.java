//Zertop™
//www.zertop.com
package LineTool.Control;

import Modules.Update.Updater;

public class Engine {
    public static void main(String[] args) {
        System.out.println("Welcome to " + "Zertop's LineTool " + Vars.getVersionString());

        //Open Panel
        Vars.GUI = new LineTool.GUI.Interface();

        //Open Launch Pane
        Vars.GUI.switchToPane(Vars.GUI.launcherPane);
        Vars.GUI.setVisible(true);

        //Check for Updates
        Vars.GUI.setLaunchStatus("Checking for updates...");
        checkForUpdate();

        //Open Start Pane
        Vars.GUI.switchToPane(Vars.GUI.startPane);

    }

    private static void checkForUpdate() {
        Updater updaterInstance = new Updater();
        Thread updaterThread = new Thread(updaterInstance);
        updaterThread.start();
    }

    public static void doTests() {
        DoTests tests = new DoTests();
        Thread testing = new Thread(tests);
        testing.start();
    }

    public static void displayMessage(String header, String message) {
        Vars.GUI.setDisplayHeaderLabel(header);
        Vars.GUI.setDisplayTextArea(message);
        Vars.GUI.switchToPane(Vars.GUI.displayPane);
    }
}
