//Zertop�
//www.zertop.com
package Modules.Misc;

public class OSVariables {
    private static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    public static String getLineBreak() {
        return System.getProperty("line.separator");
    }
}
