/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.core.Utils;
import com.movie.data.repositories.RepositoryAuth;
import com.movie.data.repositories.RepositoryUser;
import com.movie.domain.models.User;

/**
 *
 * @author user
 */
public class UseCaseAuthLogin implements IUseCase<User, Void> {

    private final RepositoryUser repositoryUser = new RepositoryUser();
    private final RepositoryAuth repositoryAuth = new RepositoryAuth();

    @Override
    public Either<Failure, Void> call(User user) {
        if (user.getEmail().isEmpty() || !Utils.Format.isValidEmail(user.getEmail())) {
            return Either.left(new Failure("Alamat email tidak valid!"));
        }

        if (user.getPassword().isEmpty()) {
            return Either.left(new Failure("Kata sandi tidak boleh kosong!"));
        }

        final var readUserByEmailResult = this.repositoryUser.readByEmail(user.getEmail());
        if (readUserByEmailResult.isRight()) {
            if (readUserByEmailResult.getRight().getPassword().equalsIgnoreCase(user.getPassword())) {
                // save session
                return this.repositoryAuth.createSession(user);
            } else {
                return Either.left(new Failure("Kata sandi tidak cocok!"));
            }
        }

        return Either.left(new Failure("Pengguna tidak ditemukan!"));
    }

}
