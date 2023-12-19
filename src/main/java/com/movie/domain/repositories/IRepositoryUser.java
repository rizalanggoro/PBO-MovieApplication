/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.movie.domain.repositories;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.domain.models.User;
import java.util.List;

/**
 *
 * @author user
 */
public interface IRepositoryUser {

    public Either<Failure, Void> create(User user);

    public Either<Failure, List<User>> read();

    public Either<Failure, User> readByEmail(String email);

    public Either<Failure, Void> update(User user);
}
