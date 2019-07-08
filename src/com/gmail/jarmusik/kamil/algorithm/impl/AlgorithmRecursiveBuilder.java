/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.algorithm.impl;

import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author Kamil-Tomasz
 */
@Deprecated
public class AlgorithmRecursiveBuilder {
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
