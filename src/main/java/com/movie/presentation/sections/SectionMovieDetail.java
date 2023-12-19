/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.domain.models.Movie;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author user
 */
public class SectionMovieDetail extends javax.swing.JPanel {

    private final Movie movie;

    /**
     * Creates new form SectionMovieDetail
     *
     * @param movie
     */
    public SectionMovieDetail(
        Movie movie
    ) {
        this.movie = movie;

        initComponents();

        initLeft();
        initCenter();
    }

    private void initLeft() {
        final double posterWidth = 240;
        final double posterHeight = posterWidth / 600 * 900;

        ImageIcon imageIcon = new ImageIcon("assets/images/" + this.movie.getPoster() + ".jpg");
        imageIcon = new ImageIcon(
            imageIcon.getImage().getScaledInstance(
                (int) posterWidth, (int) posterHeight, Image.SCALE_SMOOTH
            )
        );
        this.poster.setIcon(imageIcon);
    }

    private void initCenter() {
        this.centerTitle.setText(this.movie.getTitle());
        this.labelCategoryAndDuration.setText(
            "Kategori: " + this.movie.getCategory() + " ~ " + this.movie.getDuration()
        );
        this.centerSynopsis.setText("<html>" + this.movie.getSynopsis() + "</html>");
        this.centerSynopsisId.setText("<html>" + this.movie.getSynopsisId() + "</html>");

        this.labelCharacter.setText(this.movie.getCharacter());
        this.labelDirector.setText(this.movie.getDirector());
    }

    @Override
    public String toString() {
        return "movieDetail";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        panelLeft = new javax.swing.JPanel();
        poster = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        centerTitle = new javax.swing.JLabel();
        labelCategoryAndDuration = new javax.swing.JLabel();
        centerSynopsis = new javax.swing.JLabel();
        centerSynopsisId = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        labelCharacter = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelDirector = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel3.setMaximumSize(new java.awt.Dimension(320, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(320, 0));
        jPanel3.setPreferredSize(new java.awt.Dimension(320, 720));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.EAST);

        panelLeft.setMaximumSize(new java.awt.Dimension(320, 32767));
        panelLeft.setMinimumSize(new java.awt.Dimension(320, 0));
        panelLeft.setPreferredSize(new java.awt.Dimension(320, 720));

        poster.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        panelLeft.add(poster);

        add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelCenter.setMaximumSize(new java.awt.Dimension(320, 32767));
        panelCenter.setMinimumSize(new java.awt.Dimension(320, 0));
        panelCenter.setPreferredSize(new java.awt.Dimension(320, 720));
        panelCenter.setLayout(new javax.swing.BoxLayout(panelCenter, javax.swing.BoxLayout.Y_AXIS));

        centerTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        centerTitle.setText("jLabel1");
        centerTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 0, 0, 32));
        panelCenter.add(centerTitle);

        labelCategoryAndDuration.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCategoryAndDuration.setText("jLabel6");
        panelCenter.add(labelCategoryAndDuration);

        centerSynopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centerSynopsis.setText("jLabel6");
        centerSynopsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 32));
        panelCenter.add(centerSynopsis);

        centerSynopsisId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centerSynopsisId.setText("jLabel3");
        centerSynopsisId.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 32, 32));
        panelCenter.add(centerSynopsisId);

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 10));
        panelCenter.add(jSeparator1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Pemeran Utama");
        panelCenter.add(jLabel1);

        labelCharacter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCharacter.setText("jLabel3");
        panelCenter.add(labelCharacter);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Sutradara");
        panelCenter.add(jLabel4);

        labelDirector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDirector.setText("jLabel5");
        panelCenter.add(labelDirector);

        add(panelCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel centerSynopsis;
    private javax.swing.JLabel centerSynopsisId;
    private javax.swing.JLabel centerTitle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCategoryAndDuration;
    private javax.swing.JLabel labelCharacter;
    private javax.swing.JLabel labelDirector;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JLabel poster;
    // End of variables declaration//GEN-END:variables
}
