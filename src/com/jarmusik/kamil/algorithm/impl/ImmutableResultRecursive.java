/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm.impl;

import java.util.function.BiFunction;
import com.jarmusik.kamil.algorithm.result.RecursiveResult;


class ImmutableResultRecursive<D, R> extends AbstractModifierResultRecursive<D, R> {

    private final BiFunction<D, R, R> toExecute;
    private final R reset;
    private R result;
    
    public ImmutableResultRecursive(BiFunction<D, R, R> toExecute, R start) {
        this.toExecute = toExecute;
        this.reset = start;
        this.result = start;
    }

    @Override
    public void execute(D value) {
        result = toExecute.apply(value, result);
    }

    @Override
    public RecursiveResult<R> snapshot() {
        return RecursiveResult.newInstance(result, numberIterations());
    }

    @Override
    public void reset() {
        this.result = this.reset;
        super.reset();
    }
}
