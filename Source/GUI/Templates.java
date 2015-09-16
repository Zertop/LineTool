//Zertop™
//www.zertop.com
package GUI;

import javax.swing.*;
import java.awt.*;

public class Templates {

    public static JLayeredPane getPaneTemplate() //Pane Template
    {
        JLayeredPane pane = new JLayeredPane();
        pane.setLayout(null);
        pane.setPreferredSize(new Dimension(650, 450));

        JLabel background = getBackGroundImage();
        JLabel logo = getLogoImage();

        JLabel versionLabel = new JLabel(); //Version Label
        versionLabel.setText("Version: " + Control.Config.getVersion());
        versionLabel.setFont(new Font("Tahoma", 0, 10));
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

    private static JLabel getBackGroundImage() //Background
    {
        JLabel backgroundImage = new JLabel();
        backgroundImage.setIcon(new ImageIcon(Templates.class.getClass().getResource("/GUI/Images/back.jpg")));
        backgroundImage.setBounds(0, 0, 650, 450);
        return backgroundImage;
    }

    private static JLabel getLogoImage() //Logo
    {
        JLabel logoImage = new JLabel();
        logoImage.setIcon(new ImageIcon(Templates.class.getClass().getResource("/GUI/Images/logo.png")));
        logoImage.setBounds(250, 50, 150, 150); //Logo
        return logoImage;
    }
}
