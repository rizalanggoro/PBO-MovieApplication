/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.movie.domain.repositories;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.domain.models.Movie;
import java.util.List;

/**
 *
 * @author user
 */
public interface IRepositoryMovie {

    public Either<Failure, List<Movie>> readNowPlaying();

    public Either<Failure, List<Movie>> readUpcoming();
}
