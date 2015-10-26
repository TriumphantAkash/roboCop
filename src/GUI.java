
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akash
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        speedButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        robotMovementPanel = new javax.swing.JPanel();
        stateLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        directionLabel = new javax.swing.JLabel();
        slowSpeedRadioButton = new javax.swing.JRadioButton();
        mediumSpeedRadioButton = new javax.swing.JRadioButton();
        fastSpeedRadioButton = new javax.swing.JRadioButton();
        movementStateButton = new javax.swing.JToggleButton();
        directionSlider = new javax.swing.JSlider();
        clawPositionLabel = new javax.swing.JPanel();
        armPositionLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        clawButton = new javax.swing.JToggleButton();
        armPositionSlider = new javax.swing.JSlider(JSlider.HORIZONTAL, 0, 90, 45);
        externalFeaturesPanel = new javax.swing.JPanel();
        tempratureSensorLabel = new javax.swing.JLabel();
        cameraStatusLabel = new javax.swing.JLabel();
        tempratureButton = new javax.swing.JToggleButton();
        cameraButton = new javax.swing.JToggleButton();
        temperatureLabel = new javax.swing.JLabel();
        frame = new javax.swing.JInternalFrame("Camera Capture");

        speedButtonGroup.add(slowSpeedRadioButton);
        speedButtonGroup.add(mediumSpeedRadioButton);
        speedButtonGroup.add(fastSpeedRadioButton);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ROBOCOP");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        robotMovementPanel.setBorder(BorderFactory.createTitledBorder(null, "Robot Movement", TitledBorder.CENTER, TitledBorder.TOP, new Font("lucida console",Font.BOLD,16), Color.black));

        stateLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        stateLabel.setText("State");

        speedLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        speedLabel.setText("Speed");

        directionLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        directionLabel.setText("Direction");

        slowSpeedRadioButton.setText("slow");

        mediumSpeedRadioButton.setText("medium");

        fastSpeedRadioButton.setText("fast");

        movementStateButton.setText("RUN");
        movementStateButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                if (movementStateButton.isSelected()){
                    movementStateButton.setText("STOP");
                } else {
                    movementStateButton.setText("RUN");
                }
            }
        });

        directionSlider.setPaintLabels(true);

        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        table.put (0, new JLabel("backward"));
        table.put (22, new JLabel("Left"));
        table.put (45, new JLabel("Forward"));
        table.put (67, new JLabel("right"));
        table.put (90, new JLabel("backward"));
        directionSlider.setLabelTable (table);

        javax.swing.GroupLayout robotMovementPanelLayout = new javax.swing.GroupLayout(robotMovementPanel);
        robotMovementPanel.setLayout(robotMovementPanelLayout);
        robotMovementPanelLayout.setHorizontalGroup(
            robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(robotMovementPanelLayout.createSequentialGroup()
                .addGroup(robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(robotMovementPanelLayout.createSequentialGroup()
                        .addComponent(directionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(directionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(robotMovementPanelLayout.createSequentialGroup()
                        .addComponent(speedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slowSpeedRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mediumSpeedRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fastSpeedRadioButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, robotMovementPanelLayout.createSequentialGroup()
                        .addComponent(stateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(movementStateButton)))
                .addContainerGap())
        );
        robotMovementPanelLayout.setVerticalGroup(
            robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(robotMovementPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stateLabel)
                    .addComponent(movementStateButton))
                .addGroup(robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(robotMovementPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(speedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, robotMovementPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fastSpeedRadioButton)
                            .addComponent(mediumSpeedRadioButton)
                            .addComponent(slowSpeedRadioButton))
                        .addGap(18, 18, 18)))
                .addGroup(robotMovementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(directionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(directionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        clawPositionLabel.setBorder(BorderFactory.createTitledBorder(null, "Robot Arm", TitledBorder.CENTER, TitledBorder.TOP, new Font("lucida console",Font.BOLD,16), Color.black));

        armPositionLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        armPositionLabel.setText("Arm Position");

        jLabel6.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        jLabel6.setText("ClawPosition");

        clawButton.setText("CLOSE");
        clawButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent event) {
                if (clawButton.isSelected()){
                    clawButton.setText("OPEN");
                } else {
                    clawButton.setText("CLOSE");
                }
            }
        });

        armPositionSlider.setMinorTickSpacing(2);
        armPositionSlider.setMajorTickSpacing(10);
        armPositionSlider.setPaintTicks(true);
        armPositionSlider.setPaintLabels(true);

        javax.swing.GroupLayout clawPositionLabelLayout = new javax.swing.GroupLayout(clawPositionLabel);
        clawPositionLabel.setLayout(clawPositionLabelLayout);
        clawPositionLabelLayout.setHorizontalGroup(
            clawPositionLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clawPositionLabelLayout.createSequentialGroup()
                .addComponent(armPositionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(armPositionSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(clawPositionLabelLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clawButton)
                .addGap(28, 28, 28))
        );
        clawPositionLabelLayout.setVerticalGroup(
            clawPositionLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clawPositionLabelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(clawPositionLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(armPositionSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(armPositionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(clawPositionLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(clawButton))
                .addContainerGap())
        );

        externalFeaturesPanel.setBorder(BorderFactory.createTitledBorder(null, "External Features", TitledBorder.CENTER, TitledBorder.TOP, new Font("lucida console",Font.BOLD,16), Color.black));

        tempratureSensorLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        tempratureSensorLabel.setText("Temprature Sensor");

        cameraStatusLabel.setFont(new java.awt.Font("Lucida Console", 1, 12)); // NOI18N
        cameraStatusLabel.setText("Camera Status");

        tempratureButton.setText("TURN ON");
        tempratureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (tempratureButton.isSelected()){
                    tempratureButton.setText("TURN OFF");
                    int t = showTemp();
                    temperatureLabel.setText("The temperature reported by robot is: "+t);
                } else {
                    tempratureButton.setText("TURN ON");
                    temperatureLabel.setText("The temperature sensor is off");
                }
            }
        });

        cameraButton.setText("TURN ON");
        cameraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (cameraButton.isSelected()){
                    cameraButton.setText("TURN OFF");
                    loadImage();
                }
                else {
                    cameraButton.setText("TURN ON");
                    removeImage();
                }
            }
        });

        javax.swing.GroupLayout externalFeaturesPanelLayout = new javax.swing.GroupLayout(externalFeaturesPanel);
        externalFeaturesPanel.setLayout(externalFeaturesPanelLayout);
        externalFeaturesPanelLayout.setHorizontalGroup(
            externalFeaturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, externalFeaturesPanelLayout.createSequentialGroup()
                .addGroup(externalFeaturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tempratureSensorLabel)
                    .addComponent(cameraStatusLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(externalFeaturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cameraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tempratureButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        externalFeaturesPanelLayout.setVerticalGroup(
            externalFeaturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(externalFeaturesPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(externalFeaturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tempratureSensorLabel)
                    .addComponent(tempratureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 60, Short.MAX_VALUE)
                .addGroup(externalFeaturesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cameraStatusLabel)
                    .addComponent(cameraButton))
                .addGap(18, 18, 18))
        );

        frame.setVisible(true);

        javax.swing.GroupLayout frameLayout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(frameLayout);
        frameLayout.setHorizontalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        frameLayout.setVerticalGroup(
            frameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(robotMovementPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clawPositionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(externalFeaturesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(frame))
                    .addComponent(temperatureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(robotMovementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(temperatureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(frame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(clawPositionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(externalFeaturesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    public void loadImage()
    {
        try 
        {
            BufferedImage img = ImageIO.read(new File("dp.png"));
            System.out.println("came in loadImage() function");
           // JLabel imgLabel = new JLabel(new ImageIcon(bi));
            frame.setContentPane(new JLabel(new ImageIcon(img)));
            // Supply a layout manager for the body of the content
                   // frame.setLayout(new GridBagLayout());
//                    GridBagConstraints gbc = new GridBagConstraints();
//                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    
                    //frame.pack();
                   // frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
//            imagePanel.add(imgLabel);
//            imagePanel.revalidate();
//            imagePanel.repaint();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void removeImage()
    {
        frame.setVisible(false);
        
    }
    
    public int showTemp()
    {
        //generate a random number between 
        Random r = new Random();
        //the low and high values are set based on Dallas's Temperature in the History
        int Low = -8;
        int High = 113;
        int R = r.nextInt(High-Low) + Low;
        return R;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel armPositionLabel;
    private javax.swing.JSlider armPositionSlider;
    private javax.swing.JToggleButton cameraButton;
    private javax.swing.JLabel cameraStatusLabel;
    private javax.swing.JToggleButton clawButton;
    private javax.swing.JPanel clawPositionLabel;
    private javax.swing.JLabel directionLabel;
    private javax.swing.JSlider directionSlider;
    private javax.swing.JPanel externalFeaturesPanel;
    private javax.swing.JRadioButton fastSpeedRadioButton;
    private javax.swing.JInternalFrame frame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton mediumSpeedRadioButton;
    private javax.swing.JToggleButton movementStateButton;
    private javax.swing.JPanel robotMovementPanel;
    private javax.swing.JRadioButton slowSpeedRadioButton;
    private javax.swing.ButtonGroup speedButtonGroup;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel temperatureLabel;
    private javax.swing.JToggleButton tempratureButton;
    private javax.swing.JLabel tempratureSensorLabel;
    // End of variables declaration//GEN-END:variables
}
