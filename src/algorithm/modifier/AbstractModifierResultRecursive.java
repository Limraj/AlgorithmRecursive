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
public abstract class AbstractModifierResultRecursive<D, R> implements ModifierResultRecursive<D, R> {
    
    protected long numberIteration;
    
    public AbstractModifierResultRecursive() {
        this.numberIteration = 0;
    }

    @Override
    public void incrementIteration() {
        numberIteration++;
    }
    
    @Override
    public boolean hasBeenExceeded(int limit) {
        return numberIteration > limit;
    }

}
