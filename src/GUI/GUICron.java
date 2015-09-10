//Zertop™
//www.zertop.com
package GUI;
public class GUICron implements Runnable {
    static boolean running = true;
    public void run ()
    {
        while (running)
        {
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            RunningTestsAnimation ();
        }
    }
    
    public static void setRunning (boolean r)
    {
        running = r;
    }
    public void RunningTestsAnimation ()
    {
        if (running)
        {
            GUI.labelRunningTests.setText ("Running Tests.");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        }
        if (running)
        {
            GUI.labelRunningTests.setText ("Running Tests..");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        }
        if (running)
        {
            GUI.labelRunningTests.setText ("Running Tests...");
        }
    }
    
}
