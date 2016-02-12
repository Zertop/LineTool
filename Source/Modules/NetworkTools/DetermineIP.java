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
        PingResultsAnalysis testIP = new PingResultsAnalysis(PingIP.run("155.239.255.250", 1,30));
        if (testIP.getPacketLoss() == 100) {
            String results = PingIP.run("8.8.8.8",1,2);
            Pattern ipPattern = null;

            if (OSVariables.isWindows()) {
                ipPattern = Pattern.compile("Reply from .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}): TTL expired in transit");
            }
            if (OSVariables.isUnix()){
                ipPattern = Pattern.compile("From .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}).*Time to live exceeded");
            }

            try { //Kick error if unable to match IP
                Matcher ipMatcher = ipPattern.matcher(results);
                ipMatcher.find();
                IP = ipMatcher.group(1);
            } catch (Exception e) {
                System.out.println("Sorry, the tool was unable to detect an IP to ping.\nPlease ensure that you are connected to the internet.\n\nDetailed:\n" + e + results);
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
