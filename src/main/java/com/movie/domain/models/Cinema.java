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
public class Cinema {

    private final String name;
    private final List<String> rooms;

    public Cinema(
        String name,
        List<String> rooms
    ) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public List<String> getRooms() {
        return rooms;
    }

}
