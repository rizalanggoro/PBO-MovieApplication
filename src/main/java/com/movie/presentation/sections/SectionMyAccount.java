/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.MovieApplication;
import com.movie.core.Utils;
import com.movie.data.repositories.RepositoryAuth;
import com.movie.domain.models.User;
import com.movie.domain.usecases.UseCaseTopUpBalance;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SectionMyAccount extends javax.swing.JPanel {

    /**
     * Creates new form SectionMyAccount
     *
     */
    public SectionMyAccount() {

        initComponents();
        initProfile();

    }

    @Override
    public String toString() {
        return "myAccount";
    }

    private void initProfile() {
        User user = MovieApplication.USER;
        if (user != null) {
            this.labelName.setText(user.getName());
            this.labelEmail.setText(user.getEmail());
            this.labelBalance.setText("Saldo: Rp " + Utils.Format.decimal(user.getBalance()) + ",00");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labelBalance = new javax.swing.JLabel();
        buttonTopUp = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buttonLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        labelName.setText("jLabel1");
        jPanel2.add(labelName);

        labelEmail.setText("jLabel2");
        jPanel2.add(labelEmail);

        jPanel5.setAlignmentX(0.0F);
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0));

        labelBalance.setText("jLabel4");
        jPanel5.add(labelBalance);

        buttonTopUp.setText("Isi saldo");
        buttonTopUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTopUpActionPerformed(evt);
            }
        });
        jPanel5.add(buttonTopUp);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        buttonLogout.setText("Keluar");
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });
        jPanel4.add(buttonLogout);

        jPanel1.add(jPanel4, java.awt.BorderLayout.EAST);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // TODO add your handling code here:
        final boolean result = new RepositoryAuth().logout();
        if (result) {
            MovieApplication.application.setVisible(false);
            MovieApplication.application = new MovieApplication();
            MovieApplication.application.setVisible(true);
        }
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonTopUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTopUpActionPerformed
        // TODO add your handling code here:
        final String amount = JOptionPane.showInputDialog(
            this,
            "Masukkan nominal saldo yang Anda inginkan",
            "Isi Saldo",
            JOptionPane.QUESTION_MESSAGE
        );
        final var result = new UseCaseTopUpBalance().call(amount);
        if (result.isLeft()) {
            // failure
            JOptionPane.showMessageDialog(
                this,
                result.getLeft().message,
                "Terjadi Kesalahan",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            // success
            MovieApplication.USER = result.getRight();
            initProfile();

            JOptionPane.showMessageDialog(
                this,
                "Top up saldo berhasil dilakukan!",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_buttonTopUpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonTopUp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel labelBalance;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelName;
    // End of variables declaration//GEN-END:variables
}
