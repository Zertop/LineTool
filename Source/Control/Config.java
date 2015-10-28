//Zertop™
//www.zertop.com
package Control;

public class Config {

    private static final int version = 221;
    private static final String releasesURL = "http://releases.zertop.com/linetool/"; //URL for the latest version of the file

    public static int getVersion() {
        return version;
    }

    public static String getReleasesURL() {
        return releasesURL;
    }
}
