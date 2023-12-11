/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.models;

/**
 *
 * @author user
 */
public class Movie {

    private final String title;
    private final String synopsis;
    private final String posterPath;
    private final int price;

    public Movie(
            String title,
            String synopsis,
            String posterPath,
            int price
    ) {
        this.title = title;
        this.synopsis = synopsis;
        this.posterPath = posterPath;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public int getPrice() {
        return price;
    }
}
