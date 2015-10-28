//Zertop™
//www.zertop.com
package Config;

public class Config {
    //Constant Variables
    private static final int version = 221; //Current version
    private static final String releasesURL = "http://releases.zertop.com/linetool/"; //URL for the latest version of the file


    //Report Text
    private static final String appName = "Zertop's LineTool";
    private static final String seriousPacketLoss = "You have serious packet loss. Please post these results to the forum for advice.";
    private static final String somePacketLoss = "You seem to have some packet loss. This indicates an issue on the line.";

    private static final String badAveragePing = "Looking at your average ping, there is definitely something wrong with your line! Please post the results (at the end of the program) into the forum for advice!";
    private static final String medAveragePing = "Looking at your average ping, your line seems to be a bit dodgy. This may account for any slow speeds you may be experiencing. However, it could just be related to a high-latency home network (eg... Wi-Fi). If you feel the need, please post the results (at the end of the program) into the forum for advice!";
    private static final String goodAveragePing = "Looking at your average ping, your line seems to be running perfectly.";

    private static final String badMaximumPing = "Looking at your maximum ping, however, it seems as though there could be a serious intermittent fault on the line. This could be a cause of an issue. Please post the results (at the end of the program) into the forum for advice.";
    private static final String medMaximumPing = "Looking at your maximum ping, however, it seems as though there could be a slight intermittent issue on the line. If required, please post the results to a forum post.";
    private static final String goodMaximumPing = "It seems that your maximum ping is also good. If there are any issues, they most probably lie with your ISP";


    //Get's
    public static int getVersion() {
        return version;
    }
    public static String getReleasesURL() {
        return releasesURL;
    }
    public static String getAppName() {
        return appName;
    }
    public static String getSeriousPacketLoss() {
        return seriousPacketLoss;
    }
    public static String getSomePacketLoss() {
        return somePacketLoss;
    }
    public static String getBadAveragePing() {
        return badAveragePing;
    }
    public static String getMedAveragePing() {
        return medAveragePing;
    }
    public static String getGoodAveragePing() {
        return goodAveragePing;
    }
    public static String getBadMaximumPing() {
        return badMaximumPing;
    }
    public static String getMedMaximumPing() {
        return medMaximumPing;
    }
    public static String getGoodMaximumPing() {
        return goodMaximumPing;
    }
}
