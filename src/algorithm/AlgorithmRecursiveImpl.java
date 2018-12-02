/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.config.AlgorithmRecursiveConfiguration;
import algorithm.exception.IterationLimitHasBeenExceededException;
import algorithm.modifier.GenInstance;
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
final class AlgorithmRecursiveImpl<D, R> implements AlgorithmRecursive<D, R> {
    
    private final AlgorithmRecursiveConfiguration<D> config;
    private final ModifierResultRecursive<D, R> modifier;
    private NodeAlgorithm<D> start;

    AlgorithmRecursiveImpl(NodeAlgorithm<D> start, AlgorithmRecursiveConfiguration<D> config, ModifierResultRecursive<D, R> modifier) {
        this.config = config;
        this.modifier = modifier;
        this.start = start;
    }
    
    @Override
    public void changeStartAndRun(NodeAlgorithm<D> start) {
        this.start = start;
        run();
    }
    
    @Override
    public ResultRecursive<R> result() {
        return modifier.snapshot();
    }
    
    @Override
    public void run() {
        modifier.reset();
        modifier.incrementIteration();
        if(config.isToExecute(start))
            modifier.execute(start.data());
        if(isEnd(start))
            return;
        step(start);
    }

    private boolean isEnd(NodeAlgorithm<D> node) {
        return isLeaf(node) || config.isFinish(node);
    }
    
    private static <T> boolean isLeaf(NodeAlgorithm<T> node) {
        List<NodeAlgorithm<T>> nodes = node.nodes();
        return nodes == null || nodes.isEmpty();
    }
    
    private void step(NodeAlgorithm<D> start) {
        modifier.incrementIteration();
        ifHasBeenExceededThenThrowException();
        start.nodes().stream().map(node -> {
            if(config.isToExecute(node))
                modifier.execute(node.data());
            return node;
        }).filter(node -> !isEnd(node)).forEachOrdered(node -> {
            step(node);
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
