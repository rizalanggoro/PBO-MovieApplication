/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.movie;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.movie.data.repositories.RepositoryAuth;
import com.movie.data.repositories.RepositoryMovie;
import com.movie.domain.models.User;
import com.movie.presentation.sections.SectionAuthentication;
import com.movie.presentation.sections.SectionHome;
import com.movie.presentation.sections.SectionLoading;
import com.movie.presentation.sections.SectionMovieOrder;
import com.movie.presentation.sections.SectionMyAccount;
import java.awt.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author user
 */
public class MovieApplication extends javax.swing.JFrame {

    public static User USER = null;

    /**
     * Creates new form MovieApplication
     */
    public MovieApplication() {
        initComponents();

        initAccount();
    }

    private void initAccount() {
        // section loading
        this.panelContent.add(SectionLoading.name, new SectionLoading());

        new Thread(() -> {
            var sessionResult = new RepositoryAuth().getSession();
            if (sessionResult.isRight()) {
                MovieApplication.USER = sessionResult.getRight();
            } else {
                System.out.println("session status: " + sessionResult.getLeft().message);
            }

            initContent();
            navigateToSectionName(SectionHome.name);
        }).start();
    }

    private void initContent() {

        this.panelContent.add(SectionHome.name, new SectionHome((movie) -> {
            for (Component component : this.panelContent.getComponents()) {
                if (component instanceof SectionMovieOrder) {
                    this.panelContent.remove(component);
                    break;
                }
            }
            this.panelContent.add(SectionMovieOrder.name, new SectionMovieOrder(movie));
            navigateToSectionName(SectionMovieOrder.name);
        }));
        this.panelContent.add(SectionMovieOrder.name, new SectionMovieOrder(
            new RepositoryMovie().readNowPlaying().getRight().get(0)
        // null
        ));

        // section my account
        this.panelContent.add(SectionMyAccount.name, new SectionMyAccount(
            () -> this.setVisible(false)
        ));

        // section authentication
        this.panelContent.add(
            SectionAuthentication.name,
            new SectionAuthentication(() -> {
                setVisible(false);
                new MovieApplication().setVisible(true);
            })
        );
    }

    private void navigateToSectionName(String name) {
        ((CardLayout) this.panelContent.getLayout()).show(this.panelContent, name);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupSelectDay = new javax.swing.ButtonGroup();
        panelNavbar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        buttonMovies = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        buttonMyAccount = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        panelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movie Application");
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 720));

        panelNavbar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        panelNavbar.setPreferredSize(new java.awt.Dimension(1280, 56));
        panelNavbar.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setPreferredSize(new java.awt.Dimension(32, 100));
        jPanel4.add(jPanel5);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Movie Cinema");
        jPanel4.add(jLabel1);

        panelNavbar.add(jPanel4, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.X_AXIS));

        buttonMovies.setText("Daftar Film");
        buttonMovies.setFocusPainted(false);
        buttonMovies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoviesActionPerformed(evt);
            }
        });
        jPanel2.add(buttonMovies);

        jPanel1.setMaximumSize(new java.awt.Dimension(8, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(8, 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(8, 100));
        jPanel2.add(jPanel1);

        buttonMyAccount.setText("Akun Saya");
        buttonMyAccount.setFocusPainted(false);
        buttonMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMyAccountActionPerformed(evt);
            }
        });
        jPanel2.add(buttonMyAccount);

        jPanel3.setPreferredSize(new java.awt.Dimension(32, 100));
        jPanel2.add(jPanel3);

        panelNavbar.add(jPanel2, java.awt.BorderLayout.EAST);

        getContentPane().add(panelNavbar, java.awt.BorderLayout.NORTH);

        panelContent.setPreferredSize(new java.awt.Dimension(1280, 0));
        panelContent.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelContent, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMoviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoviesActionPerformed
        // TODO add your handling code here:
        navigateToSectionName(SectionHome.name);
    }//GEN-LAST:event_buttonMoviesActionPerformed

    private void buttonMyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMyAccountActionPerformed
        // TODO add your handling code here:
        if (MovieApplication.USER == null) {
            navigateToSectionName(SectionAuthentication.name);
        } else {
            navigateToSectionName(SectionMyAccount.name);
        }
    }//GEN-LAST:event_buttonMyAccountActionPerformed

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
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println(e.getMessage());
        }

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MovieApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MovieApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MovieApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MovieApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MovieApplication().setVisible(true);
        });
//        var result1 = new RepositoryAuth().login(new User("rizaldwianggoro@email.com", "12345678"));
//        System.out.println("result1: "
//            + (result1.isLeft()
//            ? result1.getLeft().message : result1.getRight())
//        );
//
//        var result2 = new RepositoryAuth().login(new User("rizaldwianggoro@email.com", "123456788"));
//        System.out.println("result2: "
//            + (result2.isLeft()
//            ? result2.getLeft().message : result2.getRight())
//        );
//
//        var result3 = new RepositoryAuth().login(new User("rizaldwianggoroo@email.com", "123456788"));
//        System.out.println("result3: "
//            + (result3.isLeft()
//            ? result3.getLeft().message : result2.getRight())
//        );
//
//        var session = new RepositoryAuth().getSession();
//        System.out.println("session: "
//            + (session.isLeft()
//            ? session.getLeft().message : session.getRight().getName())
//        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupSelectDay;
    private javax.swing.JButton buttonMovies;
    private javax.swing.JButton buttonMyAccount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelNavbar;
    // End of variables declaration//GEN-END:variables
}
