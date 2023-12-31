/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.components;

import com.movie.core.Utils;
import com.movie.domain.models.Ticket;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class TicketItem extends javax.swing.JPanel {

    private final Ticket ticket;

    /**
     * Creates new form TicketItem
     *
     * @param ticket
     */
    public TicketItem(
        Ticket ticket
    ) {
        this.ticket = ticket;

        initComponents();
        initLeft();
        initCenter();
    }

    private void initLeft() {
        final double posterWidth = 180;
        final double posterHeight = posterWidth / 600 * 900;

        ImageIcon imageIcon = new ImageIcon("assets/images/" + this.ticket.getMoviePoster() + ".jpg");
        imageIcon = new ImageIcon(
            imageIcon.getImage().getScaledInstance(
                (int) posterWidth,
                (int) posterHeight,
                Image.SCALE_SMOOTH
            )
        );

        this.poster.setIcon(imageIcon);
    }

    private void initCenter() {
        this.title.setText("<html>" + this.ticket.getMovieTitle() + "</html>");
        this.location.setText("<html>"
            + this.ticket.getCinema() + ", " + this.ticket.getTheater()
            + "</html>");
        this.session.setText(this.ticket.getSession());
        this.labelTickets.setText(
            "<html>" + this.ticket.getSeat().size() + " Tiket <b>"
            + String.join(", ", this.ticket.getSeat())
            + "</b>" + "</html>"
        );
        this.labelTicketPrice.setText(
            "<html>Harga Tiket <b>Rp " + Utils.Format.decimal(this.ticket.getPrice())
            + ",00</b></html>");
        this.labelTotalPrice.setText(
            "<html>Total Pembayaran <b>Rp "
            + Utils.Format.decimal(this.ticket.getPrice() * this.ticket.getSeat().size())
            + ",00</b></html>"
        );
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
        poster = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        location = new javax.swing.JLabel();
        session = new javax.swing.JLabel();
        labelTickets = new javax.swing.JLabel();
        labelTicketPrice = new javax.swing.JLabel();
        labelTotalPrice = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(180, 270));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        jPanel1.add(poster);

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 32, 0, 0));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        title.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        title.setText("jLabel1");
        jPanel2.add(title);

        location.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        location.setText("XXI Solo Paragon, Teater 3");
        location.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        jPanel2.add(location);

        session.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        session.setText("18.00-21.00");
        jPanel2.add(session);

        labelTickets.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTickets.setText("4 Tiket");
        labelTickets.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        jPanel2.add(labelTickets);

        labelTicketPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTicketPrice.setText("<html>Harga Tiket: <b>Rp 12.000</b></html>");
        labelTicketPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 0));
        jPanel2.add(labelTicketPrice);

        labelTotalPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTotalPrice.setText("Total Pembayaran: ");
        jPanel2.add(labelTotalPrice);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelTicketPrice;
    private javax.swing.JLabel labelTickets;
    private javax.swing.JLabel labelTotalPrice;
    private javax.swing.JLabel location;
    private javax.swing.JLabel poster;
    private javax.swing.JLabel session;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
