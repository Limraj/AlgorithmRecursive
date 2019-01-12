/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.result.RecursiveResult;
import algorithm.node.RecursiveNode;

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
}
