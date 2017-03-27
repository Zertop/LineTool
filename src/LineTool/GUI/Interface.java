//Zertop�
//www.zertop.com
package LineTool.GUI;

import LineTool.Control.Engine;
import LineTool.Control.Vars;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Interface extends JFrame {
    public JLayeredPane launcherPane = Templates.getPaneTemplate();
    public JLayeredPane startPane = Templates.getPaneTemplate();
    public JLayeredPane testsPane = Templates.getPaneTemplate();
    public JLayeredPane resultsPane = Templates.getPaneTemplate();
    public JLayeredPane displayPane = Templates.getPaneTemplate();
    JLabel runningTestsLabel = new JLabel();
    JLabel imageDeterminingIPToPingFalse = new JLabel();
    JLabel imageDeterminingIPToPingTrue = new JLabel();
    JLabel imagePingingTelkomEquipmentFalse = new JLabel();
    JLabel imagePingingTelkomEquipmentTrue = new JLabel();
    JLabel imageGeneratingReportFalse = new JLabel();
    JLabel imageGeneratingReportTrue = new JLabel();
    JLabel imageFinishedFalse = new JLabel();
    JLabel imageFinishedTrue = new JLabel();
    private JLabel launchStatusLabel = new JLabel();
    private JLabel displayHeaderLabel = new JLabel();
    private JTextArea displayTextArea = new JTextArea();
    public Interface() {
        initJFrame(); //Init main components

        launcherPane(); //Generate Launcher Pane
        startPane(); //Generate Start Pane
        testsPane(); //Generate Tests Pane
        resultsPane(); //Generate Results Pane
        displayPane(); //Generate Display Pane
    }

    private void initJFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public void switchToPane(JLayeredPane panel) {
        this.getContentPane().removeAll(); //Removes all JPanels currently open
        this.getContentPane().add(panel); //Adds the required JPanel
        panel.setVisible(true); //Sets the panel Visible
        pack(); //Pack to make it nice and neat
        this.setLocationRelativeTo(null); //Generate Centre
        this.repaint(); //Repaint to ensure it shows up correctly
    }

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

    private void startPane() {
        JLabel startButton = new JLabel(); //Start Button
        startButton.setIcon(new ImageIcon(getClass().getResource("/LineTool/GUI/Images/start.png")));
        startButton.setHorizontalAlignment(SwingConstants.CENTER);
        startButton.setBounds(0, 300, 650, 48);
        startPane.add(startButton);

        startButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                LineTool.Control.Engine.doTests();
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

    private void testsPane() {

        runningTestsLabel.setText("Running Tests");
        runningTestsLabel.setFont(new Font("Calibri", 0, 20));
        runningTestsLabel.setForeground(Color.WHITE);
        runningTestsLabel.setHorizontalAlignment(SwingConstants.LEADING);
        runningTestsLabel.setBounds(260, 240, 150, 20);
        testsPane.add(runningTestsLabel);

        //Step 1: Determining IP
        JLabel labelDeterminingIPToPing = new JLabel();
        labelDeterminingIPToPing.setFont(new java.awt.Font("Calibri", 0, 14));
        labelDeterminingIPToPing.setForeground(Color.WHITE);
        labelDeterminingIPToPing.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelDeterminingIPToPing.setText("Determining IP Address to Ping:");
        labelDeterminingIPToPing.setBounds(130, 290, 230, 20);
        testsPane.add(labelDeterminingIPToPing);

        imageDeterminingIPToPingFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/cross.png")));
        imageDeterminingIPToPingFalse.setBounds(380, 290, 20, 20);
        testsPane.add(imageDeterminingIPToPingFalse);
        imageDeterminingIPToPingFalse.setVisible(true);

        imageDeterminingIPToPingTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/tick.png")));
        imageDeterminingIPToPingTrue.setBounds(380, 290, 20, 20);
        testsPane.add(imageDeterminingIPToPingTrue);
        imageDeterminingIPToPingTrue.setVisible(false);

        //Step 2: Pinging Telkom Equipment
        JLabel labelPingingTelkomEquipment = new JLabel();
        labelPingingTelkomEquipment.setFont(new java.awt.Font("Calibri", 0, 14));
        labelPingingTelkomEquipment.setForeground(Color.WHITE);
        labelPingingTelkomEquipment.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelPingingTelkomEquipment.setText("Pinging Telkom Equipment:");
        labelPingingTelkomEquipment.setBounds(150, 320, 210, 20);
        testsPane.add(labelPingingTelkomEquipment);

        imagePingingTelkomEquipmentFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/cross.png")));
        imagePingingTelkomEquipmentFalse.setBounds(380, 320, 20, 20);
        testsPane.add(imagePingingTelkomEquipmentFalse);
        imagePingingTelkomEquipmentFalse.setVisible(true);

        imagePingingTelkomEquipmentTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/tick.png")));
        imagePingingTelkomEquipmentTrue.setBounds(380, 320, 20, 20);
        testsPane.add(imagePingingTelkomEquipmentTrue);
        imagePingingTelkomEquipmentTrue.setVisible(false);

        //Step 3: Generating Report
        JLabel labelGeneratingReport = new JLabel();
        labelGeneratingReport.setFont(new java.awt.Font("Calibri", 0, 14));
        labelGeneratingReport.setForeground(Color.WHITE);
        labelGeneratingReport.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelGeneratingReport.setText("Generating Report:");
        labelGeneratingReport.setBounds(150, 350, 210, 20);
        testsPane.add(labelGeneratingReport);

        imageGeneratingReportFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/cross.png")));
        imageGeneratingReportFalse.setBounds(380, 350, 20, 20);
        testsPane.add(imageGeneratingReportFalse);
        imageGeneratingReportFalse.setVisible(true);

        imageGeneratingReportTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/tick.png")));
        imageGeneratingReportTrue.setBounds(380, 350, 20, 20);
        testsPane.add(imageGeneratingReportTrue);
        imageGeneratingReportTrue.setVisible(false);

        //Step 4: Finished
        JLabel labelFinished = new JLabel();
        labelFinished.setFont(new java.awt.Font("Calibri", 0, 14));
        labelFinished.setForeground(Color.WHITE);
        labelFinished.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelFinished.setText("Finished:");
        labelFinished.setBounds(150, 380, 210, 20);
        testsPane.add(labelFinished);

        imageFinishedFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/cross.png")));
        imageFinishedFalse.setBounds(380, 380, 20, 20);
        testsPane.add(imageFinishedFalse);
        imageFinishedFalse.setVisible(true);

        imageFinishedTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/tick.png")));
        imageFinishedTrue.setBounds(380, 380, 20, 20);
        testsPane.add(imageFinishedTrue);
        imageFinishedTrue.setVisible(false);
    }

    public void setRunningTestsLabel(String text) {
        runningTestsLabel.setText(text);
    }

    public void setDeterminingIPToPingComplete() {
        imageDeterminingIPToPingFalse.setVisible(false);
        imageDeterminingIPToPingTrue.setVisible(true);
    }

    public void setPingingTelkomEquipmentComplete() {
        imagePingingTelkomEquipmentFalse.setVisible(false);
        imagePingingTelkomEquipmentTrue.setVisible(true);
    }

    public void setGeneratingReportComplete() {
        imageGeneratingReportFalse.setVisible(false);
        imageGeneratingReportTrue.setVisible(true);
    }

    public void setFinishedComplete() {
        imageFinishedFalse.setVisible(false);
        imageFinishedTrue.setVisible(true);
    }

    private void resultsPane() {
        JLabel resultsHeaderLabel = new JLabel();
        resultsHeaderLabel.setText("Results");
        resultsHeaderLabel.setFont(new Font("Calibri", 0, 20));
        resultsHeaderLabel.setForeground(Color.WHITE);
        resultsHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultsHeaderLabel.setBounds(0, 210, 650, 20);
        resultsPane.add(resultsHeaderLabel);

        JLabel imageDisplayResultsOnScreen = new JLabel();
        imageDisplayResultsOnScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/monitor.png")));
        imageDisplayResultsOnScreen.setBounds(180, 240, 48, 48);
        resultsPane.add(imageDisplayResultsOnScreen);
        imageDisplayResultsOnScreen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Engine.displayMessage("Results", Vars.report.getIntelReport());
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
        imageOpenResultsInTextFilePlain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/clipextra.png")));
        imageOpenResultsInTextFilePlain.setBounds(180, 300, 48, 48);
        resultsPane.add(imageOpenResultsInTextFilePlain);
        imageOpenResultsInTextFilePlain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().open(new File(Vars.report.getPlainTxtPath()));
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
        imageOpenResultsInTextFileFormatted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/clip.png")));
        imageOpenResultsInTextFileFormatted.setBounds(180, 360, 48, 48);
        resultsPane.add(imageOpenResultsInTextFileFormatted);
        imageOpenResultsInTextFileFormatted.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().open(new File(Vars.report.getFormattedTxtPath()));
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

    private void displayPane() {
        displayHeaderLabel.setText("Display");
        displayHeaderLabel.setFont(new Font("Calibri", 0, 20));
        displayHeaderLabel.setForeground(Color.WHITE);
        displayHeaderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        displayHeaderLabel.setBounds(0, 210, 650, 20);
        displayPane.add(displayHeaderLabel);

        JLabel imageGoBack = new JLabel();
        imageGoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/GUI/Images/return.png")));
        imageGoBack.setText("Go Back");
        imageGoBack.setForeground(Color.WHITE);
        imageGoBack.setBounds(10, 10, 100, 32);
        displayPane.add(imageGoBack);
        imageGoBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Vars.GUI.switchToPane(Vars.GUI.resultsPane);
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
        displayTextArea.addMouseListener(new MouseAdapter() { //Ensures transparency is correctly painted
            @Override
            public void mouseReleased(MouseEvent e) {
                displayPane.repaint();
                displayTextArea.repaint();
            }
        });

        JScrollPane displayTextScroll = new JScrollPane(displayTextArea);
        displayTextScroll.setBounds(110, 240, 450, 180);
        displayTextScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        displayTextScroll.setOpaque(false);
        displayTextScroll.setBorder(null);
        displayPane.add(displayTextScroll);

    }

    public void setDisplayHeaderLabel(String labelText) {
        displayHeaderLabel.setText(labelText);
    }

    public void setDisplayTextArea(String areaText) {
        displayTextArea.setText(areaText);
    }
}
