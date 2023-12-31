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
import com.movie.domain.models.Ticket;
import com.movie.domain.repositories.IRepositoryTicket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class RepositoryTicket implements IRepositoryTicket {

    private final ProviderLocal providerLocal = new ProviderLocal();
    private final Gson gson = new Gson();
    private final String directory = "appdata/tickets/";
    private final String soldDirectory = directory + "sold/";

    @Override
    public Either<Failure, Void> create(String userEmail, Ticket ticket) {
        final String filePath = this.directory + userEmail + ".json";
        if (this.providerLocal.isFileExists(filePath)) {
            final var readResult = this.providerLocal.read(filePath);
            if (readResult.isRight()) {
                final ArrayList<Ticket> tickets = this.gson.fromJson(
                    readResult.getRight(),
                    new TypeToken<ArrayList<Ticket>>() {
                    }.getType()
                );
                tickets.add(ticket);

                // save
                final var createResult = this.providerLocal.create(
                    filePath,
                    this.gson.toJson(tickets)
                );

                if (createResult.isRight()) {
                    return Either.right(null);
                }
            }

        } else {
            final ArrayList<Ticket> tickets = new ArrayList<>();
            tickets.add(ticket);

            final var createResult = this.providerLocal.create(
                filePath,
                this.gson.toJson(tickets)
            );

            if (createResult.isRight()) {
                return Either.right(null);
            }
        }

        return Either.left(new Failure("Gagal menambahkan tiket!"));
    }

    @Override
    public Either<Failure, Void> createSold(Ticket ticket) {
        final String filePath = this.soldDirectory + ticket.getMovieTitle() + "-"
            + ticket.getCinema() + "-"
            + ticket.getTheater() + "-"
            + ticket.getSession() + ".json";

        ArrayList<String> arrayListSeats = new ArrayList<>();
        if (this.providerLocal.isFileExists(filePath)) {
            final var readResult = this.providerLocal.read(filePath);
            if (readResult.isRight()) {
                arrayListSeats = this.gson.fromJson(
                    readResult.getRight(),
                    new TypeToken<ArrayList<String>>() {
                    }.getType()
                );
            }
        }

        arrayListSeats.addAll(ticket.getSeat());

        // save to file
        return this.providerLocal.create(
            filePath,
            this.gson.toJson(arrayListSeats)
        );
    }

    @Override
    public Either<Failure, List<Ticket>> read(String userEmail) {
        List<Ticket> result = new ArrayList<>();

        final var readResult = this.providerLocal.read(this.directory + userEmail + ".json");
        if (readResult.isRight()) {
            result = this.gson.fromJson(
                readResult.getRight(),
                new TypeToken<List<Ticket>>() {
                }.getType()
            );
        }

        return Either.right(result);
    }

    @Override
    public Either<Failure, List<String>> readSold(
        String movieTitle,
        String cinema,
        String theater,
        String session
    ) {
        final String filePath = this.soldDirectory + movieTitle + "-"
            + cinema + "-"
            + theater + "-"
            + session + ".json";

        List<String> result = new ArrayList<>();
        final var readResult = this.providerLocal.read(filePath);
        if (readResult.isRight()) {
            result = this.gson.fromJson(
                readResult.getRight(),
                new TypeToken<List<String>>() {
                }.getType()
            );
        }

        return Either.right(result);
    }
}
