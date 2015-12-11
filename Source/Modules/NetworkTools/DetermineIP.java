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
            String traceResults = TraceIP.run("8.8.8.8", 2);
            Pattern ipPattern = null;

            if (OSVariables.isWindows()) {
                ipPattern = Pattern.compile("2    .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
            }
            if (OSVariables.isUnix()){
                ipPattern = Pattern.compile(" 2  .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
            }

            Matcher ipMatcher = ipPattern.matcher(traceResults);
            ipMatcher.find();
            try { //Kick error if unable to match IP
                IP = ipMatcher.group(1);
            } catch (Exception e) {
                System.out.println("Sorry, the tool was unable to detect an IP to ping.\nPlease ensure that you are connected to the internet.\n\nDetailed:\n" + e + traceResults);
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
