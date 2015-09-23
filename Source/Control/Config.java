//Zertop™
//www.zertop.com
package Control;

public class Config {

    private static final int version = 220;
    private static final String releasesURL = "http://releases.zertop.com/linetool/"; //URL for the latest version of the file
    private static final String localSpeedTestFile = "http://testfiles.zertop.com/01meg.test"; //Test file for the local download test
    private static final String internationalSpeedTestFile = "http://cachefly.cachefly.net/1mb.test"; //Test file for the international download test
    private static final int speedTestFileSizeMB = 1; //Size of test files. The test is run 5 times, therefore the total download will be 5x this value.

    public static int getVersion() {
        return version;
    }

    public static String getReleasesURL() {
        return releasesURL;
    }

    public static String getInternationalSpeedTestFile() {
        return internationalSpeedTestFile;
    }

    public static String getLocalSpeedTestFile() {
        return localSpeedTestFile;
    }

    public static int getSpeedTestFileSizeMB() {
        return speedTestFileSizeMB;
    }
}
