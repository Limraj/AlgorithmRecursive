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
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import algorithm.node.NodeAlgorithmRecursive;
import java.util.Iterator;

/**
 *
 * @author kamil.jarmusik
 * @param <D>
 * @param <R>
 */
final class AlgorithmRecursiveImpl<D, R> implements AlgorithmRecursive<D, R> {
    
    private final AlgorithmRecursiveConfiguration<D> config;
    private final ModifierResultRecursive<D, R> modifier;
    private NodeAlgorithmRecursive<D> start;

    AlgorithmRecursiveImpl(NodeAlgorithmRecursive<D> start, AlgorithmRecursiveConfiguration<D> config, ModifierResultRecursive<D, R> modifier) {
        this.config = config;
        this.modifier = modifier;
        this.start = start;
    }
    
    @Override
    public void changeStartAndRun(NodeAlgorithmRecursive<D> start) {
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

    private boolean isEnd(NodeAlgorithmRecursive<D> node) {
        return isLeaf(node) || config.isFinish(node);
    }
    
    private static <T> boolean isLeaf(NodeAlgorithmRecursive<T> node) {
        List<NodeAlgorithmRecursive<T>> nodes = node.nodes();
        return nodes == null || nodes.isEmpty();
    }
    
    private void step(NodeAlgorithmRecursive<D> start) {
        modifier.incrementIteration();
        ifHasBeenExceededThenThrowException();
        for (NodeAlgorithmRecursive<D> node : start.nodes()) {
            if(config.isToExecute(node))
                modifier.execute(node.data());  
            if(!isEnd(node))
                step(node);
        }
    }

    private void ifHasBeenExceededThenThrowException() {
        if(hasBeenExceeded())
            throw new IterationLimitHasBeenExceededException(config.getLimitNumberIterations(), modifier.snapshot().getNumberIteration());
    }

    private boolean hasBeenExceeded() {
        return config.getLimitNumberIterations() > 0 && modifier.hasBeenExceeded(config.getLimitNumberIterations());
    }
}
