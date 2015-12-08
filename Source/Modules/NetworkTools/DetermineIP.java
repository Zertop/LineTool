//Zertop�
//www.zertop.com
package Modules.NetworkTools;

import Modules.Analysis.PingResultsAnalysis;
import Modules.Misc.OSVariables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetermineIP {
    public static String run() {
        String IP = "";
        PingResultsAnalysis testIP = new PingResultsAnalysis(PingIP.run("155.239.255.250", 1));
        if (testIP.getPacketLoss() == 100) {
            if (OSVariables.isWindows()) {
                String traceResults = TraceIP.run("zertop.com", 2);
                Pattern ipPattern = Pattern.compile("2     .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
                Matcher ipMatcher = ipPattern.matcher(traceResults);
                ipMatcher.find();
                try { //Kick error if unable to match IP
                    IP = ipMatcher.group(1);
                } catch (Exception e) {
                    System.out.println("Sorry, the tool was unable to detect an IP to ping.\nPlease ensure that you are connected to the internet.\n\nDetailed:\n" + e + traceResults);
                }
            } else {
                System.out.println("Unfortunately, you are still running on an old exchange. The tool only supports windows for this capability.");
            }
        } else {
            IP = "155.239.255.250";
        }
        System.out.println("Using IP: " + IP);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getStackTrace());
        }
        return IP;
    }
}
