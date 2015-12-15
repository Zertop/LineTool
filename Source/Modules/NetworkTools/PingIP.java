//Zertop�
//www.zertop.com
package Modules.NetworkTools;

import Modules.Misc.OSVariables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingIP {
    public static String run(String host, int count, int ttl) {
        String output = "";
        try {
            String pingcmd;

            if (OSVariables.isWindows()) {
                pingcmd = "ping " + host + " -n " + count + " -i " + ttl; // For Windows
            } else {
                pingcmd = "ping " + host + " -c " + count + " -t " + ttl; // For Linux and OSX
            }

            Process ping = Runtime.getRuntime().exec(pingcmd);
            ping.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ping.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output = output + line + OSVariables.getLineBreak();
            }
        } catch (IOException | InterruptedException e1) {
            System.out.println(e1);
        }
        return output;
    }
}
