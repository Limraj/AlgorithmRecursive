/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.algorithm.impl;

import java.util.function.Predicate;
import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 */
class AlgorithmRecursiveConfiguration<D> {

    private final Predicate<RecursiveNode<D>> executeIf;
    private final Predicate<RecursiveNode<D>> finishIf;
    private final int limitNumberIterations;
    private final int endPostIterations;

    public AlgorithmRecursiveConfiguration(int limitNumberIterations, Predicate<RecursiveNode<D>> executeIf, Predicate<RecursiveNode<D>> finishIf, int endPostIterations) {
        this.executeIf = executeIf;
        this.finishIf = finishIf;
        this.limitNumberIterations = limitNumberIterations;
        this.endPostIterations = endPostIterations;
    }

    public static class Builder<D> {

        private Predicate<RecursiveNode<D>> executeIf;
        private Predicate<RecursiveNode<D>> finishIf;
        private int limitNumberIterations;
        private int endPostIterations;

        public Builder() {
        }

        public Builder<D> executeIf(Predicate<RecursiveNode<D>> executeIf) {
            this.executeIf = executeIf;
            return this;
        }

        public Builder<D> finishIf(Predicate<RecursiveNode<D>> finishIf) {
            this.finishIf = finishIf;
            return this;
        }
        
        public Builder<D> limitNumberIterations(int limitNumberIterations) {
            this.limitNumberIterations = limitNumberIterations;
            return this;
        }
        
        public Builder<D> endPostIterations(int endPostIterations) {
            this.endPostIterations = endPostIterations;
            return this;
        }
        
        public AlgorithmRecursiveConfiguration<D> build() {
            return new AlgorithmRecursiveConfiguration<>(limitNumberIterations, executeIf, finishIf, endPostIterations);
        }
    }

    public boolean isToExecute(RecursiveNode<D> t) {
        return executeIf.test(t);
    }

    public boolean isFinish(RecursiveNode<D> t) {
        return finishIf.test(t);
    }

    public int getLimitNumberIterations() {
        return limitNumberIterations;
    }

    public int getEndPostIterations() {
        return endPostIterations;
    }
}
