/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm.impl;

import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.jarmusik.kamil.algorithm.node.RecursiveNode;
import java.util.function.Predicate;

/**
 *
 * @author Kamil-Tomasz
 */
abstract class AbstractAlgorithmRecursiveBuilder<D, R> {

    private final RecursiveNode<D> start;
    private Predicate<RecursiveNode<D>> executeIf;
    private Predicate<RecursiveNode<D>> finishIf;
    private ModifierResultRecursive<D, R> modifier;
    private int limitNumberIterations;
    private int endPostIterations;

    AbstractAlgorithmRecursiveBuilder(RecursiveNode<D> start) {
        this.start = start;
        this.modifier = null;
        this.executeIf = a -> true;
        this.finishIf = a -> false;
        this.limitNumberIterations = -1;
        this.endPostIterations = -1;
    }

    public AbstractAlgorithmRecursiveBuilder<D, R> finishIf(Predicate<RecursiveNode<D>> finishIf) {
        this.finishIf = finishIf;
        return this;
    }

    public AbstractAlgorithmRecursiveBuilder<D, R> executeIf(Predicate<RecursiveNode<D>> executeIf) {
        this.executeIf = executeIf;
        return this;
    }

    public AbstractAlgorithmRecursiveBuilder<D, R> limitNumberIterations(int limitNumberIterations) {
        this.limitNumberIterations = limitNumberIterations;
        return this;
    }

    public AbstractAlgorithmRecursiveBuilder<D, R> endPostIterations(int endPostIterations) {
        this.endPostIterations = endPostIterations;
        return this;
    }
    
    public AbstractAlgorithmRecursiveBuilder<D, R> modifier(ModifierResultRecursive<D, R> modifier) {
        this.modifier = modifier;
        return this;
    }

    public AlgorithmRecursive<D, R> build() {
        if(modifier == null)
            throw new IllegalArgumentException();
        AlgorithmRecursiveConfiguration<D> config = new AlgorithmRecursiveConfiguration.Builder<D>()
            .executeIf(executeIf)
            .finishIf(finishIf)
            .limitNumberIterations(limitNumberIterations)
            .endPostIterations(endPostIterations)
            .build();
        return new AlgorithmRecursiveImpl<>(start, config, modifier);
    }
}
