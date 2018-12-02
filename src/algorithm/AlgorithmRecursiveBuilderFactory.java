/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.modifier.GenInstance;
import java.util.ArrayList;
import java.util.List;
import algorithm.node.NodeAlgorithmRecursive;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveBuilderFactory {
    
    public static <D, R> AlgorithmRecursiveImmutableResultBuilder<D, R> immutableResult(NodeAlgorithmRecursive<D> start, R result) {
        return new AlgorithmRecursiveImmutableResultBuilder<>(start, result);
    }
    
    public static <D, R> AlgorithmRecursiveMutableResultBuilder<D, R> mutableResult(NodeAlgorithmRecursive<D> start, GenInstance<R> instanceGenerator) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, instanceGenerator);
    }
    
    public static <D> AlgorithmRecursiveMutableResultBuilder<D, List<D>> aggregateResult(NodeAlgorithmRecursive<D> start) {
        return new AlgorithmRecursiveMutableResultBuilder<>(start, () -> new ArrayList<>());
    }
}
