/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
    
    static <D, R> ModifierResultRecursive<D, R> mutableResultRecursive(GenInstance<R> instanceGenerator, BiConsumer<D, R> toExecute) {
        return new MutableResultRecursive<>(instanceGenerator, toExecute);
    }
    
    static <D, R> ModifierResultRecursive<D, R> immutableResultRecursive(R result, BiFunction<D, R, R> toExecute) {
        return new ImmutableResultRecursive<>(result, toExecute);
    }
}
