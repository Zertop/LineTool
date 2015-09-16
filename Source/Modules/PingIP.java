package Modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingIP {
    static String output = "";

    public static String run(String host, int num) {
        try {
            String pingcmd;

            if (DetectOS.isWindows()) {
                pingcmd = "ping -n " + num + " " + host; // For Windows
            } else {
                pingcmd = "ping -c " + num + " " + host; // For Linux and OSX
            }

            Process ping = Runtime.getRuntime().exec(pingcmd);
            ping.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ping.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output = output + line + Modules.SystemVariables.getLineBreak();
            }
        } catch (IOException | InterruptedException e1) {
        }
        return output;
    }
}
