/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.node;

import java.util.List;

/**
 *
 * @author kamil.jarmusik
 * @param <T>
 */
public interface NodeAlgorithm<T> {
    List<NodeAlgorithm<T>> nodes();
    T data();
}
