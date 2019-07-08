/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm;

import com.jarmusik.kamil.algorithm.impl.AlgorithmRecursiveImmutableResultBuilder;
import com.jarmusik.kamil.algorithm.impl.AlgorithmRecursiveMutableResultBuilder;
import com.jarmusik.kamil.algorithm.result.RecursiveResult;
import com.jarmusik.kamil.algorithm.node.RecursiveNode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 * Deprecated method not safe for thread
 */
public interface AlgorithmRecursive<D, R> {
    RecursiveResult<R> runAndResult();
    RecursiveResult<R> runAndResultForStart(RecursiveNode<D> start);
    
    static <D, R> AlgorithmRecursiveImmutableResultBuilder<D, R> immutableResult(RecursiveNode<D> start, R result) {
        return new AlgorithmRecursiveImmutableResultBuilder<>(start, result);
    }
    
    static <D, R> AlgorithmRecursiveMutableResultBuilder<D, R> mutableResult(RecursiveNode<D> start, Supplier<R> instanceGenerator) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, instanceGenerator);
    }
    
    static <D> AlgorithmRecursiveMutableResultBuilder<D, List<D>> aggregateResult(RecursiveNode<D> start) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, () -> new ArrayList<>());
    }
}
