//Zertop™
//www.zertop.com
package GUI;

public class Dynamic implements Runnable {
    private boolean running = true;

    public void run() {
        while (running) {
            RunningTestsProgressDots();
        }
    }

    public void setRunning(boolean run) {
        running = run;
    }

    private void RunningTestsProgressDots() {
        Modules.Sleep.Time(1);
        Control.Engine.setRunningTestsLabel("Running Tests.");
        Modules.Sleep.Time(1);
        Control.Engine.setRunningTestsLabel("Running Tests..");
        Modules.Sleep.Time(1);
        Control.Engine.setRunningTestsLabel("Running Tests...");
    }
}
