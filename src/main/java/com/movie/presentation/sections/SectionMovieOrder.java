/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.sections;

import com.movie.core.Utils;
import com.movie.domain.models.Movie;
import com.movie.domain.models.Ticket;
import com.movie.domain.usecases.UseCaseBuyTicket;
import com.movie.presentation.components.SeatItem;
import com.movie.presentation.components.SeatLabelItem;
import com.movie.presentation.listeners.OnMovieItemClickListener;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import org.kordamp.ikonli.fluentui.FluentUiFilledMZ;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author user
 */
public class SectionMovieOrder extends javax.swing.JPanel {

    private final Movie movie;

    private String selectedCinema = "-";
    private String selectedSession = "-";
    private final ArrayList<String> arrayListSelectedSeat = new ArrayList<>();

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
            initializeRight();
        }
    }

    @Override
    public String toString() {
        return "movieOrder";
    }

    private void initializeRight() {
        this.detailMovieTitle.setText("<html>" + this.movie.getTitle() + "</html>");
        this.detailCinema.setText("Bioskop: -");
    }

    private void initializeCenter(Movie movie) {
        this.scrollPaneCenter.getVerticalScrollBar().setPreferredSize(new Dimension(16, 0));
        this.scrollPaneCenter.getVerticalScrollBar().setUnitIncrement(16);

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
                    String seat = seatRow.substring(r - 1, r) + c;
                    this.containerSeats.add(new SeatItem(new OnMovieItemClickListener() {
                        @Override
                        public void onSelected() {
                            arrayListSelectedSeat.add(seat);
                            onChangeSelectedSeat();
                        }

                        @Override
                        public void onUnselected() {
                            arrayListSelectedSeat.remove(seat);
                            onChangeSelectedSeat();
                        }
                    }));
                }
            }
        }

        // sessions
        this.radioSession1.setText(this.movie.getSessions().get(0));
        this.radioSession2.setText(this.movie.getSessions().get(1));
        if (this.movie.getSessions().size() > 2) {
            this.radioSession3.setText(this.movie.getSessions().get(2));
        } else {
            this.radioSession3.setVisible(false);
        }

        this.containerCenter.setPreferredSize(
            new Dimension(
                1280 - 2 * 320 - 16,
                1512
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

        buttonGroupCinema = new javax.swing.ButtonGroup();
        buttonGroupSession = new javax.swing.ButtonGroup();
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
        labelCinema = new javax.swing.JLabel();
        containerCinemas = new javax.swing.JPanel();
        radioCinema1 = new javax.swing.JRadioButton();
        radioCinema2 = new javax.swing.JRadioButton();
        radioCinema3 = new javax.swing.JRadioButton();
        radioCinema4 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        radioSession1 = new javax.swing.JRadioButton();
        radioSession2 = new javax.swing.JRadioButton();
        radioSession3 = new javax.swing.JRadioButton();
        labelSeat = new javax.swing.JLabel();
        containerSeats = new javax.swing.JPanel();
        panelRight = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        detailMovieTitle = new javax.swing.JLabel();
        detailCinema = new javax.swing.JLabel();
        detailDate = new javax.swing.JLabel();
        detailSeat = new javax.swing.JLabel();
        detailPrice = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        buttonBuy = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Pemeran Utama");
        jLabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 0, 0, 0));
        containerCenter.add(jLabel1);

        labelCharacter.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCharacter.setText("jLabel3");
        containerCenter.add(labelCharacter);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Sutradara");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        containerCenter.add(jLabel4);

        labelDirector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDirector.setText("jLabel5");
        labelDirector.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 32, 0));
        containerCenter.add(labelDirector);

        jSeparator2.setMaximumSize(new java.awt.Dimension(32767, 10));
        containerCenter.add(jSeparator2);

        labelCinema.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelCinema.setText("Pilih Bioskop");
        labelCinema.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 0, 0, 0));
        containerCenter.add(labelCinema);

        containerCinemas.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        containerCinemas.setLayout(new javax.swing.BoxLayout(containerCinemas, javax.swing.BoxLayout.Y_AXIS));

        buttonGroupCinema.add(radioCinema1);
        radioCinema1.setText("XXI Solo Paragon");
        radioCinema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCinema1ActionPerformed(evt);
            }
        });
        containerCinemas.add(radioCinema1);

        buttonGroupCinema.add(radioCinema2);
        radioCinema2.setText("XXI Solo Square");
        radioCinema2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCinema2ActionPerformed(evt);
            }
        });
        containerCinemas.add(radioCinema2);

        buttonGroupCinema.add(radioCinema3);
        radioCinema3.setText("XXI The Park Solo");
        radioCinema3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCinema3ActionPerformed(evt);
            }
        });
        containerCinemas.add(radioCinema3);

        buttonGroupCinema.add(radioCinema4);
        radioCinema4.setText("XXI Solo Grand Mall");
        radioCinema4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCinema4ActionPerformed(evt);
            }
        });
        containerCinemas.add(radioCinema4);

        containerCenter.add(containerCinemas);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Pilih Sesi");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 0, 0, 0));
        containerCenter.add(jLabel7);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 0, 0));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        buttonGroupSession.add(radioSession1);
        radioSession1.setText("jRadioButton5");
        radioSession1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSession1ActionPerformed(evt);
            }
        });
        jPanel2.add(radioSession1);

        buttonGroupSession.add(radioSession2);
        radioSession2.setText("jRadioButton6");
        radioSession2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSession2ActionPerformed(evt);
            }
        });
        jPanel2.add(radioSession2);

        buttonGroupSession.add(radioSession3);
        radioSession3.setText("jRadioButton7");
        radioSession3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSession3ActionPerformed(evt);
            }
        });
        jPanel2.add(radioSession3);

        containerCenter.add(jPanel2);

        labelSeat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelSeat.setText("Pilih Kursi");
        labelSeat.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 0, 0, 0));
        containerCenter.add(labelSeat);

        containerSeats.setAlignmentX(0.0F);
        containerSeats.setMaximumSize(new java.awt.Dimension(400, 400));
        containerSeats.setPreferredSize(new java.awt.Dimension(400, 400));
        containerSeats.setLayout(new java.awt.GridLayout(9, 9));
        containerCenter.add(containerSeats);

        scrollPaneCenter.setViewportView(containerCenter);

        panelCenter.add(scrollPaneCenter, java.awt.BorderLayout.CENTER);

        add(panelCenter, java.awt.BorderLayout.CENTER);

        panelRight.setPreferredSize(new java.awt.Dimension(320, 664));
        panelRight.setLayout(new javax.swing.BoxLayout(panelRight, javax.swing.BoxLayout.Y_AXIS));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Rincian");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 0, 32));
        panelRight.add(jLabel3);

        detailMovieTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        detailMovieTitle.setText("Judul Film");
        detailMovieTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 32, 0, 32));
        panelRight.add(detailMovieTitle);

        detailCinema.setText("Lokasi: -");
        detailCinema.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 32, 0, 32));
        panelRight.add(detailCinema);

        detailDate.setText("Sesi: -");
        detailDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 32, 0, 32));
        panelRight.add(detailDate);

        detailSeat.setText("Kursi: -");
        detailSeat.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 32, 0, 32));
        panelRight.add(detailSeat);

        detailPrice.setText("Total: Rp 0,00");
        detailPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 32, 0, 32));
        panelRight.add(detailPrice);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(32, 32, 32, 32));
        jPanel3.setAlignmentX(0.0F);
        jPanel3.setLayout(new java.awt.BorderLayout());

        buttonBuy.setText("Beli");
        buttonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBuyActionPerformed(evt);
            }
        });
        jPanel3.add(buttonBuy, java.awt.BorderLayout.NORTH);

        panelRight.add(jPanel3);

        add(panelRight, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void onChangeCinema() {
        if (this.radioCinema1.isSelected()) {
            this.selectedCinema = this.radioCinema1.getText();
        } else if (this.radioCinema2.isSelected()) {
            this.selectedCinema = this.radioCinema2.getText();
        } else if (this.radioCinema3.isSelected()) {
            this.selectedCinema = this.radioCinema3.getText();
        } else if (this.radioCinema4.isSelected()) {
            this.selectedCinema = this.radioCinema4.getText();
        }

        if (!this.selectedCinema.equals("-")) {
            this.selectedCinema += ", " + this.movie.getTheater();
        }

        this.detailCinema.setText("Lokasi: " + this.selectedCinema);
    }

    private void onChangeSession() {
        if (this.radioSession1.isSelected()) {
            this.selectedSession = this.radioSession1.getText();
        } else if (this.radioSession2.isSelected()) {
            this.selectedSession = this.radioSession2.getText();
        } else if (this.radioSession3.isSelected()) {
            this.selectedSession = this.radioSession3.getText();
        }

        if (!this.selectedSession.equals("-")) {
            Date currentDate = new Date();
            String currentDateStr = new SimpleDateFormat("EEEE, dd MMMM yyyy").format(currentDate);
            this.selectedSession = "Sesi: " + currentDateStr + ", " + this.selectedSession;
        }
        this.detailDate.setText(this.selectedSession);
    }

    private void onChangeSelectedSeat() {
        String selectedSeat = "-";
        if (!arrayListSelectedSeat.isEmpty()) {
            selectedSeat = String.join(", ", arrayListSelectedSeat);
        }
        detailSeat.setText("<html>Kursi: " + selectedSeat + "</html>");

        long price = movie.getTicketPrice() * arrayListSelectedSeat.size();
        detailPrice.setText("Total: Rp " + Utils.Format.decimal(price) + ",00");
    }

    private void radioCinema2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCinema2ActionPerformed
        // TODO add your handling code here:
        onChangeCinema();
    }//GEN-LAST:event_radioCinema2ActionPerformed

    private void radioCinema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCinema1ActionPerformed
        // TODO add your handling code here:
        onChangeCinema();
    }//GEN-LAST:event_radioCinema1ActionPerformed

    private void radioCinema3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCinema3ActionPerformed
        // TODO add your handling code here:
        onChangeCinema();
    }//GEN-LAST:event_radioCinema3ActionPerformed

    private void radioCinema4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCinema4ActionPerformed
        // TODO add your handling code here:
        onChangeCinema();
    }//GEN-LAST:event_radioCinema4ActionPerformed

    private void radioSession1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSession1ActionPerformed
        // TODO add your handling code here:
        onChangeSession();
    }//GEN-LAST:event_radioSession1ActionPerformed

    private void radioSession2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSession2ActionPerformed
        // TODO add your handling code here:
        onChangeSession();
    }//GEN-LAST:event_radioSession2ActionPerformed

    private void radioSession3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSession3ActionPerformed
        // TODO add your handling code here:
        onChangeSession();
    }//GEN-LAST:event_radioSession3ActionPerformed

    private void buttonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBuyActionPerformed
        // TODO add your handling code here:
        final Ticket ticket = new Ticket(
            this.movie.getTitle(),
            this.selectedCinema,
            this.movie.getTheater(),
            this.selectedSession,
            String.join(", ", this.arrayListSelectedSeat),
            this.movie.getTicketPrice(),
            this.movie.getTicketPrice() * this.arrayListSelectedSeat.size()
        );

        final var buyResult = new UseCaseBuyTicket().call(ticket);
        if (buyResult.isLeft()) {
            JOptionPane.showMessageDialog(
                this,
                buyResult.getLeft().message,
                "Terjadi Kesalahan",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Berhasil membeli tiket!",
                "Berhasil",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_buttonBuyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBuy;
    private javax.swing.ButtonGroup buttonGroupCinema;
    private javax.swing.ButtonGroup buttonGroupSession;
    private javax.swing.JLabel centerSynopsis;
    private javax.swing.JLabel centerSynopsisId;
    private javax.swing.JLabel centerTitle;
    private javax.swing.JPanel containerCenter;
    private javax.swing.JPanel containerCinemas;
    private javax.swing.JPanel containerSeats;
    private javax.swing.JLabel detailCinema;
    private javax.swing.JLabel detailDate;
    private javax.swing.JLabel detailMovieTitle;
    private javax.swing.JLabel detailPrice;
    private javax.swing.JLabel detailSeat;
    private javax.swing.JLabel iconStar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCategoryAndDuration;
    private javax.swing.JLabel labelCharacter;
    private javax.swing.JLabel labelCinema;
    private javax.swing.JLabel labelDirector;
    private javax.swing.JLabel labelSeat;
    private javax.swing.JPanel panelCenter;
    private javax.swing.JPanel panelLeft;
    private javax.swing.JPanel panelRight;
    private javax.swing.JLabel poster;
    private javax.swing.JRadioButton radioCinema1;
    private javax.swing.JRadioButton radioCinema2;
    private javax.swing.JRadioButton radioCinema3;
    private javax.swing.JRadioButton radioCinema4;
    private javax.swing.JRadioButton radioSession1;
    private javax.swing.JRadioButton radioSession2;
    private javax.swing.JRadioButton radioSession3;
    private javax.swing.JScrollPane scrollPaneCenter;
    // End of variables declaration//GEN-END:variables
}
