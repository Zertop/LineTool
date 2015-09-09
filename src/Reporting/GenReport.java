//Zertop™
//www.zertop.com
package Reporting;

import java.io.*;
import java.util.Date;

public class GenReport implements Runnable {
//PERM VARIABLES
        static String pingResults;
        static String intelReport = "";
        static MinMaxAve testIP;
//PERM VARIABLES
        
    public void run ()
    {
        //Generate ping results
        genPingResults();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        
        //Generate Report
        genReport ();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        
        //Finish. Check for total packet loss else move to results screen
        LineTool.GUI.setimageFinishedCompleted();
        if (totalPacketLoss()){
            LineTool.GUI.displayError("The program was unable to ping an IP. \nPlease ensure that you are connected to the internet!");}
        else{
            LineTool.GUI.labelRunningTests.setText ("Tests Finished");
            try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
            LineTool.GUI.TestPanel.setVisible (false);
            LineTool.GUI.CompletedPanel.setVisible (true);}
    }
    
    public static void genPingResults () //Generate Ping Results
    {
        pingResults = Tools.pingIP (Tools.determineIP(),30);
        LineTool.GUI.setimagePingingTelkomEquipmentCompleted();
    }
   
   public static boolean totalPacketLoss() //Check for total packet loss
   {
        return testIP.getPacketLoss() == 100;
   }

   public static void genReport () //Generate report files
   {
       
    try {
        //INITIALISE WRITERS
        File tempUnformatted = File.createTempFile("zertoplinetool", ".txt");
        PrintWriter writerUnformatted = new PrintWriter (tempUnformatted);

        File tempFormatted = File.createTempFile("zertoplinetool", ".txt");
        PrintWriter writerFormatted = new PrintWriter (tempFormatted);

        //GENERATE MIN MAX AVE VARIABLES
        testIP = new MinMaxAve (pingResults);

        //GENERATE TEXT FILE HEADERS
        writerUnformatted.println ("Zertop's \"Is it my Line\" Results" + "\nDate/Time: " + new Date());
        writerUnformatted.println ("\nBasic Report:");
        writerUnformatted.println ("");

        writerFormatted.println ("[B]Zertop's \"Is it my Line\" Results" + "\nDate/Time: " + new Date()+"[/B]");
        writerFormatted.println ("[I][B]\nBasic Report:[/B][/I]");
        writerFormatted.println ("");

        //GENERATE INTELLIGENT REPORT HEADERS
        intelReport = intelReport + ("Your packet loss was "+testIP.getPacketLoss()+"%.");
        intelReport = intelReport + "\n" +  ("Your average ping was "+testIP.getAvePing()+"ms.");
        intelReport = intelReport + "\n" +  ("Your maximum ping was "+testIP.getMaxPing()+"ms.");
        intelReport = intelReport + "\n" +  ("");

        //PACKET LOSS REPORT                
        if (testIP.getPacketLoss() > 20)
        {
            intelReport = intelReport + "\n" +  ("You have serious packet loss. Please post these results to the forum for advice.");
        } else if (testIP.getPacketLoss() > 1)
        {
            intelReport = intelReport + "\n" +  ("You seem to have some packet loss. This indicates an issue on the line.");
        }

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

        //ADD INTEL REPORT TO TXT FILE AND SET VARIABLES OF GUI
       writerUnformatted.println (intelReport);
       writerFormatted.println (intelReport);
       LineTool.GUI.setFieldResults(intelReport);

        //ATTACHING DETAILED REPORT
        writerUnformatted.println ("");
        writerUnformatted.println ("Detailed Report:");
        writerUnformatted.println (pingResults);

        writerFormatted.println ("");
        writerFormatted.println ("[B][I]Detailed Report:[/B][/I]");
        writerFormatted.println ("[CODE]");
        writerFormatted.println (pingResults);
        writerFormatted.println ("[/CODE]");

        //SAVE AS TMP AND PARSE TO MAIN THREAD                
        writerUnformatted.close();
        writerFormatted.close();
        LineTool.GUI.setTempFilePathUnformatted (tempUnformatted.getAbsolutePath());
        LineTool.GUI.setTempFilePathFormatted (tempFormatted.getAbsolutePath());

        //SET COMPLETED IMAGE                
        LineTool.GUI.setimageGeneratingReportCompleted ();
    } catch (IOException ex) {}
   }
//GENERATE REPORT
}
