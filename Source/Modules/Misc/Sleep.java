//Zertop�
//www.zertop.com
package Modules.Misc;

public class Sleep {
    public static void Time(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        } //Sleep Execution for 1s
    }
}
