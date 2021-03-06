//Zertop�
//www.zertop.com
package LineTool.GUI;

import LineTool.Control.Vars;

import javax.swing.*;
import java.awt.*;

public class Templates {

    public static JLayeredPane getPaneTemplate() //Pane Template
    {
        JLayeredPane pane = new JLayeredPane();
        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(650, 450));

        JLabel background = getBackgroundImage();
        JLabel logo = getLogoImage();

        JLabel versionLabel = new JLabel(); //Version Label
        versionLabel.setText("Zertop | Version: " + Vars.getVersionString());
        versionLabel.setFont(new Font("Tahoma", 0, 9));
        versionLabel.setForeground(Color.WHITE);
        versionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        versionLabel.setBounds(0, 430, 650, 20);
        pane.add(versionLabel);
        pane.setLayer(versionLabel, -1);

        pane.add(logo);
        pane.setLayer(logo, -1); //Ensures it stays in background

        pane.add(background);
        pane.setLayer(background, -2); //Ensures it stays in background

        pane.setVisible(false);
        return pane;
    }

    private static JLabel getBackgroundImage() //Background
    {
        JLabel backgroundImage = new JLabel();
        backgroundImage.setIcon(new ImageIcon(Templates.class.getClass().getResource("/LineTool/GUI/Images/back.jpg")));
        backgroundImage.setBounds(0, 0, 650, 450);
        return backgroundImage;
    }

    private static JLabel getLogoImage() //Logo
    {
        JLabel logoImage = new JLabel();
        logoImage.setIcon(new ImageIcon(Templates.class.getClass().getResource("/LineTool/GUI/Images/logo.png")));
        logoImage.setBounds(250, 50, 150, 150); //Logo
        return logoImage;
    }
}
