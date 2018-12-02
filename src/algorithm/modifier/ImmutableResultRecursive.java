/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import algorithm.node.NodeAlgorithm;
import java.util.function.BiFunction;


class ImmutableResultRecursive<D, R> extends AbstractModifierResultRecursive<D, R> {

    private final BiFunction<D, R, R> toExecute;
    private final R reset;
    private R result;
    
    public ImmutableResultRecursive(BiFunction<D, R, R> toExecute, R result) {
        this.toExecute = toExecute;
        this.reset = result;
        this.result = result;
    }

    @Override
    public void execute(D value) {
        result = toExecute.apply(value, result);
    }

    @Override
    public ResultRecursive<R> snapshot() {
        return ResultRecursive.newInstance(result, numberIteration());
    }

    @Override
    public void reset() {
        this.result = this.reset;
        super.reset();
    }
}
