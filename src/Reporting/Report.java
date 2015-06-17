//Zertop™
//www.zertop.com
package Reporting;

import LineTool.GUI;
import LineTool.GUICron;
import java.io.*;
import java.util.Date;
import java.util.regex.*;

public class Report implements Runnable {
//PERM VARIABLES
        static String pingResults;
        static String intelReport = "";
        static int maxPing = 0;
        static int minPing = 0;
        static int avePing = 0;  
        static int packetLoss = 0;
//PERM VARIABLES
        
    public void run ()
    {
        pingGateway();
        GUI.setimagePingingTelkomEquipmentCompleted();
        try {Thread.sleep(1000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        generateReport ();
        GUI.setimageGeneratingReportCompleted ();
        try {Thread.sleep(3000);} catch (InterruptedException ex) {} //Sleep Execution for 1s
        GUI.setimageFinishedCompleted();
        GUICron.setRunning (false);
    }

//PINGS GATEWAY
   public static void pingGateway ()
    {
        pingResults = pingIP ("155.239.255.250");
    }
//PINGS GATEWAY

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
                genMinMaxAve();
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
                intelReport = intelReport + ("Your packet loss was "+packetLoss+"%.");
                intelReport = intelReport + "\n" +  ("Your average ping was "+avePing+"ms.");
                intelReport = intelReport + "\n" +  ("Your maximum ping was "+maxPing+"ms.");
                intelReport = intelReport + "\n" +  ("");
//GENERATE INTELLIGENT REPORT HEADERS
                
//PACKET LOSS REPORT                
                if (packetLoss > 20)
                {
                    intelReport = intelReport + "\n" +  ("You have serious packet loss. Please post these results to the forum for advice.");
                } else if (packetLoss > 1)
                {
                    intelReport = intelReport + "\n" +  ("You seem to have some packet loss. This indicates an issue on the line.");
                }
//PACKET LOSS REPORT
                
//AVERAGE PING REPORT                
                if (packetLoss < 20)
                {
                    if (avePing > 80)
                    {
                        intelReport = intelReport + "\n" +  ("Looking at your average ping, there is definitely something wrong with your line! Please post the results (at the end of the program) into the forum for advice!");
                    } else if (avePing > 30)
                    {
                        intelReport = intelReport + "\n" +  ("Looking at your average ping, your line seems to be a bit dodgy. This may account for any slow speeds you may be experiencing. However, it could just be related to a high-latency home network (eg... Wi-Fi). If you feel the need, please post the results (at the end of the program) into the forum for advice!");
                    } else
                    {
                        intelReport = intelReport + "\n" +  ("Looking at your average ping, your line seems to be running perfectly.");
                    }
                }
//AVERAGE PING REPORT
                
//MAXIMUM PING REPORT
                if (packetLoss < 20)
                {
                    if (avePing < 30)
                    {
                        if (maxPing > 100)
                        {
                            intelReport = intelReport + "\n" +  ("Looking at your maximum ping, however, it seems as though there could be a serious intermittent fault on the line. This could be a cause of an issue. Please post the results (at the end of the program) into the forum for advice.");
                        } else if (maxPing > 30)
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
   
//GENERATE MINMAXAVE
   public static void genMinMaxAve ()
   {
//WINDOWS
       if (OSDetection.isWindows())
       {
        Pattern packetLossPattern = Pattern.compile("Lost.*\\((\\d*)");
        Matcher packetLossMatcher = packetLossPattern.matcher(pingResults);
        if (packetLossMatcher.find())
        {
            packetLoss = Integer.parseInt (packetLossMatcher.group(1));
        }

        Pattern maxPattern = Pattern.compile("Maximum...(\\d*)");
        Matcher maxMatcher = maxPattern.matcher(pingResults);
        if (maxMatcher.find())
        {
            maxPing = Integer.parseInt (maxMatcher.group(1));
        }

        Pattern minPattern = Pattern.compile("Minimum...(\\d*)");
        Matcher minMatcher = minPattern.matcher(pingResults);
        if (minMatcher.find())
        {
            minPing = Integer.parseInt (minMatcher.group(1));
        }

        Pattern avePattern = Pattern.compile("Average...(\\d*)");
        Matcher aveMatcher = avePattern.matcher(pingResults);
        if (aveMatcher.find())
        {
            avePing = Integer.parseInt (aveMatcher.group(1));
        }
       }
//WINDOWS

//LINUX
       if (OSDetection.isUnix())
       {
            Pattern pattern = Pattern.compile("rtt\\ min\\/avg\\/max\\/mdev\\ \\=\\ (\\d*).\\d*\\/(\\d*).\\d*\\/(\\d*).\\d*");
            Matcher Matcher = pattern.matcher(pingResults);
            if (Matcher.find())
            {
                maxPing = Integer.parseInt (Matcher.group(3));
                minPing = Integer.parseInt (Matcher.group(1));
                avePing = Integer.parseInt (Matcher.group(2));
            }
            
            Pattern packetLossPattern = Pattern.compile ("(\\d*)\\%\\ packet\\ loss");
            Matcher packetLossMatcher = packetLossPattern.matcher(pingResults);
            if (packetLossMatcher.find())
            {
            packetLoss = Integer.parseInt (packetLossMatcher.group(1));
            } else { packetLoss = -1; }
       }
//LINUX  
       
//OSX
       if (OSDetection.isMac())
       {
            Pattern pattern = Pattern.compile("round-trip\\ min\\/avg\\/max\\/stddev\\ \\=\\ (\\d*).\\d*\\/(\\d*).\\d*\\/(\\d*).\\d*");
            Matcher Matcher = pattern.matcher(pingResults);
            if (Matcher.find())
            {
                maxPing = Integer.parseInt (Matcher.group(3));
                minPing = Integer.parseInt (Matcher.group(1));
                avePing = Integer.parseInt (Matcher.group(2));
            }
            
            Pattern packetLossPattern = Pattern.compile ("(\\d*)\\%\\ packet\\ loss");
            Matcher packetLossMatcher = packetLossPattern.matcher(pingResults);
            if (packetLossMatcher.find())
            {
            packetLoss = Integer.parseInt (packetLossMatcher.group(1));
            } else { packetLoss = -1; }
       }
//OSX       
   }
//GENERATE MINMAXAVE
   
//CREATE A LOCAL TERMINAL AND PING IP ADDRESS    
    public static String pingIP (String host)
    {
        String output = "";
        try 
            {
                String pingcmd;

                if(System.getProperty("os.name").startsWith("Windows")) 
                {   
                    pingcmd = "ping -n 30 " + host; // For Windows
                }  
                else 
                {
                    pingcmd = "ping -c 30 " + host; // For Linux and OSX
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
