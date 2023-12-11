/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.domain.models.Movie;
import com.movie.presentation.components.SeatItem;
import com.movie.presentation.components.SeatLabelItem;
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

        this.labelCategoryAndDuration.setText(
            "Kategori: " + movie.getCategory() + " ~ " + movie.getDuration()
        );

        this.centerTitle.setText("<html>" + movie.getTitle() + "</html>");
        this.centerSynopsis.setText("<html>" + movie.getSynopsis() + "</html>");
        this.centerSynopsisId.setText("<html>" + movie.getSynopsisId() + "</html>");

        this.labelCharacter.setText(movie.getCharacter());
        this.labelDirector.setText(movie.getDirector());

        // seats
        String seatRow = "ABCDEFGH";
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (r == 0 && c == 0) {
                    this.containerSeats.add(new JPanel());
                } else if (r == 0) {
                    this.containerSeats.add(new SeatLabelItem(
                        String.valueOf(c)
                    ));
                } else if (c == 0) {
                    this.containerSeats.add(new SeatLabelItem(
                        seatRow.substring(r - 1, r)
                    ));
                } else {
                    this.containerSeats.add(new SeatItem());
                }
            }
        }

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

        ImageIcon imageIconPoster = new ImageIcon("assets/images/" + movie.getPoster() + ".jpg");
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

        panelLeft = new javax.swing.JPanel();
        poster = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        iconStar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelCenter = new javax.swing.JPanel();
        scrollPaneCenter = new javax.swing.JScrollPane();
        containerCenter = new javax.swing.JPanel();
        centerTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        labelCategoryAndDuration = new javax.swing.JLabel();
        centerSynopsis = new javax.swing.JLabel();
        centerSynopsisId = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        labelCharacter = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelDirector = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        containerSeats = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        panelLeft.setPreferredSize(new java.awt.Dimension(320, 664));
        panelLeft.setLayout(new javax.swing.BoxLayout(panelLeft, javax.swing.BoxLayout.Y_AXIS));

        poster.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        panelLeft.add(poster);

        jPanel4.setAlignmentX(0.0F);
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 32));
        jPanel4.setMinimumSize(new java.awt.Dimension(89, 32));
        jPanel4.setPreferredSize(new java.awt.Dimension(320, 32));
        jPanel4.add(iconStar);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("4,5/5");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 8, 0, 0));
        jPanel4.add(jLabel2);

        panelLeft.add(jPanel4);

        add(panelLeft, java.awt.BorderLayout.LINE_START);

        panelCenter.setLayout(new java.awt.BorderLayout());

        scrollPaneCenter.setBorder(null);

        containerCenter.setLayout(new javax.swing.BoxLayout(containerCenter, javax.swing.BoxLayout.Y_AXIS));

        centerTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        centerTitle.setText("jLabel1");
        centerTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 0, 0, 32));
        containerCenter.add(centerTitle);

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 24));
        jPanel1.setLayout(new java.awt.BorderLayout());

        labelCategoryAndDuration.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCategoryAndDuration.setText("jLabel6");
        jPanel1.add(labelCategoryAndDuration, java.awt.BorderLayout.CENTER);

        containerCenter.add(jPanel1);

        centerSynopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centerSynopsis.setText("jLabel6");
        centerSynopsis.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 32));
        containerCenter.add(centerSynopsis);

        centerSynopsisId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        centerSynopsisId.setText("jLabel3");
        centerSynopsisId.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 32, 32));
        containerCenter.add(centerSynopsisId);

        jSeparator1.setMaximumSize(new java.awt.Dimension(32767, 10));
        containerCenter.add(jSeparator1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Pemeran Utama");
        containerCenter.add(jLabel1);

        labelCharacter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCharacter.setText("jLabel3");
        containerCenter.add(labelCharacter);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Sutradara");
        containerCenter.add(jLabel4);

        labelDirector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDirector.setText("jLabel5");
        containerCenter.add(labelDirector);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 10));
        containerCenter.add(jSeparator2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Pilih Kursi");
        containerCenter.add(jLabel3);

        containerSeats.setAlignmentX(0.0F);
        containerSeats.setMaximumSize(new java.awt.Dimension(400, 400));
        containerSeats.setPreferredSize(new java.awt.Dimension(400, 400));
        containerSeats.setLayout(new java.awt.GridLayout(9, 9));
        containerCenter.add(containerSeats);

        scrollPaneCenter.setViewportView(containerCenter);

        panelCenter.add(scrollPaneCenter, java.awt.BorderLayout.CENTER);

        add(panelCenter, java.awt.BorderLayout.CENTER);

        panelRight.setPreferredSize(new java.awt.Dimension(320, 664));

        javax.swing.GroupLayout panelRightLayout = new javax.swing.GroupLayout(panelRight);
        panelRight.setLayout(panelRightLayout);
        panelRightLayout.setHorizontalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        panelRightLayout.setVerticalGroup(
            panelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 664, Short.MAX_VALUE)
        );

        add(panelRight, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel centerSynopsis;
    private javax.swing.JLabel centerSynopsisId;
    private javax.swing.JLabel centerTitle;
    private javax.swing.JPanel containerCenter;
    private javax.swing.JPanel containerSeats;
    private javax.swing.JLabel iconStar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCategoryAndDuration;
    private javax.swing.JLabel labelCharacter;
    private javax.swing.JLabel labelDirector;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JLabel poster;
    private javax.swing.JScrollPane scrollPaneCenter;
    // End of variables declaration//GEN-END:variables
}
