/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.config.AlgorithmRecursiveConfiguration;
import algorithm.modifier.GenInstance;
import algorithm.modifier.ModifierResultRecursive;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import algorithm.node.NodeAlgorithmRecursive;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public class AlgorithmRecursiveMutableResultBuilder<D, R> {
    
    private final GenInstance<R> instanceGenerator;
    private final NodeAlgorithmRecursive<D> start;
    private Predicate<NodeAlgorithmRecursive<D>> executeIf;
    private Predicate<NodeAlgorithmRecursive<D>> finishIf;
    private BiConsumer<D, R> toExecute;
    private int limitNumberIterations;

    public AlgorithmRecursiveMutableResultBuilder(NodeAlgorithmRecursive<D> start, GenInstance<R> instanceGenerator) {
        this.start = start;
        this.instanceGenerator = instanceGenerator;
        this.executeIf = a -> true;
        this.finishIf = a -> false;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> finishIf(Predicate<NodeAlgorithmRecursive<D>> finishIf) {
        this.finishIf = finishIf;
        return this;
    }

    public AlgorithmRecursiveMutableResultBuilder<D, R> executeIf(Predicate<NodeAlgorithmRecursive<D>> executeIf) {
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

    public AlgorithmRecursive<D, R> build() {
        AlgorithmRecursiveConfiguration<D> config = new AlgorithmRecursiveConfiguration.Builder<D>()
            .executeIf(executeIf)
            .finishIf(finishIf)
            .limitNumberIterations(limitNumberIterations)
            .build();
        return new AlgorithmRecursiveImpl<>(start, config, ModifierResultRecursive.mutableResult(toExecute, instanceGenerator));
    }
}
