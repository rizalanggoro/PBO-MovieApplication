/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.MovieApplication;
import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.data.repositories.RepositoryUser;
import com.movie.domain.models.User;

/**
 *
 * @author user
 */
public class UseCaseTopUpBalance implements IUseCase<String, User> {

    private final RepositoryUser repositoryUser = new RepositoryUser();

    @Override
    public Either<Failure, User> call(String params) {
        try {
            long amount = Long.parseLong(params);

            User user = MovieApplication.USER;
            if (user != null) {
                // clone user object
                User newUser = new User(
                    user.getName(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getBalance() + amount
                );

                final var updateResult = this.repositoryUser.update(newUser);
                if (updateResult.isRight()) {
                    return Either.right(newUser);
                }
            }

            return Either.left(new Failure("Gagal melakukan top up saldo!"));
        } catch (NumberFormatException e) {
            return Either.left(new Failure("Nominal yang Anda masukkan tidak valid!"));
        }
    }

}
