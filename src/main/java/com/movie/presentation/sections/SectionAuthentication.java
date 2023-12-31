/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.MovieApplication;
import com.movie.domain.models.User;
import com.movie.domain.usecases.UseCaseAuthLogin;
import com.movie.domain.usecases.UseCaseAuthRegister;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SectionAuthentication extends javax.swing.JPanel {

    private boolean isLogin = true;

    /**
     * Creates new form SectionAuthentication
     *
     */
    public SectionAuthentication() {
        initComponents();
        initForm();

    }

    @Override
    public String toString() {
        return "authentication";
    }

    private void initForm() {
        this.labelName.setVisible(!this.isLogin);
        this.textFieldName.setVisible(!this.isLogin);

        this.title.setText(this.isLogin ? "Masuk" : "Daftar");
        this.subtitle.setText("<html>"
            + (this.isLogin
                ? "Lengkapi beberapa informasi berikut untuk melanjutkan ke aplikasi Movie"
                : "Lengkapi beberapa informasi berikut untuk bergabung di aplikasi Movie")
            + "</html>"
        );
        this.buttonSubmit.setText(this.isLogin ? "Masuk" : "Daftar");
        this.buttonSwitch.setText(
            this.isLogin
                ? "Belum punya akun? Daftar sekarang"
                : "Sudah punya akun? Masuk sekarang"
        );

    }

    private void register() {
        final String name = this.textFieldName.getText();
        final String email = this.textFieldEmail.getText();
        final String password = this.textFieldPassword.getText();

        new Thread(() -> {
//            var registerResult = new RepositoryAuth().register(
//                new User(name, email, password, 0)
//            );
            var registerResult = new UseCaseAuthRegister().call(
                new User(name, email, password, 0)
            );

            if (registerResult.isLeft()) {
                JOptionPane.showMessageDialog(
                    this,
                    registerResult.getLeft().message,
                    "Terjadi Kesalahan",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Pendaftaran berhasil dilakukan! Silahkan masuk",
                    "Berhasil",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }

        }).start();
    }

    private void login() {

        final String email = this.textFieldEmail.getText();
        final String password = this.textFieldPassword.getText();

        new Thread(() -> {
//            var loginResult = new RepositoryAuth().login(
//                new User(email, password)
//            );

            final var loginResult = new UseCaseAuthLogin().call(
                new User(email, password)
            );

            if (loginResult.isLeft()) {
                JOptionPane.showMessageDialog(
                    this,
                    loginResult.getLeft().message,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                MovieApplication.application.setVisible(false);
                MovieApplication.application = new MovieApplication();
                MovieApplication.application.setVisible(true);
            }

        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        subtitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        labelEmail = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        textFieldPassword = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        buttonSubmit = new javax.swing.JButton();
        buttonSwitch = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(512, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(512, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(320, 360));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setText("Masuk");
        jPanel1.add(title);

        subtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        subtitle.setText("Lengkapi beberapa informasi berikut ini untuk melanjutkan ke aplikasi Movie");
        jPanel1.add(subtitle);
        jPanel1.add(jPanel3);

        labelName.setText("Nama lengkap");
        labelName.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 4, 0));
        jPanel1.add(labelName);

        textFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldName.setAlignmentX(0.0F);
        textFieldName.setMaximumSize(new java.awt.Dimension(2147483647, 32));
        textFieldName.setPreferredSize(new java.awt.Dimension(131, 32));
        jPanel1.add(textFieldName);

        labelEmail.setText("Alamat email");
        labelEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 4, 0));
        jPanel1.add(labelEmail);

        textFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldEmail.setAlignmentX(0.0F);
        textFieldEmail.setMaximumSize(new java.awt.Dimension(2147483647, 32));
        textFieldEmail.setPreferredSize(new java.awt.Dimension(190, 32));
        jPanel1.add(textFieldEmail);

        labelPassword.setText("Kata sandi");
        labelPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 4, 0));
        jPanel1.add(labelPassword);

        textFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textFieldPassword.setAlignmentX(0.0F);
        textFieldPassword.setMaximumSize(new java.awt.Dimension(2147483647, 32));
        textFieldPassword.setMinimumSize(new java.awt.Dimension(68, 32));
        textFieldPassword.setPreferredSize(new java.awt.Dimension(83, 32));
        jPanel1.add(textFieldPassword);
        jPanel1.add(jPanel7);

        buttonSubmit.setText("jButton1");
        buttonSubmit.setMaximumSize(new java.awt.Dimension(320, 27));
        buttonSubmit.setMinimumSize(new java.awt.Dimension(320, 27));
        buttonSubmit.setPreferredSize(new java.awt.Dimension(320, 27));
        buttonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSubmit);

        buttonSwitch.setText("jButton1");
        buttonSwitch.setMaximumSize(new java.awt.Dimension(320, 27));
        buttonSwitch.setMinimumSize(new java.awt.Dimension(320, 27));
        buttonSwitch.setPreferredSize(new java.awt.Dimension(320, 27));
        buttonSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSwitchActionPerformed(evt);
            }
        });
        jPanel1.add(buttonSwitch);

        jPanel2.add(jPanel1);

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSubmitActionPerformed
        // TODO add your handling code here:
        if (this.isLogin) {
            login();
        } else {
            register();
        }
    }//GEN-LAST:event_buttonSubmitActionPerformed

    private void buttonSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSwitchActionPerformed
        // TODO add your handling code here:
        this.isLogin = !this.isLogin;
        initForm();
    }//GEN-LAST:event_buttonSwitchActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSubmit;
    private javax.swing.JButton buttonSwitch;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel subtitle;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldPassword;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
