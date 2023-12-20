/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.data.repositories.RepositoryTicket;
import com.movie.domain.models.ReadSoldTicket;
import java.util.List;

/**
 *
 * @author user
 */
public class UseCaseReadSoldTicket implements IUseCase<ReadSoldTicket, List<String>> {

    private final RepositoryTicket repositoryTicket = new RepositoryTicket();

    @Override
    public Either<Failure, List<String>> call(ReadSoldTicket params) {
        return this.repositoryTicket.readSold(
            params.getMovieTitle(),
            params.getCinema(),
            params.getTheater(),
            params.getSession()
        );
    }

}
