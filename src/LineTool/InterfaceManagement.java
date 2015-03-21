package LineTool;
public class InterfaceManagement implements Runnable {
    static boolean running = true;
    public void run ()
    {
        while (running)
        {
            try {Thread.sleep(500);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            RunningTestsAnimation ();
        }
        
        if (!running)
        {
            Main.labelRunningTests.setText ("Tests Finished (3)");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            Main.labelRunningTests.setText ("Tests Finished (2)");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            Main.labelRunningTests.setText ("Tests Finished (1)");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            Main.TestPanel.setVisible (false);
            Main.CompletedPanel.setVisible (true);
        }
    }
    
    public void RunningTestsAnimation ()
    {
        if (running)
        {
            Main.labelRunningTests.setText ("Running Tests.");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        }
        if (running)
        {
            Main.labelRunningTests.setText ("Running Tests..");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        }
        if (running)
        {
            Main.labelRunningTests.setText ("Running Tests...");
        }
    }
    
}
