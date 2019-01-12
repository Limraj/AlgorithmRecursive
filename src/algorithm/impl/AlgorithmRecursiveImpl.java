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
import algorithm.node.AlgorithmRecursiveNode;
import algorithm.result.RecursiveResult;

/**
 *
 * @author kamil.jarmusik
 * @param <D>
 * @param <R>
 */
final class AlgorithmRecursiveImpl<D, R> implements AlgorithmRecursive<D, R> {
    
    private final AlgorithmRecursiveConfiguration<D> config;
    private final ModifierResultRecursive<D, R> modifier;
    private volatile AlgorithmRecursiveNode<D> start;
    
    AlgorithmRecursiveImpl(AlgorithmRecursiveNode<D> start, AlgorithmRecursiveConfiguration<D> config, ModifierResultRecursive<D, R> modifier) {
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
    public synchronized RecursiveResult<R> runAndResultForStart(AlgorithmRecursiveNode<D> start) {
        this.start = start;
        return runAndResult();
    }
    
    @Override
    public synchronized void changeStartAndRun(AlgorithmRecursiveNode<D> start) {
        runAndResultForStart(start);
    }
    
    @Override
    public synchronized RecursiveResult<R> result() {
        return modifier.snapshot();
    }
    
    @Override
    public synchronized void run() {
        runAndResult();
    }

    private boolean isEnd(AlgorithmRecursiveNode<D> node) {
        return isLeaf(node) || config.isFinish(node) || isEndOfIterations();
    }
    
    private static <T> boolean isLeaf(AlgorithmRecursiveNode<T> node) {
        List<AlgorithmRecursiveNode<T>> nodes = node.nodes();
        return nodes == null || nodes.isEmpty();
    }
    
    private void step(AlgorithmRecursiveNode<D> start) {
        modifier.incrementIterations();
        ifHasBeenExceededThenThrowException();
        forImpl(start);
    }
    
    private void foreachImpl(AlgorithmRecursiveNode<D> start) {
        for (AlgorithmRecursiveNode<D> node : start.nodes()) {
            if(config.isToExecute(node))
                modifier.execute(node.data());  
            if(!isEnd(node))
                step(node);
        }
    }
    
    private void forImpl(AlgorithmRecursiveNode<D> start) {
        List<AlgorithmRecursiveNode<D>> nodes = start.nodes();
        for (int i = 0; i < nodes.size(); i++) {
            AlgorithmRecursiveNode<D> node = nodes.get(i);
            if(config.isToExecute(node))
                modifier.execute(node.data());  
            if(!isEnd(node))
                step(node);
        }
    }
    
    private void sreamImpl(AlgorithmRecursiveNode<D> start) {
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
            throw new IterationLimitHasBeenExceededException(config.getLimitNumberIterations(), modifier.snapshot().getNumberIterations());
    }

    private boolean hasBeenExceeded() {
        return config.getLimitNumberIterations() > -1 && modifier.hasBeenExceeded(config.getLimitNumberIterations());
    }
    
    private boolean isEndOfIterations() {
        return config.getEndOfIterations() > -1 && modifier.isEndOfIterations(config.getEndOfIterations());
    }
}
