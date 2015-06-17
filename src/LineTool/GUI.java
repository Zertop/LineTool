//Zertop™
//www.zertop.com
package LineTool;

import Reporting.Report;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class GUI extends javax.swing.JFrame {
//VARIABLES
        Report reportInstance = new Report ();
        Thread reportThread = new Thread (reportInstance);
        
        GUICron GUICronInstance = new GUICron ();
        Thread GUICronThread = new Thread (GUICronInstance);
        
        static String tempFilePathUnformatted;
        static String tempFilePathFormatted;
//VARIABLES        
    public GUI() {
        initComponents();
        MainPanel.setVisible (true);
        TestPanel.setVisible(false);
        CompletedPanel.setVisible(false);
        ResultsPanel.setVisible (false);
        Updater.check();
    }
//VARIABLES
    
//GETS AND SETS    
    public static void setimagePingingTelkomEquipmentCompleted ()
    {
        imagePingingTelkomEquipmentFalse.setVisible (false);
    }
    
    public static void setimageGeneratingReportCompleted ()
    {
        imageGeneratingReportFalse.setVisible (false);
    }
    
    public static void setimageFinishedCompleted ()
    {
        imageFinishedFalse.setVisible (false);
    }
    
    public static void setFieldResults (String fR)
    {
        fieldResults.setText(fR);
    }
    
    public static void setTempFilePathUnformatted (String fP)
    {
        tempFilePathUnformatted = fP;
    }
    
    public static void setTempFilePathFormatted (String fP)
    {
        tempFilePathFormatted = fP;
    }
//GETS AND SETS   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        ImageLogo = new javax.swing.JLabel();
        LabelBeginTests = new javax.swing.JLabel();
        ButtonPower = new javax.swing.JLabel();
        ImageBack = new javax.swing.JLabel();
        TestPanel = new javax.swing.JPanel();
        labelRunningTests = new javax.swing.JLabel();
        labelPingingTelkomEquipment = new javax.swing.JLabel();
        imagePingingTelkomEquipmentFalse = new javax.swing.JLabel();
        imagePingingTelkomEquipmentTrue = new javax.swing.JLabel();
        labelGeneratingReport = new javax.swing.JLabel();
        imageGeneratingReportFalse = new javax.swing.JLabel();
        imageGeneratingReportTrue = new javax.swing.JLabel();
        lableFinished = new javax.swing.JLabel();
        imageFinishedFalse = new javax.swing.JLabel();
        imageFinishedTrue = new javax.swing.JLabel();
        ImageLogo1 = new javax.swing.JLabel();
        ImageBack1 = new javax.swing.JLabel();
        CompletedPanel = new javax.swing.JPanel();
        imageOpenResultsFormatted = new javax.swing.JLabel();
        LabelOpenResultsFormatted = new javax.swing.JLabel();
        imageDisplayResults = new javax.swing.JLabel();
        LabelDisplayResults = new javax.swing.JLabel();
        labelRunningTests1 = new javax.swing.JLabel();
        LabelOpenResultsUnformatted = new javax.swing.JLabel();
        imageOpenResultsUnformatted = new javax.swing.JLabel();
        ImageLogo2 = new javax.swing.JLabel();
        ImageBack2 = new javax.swing.JLabel();
        ResultsPanel = new javax.swing.JPanel();
        ImageReturn = new javax.swing.JLabel();
        fieldResultsScroll = new javax.swing.JScrollPane();
        fieldResults = new javax.swing.JTextArea();
        labelResults = new javax.swing.JLabel();
        ImageLogo3 = new javax.swing.JLabel();
        ImageBack3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        MainPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        MainPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/logo.png"))); // NOI18N
        MainPanel.add(ImageLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        LabelBeginTests.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LabelBeginTests.setForeground(new java.awt.Color(255, 255, 255));
        LabelBeginTests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelBeginTests.setText("Begin Ping Tests");
        MainPanel.add(LabelBeginTests, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 110, 20));

        ButtonPower.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/power.png"))); // NOI18N
        ButtonPower.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonPowerMouseClicked(evt);
            }
        });
        MainPanel.add(ButtonPower, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, -1, -1));

        ImageBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/back.jpg"))); // NOI18N
        MainPanel.add(ImageBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, -50, -1, -1));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));

        TestPanel.setBackground(new java.awt.Color(255, 255, 255));
        TestPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        TestPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        TestPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        TestPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelRunningTests.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        labelRunningTests.setForeground(new java.awt.Color(255, 255, 255));
        labelRunningTests.setText("Running Tests");
        TestPanel.add(labelRunningTests, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        labelPingingTelkomEquipment.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelPingingTelkomEquipment.setForeground(new java.awt.Color(255, 255, 255));
        labelPingingTelkomEquipment.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelPingingTelkomEquipment.setText("Pinging Telkom Equipment: ");
        TestPanel.add(labelPingingTelkomEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 210, -1));

        imagePingingTelkomEquipmentFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/cross.png"))); // NOI18N
        TestPanel.add(imagePingingTelkomEquipmentFalse, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        imagePingingTelkomEquipmentTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/tick.png"))); // NOI18N
        TestPanel.add(imagePingingTelkomEquipmentTrue, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, -1, -1));

        labelGeneratingReport.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        labelGeneratingReport.setForeground(new java.awt.Color(255, 255, 255));
        labelGeneratingReport.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        labelGeneratingReport.setText("Generating Report:");
        TestPanel.add(labelGeneratingReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 210, -1));

        imageGeneratingReportFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/cross.png"))); // NOI18N
        TestPanel.add(imageGeneratingReportFalse, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        imageGeneratingReportTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/tick.png"))); // NOI18N
        TestPanel.add(imageGeneratingReportTrue, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, -1));

        lableFinished.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        lableFinished.setForeground(new java.awt.Color(255, 255, 255));
        lableFinished.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lableFinished.setText("Finished:");
        TestPanel.add(lableFinished, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 210, -1));

        imageFinishedFalse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/cross.png"))); // NOI18N
        TestPanel.add(imageFinishedFalse, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        imageFinishedTrue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/tick.png"))); // NOI18N
        TestPanel.add(imageFinishedTrue, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        ImageLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/logo.png"))); // NOI18N
        TestPanel.add(ImageLogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        ImageBack1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/back.jpg"))); // NOI18N
        TestPanel.add(ImageBack1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, -50, -1, -1));

        getContentPane().add(TestPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 410));

        CompletedPanel.setBackground(new java.awt.Color(255, 255, 255));
        CompletedPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        CompletedPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        CompletedPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        CompletedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageOpenResultsFormatted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/clip.png"))); // NOI18N
        imageOpenResultsFormatted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageOpenResultsFormattedMouseClicked(evt);
            }
        });
        CompletedPanel.add(imageOpenResultsFormatted, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, 50));

        LabelOpenResultsFormatted.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LabelOpenResultsFormatted.setForeground(new java.awt.Color(255, 255, 255));
        LabelOpenResultsFormatted.setText("Open Results in Text File (Formatted for Forum)");
        CompletedPanel.add(LabelOpenResultsFormatted, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 340, 20));

        imageDisplayResults.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/monitor.png"))); // NOI18N
        imageDisplayResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageDisplayResultsMouseClicked(evt);
            }
        });
        CompletedPanel.add(imageDisplayResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, -1, 50));

        LabelDisplayResults.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LabelDisplayResults.setForeground(new java.awt.Color(255, 255, 255));
        LabelDisplayResults.setText("Display Results on Screen");
        CompletedPanel.add(LabelDisplayResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 190, 20));

        labelRunningTests1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        labelRunningTests1.setText("Tests Completed");
        CompletedPanel.add(labelRunningTests1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        LabelOpenResultsUnformatted.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        LabelOpenResultsUnformatted.setForeground(new java.awt.Color(255, 255, 255));
        LabelOpenResultsUnformatted.setText("Open Results  in Text File (Plain)");
        CompletedPanel.add(LabelOpenResultsUnformatted, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 240, 20));

        imageOpenResultsUnformatted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/clipextra.png"))); // NOI18N
        imageOpenResultsUnformatted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageOpenResultsUnformattedMouseClicked(evt);
            }
        });
        CompletedPanel.add(imageOpenResultsUnformatted, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, 50));

        ImageLogo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/logo.png"))); // NOI18N
        CompletedPanel.add(ImageLogo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        ImageBack2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/back.jpg"))); // NOI18N
        CompletedPanel.add(ImageBack2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, -50, -1, -1));

        getContentPane().add(CompletedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        ResultsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ResultsPanel.setMaximumSize(new java.awt.Dimension(600, 400));
        ResultsPanel.setMinimumSize(new java.awt.Dimension(600, 400));
        ResultsPanel.setPreferredSize(new java.awt.Dimension(600, 400));
        ResultsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImageReturn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        ImageReturn.setForeground(new java.awt.Color(255, 255, 255));
        ImageReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/return.png"))); // NOI18N
        ImageReturn.setText("Go Back");
        ImageReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageReturnMouseClicked(evt);
            }
        });
        ResultsPanel.add(ImageReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        fieldResultsScroll.setBackground(new java.awt.Color(51, 51, 51));
        fieldResultsScroll.setBorder(null);
        fieldResultsScroll.setOpaque(false);

        fieldResults.setEditable(false);
        fieldResults.setBackground(new java.awt.Color(102, 102, 102));
        fieldResults.setColumns(20);
        fieldResults.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        fieldResults.setForeground(new java.awt.Color(255, 255, 255));
        fieldResults.setLineWrap(true);
        fieldResults.setRows(5);
        fieldResults.setWrapStyleWord(true);
        fieldResults.setAutoscrolls(false);
        fieldResults.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fieldResultsScroll.setViewportView(fieldResults);

        ResultsPanel.add(fieldResultsScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 450, 180));

        labelResults.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        labelResults.setText("Results");
        ResultsPanel.add(labelResults, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        ImageLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/logo.png"))); // NOI18N
        ResultsPanel.add(ImageLogo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        ImageBack3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LineTool/Images/back.jpg"))); // NOI18N
        ResultsPanel.add(ImageBack3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-320, -50, -1, -1));

        getContentPane().add(ResultsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonPowerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonPowerMouseClicked
        if (!reportThread.isAlive())
        {
        reportThread.start();
        GUICronThread.start();
        }
        MainPanel.setVisible (false);
        TestPanel.setVisible(true);
        MainPanel.repaint();
        TestPanel.repaint();
            
    }//GEN-LAST:event_ButtonPowerMouseClicked

    private void imageOpenResultsFormattedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageOpenResultsFormattedMouseClicked
        try {
        Desktop.getDesktop().open(new File (tempFilePathFormatted));
        } catch (IOException ex) {}// TODO add your handling code here:
    }//GEN-LAST:event_imageOpenResultsFormattedMouseClicked

    private void imageDisplayResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageDisplayResultsMouseClicked
        CompletedPanel.setVisible(false);
        ResultsPanel.setVisible (true);// TODO add your handling code here:
    }//GEN-LAST:event_imageDisplayResultsMouseClicked

    private void imageOpenResultsUnformattedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageOpenResultsUnformattedMouseClicked
        try {
        Desktop.getDesktop().open(new File (tempFilePathUnformatted));
        } catch (IOException ex) {}// TODO add your handling code here:
    }//GEN-LAST:event_imageOpenResultsUnformattedMouseClicked

    private void ImageReturnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageReturnMouseClicked
        CompletedPanel.setVisible(true);
        ResultsPanel.setVisible (false);        // TODO add your handling code here:
    }//GEN-LAST:event_ImageReturnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ButtonPower;
    static javax.swing.JPanel CompletedPanel;
    private javax.swing.JLabel ImageBack;
    private javax.swing.JLabel ImageBack1;
    private javax.swing.JLabel ImageBack2;
    private javax.swing.JLabel ImageBack3;
    private javax.swing.JLabel ImageLogo;
    private javax.swing.JLabel ImageLogo1;
    private javax.swing.JLabel ImageLogo2;
    private javax.swing.JLabel ImageLogo3;
    private javax.swing.JLabel ImageReturn;
    private javax.swing.JLabel LabelBeginTests;
    private javax.swing.JLabel LabelDisplayResults;
    private javax.swing.JLabel LabelOpenResultsFormatted;
    private javax.swing.JLabel LabelOpenResultsUnformatted;
    private javax.swing.JPanel MainPanel;
    static javax.swing.JPanel ResultsPanel;
    static javax.swing.JPanel TestPanel;
    static javax.swing.JTextArea fieldResults;
    private javax.swing.JScrollPane fieldResultsScroll;
    private javax.swing.JLabel imageDisplayResults;
    static javax.swing.JLabel imageFinishedFalse;
    static javax.swing.JLabel imageFinishedTrue;
    static javax.swing.JLabel imageGeneratingReportFalse;
    static javax.swing.JLabel imageGeneratingReportTrue;
    private javax.swing.JLabel imageOpenResultsFormatted;
    private javax.swing.JLabel imageOpenResultsUnformatted;
    static javax.swing.JLabel imagePingingTelkomEquipmentFalse;
    static javax.swing.JLabel imagePingingTelkomEquipmentTrue;
    private javax.swing.JLabel labelGeneratingReport;
    private javax.swing.JLabel labelPingingTelkomEquipment;
    static javax.swing.JLabel labelResults;
    static javax.swing.JLabel labelRunningTests;
    static javax.swing.JLabel labelRunningTests1;
    private javax.swing.JLabel lableFinished;
    // End of variables declaration//GEN-END:variables
}
