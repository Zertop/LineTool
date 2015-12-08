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

        LineTool.Control.Variables.GUI.switchToPane(LineTool.Control.Variables.GUI.testsPane);
        LineTool.GUI.Dynamic dynamic = new LineTool.GUI.Dynamic();
        Thread dynamicThread = new Thread(dynamic);

        dynamicThread.start();

        //Determine correct IP
        String determinedIP = DetermineIP.run();
        LineTool.Control.Variables.GUI.setDeterminingIPToPingComplete();

        //Ping the IP
        String pingResults = PingIP.run(determinedIP, 30);
        LineTool.Control.Variables.GUI.setPingingTelkomEquipmentComplete();
        Sleep.Time(1);

        //Generate Report from Ping Results
        Variables.report = new GenerateReport(pingResults);
        LineTool.Control.Variables.GUI.setGeneratingReportComplete();

        //Finish
        Sleep.Time(1);
        LineTool.Control.Variables.GUI.setFinishedComplete();
        dynamic.stop();
        LineTool.Control.Variables.GUI.switchToPane(LineTool.Control.Variables.GUI.resultsPane);
    }
}
