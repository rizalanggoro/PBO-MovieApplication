/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.domain.usecases;

import com.movie.core.Either;
import com.movie.core.Failure;
import com.movie.core.IUseCase;
import com.movie.data.repositories.RepositoryAuth;

/**
 *
 * @author user
 */
public class UseCaseAuthLogout implements IUseCase<Void, Void> {

    private final RepositoryAuth repositoryAuth = new RepositoryAuth();

    @Override
    public Either<Failure, Void> call(Void params) {
        return this.repositoryAuth.deleteSession();
    }

}
