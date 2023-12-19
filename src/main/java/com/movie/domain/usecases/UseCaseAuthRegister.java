/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.core.Utils;
import com.movie.data.repositories.RepositoryUser;
import com.movie.domain.models.User;

/**
 *
 * @author user
 */
public class UseCaseAuthRegister implements IUseCase<User, Void> {

    private final RepositoryUser repositoryUser = new RepositoryUser();

    @Override
    public Either<Failure, Void> call(User user) {
        // validation
        if (user.getName().isEmpty()) {
            return Either.left(new Failure("Nama pengguna tidak boleh kosong!"));
        }

        if (user.getEmail().isEmpty() || !Utils.Format.isValidEmail(user.getEmail())) {
            return Either.left(new Failure("Alamat email tidak valid!"));
        }

        if (user.getPassword().isEmpty()) {
            return Either.left(new Failure("Kata sandi tidak boleh kosong!"));
        }

        final var readUserByEmailResult = this.repositoryUser.readByEmail(user.getEmail());
        if (readUserByEmailResult.isRight()) {
            return Either.left(new Failure("Alamat email telah didaftarkan!"));
        }

        final var createUserResult = this.repositoryUser.create(user);
        if (createUserResult.isRight()) {
            return Either.right(null);
        }

        return Either.left(new Failure("Gagal melakukan pendaftaran pengguna!"));

    }

}
