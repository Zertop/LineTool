//Zertop™
//www.zertop.com
package Reporting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Tools {
//DETERMINE CORRECT IP
    public static String determineIP ()
    {
        String IP = "";
        MinMaxAve testIP = new MinMaxAve (Tools.pingIP("155.239.255.250", 1));
        if (testIP.getPacketLoss() == 100)
        {
            if (OSDetection.isWindows())
            {
                String traceResults = traceIP ("zertop.com", 2);
                Pattern packetLossPattern = Pattern.compile("2 .*?(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})");
                Matcher packetLossMatcher = packetLossPattern.matcher(traceResults);
                packetLossMatcher.find();
                IP = packetLossMatcher.group(1);
            }
            else
            {
                JOptionPane.showMessageDialog (null, "Unfortunately, you are still running on an old exchange. The tool only supports windows for this capability.");
                System.exit(0);
            }
        }
        else
        {
            IP = "155.239.255.250";
        }
        System.out.println ("Using IP: "+IP);
        try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        LineTool.GUI.setimageDeterminingIPToPingCompleted();
        return IP;
    }
//DETERMINE CORRECT IP

//TRACE IP ADDRESS 
    public static String traceIP (String host, int hops)
    {
        String output = "";
            try 
            {
                String tracecmd;

                if(OSDetection.isWindows()) 
                {   
                    tracecmd = "tracert -h "+hops+ host; // For Windows
                    Process trace = Runtime.getRuntime().exec(tracecmd); 
                    trace.waitFor(); 
                    BufferedReader reader=new BufferedReader(new InputStreamReader (trace.getInputStream()));
                    String line;
                    while((line = reader.readLine()) != null) 
                    { 
                        output = output +Reporting.Tools.getLineBreak()+line;
                    }
                }
                else 
                {
                    JOptionPane.showMessageDialog (null, "An error occured. A tracert was attempted on a non-windows computer. Please report this to Zertop.");
                }
            }
            catch(IOException | InterruptedException e1) {}
        
        return output;
    }
//TRACE IP ADDRESS    
    
//PING IP ADDRESS    
    public static String pingIP (String host, int num)
    {
        String output = "";
        try 
            {
                String pingcmd;

                if(OSDetection.isWindows()) 
                {   
                    pingcmd = "ping -n "+num + " " + host; // For Windows
                }  
                else 
                {
                    pingcmd = "ping -c "+num+ " " +host; // For Linux and OSX
                }
                
                Process ping = Runtime.getRuntime().exec(pingcmd); 
                ping.waitFor(); 
                BufferedReader reader=new BufferedReader(new InputStreamReader (ping.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) 
                { 
                    output = output+line+Reporting.Tools.getLineBreak();
                } 
            }
            catch(IOException | InterruptedException e1) {} 
    return output;
    }
//PING IP ADDRESS
    
    public static String getLineBreak()
    {
        return System.getProperty("line.separator");
    }
}
