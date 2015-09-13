//Zertop™
//www.zertop.com
package GUI;

import Control.Engine;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Interface extends JFrame {
    public static JLayeredPane launcherPane = Templates.getPaneTemplate();
    public static JLayeredPane startPane = Templates.getPaneTemplate();
    public static JLayeredPane testsPane = Templates.getPaneTemplate();
    public static JLayeredPane resultsPane = Templates.getPaneTemplate();
    public static JLayeredPane displayPane = Templates.getPaneTemplate();

    private static JLabel launchStatusLabel = new JLabel();

    public Interface() {
        initJFrame(); //Init main components

        launcherPane(); //Generate Engine Pane
        startPane(); //Generate Start Pane
        testsPane(); //Generate Tests Pane
        resultsPane(); //Generate Results Pane
        displayPane(); //Generate Display Pane
    }

    public void switchToPane(JLayeredPane panel) {
        this.getContentPane().removeAll(); //Removes all JPanels currently open
        this.add(panel); //Adds the required JPanel
        panel.setVisible(true); //Sets the panel Visible
        pack(); //Pack to make it nice and neat
        this.setLocationRelativeTo(null); //Generate Centre
    }

    private void initJFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    //<editor-fold desc="Launcher Pane">
    private void launcherPane() {
        launchStatusLabel.setBounds(0, 300, 650, 30);
        launchStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        launchStatusLabel.setFont(new Font("Calibri", 0, 14));
        launchStatusLabel.setForeground(Color.WHITE);
        launcherPane.add(launchStatusLabel);
    }

    public void setLaunchStatus(String status) {
        launchStatusLabel.setText(status);
    }
    //</editor-fold>

    //<editor-fold desc="Start Pane">
    private void startPane() {
        JLabel startButton = new JLabel(); //Start Button
        startButton.setIcon(new ImageIcon(getClass().getResource("/GUI/Images/start.png")));
        startButton.setHorizontalAlignment(SwingConstants.CENTER);
        startButton.setBounds(0, 300, 650, 48);
        startPane.add(startButton);

        startButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Control.Engine.beginTests();
            }
        });

        JLabel startLabel = new JLabel(); //Start Label
        startLabel.setText("Begin Tests");
        startLabel.setFont(new Font("Calibri", 0, 14));
        startLabel.setForeground(Color.WHITE);
        startLabel.setHorizontalAlignment(SwingConstants.CENTER);
        startLabel.setBounds(0, 355, 650, 20);
        startPane.add(startLabel);

    }
    //</editor-fold>

    //<editor-fold desc="Tests Pane">
    static JLabel runningTestsLabel = new JLabel();
    static JLabel imageDeterminingIPToPingFalse = new JLabel();
    static JLabel imageDeterminingIPToPingTrue = new JLabel();
    static JLabel imagePingingTelkomEquipmentFalse = new JLabel();
    static JLabel imagePingingTelkomEquipmentTrue = new JLabel();
    static JLabel imageGeneratingReportFalse = new JLabel();
    static JLabel imageGeneratingReportTrue = new JLabel();
    static JLabel imageFinishedFalse = new JLabel();
    static JLabel imageFinishedTrue = new JLabel();

    private void testsPane() {

        runningTestsLabel.setText("Running Tests");
        runningTestsLabel.setFont(new Font("Calibri", 0, 20));
        runningTestsLabel.setForeground(Color.WHITE);
        runningTestsLabel.setHorizontalAlignment(SwingConstants.LEADING);
        runningTestsLabel.setBounds(260, 230, 150, 20);
        testsPane.add(runningTestsLabel);

        JLabel labelDeterminingIPToPing = new JLabel(); //Step 1: Determining IP
        labelDeterminingIPToPing.setFont(new java.awt.Font("Calibri", 0, 14));
        labelDeterminingIPToPing.setForeground(Color.WHITE);
        labelDeterminingIPToPing.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelDeterminingIPToPing.setText("Determining IP Address to Ping:");
        labelDeterminingIPToPing.setBounds(150, 290, 210, 20);
        testsPane.add(labelDeterminingIPToPing);

        imageDeterminingIPToPingFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/cross.png")));
        imageDeterminingIPToPingFalse.setBounds(380, 290, 20, 20);
        testsPane.add(imageDeterminingIPToPingFalse);
        imageDeterminingIPToPingFalse.setVisible(true);

        imageDeterminingIPToPingTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tick.png")));
        imageDeterminingIPToPingTrue.setBounds(380, 290, 20, 20);
        testsPane.add(imageDeterminingIPToPingTrue);
        imageDeterminingIPToPingTrue.setVisible(false);

        JLabel labelPingingTelkomEquipment = new JLabel(); //Step 2: Pinging Telkom Equipment
        labelPingingTelkomEquipment.setFont(new java.awt.Font("Calibri", 0, 14));
        labelPingingTelkomEquipment.setForeground(Color.WHITE);
        labelPingingTelkomEquipment.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelPingingTelkomEquipment.setText("Pinging Telkom Equipment:");
        labelPingingTelkomEquipment.setBounds(150, 320, 210, 20);
        testsPane.add(labelPingingTelkomEquipment);

        imagePingingTelkomEquipmentFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/cross.png")));
        imagePingingTelkomEquipmentFalse.setBounds(380, 320, 20, 20);
        testsPane.add(imagePingingTelkomEquipmentFalse);
        imagePingingTelkomEquipmentFalse.setVisible(true);

        imagePingingTelkomEquipmentTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tick.png")));
        imagePingingTelkomEquipmentTrue.setBounds(380, 320, 20, 20);
        testsPane.add(imagePingingTelkomEquipmentTrue);
        imagePingingTelkomEquipmentTrue.setVisible(false);

        JLabel labelGeneratingReport = new JLabel(); //Step 3: Generating Report
        labelGeneratingReport.setFont(new java.awt.Font("Calibri", 0, 14));
        labelGeneratingReport.setForeground(Color.WHITE);
        labelGeneratingReport.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelGeneratingReport.setText("Generating Report:");
        labelGeneratingReport.setBounds(150, 350, 210, 20);
        testsPane.add(labelGeneratingReport);

        imageGeneratingReportFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/cross.png")));
        imageGeneratingReportFalse.setBounds(380, 350, 20, 20);
        testsPane.add(imageGeneratingReportFalse);
        imageGeneratingReportFalse.setVisible(true);

        imageGeneratingReportTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tick.png")));
        imageGeneratingReportTrue.setBounds(380, 350, 20, 20);
        testsPane.add(imageGeneratingReportTrue);
        imageGeneratingReportTrue.setVisible(false);

        JLabel labelFinished = new JLabel(); //Step 4: Finished
        labelFinished.setFont(new java.awt.Font("Calibri", 0, 14));
        labelFinished.setForeground(Color.WHITE);
        labelFinished.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelFinished.setText("Finished:");
        labelFinished.setBounds(150, 380, 210, 20);
        testsPane.add(labelFinished);

        imageFinishedFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/cross.png")));
        imageFinishedFalse.setBounds(380, 380, 20, 20);
        testsPane.add(imageFinishedFalse);
        imageFinishedFalse.setVisible(true);

        imageFinishedTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/tick.png")));
        imageFinishedTrue.setBounds(380, 380, 20, 20);
        testsPane.add(imageFinishedTrue);
        imageFinishedTrue.setVisible(false);
    }

    public static void setRunningTestsLabel(String text) {
        runningTestsLabel.setText(text);
    }

    public static void setDeterminingIPToPingComplete() {
        imageDeterminingIPToPingFalse.setVisible(false);
        imageDeterminingIPToPingTrue.setVisible(true);
    }

    public static void setPingingTelkomEquipmentComplete() {
        imagePingingTelkomEquipmentFalse.setVisible(false);
        imagePingingTelkomEquipmentTrue.setVisible(true);
    }

    public static void setGeneratingReportComplete() {
        imageGeneratingReportFalse.setVisible(false);
        imageGeneratingReportTrue.setVisible(true);
    }

    public static void setFinishedComplete() {
        imageFinishedFalse.setVisible(false);
        imageFinishedTrue.setVisible(true);
    }
    //</editor-fold>

    //<editor-fold desc="Results Pane">
    private void resultsPane() {
        JLabel resultsHeaderLabel = new JLabel();
        resultsHeaderLabel.setText("Results");
        resultsHeaderLabel.setFont(new Font("Calibri", 0, 20));
        resultsHeaderLabel.setForeground(Color.WHITE);
        resultsHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsHeaderLabel.setBounds(0, 210, 650, 20);
        resultsPane.add(resultsHeaderLabel);

        JLabel imageDisplayResultsOnScreen = new JLabel();
        imageDisplayResultsOnScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/monitor.png")));
        imageDisplayResultsOnScreen.setBounds(180, 240, 48, 48);
        resultsPane.add(imageDisplayResultsOnScreen);
        imageDisplayResultsOnScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Engine.displayMessage("Results", Engine.getIntelligentReport());
            }
        });

        JLabel labelDisplayResultsOnScreen = new JLabel(); //Display Results on Screen
        labelDisplayResultsOnScreen.setFont(new java.awt.Font("Calibri", 0, 14));
        labelDisplayResultsOnScreen.setForeground(Color.WHITE);
        labelDisplayResultsOnScreen.setHorizontalAlignment(SwingConstants.LEADING);
        labelDisplayResultsOnScreen.setText("Display Results on Screen");
        labelDisplayResultsOnScreen.setBounds(260, 254, 340, 20);
        resultsPane.add(labelDisplayResultsOnScreen);

        JLabel imageOpenResultsInTextFilePlain = new JLabel();
        imageOpenResultsInTextFilePlain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/clipextra.png")));
        imageOpenResultsInTextFilePlain.setBounds(180, 300, 48, 48);
        resultsPane.add(imageOpenResultsInTextFilePlain);
        imageOpenResultsInTextFilePlain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().open(new File(Engine.getPlainTxtPath()));
                } catch (Exception ex) {
                }
            }
        });

        JLabel labelOpenResultsInTextFilePlain = new JLabel(); //Open Results in Plain Text File
        labelOpenResultsInTextFilePlain.setFont(new java.awt.Font("Calibri", 0, 14));
        labelOpenResultsInTextFilePlain.setForeground(Color.WHITE);
        labelOpenResultsInTextFilePlain.setHorizontalAlignment(SwingConstants.LEADING);
        labelOpenResultsInTextFilePlain.setText("Open Results in Text File (Plain)");
        labelOpenResultsInTextFilePlain.setBounds(260, 314, 340, 20);
        resultsPane.add(labelOpenResultsInTextFilePlain);

        JLabel imageOpenResultsInTextFileFormatted = new JLabel();
        imageOpenResultsInTextFileFormatted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/clip.png")));
        imageOpenResultsInTextFileFormatted.setBounds(180, 360, 48, 48);
        resultsPane.add(imageOpenResultsInTextFileFormatted);
        imageOpenResultsInTextFileFormatted.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().open(new File(Engine.getFormattedTxtPath()));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        JLabel labelOpenResultsInTextFileFormatted = new JLabel(); //Open Results in Formatted Text File
        labelOpenResultsInTextFileFormatted.setFont(new java.awt.Font("Calibri", 0, 14));
        labelOpenResultsInTextFileFormatted.setForeground(Color.WHITE);
        labelOpenResultsInTextFileFormatted.setHorizontalAlignment(SwingConstants.LEADING);
        labelOpenResultsInTextFileFormatted.setText("Open Results in Text File (Formatted for Forum)");
        labelOpenResultsInTextFileFormatted.setBounds(260, 374, 340, 20);
        resultsPane.add(labelOpenResultsInTextFileFormatted);
    }
    //</editor-fold>

    //<editor-fold desc="Display Pane">
    private static JLabel displayHeaderLabel = new JLabel();
    private static JTextArea displayTextArea = new JTextArea();

    private void displayPane() {
        displayHeaderLabel.setText("Display");
        displayHeaderLabel.setFont(new Font("Calibri", 0, 20));
        displayHeaderLabel.setForeground(Color.WHITE);
        displayHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayHeaderLabel.setBounds(0, 210, 650, 20);
        displayPane.add(displayHeaderLabel);

        JLabel imageGoBack = new JLabel();
        imageGoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Images/return.png")));
        imageGoBack.setText("Go Back");
        imageGoBack.setForeground(Color.WHITE);
        imageGoBack.setBounds(10, 10, 100, 32);
        displayPane.add(imageGoBack);
        imageGoBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Engine.goToResults();
                } catch (Exception ex) {
                }
            }
        });

        displayTextArea.setEditable(false);
        displayTextArea.setBackground(new java.awt.Color(255, 255, 255, 25));
        displayTextArea.setForeground(new java.awt.Color(255, 255, 255));
        displayTextArea.setFont(new java.awt.Font("Calibri", 0, 14));
        displayTextArea.setLineWrap(true);
        displayTextArea.setWrapStyleWord(true);
        displayTextArea.setBounds(110, 240, 450, 180);
        displayTextArea.setBorder(new LineBorder(new Color(255, 255, 255, 50), 1, true));
        displayPane.add(displayTextArea);
        displayTextArea.addMouseListener(new MouseAdapter() { //Ensures transparency is correctly painted
            @Override
            public void mouseReleased(MouseEvent e) {
                displayPane.repaint();
                displayTextArea.repaint();
            }
        });

    }

    public static void setDisplayHeaderLabel(String labelText) {
        displayHeaderLabel.setText(labelText);
    }

    public static void setDisplayTextArea(String areaText) {
        displayTextArea.setText(areaText);
    }

    //</editor-fold>
}
