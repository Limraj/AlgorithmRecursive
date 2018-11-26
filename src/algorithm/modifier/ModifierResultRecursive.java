/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
public interface ModifierResultRecursive<D, R> {
    void execute(D value);
    void incrementIteration();
    boolean hasBeenExceeded(int limit);
    ResultRecursive<R> snapshot();
}
