/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.movie.presentation.components;

import java.awt.Color;
import java.awt.event.ItemEvent;
import javax.swing.JToggleButton;
import org.kordamp.ikonli.fluentui.FluentUiFilledAL;
import org.kordamp.ikonli.swing.FontIcon;

/**
 *
 * @author user
 */
public class SeatItem extends javax.swing.JPanel {

    /**
     * Creates new form SeatPositionItem
     *
     */
    public SeatItem() {
        initComponents();

        FontIcon fontIcon = FontIcon.of(FluentUiFilledAL.BORDER_TOP_BOTTOM_DOUBLE_24);
        fontIcon.setIconSize(18);
        fontIcon.setIconColor(Color.WHITE);
        this.toggleButton.setIcon(fontIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggleButton = new javax.swing.JToggleButton();

        setLayout(new java.awt.BorderLayout());

        toggleButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toggleButtonItemStateChanged(evt);
            }
        });
        add(toggleButton, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void toggleButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toggleButtonItemStateChanged
        // TODO add your handling code here:
        FontIcon fontIcon = (FontIcon) ((JToggleButton) evt.getItem()).getIcon();
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            fontIcon.setIconColor(Color.RED);
        } else {
            fontIcon.setIconColor(Color.WHITE);
        }
    }//GEN-LAST:event_toggleButtonItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton toggleButton;
    // End of variables declaration//GEN-END:variables
}