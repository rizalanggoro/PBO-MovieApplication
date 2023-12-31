/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.models;

import java.util.List;

/**
 *
 * @author user
 */
public class Ticket {

    private final String movieTitle;
    private final String cinema;
    private final String theater;
    private final String session;
    private final List<String> seat;
    private final long price;
    private final long totalPrice;
    private final String moviePoster;

    public Ticket(
        String movieTitle,
        String cinema,
        String theater,
        String session,
        List<String> seat,
        long price,
        long totalPrice,
        String moviePoster
    ) {
        this.movieTitle = movieTitle;
        this.cinema = cinema;
        this.theater = theater;
        this.session = session;
        this.seat = seat;
        this.price = price;
        this.totalPrice = totalPrice;
        this.moviePoster = moviePoster;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getCinema() {
        return cinema;
    }

    public String getTheater() {
        return theater;
    }

    public String getSession() {
        return session;
    }

    public List<String> getSeat() {
        return seat;
    }

    public long getPrice() {
        return price;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

}
