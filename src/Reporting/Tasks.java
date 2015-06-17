//Zertop™
//www.zertop.com
package Reporting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tasks {
//DETERMINE CORRECT IP
    public static String determineIP ()
    {
//        MinMaxAve testIP = new MinMaxAve (Tasks.pingIP("155.239.255.250", 1));
//        
//        if (testIP.getPacketLoss() == 100)
//        {
//            //Implement Traceroutes for all OS's
//        }
        
        return "155.239.255.250";
    }
//DETERMINE CORRECT IP
    
//CREATE A LOCAL TERMINAL AND PING IP ADDRESS    
    public static String pingIP (String host, int num)
    {
        String output = "";
        try 
            {
                String pingcmd;

                if(System.getProperty("os.name").startsWith("Windows")) 
                {   
                    pingcmd = "ping -n "+num+" " + host; // For Windows
                }  
                else 
                {
                    pingcmd = "ping -c "+num+" " + host; // For Linux and OSX
                }
                
                Process ping = Runtime.getRuntime().exec(pingcmd); 
                ping.waitFor(); 
                BufferedReader reader=new BufferedReader(new InputStreamReader (ping.getInputStream()));
                String line;
                while((line = reader.readLine()) != null) 
                { 
                    output = output + "\n"+line;
                } 
            }
            catch(IOException e1) {} 
            catch(InterruptedException e2) {} 
    return output;
    }
//CREATE A LOCAL TERMINAL AND PING IP ADDRESS
}
