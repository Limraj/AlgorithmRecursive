/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.modifier.ResultRecursive;
import algorithm.node.NodeAlgorithm;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public interface AlgorithmRecursive<D, R> {
    void run();
    void changeStartAndRun(NodeAlgorithm<D> start);
    ResultRecursive<R> result();
}
