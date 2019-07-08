/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.algorithm.result;

/**
 *
 * @author Kamil-Tomasz
 * @param <T>
 */
public interface RecursiveResult<T> {
    T getValue();
    long getNumberIterations();

    static <T> RecursiveResult<T> newInstance(T value, long numberIteration) {
        return new RecursiveResultImpl<>(value, numberIteration);
    }
}
