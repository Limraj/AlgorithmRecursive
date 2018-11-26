/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.config.AlgorithmRecursiveConfiguration;
import algorithm.exception.IterationLimitHasBeenExceededException;
import algorithm.modifier.ModifierResultRecursive;
import algorithm.modifier.ResultRecursive;
import java.util.ArrayList;
import java.util.List;
import algorithm.node.NodeAlgorithm;

/**
 *
 * @author kamil.jarmusik
 * @param <D>
 * @param <R>
 */
public final class AlgorithmRecursive<D, R> {
    
    private final AlgorithmRecursiveConfiguration<D> config;
    private final ModifierResultRecursive<D, R> modifier;

    public AlgorithmRecursive(AlgorithmRecursiveConfiguration<D> config, ModifierResultRecursive<D, R> modifier) {
        this.config = config;
        this.modifier = modifier;
        run();
    }

    public static <D, R> AlgorithmRecursiveImmutableResultBuilder<D, R> immutableResultBuilder(NodeAlgorithm<D> start, R result) {
        return new AlgorithmRecursiveImmutableResultBuilder<>(start, result);
    }
    
    public static <D, R> AlgorithmRecursiveMutableResultBuilder<D, R> mutableResultBuilder(NodeAlgorithm<D> start, R result) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, result);
    }
    
    public static <D> AlgorithmRecursiveMutableResultBuilder<D, List<D>> aggregateResultBuilder(NodeAlgorithm<D> start) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, new ArrayList<>());
    }
    
    public ResultRecursive<R> result() {
        return modifier.snapshot();
    }
    
    private void run() {
        if(config.isToExecute(config.getStart()))
            modifier.execute(config.getStart().data());
        if(isEnd(config.getStart()))
            return;
        execute(config.getStart());
    }
    
    private boolean isEnd(NodeAlgorithm<D> node) {
        return isLeaf(node) || (config.isFinish(node));
    }
    
    private static <T> boolean isLeaf(NodeAlgorithm<T> node) {
        List<NodeAlgorithm<T>> nodes = node.nodes();
        return nodes == null || nodes.isEmpty();
    }
    
    private void execute(NodeAlgorithm<D> start) {
        modifier.incrementIteration();
        ifHasBeenExceededThenThrowException();
        start.nodes().stream().map(node -> {
            if(config.isToExecute(node))
                modifier.execute(node.data());
            return node;
        }).filter(node -> !isEnd(node)).forEachOrdered(node -> {
            execute(node);
        }); 
    }

    private void ifHasBeenExceededThenThrowException() {
        if(hasBeenExceeded())
            throw new IterationLimitHasBeenExceededException(config.getLimitNumberIterations(), modifier.snapshot().getNumberIteration());
    }

    private boolean hasBeenExceeded() {
        return config.getLimitNumberIterations() > 0 && modifier.hasBeenExceeded(config.getLimitNumberIterations());
    }
}
