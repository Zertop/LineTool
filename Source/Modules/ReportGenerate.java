//Zertop™
//www.zertop.com
package Modules;

import Config.Config;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class ReportGenerate implements Runnable {
    //PERM VARIABLES
    static String pingResults;
    static String determinedIP;
    static String intelReport = "";
    static ReportPingAnalyse testIP;
//PERM VARIABLES

    public void run() {
        //Determine IP to ping
        determinedIP = IPDetermine.run();
        Control.Engine.setDeterminingIPToPingComplete();

        if (!determinedIP.equals("")) {
            getPingResults(); //Generate ping results
            Control.Engine.setPingingTelkomEquipmentComplete();
            Modules.Sleep.Time(1);

            genReport();//Generate Report
            Control.Engine.setGeneratingReportComplete();

            //Finish Up
            Control.Engine.setFinishedComplete();
            Modules.Sleep.Time(1);

            //Report Back to Engine
            Control.Engine.goToResults();
        }
    }

    public void getPingResults() //Generate Ping Results
    {
        pingResults = IPPing.run(determinedIP, 30);
    }

    public void genReport() //Generate report files
    {

        try {
            //INITIALISE WRITERS
            File tempPlain = File.createTempFile(Config.getAppName(), ".txt");
            PrintWriter writerPlain = new PrintWriter(tempPlain);

            File tempFormatted = File.createTempFile(Config.getAppName(), ".txt");
            PrintWriter writerFormatted = new PrintWriter(tempFormatted);

            //GENERATE MIN MAX AVE VARIABLES
            testIP = new ReportPingAnalyse(pingResults);

            //GENERATE TEXT FILE HEADERS
            writerPlain.println(Config.getAppName() + " Results" + OSVariables.getLineBreak() + "Date/Time: " + new Date());
            writerPlain.println("" + OSVariables.getLineBreak() + "Basic Report:");
            writerPlain.println("");

            writerFormatted.println("[B]" + Config.getAppName() + " Results" + OSVariables.getLineBreak() + "Date/Time: " + new Date() + "[/B]");
            writerFormatted.println("[I][B]" + OSVariables.getLineBreak() + "Basic Report:[/B][/I]");
            writerFormatted.println("");

            //GENERATE INTELLIGENT REPORT HEADERS
            intelReport = intelReport + ("Your packet loss was " + testIP.getPacketLoss() + "%.");
            intelReport = intelReport + OSVariables.getLineBreak() + ("Your average ping was " + testIP.getAvePing() + "ms.");
            intelReport = intelReport + OSVariables.getLineBreak() + ("Your maximum ping was " + testIP.getMaxPing() + "ms.");
            intelReport = intelReport + OSVariables.getLineBreak() + ("");

            //PACKET LOSS REPORT
            if (testIP.getPacketLoss() > 20) {
                intelReport = intelReport + OSVariables.getLineBreak() + (Config.getSeriousPacketLoss());
            } else if (testIP.getPacketLoss() > 1) {
                intelReport = intelReport + OSVariables.getLineBreak() + (Config.getSomePacketLoss());
            }

            //AVERAGE PING REPORT
            if (testIP.getPacketLoss() < 20) {
                if (testIP.getAvePing() > 80) {
                    intelReport = intelReport + OSVariables.getLineBreak() + (Config.getBadAveragePing());
                } else if (testIP.getAvePing() > 30) {
                    intelReport = intelReport + OSVariables.getLineBreak() + (Config.getMedAveragePing());
                } else {
                    intelReport = intelReport + OSVariables.getLineBreak() + (Config.getGoodAveragePing());
                }
            }

            //MAXIMUM PING REPORT
            if (testIP.getPacketLoss() < 20) {
                if (testIP.getAvePing() < 30) {
                    if (testIP.getMaxPing() > 100) {
                        intelReport = intelReport + OSVariables.getLineBreak() + (Config.getBadMaximumPing());
                    } else if (testIP.getMaxPing() > 30) {
                        intelReport = intelReport + OSVariables.getLineBreak() + (Config.getMedMaximumPing());
                    } else {
                        intelReport = intelReport + OSVariables.getLineBreak() + (Config.getGoodMaximumPing());
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
