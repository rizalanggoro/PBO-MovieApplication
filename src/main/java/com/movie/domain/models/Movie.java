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
public class Movie {

    private final String title;
    private final String category;
    private final String duration;
    private final String synopsis;
    private final String synopsisId;
    private final String character;
    private final String director;
    private final String poster;
    private final int ticketPrice;
    private final boolean isUpcoming;
    private final String theater;
    private final List<String> sessions;

    public Movie(
        String title,
        String category,
        String duration,
        String synopsis,
        String synopsisId,
        String character,
        String director,
        String poster,
        int ticketPrice,
        boolean isUpcoming,
        String theater,
        List<String> sessions
    ) {
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.synopsis = synopsis;
        this.synopsisId = synopsisId;
        this.character = character;
        this.director = director;
        this.poster = poster;
        this.ticketPrice = ticketPrice;
        this.isUpcoming = isUpcoming;
        this.theater = theater;
        this.sessions = sessions;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDuration() {
        return duration;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getSynopsisId() {
        return synopsisId;
    }

    public String getCharacter() {
        return character;
    }

    public String getDirector() {
        return director;
    }

    public String getPoster() {
        return poster;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public boolean isUpcoming() {
        return isUpcoming;
    }

    public String getTheater() {
        return theater;
    }

    public List<String> getSessions() {
        return sessions;
    }

}
