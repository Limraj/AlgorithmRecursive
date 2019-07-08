/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm.impl;

import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import com.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public class AlgorithmRecursiveMutableResultBuilder<D, R> extends AbstractAlgorithmRecursiveBuilder<D, R> {

    private final Supplier<R> instanceGenerator;
    private BiConsumer<D, R> toExecute;
    
    public AlgorithmRecursiveMutableResultBuilder(RecursiveNode<D> start, Supplier<R> instanceGenerator) {
        super(start);
        this.instanceGenerator = instanceGenerator;
    }
    
    public AlgorithmRecursiveMutableResultBuilder<D, R> toExecute(BiConsumer<D, R> toExecute) {
        this.toExecute = toExecute;
        return this;
    }
    
    @Override
    public AlgorithmRecursiveMutableResultBuilder<D, R> finishIf(Predicate<RecursiveNode<D>> finishIf) {
        super.finishIf(finishIf);
        return this;
    }

    @Override
    public AlgorithmRecursiveMutableResultBuilder<D, R> executeIf(Predicate<RecursiveNode<D>> executeIf) {
        super.executeIf(executeIf);
        return this;
    }

    @Override
    public AlgorithmRecursiveMutableResultBuilder<D, R> limitNumberIterations(int limitNumberIterations) {
        super.limitNumberIterations(limitNumberIterations);
        return this;
    }

    @Override
    public AlgorithmRecursiveMutableResultBuilder<D, R> endPostIterations(int endPostIterations) {
        super.endPostIterations(endPostIterations);
        return this;
    }

    @Override
    public AlgorithmRecursive<D, R> build() {
        super.modifier(ModifierResultRecursive.mutableResult(toExecute, instanceGenerator));
        return super.build();
    }
}
