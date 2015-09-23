//Zertop™
//www.zertop.com
package GUI;

public class Dynamic implements Runnable {
    private static boolean running = true;

    public void run() {
        while (running) {
            RunningTestsProgressDots();
        }
    }

    public static void setRunning(boolean run) {
        running = run;
    }

    private static void RunningTestsProgressDots() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        } //Sleep Execution for 1s
        GUI.Interface.setRunningTestsLabel("Running Tests.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        } //Sleep Execution for 1s
        GUI.Interface.setRunningTestsLabel("Running Tests..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        } //Sleep Execution for 1s
        GUI.Interface.setRunningTestsLabel("Running Tests...");
    }
}
