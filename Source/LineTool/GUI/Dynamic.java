//Zertop�
//www.zertop.com
package LineTool.GUI;

import Modules.Misc.Sleep;

public class Dynamic implements Runnable {
    private boolean running = true;

    public void run() {
        while (running) {
            RunningTestsProgressDots();
        }
    }

    public void stop(){
        running = false;
    }

    private void RunningTestsProgressDots() {
        Sleep.Time(1);
        setRunningTestsLabel("Running Tests.");
        Sleep.Time(1);
        setRunningTestsLabel("Running Tests..");
        Sleep.Time(1);
        setRunningTestsLabel("Running Tests...");
    }

    private void setRunningTestsLabel (String text)
    {
        LineTool.Control.Variables.GUI.setRunningTestsLabel(text);
    }
}
