/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import algorithm.node.NodeAlgorithmRecursive;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public interface ModifierResultRecursive<D, R> {
    void reset();
    void execute(D value);
    void incrementIteration();
    boolean hasBeenExceeded(int limit);
    ResultRecursive<R> snapshot();
    
    static <D, R> ModifierResultRecursive<D, R> mutableResult(BiConsumer<D, R> toExecute, GenInstance<R> instanceGenerator) {
        return new MutableResultRecursive<>(toExecute, instanceGenerator);
    }
    
    static <D, R> ModifierResultRecursive<D, R> immutableResult(BiFunction<D, R, R> toExecute, R result) {
        return new ImmutableResultRecursive<>(toExecute, result);
    }
}
