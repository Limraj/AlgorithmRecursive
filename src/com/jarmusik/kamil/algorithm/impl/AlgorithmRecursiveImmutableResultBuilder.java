/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm.impl;

import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import com.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public class AlgorithmRecursiveImmutableResultBuilder<D, R> extends AbstractAlgorithmRecursiveBuilder<D, R> {
    
    private final R result;
    private BiFunction<D, R, R> toExecute;
    
    public AlgorithmRecursiveImmutableResultBuilder(RecursiveNode<D> start, R result) {
        super(start);
        this.result = result;
    }
    
    public AlgorithmRecursiveImmutableResultBuilder<D, R> toExecute(BiFunction<D, R, R> toExecute) {
        this.toExecute = toExecute;
        return this;
    }
    
    @Override
    public AlgorithmRecursiveImmutableResultBuilder<D, R> finishIf(Predicate<RecursiveNode<D>> finishIf) {
        super.finishIf(finishIf);
        return this;
    }

    @Override
    public AlgorithmRecursiveImmutableResultBuilder<D, R> executeIf(Predicate<RecursiveNode<D>> executeIf) {
        super.executeIf(executeIf);
        return this;
    }

    @Override
    public AlgorithmRecursiveImmutableResultBuilder<D, R> limitNumberIterations(int limitNumberIterations) {
        super.limitNumberIterations(limitNumberIterations);
        return this;
    }

    @Override
    public AlgorithmRecursiveImmutableResultBuilder<D, R> endPostIterations(int endPostIterations) {
        super.endPostIterations(endPostIterations);
        return this;
    }

    @Override
    public AlgorithmRecursive<D, R> build() {
        super.modifier(ModifierResultRecursive.immutableResult(toExecute, result));
        return super.build();
    }
}
