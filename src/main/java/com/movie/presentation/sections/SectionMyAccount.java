/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.MovieApplication;
import com.movie.core.Utils;
import com.movie.data.repositories.RepositoryAuth;
import com.movie.domain.models.Ticket;
import com.movie.domain.models.User;
import com.movie.domain.usecases.UseCaseReadTickets;
import com.movie.domain.usecases.UseCaseTopUpBalance;
import com.movie.presentation.components.TicketItem;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SectionMyAccount extends javax.swing.JPanel {

    private List<Ticket> listTickets = new ArrayList<>();

    /**
     * Creates new form SectionMyAccount
     *
     */
    public SectionMyAccount() {

        initComponents();
        initProfile();
        loadTickets();
    }

    @Override
    public String toString() {
        return "myAccount";
    }

    private void loadTickets() {
        new Thread(() -> {
            final var result = new UseCaseReadTickets().call(null);
            if (result.isRight()) {
                this.listTickets = result.getRight();

                initTickets();
            }
        }).start();
    }

    private void initTickets() {
        this.scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
        this.scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        final int colCount = 2;
        final int rowCount = (this.listTickets.size() + colCount - 1) / colCount;

        ((GridLayout) this.containerTickets.getLayout()).setColumns(colCount);
        ((GridLayout) this.containerTickets.getLayout()).setRows(rowCount);

        for (Ticket ticket : this.listTickets) {
            final var ticketItem = new TicketItem(ticket);
            this.containerTickets.add(ticketItem);
        }

        this.containerTickets.setPreferredSize(new Dimension(
            1280 - this.scrollPane.getWidth(),
            rowCount * 300 + (rowCount - 1) * 32
        ));
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
        scrollPane = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        containerTickets = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        labelName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelName.setText("jLabel1");
        jPanel2.add(labelName);

        labelEmail.setText("jLabel2");
        jPanel2.add(labelEmail);

        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEADING, 0, 0));

        labelBalance.setText("jLabel4");
        labelBalance.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 32));
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

        scrollPane.setBorder(null);
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.Y_AXIS));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tiket Saya");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 0, 32));
        jPanel6.add(jLabel1);

        containerTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        containerTickets.setAlignmentX(0.0F);
        containerTickets.setLayout(new java.awt.GridLayout(1, 0, 32, 32));
        jPanel6.add(containerTickets);

        scrollPane.setViewportView(jPanel6);

        add(scrollPane, java.awt.BorderLayout.CENTER);
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
        if (amount != null) {
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
        }
    }//GEN-LAST:event_buttonTopUpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogout;
    private javax.swing.JButton buttonTopUp;
    private javax.swing.JPanel containerTickets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelBalance;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelName;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
