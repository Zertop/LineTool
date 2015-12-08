//Zertop™
//www.zertop.com
package LineTool.Control;

public class Config {
    //Constant Variables
    private static final int version = 224; //Current version
    private static final String releasesURL = "http://releases.zertop.com/linetool/"; //URL for the latest version of the file


    //Get's
    public static int getVersion() {
        return version;
    }

    public static String getReleasesURL() {
        return releasesURL;
    }
}
