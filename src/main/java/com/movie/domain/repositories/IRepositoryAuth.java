/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.movie.domain.repositories;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.domain.models.User;

/**
 *
 * @author user
 */
public interface IRepositoryAuth {

    public Either<Failure, Boolean> register(User user);

    public Either<Failure, Boolean> login(User user);

    public boolean logout();

    public Either<Failure, User> getSession();
}
