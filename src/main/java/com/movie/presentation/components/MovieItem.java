/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.components;

import com.movie.MovieApplication;
import com.movie.domain.models.Movie;
import com.movie.presentation.sections.SectionMovieDetail;
import com.movie.presentation.sections.SectionMovieOrder;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class MovieItem extends javax.swing.JPanel {

    private final double posterWidth;
    private final double posterHeight;
    private final int containerDetailsHeight;
    private final Movie movie;

    /**
     * Creates new form MovieItem
     *
     * @param movie
     */
    public MovieItem(
        Movie movie
    ) {
        this.movie = movie;

        initComponents();

        final int colCount = 5;
        final int frameWidth = 1280 - 16;
        posterWidth = (frameWidth - 64 - 8 * (colCount - 1)) / colCount;
        posterHeight = posterWidth / 600 * 900;
        ImageIcon imageIcon = new ImageIcon("assets/images/" + movie.getPoster() + ".jpg");
        imageIcon = new ImageIcon(
            imageIcon.getImage().getScaledInstance(
                (int) posterWidth,
                (int) posterHeight,
                Image.SCALE_SMOOTH
            )
        );
        this.labelPoster.setIcon(imageIcon);

        this.labelTitle.setText(movie.getTitle());
        this.labelSynopsis.setText(movie.getSynopsis());
        this.buttonAction.setText(movie.isUpcoming() ? "Lihat rincian" : "Pesan");

        this.containerDetailsHeight = this.containerDetails.getPreferredSize().height;

    }

    public double getPosterWidth() {
        return posterWidth;
    }

    public double getPosterHeight() {
        return posterHeight;
    }

    public int getContainerDetailsHeight() {
        return containerDetailsHeight;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerDetails = new javax.swing.JPanel();
        labelTitle = new javax.swing.JLabel();
        labelSynopsis = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        buttonAction = new javax.swing.JButton();
        labelPoster = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setLayout(new java.awt.BorderLayout());

        containerDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 16, 16));
        containerDetails.setOpaque(false);
        containerDetails.setLayout(new javax.swing.BoxLayout(containerDetails, javax.swing.BoxLayout.Y_AXIS));

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTitle.setText("label title");
        containerDetails.add(labelTitle);

        labelSynopsis.setText("label synopsis");
        labelSynopsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 0, 8, 0));
        containerDetails.add(labelSynopsis);

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setLayout(new java.awt.BorderLayout());

        buttonAction.setText("Pesan");
        buttonAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionActionPerformed(evt);
            }
        });
        jPanel1.add(buttonAction, java.awt.BorderLayout.CENTER);

        containerDetails.add(jPanel1);

        add(containerDetails, java.awt.BorderLayout.SOUTH);

        labelPoster.setBackground(new java.awt.Color(0, 153, 153));
        add(labelPoster, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionActionPerformed
        // TODO add your handling code here:
        if (this.movie.isUpcoming()) {
            MovieApplication.application.navigateToSection(
                new SectionMovieDetail(this.movie),
                true
            );
        } else {
            MovieApplication.application.navigateToSection(
                new SectionMovieOrder(this.movie),
                true
            );
        }
    }//GEN-LAST:event_buttonActionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAction;
    private javax.swing.JPanel containerDetails;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelPoster;
    private javax.swing.JLabel labelSynopsis;
    private javax.swing.JLabel labelTitle;
    // End of variables declaration//GEN-END:variables
}
