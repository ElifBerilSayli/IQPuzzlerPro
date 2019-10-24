/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author zeynep
 */
public class Menu1 extends javax.swing.JPanel {
    
    public Menu1() throws FileNotFoundException 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        startGame = new javax.swing.JButton();
        leaderBoard = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        howToPlay = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(222, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(480, 800));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 700));
        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        startGame.setBackground(new java.awt.Color(102, 153, 255));
        startGame.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        startGame.setForeground(new java.awt.Color(51, 255, 204));
        startGame.setText("Start Game");
        startGame.setBorder(null);
        startGame.setContentAreaFilled(false);
        startGame.setFocusPainted(false);
        jPanel1.add(startGame);

        leaderBoard.setBackground(new java.awt.Color(0, 204, 204));
        leaderBoard.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        leaderBoard.setForeground(new java.awt.Color(0, 102, 255));
        leaderBoard.setText("Leader Board");
        leaderBoard.setBorder(null);
        leaderBoard.setContentAreaFilled(false);
        leaderBoard.setFocusPainted(false);
        jPanel1.add(leaderBoard);

        settings.setBackground(new java.awt.Color(0, 204, 153));
        settings.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        settings.setForeground(new java.awt.Color(0, 102, 102));
        settings.setText("Settings");
        settings.setBorder(null);
        settings.setContentAreaFilled(false);
        settings.setFocusPainted(false);
        jPanel1.add(settings);

        howToPlay.setBackground(new java.awt.Color(153, 255, 0));
        howToPlay.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        howToPlay.setForeground(new java.awt.Color(102, 204, 0));
        howToPlay.setText("How to Play");
        howToPlay.setBorder(null);
        howToPlay.setContentAreaFilled(false);
        howToPlay.setFocusPainted(false);
        jPanel1.add(howToPlay);

        quit.setBackground(new java.awt.Color(51, 153, 0));
        quit.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        quit.setForeground(new java.awt.Color(204, 51, 0));
        quit.setText("Quit");
        quit.setBorder(null);
        quit.setContentAreaFilled(false);
        quit.setFocusPainted(false);
        quit.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(quit);

        add(jPanel1);
        jPanel1.setBounds(640, 180, 280, 300);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/title_iqpuzzler.png"))); // NOI18N
        add(jLabel15);
        jLabel15.setBounds(130, 40, 1280, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/mass.png"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(120, 250, 300, 220);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/piece6.png"))); // NOI18N
        add(jLabel3);
        jLabel3.setBounds(1120, 180, 120, 100);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/piece5.png"))); // NOI18N
        add(jLabel8);
        jLabel8.setBounds(1120, 380, 140, 80);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/Background_Menu_1600x900.jpg"))); // NOI18N
        add(jLabel9);
        jLabel9.setBounds(0, 0, 1600, 900);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton howToPlay;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leaderBoard;
    private javax.swing.JButton quit;
    private javax.swing.JButton settings;
    private javax.swing.JButton startGame;
    // End of variables declaration//GEN-END:variables

    public JButton getStartGameButton()
    {
        return startGame;
    }
    
    public JButton getHowToPlayButton()
    {
        return howToPlay;
    }
    
    public JButton getLeaderBoardButton()
    {
        return leaderBoard;
    }
    
    public JButton getSettingsButton()
    {
        return settings;
    }
    
    public JButton getQuitButton()
    {
        return quit;
    }
}