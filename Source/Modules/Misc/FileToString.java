//Zertop�
//www.zertop.com
package Modules.Misc;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileToString {
    public static String FileToString(java.io.File file) {
        String out = "";
        try {
            Scanner fileScan = new Scanner(file);

            while (fileScan.hasNextLine()) {
                out += "\n" + fileScan.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return out;
    }
}
