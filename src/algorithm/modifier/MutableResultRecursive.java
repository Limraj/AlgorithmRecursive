/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import java.util.function.BiConsumer;

/**
 *
 * @author Kamil-Tomasz
 */
public class MutableResultRecursive<D, R> extends AbstractModifierResultRecursive<D, R> {
 
    private final BiConsumer<D, R> toExecute;
    private final R result;
    
    public MutableResultRecursive(R result, BiConsumer<D, R> toExecute) {
        this.toExecute = toExecute;
        this.result = result;
    }

    @Override
    public void execute(D value) {
        toExecute.accept(value, result);
    }

    @Override
    public ResultRecursive<R> snapshot() {
        return new ResultRecursiveImpl<>(result, numberIteration);
    }
}
