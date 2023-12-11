/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.movie.core;

/**
 *
 * @author user
 */
public class Either<L, R> {

    private final L left;
    private final R right;
    private final boolean isLeft;

    private Either(L left, R right, boolean isLeft) {
        this.left = left;
        this.right = right;
        this.isLeft = isLeft;
    }

    public static <A, B> Either<A, B> left(A value) {
        return new Either<>(value, null, true);
    }

    public static <A, B> Either<A, B> right(B value) {
        return new Either<>(null, value, false);
    }

    public boolean isLeft() {
        return isLeft;
    }

    public boolean isRight() {
        return !isLeft;
    }

    public L getLeft() {
        if (!isLeft) {
            throw new UnsupportedOperationException("Cannot getLeft() on a Right Either");
        }
        return left;
    }

    public R getRight() {
        if (isLeft) {
            throw new UnsupportedOperationException("Cannot getRight() on a Left Either");
        }
        return right;
    }
}
