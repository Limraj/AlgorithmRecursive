/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveBuilder {
    
    public static <D, R> AlgorithmRecursiveImmutableResultBuilder<D, R> immutableResult(RecursiveNode<D> start, R result) {
        return new AlgorithmRecursiveImmutableResultBuilder<>(start, result);
    }
    
    public static <D, R> AlgorithmRecursiveMutableResultBuilder<D, R> mutableResult(RecursiveNode<D> start, Supplier<R> instanceGenerator) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, instanceGenerator);
    }
    
    public static <D> AlgorithmRecursiveMutableResultBuilder<D, List<D>> aggregateResult(RecursiveNode<D> start) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, () -> new ArrayList<>());
    }
}
