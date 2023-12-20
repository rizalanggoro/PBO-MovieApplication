/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.models;

/**
 *
 * @author user
 */
public class ReadSoldTicket {

    private final String movieTitle;
    private final String cinema;
    private final String theater;
    private final String session;

    public ReadSoldTicket(
        String movieTitle,
        String cinema,
        String theater,
        String session
    ) {
        this.movieTitle = movieTitle;
        this.cinema = cinema;
        this.theater = theater;
        this.session = session;
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

}
