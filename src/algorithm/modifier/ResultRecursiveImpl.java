/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.modifier;

import java.util.Objects;


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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.value);
        hash = 29 * hash + (int) (this.numberIteration ^ (this.numberIteration >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResultRecursiveImpl<?> other = (ResultRecursiveImpl<?>) obj;
        if (this.numberIteration != other.numberIteration) {
            return false;
        }
        return Objects.equals(this.value, other.value);
    }

    @Override
    public String toString() {
        return "ResultRecursiveImpl{" + "value=" + value + ", numberIteration=" + numberIteration + '}';
    }
}
