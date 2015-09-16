//Zertop™
//www.zertop.com
package Modules;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadToNull implements Runnable {
    URL link;

    public DownloadToNull(String url) {
        try {
            link = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            InputStream in = new BufferedInputStream(link.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[10240];
            int n = 0;

            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }

            out.close();
            in.close();

        } catch (Exception e) {
        }
    }
}
