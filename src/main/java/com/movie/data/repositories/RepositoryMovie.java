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
import com.movie.domain.models.Movie;
import com.movie.domain.repositories.IRepositoryMovie;
import java.util.List;

/**
 *
 * @author user
 */
public class RepositoryMovie implements IRepositoryMovie {

    private final ProviderLocal providerLocal = new ProviderLocal();
    private final Gson gson = new Gson();

    private Either<Failure, List<Movie>> readMoviesByFilePath(
        String filePath
    ) {
        if (this.providerLocal.isFileExists(filePath)) {
            final var readResult = this.providerLocal.read(filePath);
            if (readResult.isRight()) {
                return Either.right(this.gson.fromJson(
                    readResult.getRight(),
                    new TypeToken<List<Movie>>() {
                    }.getType()
                ));
            }
        }

        return Either.left(new Failure("Gagal membaca data film!"));
    }

    @Override
    public Either<Failure, List<Movie>> readNowPlaying() {
        return readMoviesByFilePath("assets/json/nowplaying.json");
    }

    @Override
    public Either<Failure, List<Movie>> readUpcoming() {
        return readMoviesByFilePath("assets/json/upcoming.json");
    }
}
