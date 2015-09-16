//Zertop™
//www.zertop.com
package Modules;

public class DownloadSpeed {
    public static int run(String downloadLink) {
        try {
            DownloadToNull downloader = new DownloadToNull(downloadLink);

            long start;
            long end;
            start = System.nanoTime(); //Start timer
            Thread[] threads = new Thread[10];

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(downloader);
                threads[i].start();
            }

            for (int i = 0; i < threads.length; i++) {
                while (threads[i].isAlive()) {

                }
            }

            end = System.nanoTime(); //End Timer

            double fileSizeKb = Control.Config.getSpeedTestFileSizeMB() * 1000 * 5;
            double downloadTime = ((end - start) / 1000000000);

            return (int) Math.round(fileSizeKb / downloadTime);
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }
}
