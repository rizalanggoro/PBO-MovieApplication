/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.models;

/**
 *
 * @author user
 */
public class User {

    private final String name;
    private final String email;
    private final String password;
    private long balance;

    // constructor for register
    public User(
        String name,
        String email,
        String password,
        long balance
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
    }

    // contstructor for login
    public User(
        String email,
        String password
    ) {
        this.name = null;
        this.email = email;
        this.password = password;
        this.balance = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}
