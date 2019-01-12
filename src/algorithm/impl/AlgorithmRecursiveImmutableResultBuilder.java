/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import algorithm.AlgorithmRecursive;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public class AlgorithmRecursiveImmutableResultBuilder<D, R> {
    
    private Predicate<RecursiveNode<D>> executeIf;
    private Predicate<RecursiveNode<D>> finishIf;
    private BiFunction<D, R, R> toExecute;
    private int limitNumberIterations;
    private int endOfIterations;
    private final RecursiveNode<D> start;
    private final R result;

    AlgorithmRecursiveImmutableResultBuilder(RecursiveNode<D> start, R result) {
        this.start = start;
        this.result = result;
        this.executeIf = a -> true;
        this.finishIf = a -> false;
        this.limitNumberIterations = -1;
        this.endOfIterations = -1;
    }

    public AlgorithmRecursiveImmutableResultBuilder<D, R> finishIf(Predicate<RecursiveNode<D>> finishIf) {
        this.finishIf = finishIf;
        return this;
    }

    public AlgorithmRecursiveImmutableResultBuilder<D, R> executeIf(Predicate<RecursiveNode<D>> executeIf) {
        this.executeIf = executeIf;
        return this;
    }

    public AlgorithmRecursiveImmutableResultBuilder<D, R> toExecute(BiFunction<D, R, R> toExecute) {
        this.toExecute = toExecute;
        return this;
    }
    
    public AlgorithmRecursiveImmutableResultBuilder<D, R> limitNumberIterations(int limitNumberIterations) {
        this.limitNumberIterations = limitNumberIterations;
        return this;
    }
    
    public AlgorithmRecursiveImmutableResultBuilder<D, R> endPostIterations(int endOfIterations) {
        this.endOfIterations = endOfIterations;
        return this;
    }

    public AlgorithmRecursive<D, R> build() {
        AlgorithmRecursiveConfiguration<D> config = new AlgorithmRecursiveConfiguration.Builder<D>()
            .executeIf(executeIf)
            .finishIf(finishIf)
            .limitNumberIterations(limitNumberIterations)
            .endOfIterations(endOfIterations)
            .build();
        return new AlgorithmRecursiveImpl<>(start, config, ModifierResultRecursive.immutableResult(toExecute, result));
    }
}
