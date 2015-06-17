//Zertop™
//www.zertop.com
package LineTool;
public class GUICron implements Runnable {
    static boolean running = true;
    public void run ()
    {
        while (running)
        {
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            RunningTestsAnimation ();
        }
        
        if (!running)
        {
            GUI.labelRunningTests.setText ("Tests Finished (3)");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            GUI.labelRunningTests.setText ("Tests Finished (2)");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            GUI.labelRunningTests.setText ("Tests Finished (1)");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            GUI.TestPanel.setVisible (false);
            GUI.CompletedPanel.setVisible (true);
        }
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