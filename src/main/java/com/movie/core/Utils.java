/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.core;

import java.text.DecimalFormat;

/**
 *
 * @author user
 */
public class Utils {

    public static class Format {

        public static String decimal(long num) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###");
            return decimalFormat.format(num);
        }
    }
}
