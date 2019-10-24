package ıqpuzzlerpro;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class SettingsPanel extends javax.swing.JPanel {

    public SettingsPanel() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        musicOnOff = new javax.swing.JRadioButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        musicOnOff.setBackground(new java.awt.Color(255, 255, 255));
        musicOnOff.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        musicOnOff.setForeground(new java.awt.Color(255, 255, 255));
        musicOnOff.setText("Music On/Off");
        musicOnOff.setMaximumSize(new java.awt.Dimension(2000, 1000));
        musicOnOff.setMinimumSize(new java.awt.Dimension(2000, 1000));
        musicOnOff.setOpaque(false);
        musicOnOff.setPreferredSize(new java.awt.Dimension(2000, 1000));
        add(musicOnOff);
        musicOnOff.setBounds(190, 200, 200, 30);

        back.setBackground(new java.awt.Color(255, 0, 51));
        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setForeground(new java.awt.Color(255, 0, 51));
        back.setText("Back");
        back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 153, 255), new java.awt.Color(141, 76, 160), new java.awt.Color(255, 255, 102), new java.awt.Color(0, 204, 204)));
        back.setContentAreaFilled(false);
        add(back);
        back.setBounds(50, 50, 80, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/Settings_Background_1600x900.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1600, 900);
    }// </editor-fold>//GEN-END:initComponents

    public boolean getFlag(){
        if(musicOnOff.isSelected()){
            return true;
        }
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton musicOnOff;
    // End of variables declaration//GEN-END:variables
    
    public JButton getBackButton()
    {
        return back;
    }
    public JRadioButton getMusicOnOffButton()
    {
        return musicOnOff;
    }
}