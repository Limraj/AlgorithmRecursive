/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.config.AlgorithmRecursiveConfiguration;
import algorithm.modifier.ModifierResultRecursive;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import algorithm.node.NodeAlgorithm;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public class AlgorithmRecursiveImmutableResultBuilder<D, R> {
    
    private Predicate<NodeAlgorithm<D>> executeIf;
    private Predicate<NodeAlgorithm<D>> finishIf;
    private BiFunction<D, R, R> toExecute;
    private int limitNumberIterations;
    private final NodeAlgorithm<D> start;
    private final R result;

    public AlgorithmRecursiveImmutableResultBuilder(NodeAlgorithm<D> start, R result) {
        this.start = start;
        this.result = result;
    }

    public AlgorithmRecursiveImmutableResultBuilder<D, R> finishIf(Predicate<NodeAlgorithm<D>> finishIf) {
        this.finishIf = finishIf;
        return this;
    }

    public AlgorithmRecursiveImmutableResultBuilder<D, R> executeIf(Predicate<NodeAlgorithm<D>> executeIf) {
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

    public AlgorithmRecursive<D, R> build() {
        AlgorithmRecursiveConfiguration<D> config = new AlgorithmRecursiveConfiguration.Builder<D>()
            .executeIf(executeIf)
            .finishIf(finishIf)
            .limitNumberIterations(limitNumberIterations)
            .build();
        return new AlgorithmRecursiveImpl<>(start, config, ModifierResultRecursive.immutableResultRecursive(toExecute, result));
    }
}
