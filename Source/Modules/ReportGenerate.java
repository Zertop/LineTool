//Zertop™
//www.zertop.com
package Modules;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReportGenerate implements Runnable {
    //PERM VARIABLES
    static String pingResults;
    static String determinedIP;
    static String intelReport = "";
    static int localSpeedTest;
    static int intSpeedTest;
    static ReportPingAnalyse testIP;
//PERM VARIABLES

    public void run() {
        //Determine IP to ping
        determinedIP = IPDetermine.run();
        GUI.Interface.setDeterminingIPToPingComplete();

        if (!determinedIP.equals("")) {

            //Do Speed Test
            localSpeedTest = Modules.DownloadSpeed.run(Control.Config.getLocalSpeedTestFile());
            intSpeedTest = Modules.DownloadSpeed.run(Control.Config.getInternationalSpeedTestFile());
            GUI.Interface.setImageTestingDownloadSpeedComplete();

            //Generate ping results
            getPingResults();
            GUI.Interface.setPingingTelkomEquipmentComplete();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            } //Sleep Execution for 1s


            //Generate Report
            genReport();
            GUI.Interface.setGeneratingReportComplete();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            } //Sleep Execution for 1s

            //Finish Up
            GUI.Interface.setFinishedComplete();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            } //Sleep Execution for 1s

            //Report Back to Engine
            Control.Engine.goToResults();
        }
    }

    public static void getPingResults() //Generate Ping Results
    {
        pingResults = IPPing.run(determinedIP, 30);
    }

    public static void genReport() //Generate report files
    {

        try {
            //INITIALISE WRITERS
            File tempPlain = File.createTempFile("zertoplinetool", ".txt");
            PrintWriter writerPlain = new PrintWriter(tempPlain);

            File tempFormatted = File.createTempFile("zertoplinetool", ".txt");
            PrintWriter writerFormatted = new PrintWriter(tempFormatted);

            //GENERATE MIN MAX AVE VARIABLES
            testIP = new ReportPingAnalyse(pingResults);

            //GENERATE TEXT FILE HEADERS
            writerPlain.println("Zertop's \"Is it my Line\" Results" + OSVariables.getLineBreak() + "Date/Time: " + new Date());
            writerPlain.println("" + OSVariables.getLineBreak() + "Basic Report:");
            writerPlain.println("");

            writerFormatted.println("[B]Zertop's \"Is it my Line\" Results" + OSVariables.getLineBreak() + "Date/Time: " + new Date() + "[/B]");
            writerFormatted.println("[I][B]" + OSVariables.getLineBreak() + "Basic Report:[/B][/I]");
            writerFormatted.println("");

            //GENERATE INTELLIGENT REPORT HEADERS
            intelReport = intelReport + ("Your packet loss was " + testIP.getPacketLoss() + "%.");
            intelReport = intelReport + OSVariables.getLineBreak() + ("Your average ping was " + testIP.getAvePing() + "ms.");
            intelReport = intelReport + OSVariables.getLineBreak() + ("Your maximum ping was " + testIP.getMaxPing() + "ms.");
            intelReport = intelReport + OSVariables.getLineBreak() + "Your local download speed was " + localSpeedTest + "Kbps";
            intelReport = intelReport + OSVariables.getLineBreak() + "Your international download speed was " + intSpeedTest + "Kbps";
            intelReport = intelReport + OSVariables.getLineBreak() + ("");

            //PACKET LOSS REPORT
            if (testIP.getPacketLoss() > 20) {
                intelReport = intelReport + OSVariables.getLineBreak() + ("You have serious packet loss. Please post these results to the forum for advice.");
            } else if (testIP.getPacketLoss() > 1) {
                intelReport = intelReport + OSVariables.getLineBreak() + ("You seem to have some packet loss. This indicates an issue on the line.");
            }

            //AVERAGE PING REPORT
            if (testIP.getPacketLoss() < 20) {
                if (testIP.getAvePing() > 80) {
                    intelReport = intelReport + OSVariables.getLineBreak() + ("Looking at your average ping, there is definitely something wrong with your line! Please post the results (at the end of the program) into the forum for advice!");
                } else if (testIP.getAvePing() > 30) {
                    intelReport = intelReport + OSVariables.getLineBreak() + ("Looking at your average ping, your line seems to be a bit dodgy. This may account for any slow speeds you may be experiencing. However, it could just be related to a high-latency home network (eg... Wi-Fi). If you feel the need, please post the results (at the end of the program) into the forum for advice!");
                } else {
                    intelReport = intelReport + OSVariables.getLineBreak() + ("Looking at your average ping, your line seems to be running perfectly.");
                }
            }

            //MAXIMUM PING REPORT
            if (testIP.getPacketLoss() < 20) {
                if (testIP.getAvePing() < 30) {
                    if (testIP.getMaxPing() > 100) {
                        intelReport = intelReport + OSVariables.getLineBreak() + ("Looking at your maximum ping, however, it seems as though there could be a serious intermittent fault on the line. This could be a cause of an issue. Please post the results (at the end of the program) into the forum for advice.");
                    } else if (testIP.getMaxPing() > 30) {
                        intelReport = intelReport + OSVariables.getLineBreak() + ("Looking at your maximum ping, however, it seems as though there could be a slight intermittant issue on the line. If required, please post the results to a forum post.");
                    } else {
                        intelReport = intelReport + OSVariables.getLineBreak() + ("It seems that your maximum ping is also good. If there are any issues, they most probably lie with your ISP");
                    }
                }
            }

            writerPlain.println(intelReport);
            writerFormatted.println(intelReport);

            //ATTACHING DETAILED REPORT
            writerPlain.println("");
            writerPlain.println("Detailed Report:");
            writerPlain.println(pingResults);

            writerFormatted.println("");
            writerFormatted.println("[B][I]Detailed Report:[/B][/I]");
            writerFormatted.println("[CODE]");
            writerFormatted.println(pingResults);
            writerFormatted.println("[/CODE]");

            //SAVE AS TMP AND PARSE TO ENGINE
            writerPlain.close();
            writerFormatted.close();
            Control.Engine.setIntelligentReport(intelReport);
            Control.Engine.setPlainTxtPath(tempPlain.getAbsolutePath());
            Control.Engine.setFormattedTxtPath(tempFormatted.getAbsolutePath());

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
//GENERATE REPORT
}
