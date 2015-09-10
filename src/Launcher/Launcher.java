//Zertop™
//www.zertop.com
package Launcher;
public class Launcher {
    public static void main (String[] args)
    {
//CREATE LAUNCHER GUI, CHECK FOR UPDATE
        LauncherGUI launcherGUI = new LauncherGUI();
        launcherGUI.setVisible(true);
        startUpdate();
        new GUI.GUI().setVisible (true);
        launcherGUI.dispose();
//CREATE LAUNCHER GUI, CHECK FOR UPDATE
    }
    
    public static void startUpdate()
    {
        Updater updateInstance = new Updater ();
        Thread updateThread = new Thread (updateInstance);
        updateThread.start();
        while (updateThread.isAlive())
        {
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            //Stops thread moving forward if still updating
        }
    }
}
