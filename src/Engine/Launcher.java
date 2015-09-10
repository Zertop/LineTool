//Zertop™
//www.zertop.com
package Engine;

public class Launcher {
    public static void main (String[] args)
    {
        GUI.LauncherGUI launcherGUI = new GUI.LauncherGUI(); //Create the launcher and start
        launcherGUI.setVisible(true);
        startUpdate();
        new GUI.GUI().setVisible (true);
        launcherGUI.dispose();
    }
    
    public static void startUpdate() //Start Update Process
    {
        Updater updaterInstance = new Updater ();
        Thread updaterThread = new Thread (updaterInstance);
        updaterThread.start();
        while (updaterThread.isAlive())//Stops thread moving forward if still updating
        {
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        }
    }
}
