/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.algorithm.impl;

import com.gmail.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.gmail.jarmusik.kamil.algorithm.exception.IterationLimitHasBeenExceededException;
import java.util.List;
import com.gmail.jarmusik.kamil.algorithm.result.RecursiveResult;
import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author kamil.jarmusik
 * @param <D>
 * @param <R>
 */
final class AlgorithmRecursiveImpl<D, R> implements AlgorithmRecursive<D, R> {
    
    private final AlgorithmRecursiveConfiguration<D> config;
    private final ModifierResultRecursive<D, R> modifier;
    private final RecursiveNode<D> start;
    
    AlgorithmRecursiveImpl(RecursiveNode<D> start, AlgorithmRecursiveConfiguration<D> config, ModifierResultRecursive<D, R> modifier) {
        this.config = config;
        this.modifier = modifier;
        this.start = start;
    }
    
    @Override
    public RecursiveResult<R> runAndResult() {
        return _runAndResult(start);
    }

    @Override
    public RecursiveResult<R> runAndResultForStart(RecursiveNode<D> start) {
        return _runAndResult(start);
    }
        
    private synchronized RecursiveResult<R> _runAndResult(RecursiveNode<D> node) {
        modifier.reset();
        modifier.incrementIterations();
        if(config.isToExecute(node))
            modifier.execute(node.data());
        if(_isEnd(node))
            return modifier.snapshot();
        _step(node);
        return modifier.snapshot();
    }
    
    private boolean _isEnd(RecursiveNode<D> node) {
        return _isLeaf(node) || config.isFinish(node) || _isEndOfIterations();
    }
    
    private void _step(RecursiveNode<D> start) {
        modifier.incrementIterations();
        _ifHasBeenExceededThenThrowException();
        List<RecursiveNode<D>> nodes = start.nodes();
        for (int i = 0; i < nodes.size(); i++) {
            RecursiveNode<D> node = nodes.get(i);
            if(config.isToExecute(node))
                modifier.execute(node.data());  
            if(!_isEnd(node))
                _step(node);
        }
    }
    
    private static <T> boolean _isLeaf(RecursiveNode<T> node) {
        List<RecursiveNode<T>> nodes = node.nodes();
        return nodes == null || nodes.isEmpty();
    }
           
    private boolean _isEndOfIterations() {
        return config.getEndPostIterations() > -1 && modifier.isEndOfIterations(config.getEndPostIterations());
    }

    private void _ifHasBeenExceededThenThrowException() {
        if(_hasBeenExceeded())
            throw new IterationLimitHasBeenExceededException(config.getLimitNumberIterations(), modifier.snapshot().getNumberIterations());
    }

    private boolean _hasBeenExceeded() {
        return config.getLimitNumberIterations() > -1 && modifier.hasBeenExceeded(config.getLimitNumberIterations());
    }
}
