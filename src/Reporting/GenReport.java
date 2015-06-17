//Zertop™
//www.zertop.com
package Reporting;

import LineTool.GUI;
import LineTool.GUICron;
import java.io.*;
import java.util.Date;
import java.util.regex.*;

public class GenReport implements Runnable {
//PERM VARIABLES
        static String pingResults;
        static String intelReport = "";
//PERM VARIABLES
        
    public void run ()
    {
        pingGateway();
        GUI.setimagePingingTelkomEquipmentCompleted();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        generateReport ();
        GUI.setimageGeneratingReportCompleted ();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        GUI.setimageFinishedCompleted();
        GUICron.setRunning (false);
    }

//PINGS IP
   public static void pingGateway ()
    {
        pingResults = Tasks.pingIP (Tasks.determineIP(),30);
    }
//PINGS IP

//GENERATE REPORT
   public static void generateReport ()
   {
       
            try {
//INITIALISE WRITERS
                File tempUnformatted = File.createTempFile("zertoplinetool", ".txt");
                PrintWriter writerUnformatted = new PrintWriter (tempUnformatted);
                
                File tempFormatted = File.createTempFile("zertoplinetool", ".txt");
                PrintWriter writerFormatted = new PrintWriter (tempFormatted);
//INITIALISE WRITERS
                
//GENERATE MIN MAX AVE VARIABLES
                MinMaxAve testIP = new MinMaxAve (pingResults);
//GENERATE MIN MAX AVE VARIABLES
                
//GENERATE TEXT FILE HEADERS
                writerUnformatted.println ("Zertop's \"Is it my Line\" Results" + "\nDate/Time: " + new Date());
                writerUnformatted.println ("\nBasic Report:");
                writerUnformatted.println ("");
                
                writerFormatted.println ("[B]Zertop's \"Is it my Line\" Results" + "\nDate/Time: " + new Date()+"[/B]");
                writerFormatted.println ("[I][B]\nBasic Report:[/B][/I]");
                writerFormatted.println ("");
//GENERATE TEXT FILE HEADERS
                
//GENERATE INTELLIGENT REPORT HEADERS
                intelReport = intelReport + ("Your packet loss was "+testIP.getPacketLoss()+"%.");
                intelReport = intelReport + "\n" +  ("Your average ping was "+testIP.getAvePing()+"ms.");
                intelReport = intelReport + "\n" +  ("Your maximum ping was "+testIP.getMaxPing()+"ms.");
                intelReport = intelReport + "\n" +  ("");
//GENERATE INTELLIGENT REPORT HEADERS
                
//PACKET LOSS REPORT                
                if (testIP.getPacketLoss() > 20)
                {
                    intelReport = intelReport + "\n" +  ("You have serious packet loss. Please post these results to the forum for advice.");
                } else if (testIP.getPacketLoss() > 1)
                {
                    intelReport = intelReport + "\n" +  ("You seem to have some packet loss. This indicates an issue on the line.");
                }
//PACKET LOSS REPORT
                
//AVERAGE PING REPORT                
                if (testIP.getPacketLoss() < 20)
                {
                    if (testIP.getAvePing() > 80)
                    {
                        intelReport = intelReport + "\n" +  ("Looking at your average ping, there is definitely something wrong with your line! Please post the results (at the end of the program) into the forum for advice!");
                    } else if (testIP.getAvePing() > 30)
                    {
                        intelReport = intelReport + "\n" +  ("Looking at your average ping, your line seems to be a bit dodgy. This may account for any slow speeds you may be experiencing. However, it could just be related to a high-latency home network (eg... Wi-Fi). If you feel the need, please post the results (at the end of the program) into the forum for advice!");
                    } else
                    {
                        intelReport = intelReport + "\n" +  ("Looking at your average ping, your line seems to be running perfectly.");
                    }
                }
//AVERAGE PING REPORT
                
//MAXIMUM PING REPORT
                if (testIP.getPacketLoss() < 20)
                {
                    if (testIP.getAvePing() < 30)
                    {
                        if (testIP.getMaxPing() > 100)
                        {
                            intelReport = intelReport + "\n" +  ("Looking at your maximum ping, however, it seems as though there could be a serious intermittent fault on the line. This could be a cause of an issue. Please post the results (at the end of the program) into the forum for advice.");
                        } else if (testIP.getMaxPing() > 30)
                        {
                            intelReport = intelReport + "\n" +  ("Looking at your maximum ping, however, it seems as though there could be a slight intermittant issue on the line. If required, please post the results to a forum post.");
                        } else
                        {
                            intelReport = intelReport + "\n" +  ("It seems that your maximum ping is also good. If there are any issues, they most probably lie with your ISP");
                        }
                    }
                }
//MAXIMUM PING REPORT   

//ADD INTEL REPORT TO TXT FILE AND SET VARIABLES OF GUI
               writerUnformatted.println (intelReport);
               writerFormatted.println (intelReport);
               GUI.setFieldResults(intelReport);
//ADD INTEL REPORT TO TXT FILE AND SET VARIABLES OF GUI                
                
//ATTACHING DETAILED REPORT
                writerUnformatted.println ("");
                writerUnformatted.println ("Detailed Report:");
                writerUnformatted.println (pingResults);
                
                writerFormatted.println ("");
                writerFormatted.println ("[B][I]Detailed Report:[/B][/I]");
                writerFormatted.println ("[CODE]");
                writerFormatted.println (pingResults);
                writerFormatted.println ("[/CODE]");
//ATTACHING DETAILED REPORT
                
//SAVE AS TMP AND PARSE TO MAIN THREAD                
                writerUnformatted.close();
                writerFormatted.close();
                GUI.setTempFilePathUnformatted (tempUnformatted.getAbsolutePath());
                GUI.setTempFilePathFormatted (tempFormatted.getAbsolutePath());
//SAVE AS TMP AND PARSE TO MAIN THREAD     
            } catch (IOException ex) {}
   }
//GENERATE REPORT
   
 
}
