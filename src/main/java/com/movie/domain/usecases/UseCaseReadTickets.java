/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.MovieApplication;
import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.data.repositories.RepositoryTicket;
import com.movie.domain.models.Ticket;
import com.movie.domain.models.User;
import java.util.List;

/**
 *
 * @author user
 */
public class UseCaseReadTickets implements IUseCase<Void, List<Ticket>> {

    private final RepositoryTicket repositoryTicket = new RepositoryTicket();
    private final User user = MovieApplication.USER;

    @Override
    public Either<Failure, List<Ticket>> call(Void params) {
        return this.repositoryTicket.read(this.user.getEmail());
    }

}
