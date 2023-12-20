/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.movie.domain.repositories;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.domain.models.Ticket;
import java.util.List;

/**
 *
 * @author user
 */
public interface IRepositoryTicket {

    public Either<Failure, Void> create(
        String userEmail, Ticket ticket
    );

    public Either<Failure, Void> createSold(
        Ticket ticket
    );

    public Either<Failure, List<Ticket>> read(
        String userEmail
    );

    public Either<Failure, List<String>> readSold(
        String movieTitle,
        String cinema,
        String theater,
        String session
    );
}
