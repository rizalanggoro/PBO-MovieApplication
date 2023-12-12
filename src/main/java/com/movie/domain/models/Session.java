/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.models;

/**
 *
 * @author user
 */
public class Session {

    private final String email;

    public Session(
        String email
    ) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

}
