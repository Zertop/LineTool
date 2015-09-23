//Zertop™
//www.zertop.com
package Modules;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPDetermine {
    public static String run() {
        String IP = "";
        ReportPingAnalyse testIP = new ReportPingAnalyse(IPPing.run("155.239.255.250", 1));
        if (testIP.getPacketLoss() == 100) {
            if (OSVariables.isWindows()) {
                String traceResults = IPTrace.run("zertop.com", 2);
                Pattern packetLossPattern = Pattern.compile("2 .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
                Matcher packetLossMatcher = packetLossPattern.matcher(traceResults);
                try { //Kick error if unable to match IP
                    //packetLossMatcher.find();
                    IP = packetLossMatcher.group(1);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Sorry, the tool was unable to detect an IP to ping.\nPlease ensure that you are connected to the internet.\n\nDetailed:\n" + e + traceResults);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Unfortunately, you are still running on an old exchange. The tool only supports windows for this capability.");
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
