/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import java.util.function.BiFunction;


public class ImmutableResultRecursive<D, R> extends AbstractModifierResultRecursive<D, R> {

    private final BiFunction<D, R, R> toExecute;
    private R result;
    
    public ImmutableResultRecursive(R result, BiFunction<D, R, R> toExecute) {
        this.toExecute = toExecute;
        this.result = result;
    }

    @Override
    public void execute(D value) {
        result = toExecute.apply(value, result);
    }

    @Override
    public ResultRecursive<R> snapshot() {
        return new ResultRecursiveImpl<>(result, numberIteration);
    }
}
