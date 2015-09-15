package Modules;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TraceIP {
    public static String run(String host, int hops) {
        String output = "";
        try {
            String tracecmd;

            if (DetectOS.isWindows()) {
                tracecmd = "tracert -h " + hops + " " + host; // For Windows
                Process trace = Runtime.getRuntime().exec(tracecmd);
                trace.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(trace.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    output = output + Modules.SystemVariables.getLineBreak() + line;
                }
            } else {
                JOptionPane.showMessageDialog(null, "An error occured. A tracert was attempted on a non-windows computer. Please report this to Zertop.");
            }
        } catch (IOException | InterruptedException e1) {
        }

        return output;
    }
}
