/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.movie.core;

/**
 *
 * @author user
 * @param <Params> parameter
 * @param <Result> result
 */
public interface IUseCase<Params, Result> {

    public Either<Failure, Result> call(Params params);
}
