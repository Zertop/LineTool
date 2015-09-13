//Zertop™
//www.zertop.com
package Control;
public class Config {
    
    private static final int version = 219;
    private static final String releasesURL = "http://releases.zertop.com/linetool/";
    
    public static int getVersion ()
    {
        return version;
    }
    
    public static String getReleasesURL ()
    {
        return releasesURL;
    }
}
