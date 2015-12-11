//Zertop�
//www.zertop.com
package Modules.NetworkTools;

import Modules.Misc.OSVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TraceIP {
    public static String run(String host, int hops) {
        String output = "";
        try {
            String tracecmd = null;

            if (OSVariables.isWindows()) {
                tracecmd = "tracert -h " + hops + " " + host; // For Windows
            }
            if (OSVariables.isUnix()) {
                tracecmd = "traceroute -m " + hops + " " + host; // For Linux
            }

            Process trace = Runtime.getRuntime().exec(tracecmd);
            trace.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(trace.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output = output + OSVariables.getLineBreak() + line;
            }
        } catch (IOException | InterruptedException e1) {
            System.out.println(e1);
        }
        return output;
    }
}
