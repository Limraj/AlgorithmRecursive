/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import algorithm.AlgorithmRecursive;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import algorithm.node.AlgorithmRecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public class AlgorithmRecursiveMutableResultBuilder<D, R> {
    
    private final Supplier<R> instanceGenerator;
    private final AlgorithmRecursiveNode<D> start;
    private Predicate<AlgorithmRecursiveNode<D>> executeIf;
    private Predicate<AlgorithmRecursiveNode<D>> finishIf;
    private BiConsumer<D, R> toExecute;
    private int limitNumberIterations;
    private int endOfIterations;

    AlgorithmRecursiveMutableResultBuilder(AlgorithmRecursiveNode<D> start, Supplier<R> instanceGenerator) {
        this.start = start;
        this.instanceGenerator = instanceGenerator;
        this.executeIf = a -> true;
        this.finishIf = a -> false;
        this.limitNumberIterations = -1;
        this.endOfIterations = -1;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> finishIf(Predicate<AlgorithmRecursiveNode<D>> finishIf) {
        this.finishIf = finishIf;
        return this;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> executeIf(Predicate<AlgorithmRecursiveNode<D>> executeIf) {
        this.executeIf = executeIf;
        return this;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> toExecute(BiConsumer<D, R> toExecute) {
        this.toExecute = toExecute;
        return this;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> limitNumberIterations(int limitNumberIterations) {
        this.limitNumberIterations = limitNumberIterations;
        return this;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> endOfIterations(int endOfIterations) {
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
        return new AlgorithmRecursiveImpl<>(start, config, ModifierResultRecursive.mutableResult(toExecute, instanceGenerator));
    }
}
