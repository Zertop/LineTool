package LineTool.Control;

public class Vars {
    private static final int[] currentVersion = {3, 0, 0};
    public static LineTool.GUI.Interface GUI;
    public static Modules.Analysis.GenerateReport report;

    public static String getVersionString() {
        return "V" + currentVersion[0] + "." + currentVersion[1] + "." + currentVersion[2];
    }

    public static int[] getCurrentVersion() {
        return currentVersion;
    }
}