/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.node.AlgorithmRecursiveNode;
import algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 * Deprecated method not safe for thread
 */
public interface AlgorithmRecursive<D, R> {
    @Deprecated
    void run();
    @Deprecated
    void changeStartAndRun(AlgorithmRecursiveNode<D> start);
    @Deprecated
    RecursiveResult<R> result();
    
    RecursiveResult<R> runAndResult();
    RecursiveResult<R> runAndResultForStart(AlgorithmRecursiveNode<D> start);
}
