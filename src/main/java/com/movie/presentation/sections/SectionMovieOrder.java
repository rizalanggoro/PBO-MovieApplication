/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.domain.models.Movie;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.*;
import org.kordamp.ikonli.fluentui.FluentUiFilledMZ;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author user
 */
public class SectionMovieOrder extends javax.swing.JPanel {

    public static final String name = "movieOrder";
    private final Movie movie;

    /**
     * Creates new form SectionMovieOrder
     *
     * @param movie
     */
    public SectionMovieOrder(
            Movie movie
    ) {
        this.movie = movie;

        initComponents();
        if (this.movie != null) {
            initializeLeft(movie);
            initializeCenter(movie);
        }
    }

    private void initializeCenter(Movie movie) {
        this.scrollPaneCenter.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));

        this.centerTitle.setText(movie.getTitle());
        this.centerSynopsis.setText("<html>" + movie.getSynopsis() + "</html>");

        this.containerCenter.setPreferredSize(
                new Dimension(
                        1280 - 2 * 320 - 16,
                        1000
                )
        );
    }

    private void initializeLeft(Movie movie) {
        final double containerWidth = 320;
        final double posterWidth = containerWidth - 64;
        final double posterHeight = posterWidth / 600 * 900;

        ImageIcon imageIconPoster = new ImageIcon("assets/" + movie.getPoster());
        imageIconPoster = new ImageIcon(
                imageIconPoster.getImage().getScaledInstance(
                        (int) posterWidth,
                        (int) posterHeight,
                        Image.SCALE_SMOOTH
                )
        );
        this.poster.setIcon(imageIconPoster);

        FontIcon fontIconStar = FontIcon.of(FluentUiFilledMZ.STAR_EMPHASIS_24);
        fontIconStar.setIconSize(18);
        fontIconStar.setIconColor(Color.YELLOW);
        this.iconStar.setIcon(fontIconStar);
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
        jPanel4 = new javax.swing.JPanel();
        iconStar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrollPaneCenter = new javax.swing.JScrollPane();
        containerCenter = new javax.swing.JPanel();
        centerTitle = new javax.swing.JLabel();
        centerSynopsis = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(320, 664));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        poster.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        jPanel1.add(poster);

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 32));
        jPanel4.setMinimumSize(new java.awt.Dimension(89, 32));
        jPanel4.setPreferredSize(new java.awt.Dimension(320, 32));
        jPanel4.add(iconStar);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("4,5/5");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 0));
        jPanel4.add(jLabel2);

        jPanel1.add(jPanel4);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        scrollPaneCenter.setBorder(null);

        containerCenter.setLayout(new javax.swing.BoxLayout(containerCenter, javax.swing.BoxLayout.Y_AXIS));

        centerTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        centerTitle.setText("jLabel1");
        centerTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 0, 32));
        containerCenter.add(centerTitle);

        centerSynopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centerSynopsis.setText("jLabel3");
        centerSynopsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 32, 32, 32));
        containerCenter.add(centerSynopsis);

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 10));
        containerCenter.add(jSeparator1);

        jLabel1.setText("Pemeran Utama");
        containerCenter.add(jLabel1);

        jLabel3.setText("jLabel3");
        containerCenter.add(jLabel3);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 10));
        containerCenter.add(jSeparator2);

        jLabel4.setText("Sutradara");
        containerCenter.add(jLabel4);

        jLabel5.setText("jLabel5");
        containerCenter.add(jLabel5);

        scrollPaneCenter.setViewportView(containerCenter);

        jPanel2.add(scrollPaneCenter, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(320, 664));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        add(jPanel3, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel centerSynopsis;
    private javax.swing.JLabel centerTitle;
    private javax.swing.JPanel containerCenter;
    private javax.swing.JLabel iconStar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel poster;
    private javax.swing.JScrollPane scrollPaneCenter;
    // End of variables declaration//GEN-END:variables
}