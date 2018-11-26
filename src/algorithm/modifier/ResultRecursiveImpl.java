/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;


class ResultRecursiveImpl<T> implements ResultRecursive<T> {
    
    private final T value;
    private final long numberIteration;

    public ResultRecursiveImpl(T value, long numberIteration) {
        this.value = value;
        this.numberIteration = numberIteration;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public long getNumberIteration() {
        return numberIteration;
    }
}
