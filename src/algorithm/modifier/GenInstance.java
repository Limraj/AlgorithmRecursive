/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

/**
 *
 * @author Kamil-Tomasz
 * @param <R>
 */
@FunctionalInterface
public interface GenInstance<R> {
    R generate();
}
