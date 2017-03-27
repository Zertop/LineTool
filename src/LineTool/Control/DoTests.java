//Zertop™
//www.zertop.com
package LineTool.Control;

import Modules.Analysis.GenerateReport;
import Modules.Misc.Sleep;
import Modules.NetworkTools.DetermineIP;
import Modules.NetworkTools.PingIP;

public class DoTests implements Runnable {
    @Override
    public void run() {

        Vars.GUI.switchToPane(Vars.GUI.testsPane);
        LineTool.GUI.Dynamic dynamic = new LineTool.GUI.Dynamic();
        Thread dynamicThread = new Thread(dynamic);

        dynamicThread.start();

        //Determine correct IP
        String determinedIP = DetermineIP.run();
        Vars.GUI.setDeterminingIPToPingComplete();

        //Ping the IP
        String pingResults = PingIP.run(determinedIP, 30, 30);
        Vars.GUI.setPingingTelkomEquipmentComplete();
        Sleep.Time(1);

        //Generate Report from Ping Results
        Vars.report = new GenerateReport(pingResults);
        Vars.GUI.setGeneratingReportComplete();

        //Finish
        Sleep.Time(1);
        Vars.GUI.setFinishedComplete();
        dynamic.stop();
        Vars.GUI.switchToPane(Vars.GUI.resultsPane);
    }
}
