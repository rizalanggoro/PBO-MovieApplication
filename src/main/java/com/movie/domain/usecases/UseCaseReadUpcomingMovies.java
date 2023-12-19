/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.data.repositories.RepositoryMovie;
import com.movie.domain.models.Movie;
import java.util.List;

/**
 *
 * @author user
 */
public class UseCaseReadUpcomingMovies implements IUseCase<Void, List<Movie>> {

    private final RepositoryMovie repositoryMovie = new RepositoryMovie();

    @Override
    public Either<Failure, List<Movie>> call(Void params) {
        return this.repositoryMovie.readUpcoming();
    }

}
