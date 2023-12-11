/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.data.sources;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.data.providers.ProviderLocal;
import com.movie.domain.models.Movie;
import java.util.List;

/**
 *
 * @author user
 */
public class SourceMovie {

    private final ProviderLocal providerLocal = new ProviderLocal();
    private final Gson gson = new Gson();

    public Either<Failure, List<Movie>> readNowPlaying() {
        var readResult = this.providerLocal.read("assets/json/nowplaying.json");
        if (readResult.isLeft()) {
            return Either.left(readResult.getLeft());
        }

        try {
            return Either.right(this.gson.fromJson(
                readResult.getRight(),
                new TypeToken<List<Movie>>() {
                }.getType()
            ));
        } catch (JsonSyntaxException e) {
            return Either.left(new Failure(e.getMessage()));
        }
    }

    public Either<Failure, List<Movie>> readUpcoming() {
        var readJsonResult = this.providerLocal.read("assets/json/upcoming.json");
        if (readJsonResult.isLeft()) {
            return Either.left(readJsonResult.getLeft());
        }

        try {
            return Either.right(this.gson.fromJson(
                readJsonResult.getRight(),
                new TypeToken<List<Movie>>() {
                }.getType()
            ));
        } catch (JsonSyntaxException e) {
            return Either.left(new Failure(e.getMessage()));
        }
    }

}
