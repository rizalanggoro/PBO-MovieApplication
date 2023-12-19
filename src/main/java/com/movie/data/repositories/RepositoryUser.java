/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.movie.data.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.data.providers.ProviderLocal;
import com.movie.domain.models.User;
import com.movie.domain.repositories.IRepositoryUser;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class RepositoryUser implements IRepositoryUser {

    private final ProviderLocal providerLocal = new ProviderLocal();
    private final Gson gson = new Gson();

    private final String filePathAccounts = "appdata/accounts.json";

    @Override
    public Either<Failure, Void> create(User user) {
        ArrayList<User> arrayListUsers = new ArrayList<>();
        if (this.providerLocal.isFileExists(this.filePathAccounts)) {
            final var readResult = this.providerLocal.read(this.filePathAccounts);
            if (readResult.isRight()) {
                arrayListUsers = this.gson.fromJson(
                    readResult.getRight(),
                    new TypeToken<ArrayList<User>>() {
                    }.getType()
                );
                arrayListUsers.add(user);
            } else {
                return Either.left(new Failure("Gagal menambahkan pengguna baru!"));
            }
        } else {
            arrayListUsers.add(user);
        }

        return this.providerLocal.create(
            this.filePathAccounts,
            this.gson.toJson(arrayListUsers)
        );
    }

    @Override
    public Either<Failure, List<User>> read() {
        List<User> result = new ArrayList<>();

        if (this.providerLocal.isFileExists(this.filePathAccounts)) {
            var readResult = this.providerLocal.read(this.filePathAccounts);
            if (readResult.isRight()) {
                result = this.gson.fromJson(readResult.getRight(), new TypeToken<List<User>>() {
                }.getType());
            }
        }

        return Either.right(result);
    }

    @Override
    public Either<Failure, User> readByEmail(String email) {
        final var readResult = read();
        if (readResult.isRight()) {
            User user = readResult.getRight().stream().filter((item)
                -> item.getEmail().equalsIgnoreCase(email)
            ).findFirst().orElse(null);

            if (user != null) {
                return Either.right(user);
            }
        }

        return Either.left(new Failure("Data pengguna tidak ditemukan!"));
    }

    @Override
    public Either<Failure, Void> update(User newUser) {
        final var readResult = this.read();
        if (readResult.isRight()) {
            final ArrayList<User> listUser = new ArrayList<>();
            listUser.addAll(readResult.getRight());

            int index = -1;
            for (int a = 0; a < listUser.size(); a++) {
                final User user = listUser.get(a);
                if (user.getEmail().equalsIgnoreCase(newUser.getEmail())) {
                    index = a;
                    break;
                }
            }

            if (index != -1) {
                listUser.set(index, newUser);
                final var writeResult = this.providerLocal.create(
                    this.filePathAccounts,
                    this.gson.toJson(listUser)
                );

                if (writeResult.isRight()) {
                    return Either.right(null);
                }
            }
        }

        return Either.left(new Failure("Gagal memperbarui data pengguna!"));
    }

}
