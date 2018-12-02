/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.config;

import java.util.function.Predicate;
import algorithm.node.NodeAlgorithm;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 */
public class AlgorithmRecursiveConfiguration<D> {

    private final Predicate<NodeAlgorithm<D>> executeIf;
    private final Predicate<NodeAlgorithm<D>> finishIf;
    private final int limitNumberIterations;

    private AlgorithmRecursiveConfiguration(Predicate<NodeAlgorithm<D>> executeIf, Predicate<NodeAlgorithm<D>> finishIf, int limitNumberIterations) {
        this.executeIf = executeIf;
        this.finishIf = finishIf;
        this.limitNumberIterations = limitNumberIterations;
    }
    
    public static class Builder<D> {

        private Predicate<NodeAlgorithm<D>> executeIf;
        private Predicate<NodeAlgorithm<D>> finishIf;
        private int limitNumberIterations;

        public Builder() {
        }

        public Builder<D> executeIf(Predicate<NodeAlgorithm<D>> executeIf) {
            this.executeIf = executeIf;
            return this;
        }

        public Builder<D> finishIf(Predicate<NodeAlgorithm<D>> finishIf) {
            this.finishIf = finishIf;
            return this;
        }
        
        public Builder<D> limitNumberIterations(int limitNumberIterations) {
            this.limitNumberIterations = limitNumberIterations;
            return this;
        }
        
        public AlgorithmRecursiveConfiguration<D> build() {
            return new AlgorithmRecursiveConfiguration<>(executeIf, finishIf, limitNumberIterations);
        }
    }

    public boolean isToExecute(NodeAlgorithm<D> t) {
        return executeIf.test(t);
    }

    public boolean isFinish(NodeAlgorithm<D> t) {
        return finishIf.test(t);
    }

    public int getLimitNumberIterations() {
        return limitNumberIterations;
    }
}
