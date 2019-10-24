/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ıqpuzzlerpro;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author zeynep
 */
public class UserSelectionPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserSelectionPanel
     */
    public UserSelectionPanel() {
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

        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addNewUser = new javax.swing.JButton();
        newUserNameField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        user1NameField = new javax.swing.JTextField();
        selectUser1 = new javax.swing.JButton();
        deleteUser1 = new javax.swing.JButton();
        deleteUser2 = new javax.swing.JButton();
        selectUser2 = new javax.swing.JButton();
        user2NameField = new javax.swing.JTextField();
        user3NameField = new javax.swing.JTextField();
        user4NameField = new javax.swing.JTextField();
        selectUser4 = new javax.swing.JButton();
        selectUser3 = new javax.swing.JButton();
        deleteUser3 = new javax.swing.JButton();
        deleteUser4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1600, 900));
        setMinimumSize(new java.awt.Dimension(1600, 900));
        setLayout(null);

        backButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backButton.setForeground(new java.awt.Color(255, 0, 0));
        backButton.setText("Back");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        backButton.setContentAreaFilled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton);
        backButton.setBounds(50, 50, 80, 50);
        backButton.getAccessibleContext().setAccessibleName("back");

        jPanel1.setOpaque(false);

        addNewUser.setBackground(new java.awt.Color(0, 0, 102));
        addNewUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addNewUser.setForeground(new java.awt.Color(255, 255, 255));
        addNewUser.setText("Add New");
        addNewUser.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        addNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserActionPerformed(evt);
            }
        });

        newUserNameField.setBackground(new java.awt.Color(0, 0, 102));
        newUserNameField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        newUserNameField.setForeground(new java.awt.Color(255, 255, 255));
        newUserNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newUserNameFieldActionPerformed(evt);
            }
        });

        jPanel2.setOpaque(false);

        user1NameField.setBackground(new java.awt.Color(0, 0, 102));
        user1NameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user1NameField.setForeground(new java.awt.Color(255, 255, 255));
        user1NameField.setText("Empty");
        user1NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user1NameFieldActionPerformed(evt);
            }
        });

        selectUser1.setBackground(new java.awt.Color(51, 0, 51));
        selectUser1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectUser1.setForeground(new java.awt.Color(0, 204, 255));
        selectUser1.setText("select");
        selectUser1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectUser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUser1ActionPerformed(evt);
            }
        });

        deleteUser1.setBackground(new java.awt.Color(0, 0, 51));
        deleteUser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteUser1.setForeground(new java.awt.Color(255, 255, 255));
        deleteUser1.setText("Delete User");
        deleteUser1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        deleteUser2.setBackground(new java.awt.Color(0, 0, 51));
        deleteUser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteUser2.setForeground(new java.awt.Color(255, 255, 255));
        deleteUser2.setText("Delete User");
        deleteUser2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        selectUser2.setBackground(new java.awt.Color(51, 0, 51));
        selectUser2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectUser2.setForeground(new java.awt.Color(153, 153, 255));
        selectUser2.setText("select");
        selectUser2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectUser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUser2ActionPerformed(evt);
            }
        });

        user2NameField.setBackground(new java.awt.Color(0, 0, 102));
        user2NameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user2NameField.setForeground(new java.awt.Color(255, 255, 255));
        user2NameField.setText("Empty");
        user2NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user2NameFieldActionPerformed(evt);
            }
        });

        user3NameField.setBackground(new java.awt.Color(0, 0, 102));
        user3NameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user3NameField.setForeground(new java.awt.Color(255, 255, 255));
        user3NameField.setText("Empty");
        user3NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user3NameFieldActionPerformed(evt);
            }
        });

        user4NameField.setBackground(new java.awt.Color(0, 0, 102));
        user4NameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user4NameField.setForeground(new java.awt.Color(255, 255, 255));
        user4NameField.setText("Empty");
        user4NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user4NameFieldActionPerformed(evt);
            }
        });

        selectUser4.setBackground(new java.awt.Color(51, 0, 51));
        selectUser4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectUser4.setForeground(new java.awt.Color(255, 0, 255));
        selectUser4.setText("select");
        selectUser4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectUser4.setPreferredSize(new java.awt.Dimension(78, 28));
        selectUser4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUser4ActionPerformed(evt);
            }
        });

        selectUser3.setBackground(new java.awt.Color(51, 0, 51));
        selectUser3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        selectUser3.setForeground(new java.awt.Color(51, 255, 51));
        selectUser3.setText("select");
        selectUser3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        selectUser3.setPreferredSize(new java.awt.Dimension(78, 28));
        selectUser3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectUser3ActionPerformed(evt);
            }
        });

        deleteUser3.setBackground(new java.awt.Color(0, 0, 51));
        deleteUser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteUser3.setForeground(new java.awt.Color(255, 255, 255));
        deleteUser3.setText("Delete User");
        deleteUser3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        deleteUser4.setBackground(new java.awt.Color(0, 0, 51));
        deleteUser4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteUser4.setForeground(new java.awt.Color(255, 255, 255));
        deleteUser4.setText("Delete User");
        deleteUser4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user4NameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user3NameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user2NameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user1NameField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(selectUser3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(41, 41, 41)
                            .addComponent(deleteUser3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(selectUser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(selectUser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(41, 41, 41)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(deleteUser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteUser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(selectUser4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(deleteUser4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectUser1)
                    .addComponent(user1NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteUser1))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectUser2)
                    .addComponent(user2NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteUser2))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectUser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(user3NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(deleteUser3)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(selectUser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(user4NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(deleteUser4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(newUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(addNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        add(jPanel1);
        jPanel1.setBounds(330, 220, 580, 290);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ıqpuzzlerpro/Images/UserSelection_2_1600x900.jpg"))); // NOI18N
        add(jLabel1);
        jLabel1.setBounds(0, 0, 1600, 900);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void user4NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user4NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user4NameFieldActionPerformed

    private void selectUser3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUser3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectUser3ActionPerformed

    private void selectUser4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUser4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectUser4ActionPerformed

    private void selectUser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUser2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectUser2ActionPerformed

    private void user3NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user3NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user3NameFieldActionPerformed

    private void user2NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user2NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user2NameFieldActionPerformed

    private void user1NameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user1NameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user1NameFieldActionPerformed

    private void selectUser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectUser1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectUser1ActionPerformed

    private void addNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewUserActionPerformed

    private void newUserNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newUserNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newUserNameFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewUser;
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteUser1;
    private javax.swing.JButton deleteUser2;
    private javax.swing.JButton deleteUser3;
    private javax.swing.JButton deleteUser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField newUserNameField;
    private javax.swing.JButton selectUser1;
    private javax.swing.JButton selectUser2;
    private javax.swing.JButton selectUser3;
    private javax.swing.JButton selectUser4;
    private javax.swing.JTextField user1NameField;
    private javax.swing.JTextField user2NameField;
    private javax.swing.JTextField user3NameField;
    private javax.swing.JTextField user4NameField;
    // End of variables declaration//GEN-END:variables

    public JButton getBackButton()
    {
        return backButton;
    }
    
    public JButton selectUser1Button()
    {
        return selectUser1;
    }
    public JButton selectUser2Button()
    {
        return selectUser2;
    }
    public JButton selectUser3Button()
    {
        return selectUser3;
    }
    public JButton selectUser4Button()
    {
        return selectUser4;
    }
    ////////////////////////////////////
    public JButton deleteUser1Button()
    {
        return deleteUser1;
    }
    public JButton deleteUser2Button()
    {
        return deleteUser2;
    }
    public JButton deleteUser3Button()
    {
        return deleteUser3;
    }
    public JButton deleteUser4Button()
    {
        return deleteUser4;
    }
    /////////////////////////////////////
    public JButton addNewUserButton()
    {
        return addNewUser;
    }
    ////////////////////////////////////
    public JTextField getUser1NameField()
    {
        return user1NameField;
    }
    public JTextField getUser2NameField()
    {
        return user2NameField;
    }
    public JTextField getUser3NameField()
    {
        return user3NameField;
    }
    public JTextField getUser4NameField()
    {
        return user4NameField;
    }
    /////////////////////////////////////
    public JTextField getNewUserNameField()
    {
        return newUserNameField;
    }
}