/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import java.util.function.Predicate;
import algorithm.node.AlgorithmRecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 */
class AlgorithmRecursiveConfiguration<D> {

    private final Predicate<AlgorithmRecursiveNode<D>> executeIf;
    private final Predicate<AlgorithmRecursiveNode<D>> finishIf;
    private final int limitNumberIterations;
    private final int endOfIterations;

    public AlgorithmRecursiveConfiguration(int limitNumberIterations, Predicate<AlgorithmRecursiveNode<D>> executeIf, Predicate<AlgorithmRecursiveNode<D>> finishIf, int endOfIterations) {
        this.executeIf = executeIf;
        this.finishIf = finishIf;
        this.limitNumberIterations = limitNumberIterations;
        this.endOfIterations = endOfIterations;
    }

    public static class Builder<D> {

        private Predicate<AlgorithmRecursiveNode<D>> executeIf;
        private Predicate<AlgorithmRecursiveNode<D>> finishIf;
        private int limitNumberIterations;
        private int endOfIterations;

        public Builder() {
        }

        public Builder<D> executeIf(Predicate<AlgorithmRecursiveNode<D>> executeIf) {
            this.executeIf = executeIf;
            return this;
        }

        public Builder<D> finishIf(Predicate<AlgorithmRecursiveNode<D>> finishIf) {
            this.finishIf = finishIf;
            return this;
        }
        
        public Builder<D> limitNumberIterations(int limitNumberIterations) {
            this.limitNumberIterations = limitNumberIterations;
            return this;
        }
        
        public Builder<D> endOfIterations(int endOfIterations) {
            this.endOfIterations = endOfIterations;
            return this;
        }
        
        public AlgorithmRecursiveConfiguration<D> build() {
            return new AlgorithmRecursiveConfiguration<>(limitNumberIterations, executeIf, finishIf, endOfIterations);
        }
    }

    public boolean isToExecute(AlgorithmRecursiveNode<D> t) {
        return executeIf.test(t);
    }

    public boolean isFinish(AlgorithmRecursiveNode<D> t) {
        return finishIf.test(t);
    }

    public int getLimitNumberIterations() {
        return limitNumberIterations;
    }

    public int getEndOfIterations() {
        return endOfIterations;
    }
}
