/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
class MutableResultRecursive<D, R> extends AbstractModifierResultRecursive<D, R> {
 
    private final BiConsumer<D, R> toExecute;
    private final Supplier<R> instanceGenerator;
    private R result;
    
    public MutableResultRecursive(BiConsumer<D, R> toExecute, Supplier<R> instanceGenerator) {
        this.toExecute = toExecute;
        this.instanceGenerator = instanceGenerator;
        this.result = instanceGenerator.get();
    }

    @Override
    public void execute(D value) {
        toExecute.accept(value, result);
    }

    @Override
    public RecursiveResult<R> snapshot() {
        return RecursiveResult.newInstance(result, numberIterations());
    }

    @Override
    public void reset() {
        result = instanceGenerator.get();
        super.reset();
    }
}
