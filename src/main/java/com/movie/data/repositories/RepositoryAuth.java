/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.data.repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.data.providers.ProviderLocal;
import com.movie.domain.models.Session;
import com.movie.domain.models.User;
import com.movie.domain.repositories.IRepositoryAuth;
import java.util.List;

/**
 * @author user
 */
public class RepositoryAuth implements IRepositoryAuth {

    private final ProviderLocal providerLocal = new ProviderLocal();
    private final String filePathAccounts = "appdata/accounts.json";
    private final String filePathSession = "appdata/session.json";

    private final Gson gson = new Gson();

    @Override
    public Either<Failure, Void> createSession(User user) {
        final Session session = new Session(user.getEmail());
        return this.providerLocal.create(
            this.filePathSession,
            this.gson.toJson(session)
        );
    }

    @Override
    public Either<Failure, User> getSession() {
        if (this.providerLocal.isFileExists(this.filePathSession)) {
            var readSessionResult = this.providerLocal.read(this.filePathSession);
            if (readSessionResult.isLeft()) {
                return Either.left(readSessionResult.getLeft());
            }

            Session session = this.gson.fromJson(
                readSessionResult.getRight(),
                new TypeToken<Session>() {
                }.getType()
            );

            // get user by session
            var readAccountsResult = this.providerLocal.read(this.filePathAccounts);
            if (readAccountsResult.isLeft()) {
                return Either.left(readAccountsResult.getLeft());
            }

            List<User> users = this.gson.fromJson(
                readAccountsResult.getRight(),
                new TypeToken<List<User>>() {
                }.getType()
            );

            final User userFound = users.stream().filter((item) -> {
                return item.getEmail().equalsIgnoreCase(session.getEmail());
            }).findFirst().orElse(null);

            if (userFound != null) {
                return Either.right(userFound);
            } else {
                return Either.left(new Failure("unauthenticated"));
            }
        } else {
            return Either.left(new Failure("unauthenticated"));
        }
    }

    @Override
    public Either<Failure, Void> deleteSession() {
        final boolean result = this.providerLocal.delete(this.filePathSession);
        if (result) {
            return Either.right(null);
        } else {
            return Either.left(new Failure("Gagal menghapus sesi pengguna!"));
        }
    }

}
