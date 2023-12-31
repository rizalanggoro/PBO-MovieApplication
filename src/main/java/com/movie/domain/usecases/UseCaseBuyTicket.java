/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.MovieApplication;
import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.data.repositories.RepositoryTicket;
import com.movie.data.repositories.RepositoryUser;
import com.movie.domain.models.Ticket;
import com.movie.domain.models.User;

/**
 *
 * @author user
 */
public class UseCaseBuyTicket implements IUseCase<Ticket, Void> {

    private final RepositoryUser repositoryUser = new RepositoryUser();
    private final RepositoryTicket repositoryTicket = new RepositoryTicket();
    private final User user = MovieApplication.USER;

    @Override
    public Either<Failure, Void> call(Ticket params) {
        if (params.getCinema() == null) {
            return Either.left(new Failure("Gagal membeli tiket: Bioskop tidak dipilih!"));
        }

        if (params.getSession() == null) {
            return Either.left(new Failure("Gagal membeli tiket: Sesi tidak dipilih!"));
        }

        if (params.getSeat().isEmpty()) {
            return Either.left(new Failure("Gagal membeli tiket: Kursi tidak dipilih!"));
        }

        if (user != null) {
            // validate balance
            if (user.getBalance() < params.getTotalPrice()) {
                return Either.left(new Failure("Saldo Anda tidak mencukupi! Silahkan lakukan top up saldo!"));
            }

            final var createTicketResult = this.repositoryTicket.create(
                user.getEmail(),
                params
            );

            if (createTicketResult.isRight()) {
                // save sold ticket
                this.repositoryTicket.createSold(params);

                final User newUser = new User(
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getBalance() - params.getTotalPrice()
                );
                final var updateUserResult = this.repositoryUser.update(newUser);

                if (updateUserResult.isRight()) {
                    MovieApplication.USER = newUser;
                    return Either.right(null);
                }
            }
        }

        return Either.left(new Failure("Gagal membeli tiket!"));
    }

}
