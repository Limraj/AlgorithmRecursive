/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.modifier.GenInstance;
import algorithm.node.NodeAlgorithm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveFactory {
    
    public static <D, R> AlgorithmRecursiveImmutableResultBuilder<D, R> immutableResult(NodeAlgorithm<D> start, R result) {
        return new AlgorithmRecursiveImmutableResultBuilder<>(start, result);
    }
    
    public static <D, R> AlgorithmRecursiveMutableResultBuilder<D, R> mutableResult(NodeAlgorithm<D> start, GenInstance<R> instanceGenerator) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, instanceGenerator);
    }
    
    public static <D> AlgorithmRecursiveMutableResultBuilder<D, List<D>> aggregateResult(NodeAlgorithm<D> start) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, () -> new ArrayList<>());
    }
}
