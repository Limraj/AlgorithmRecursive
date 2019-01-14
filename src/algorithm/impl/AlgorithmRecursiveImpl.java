/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import algorithm.AlgorithmRecursive;
import algorithm.exception.IterationLimitHasBeenExceededException;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import algorithm.result.RecursiveResult;
import algorithm.node.RecursiveNode;

/**
 *
 * @author kamil.jarmusik
 * @param <D>
 * @param <R>
 */
final class AlgorithmRecursiveImpl<D, R> implements AlgorithmRecursive<D, R> {
    
    private final AlgorithmRecursiveConfiguration<D> config;
    private final ModifierResultRecursive<D, R> modifier;
    private RecursiveNode<D> start;
    
    AlgorithmRecursiveImpl(RecursiveNode<D> start, AlgorithmRecursiveConfiguration<D> config, ModifierResultRecursive<D, R> modifier) {
        this.config = config;
        this.modifier = modifier;
        this.start = start;
    }
    
    @Override
    public synchronized RecursiveResult<R> runAndResult() {
        modifier.reset();
        modifier.incrementIterations();
        if(config.isToExecute(start))
            modifier.execute(start.data());
        if(isEnd(start))
            return modifier.snapshot();
        step(start);
        return modifier.snapshot();
    }

    @Override
    public synchronized RecursiveResult<R> runAndResultForStart(RecursiveNode<D> start) {
        this.start = start;
        return runAndResult();
    }
    
    private boolean isEnd(RecursiveNode<D> node) {
        return isLeaf(node) || config.isFinish(node) || isEndOfIterations();
    }
    
    private static <T> boolean isLeaf(RecursiveNode<T> node) {
        List<RecursiveNode<T>> nodes = node.nodes();
        return nodes == null || nodes.isEmpty();
    }
    
    private void step(RecursiveNode<D> start) {
        modifier.incrementIterations();
        ifHasBeenExceededThenThrowException();
        List<RecursiveNode<D>> nodes = start.nodes();
        for (int i = 0; i < nodes.size(); i++) {
            RecursiveNode<D> node = nodes.get(i);
            if(config.isToExecute(node))
                modifier.execute(node.data());  
            if(!isEnd(node))
                step(node);
        }
    }

    private void ifHasBeenExceededThenThrowException() {
        if(hasBeenExceeded())
            throw new IterationLimitHasBeenExceededException(config.getLimitNumberIterations(), modifier.snapshot().getNumberIterations());
    }

    private boolean hasBeenExceeded() {
        return config.getLimitNumberIterations() > -1 && modifier.hasBeenExceeded(config.getLimitNumberIterations());
    }
    
    private boolean isEndOfIterations() {
        return config.getEndOfIterations() > -1 && modifier.isEndOfIterations(config.getEndOfIterations());
    }
}
