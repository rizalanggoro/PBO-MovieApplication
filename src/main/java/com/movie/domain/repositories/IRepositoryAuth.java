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

    public Either<Failure, Void> createSession(User user);

    public Either<Failure, User> getSession();

    public Either<Failure, Void> deleteSession();
}
