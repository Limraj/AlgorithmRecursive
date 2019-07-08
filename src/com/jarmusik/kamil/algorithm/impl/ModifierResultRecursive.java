/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm.impl;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import com.jarmusik.kamil.algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
interface ModifierResultRecursive<D, R> {
    void reset();
    void execute(D value);
    void incrementIterations();
    boolean hasBeenExceeded(int limit);
    boolean isEndOfIterations(int endOfIterations);
    RecursiveResult<R> snapshot();
    
    static <D, R> ModifierResultRecursive<D, R> mutableResult(BiConsumer<D, R> toExecute, Supplier<R> instanceGenerator) {
        return new MutableResultRecursive<>(toExecute, instanceGenerator);
    }
    
    static <D, R> ModifierResultRecursive<D, R> immutableResult(BiFunction<D, R, R> toExecute, R result) {
        return new ImmutableResultRecursive<>(toExecute, result);
    }
}
