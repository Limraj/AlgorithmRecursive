/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import algorithm.node.NodeAlgorithm;
import java.util.function.BiConsumer;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
class MutableResultRecursive<D, R> extends AbstractModifierResultRecursive<D, R> {
 
    private final BiConsumer<D, R> toExecute;
    private final GenInstance<R> instanceGenerator;
    private R result;
    
    public MutableResultRecursive(BiConsumer<D, R> toExecute, GenInstance<R> instanceGenerator) {
        this.toExecute = toExecute;
        this.instanceGenerator = instanceGenerator;
        this.result = instanceGenerator.generate();
    }

    @Override
    public void execute(D value) {
        toExecute.accept(value, result);
    }

    @Override
    public ResultRecursive<R> snapshot() {
        return ResultRecursive.newInstance(result, numberIteration());
    }

    @Override
    public void reset() {
        result = instanceGenerator.generate();
        super.reset();
    }
}
