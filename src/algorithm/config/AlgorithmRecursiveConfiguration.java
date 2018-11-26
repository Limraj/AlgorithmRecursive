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
    
    private final NodeAlgorithm<D> start;
    private final Predicate<NodeAlgorithm<D>> executeIf;
    private final Predicate<NodeAlgorithm<D>> finishIf;
    private final int limitNumberIterations;

    private AlgorithmRecursiveConfiguration(NodeAlgorithm<D> start, Predicate<NodeAlgorithm<D>> executeIf, Predicate<NodeAlgorithm<D>> finishIf, int limitNumberIterations) {
        this.start = start;
        this.executeIf = executeIf;
        this.finishIf = finishIf;
        this.limitNumberIterations = limitNumberIterations;
    }
    
    public static <D> AlgorithmRecursiveConfiguration<D> defaultConfig(NodeAlgorithm<D> start) {
        return new AlgorithmRecursiveConfiguration.Builder<>(start).build();
    }
    
    public static class Builder<D> {
        
        private final NodeAlgorithm<D> start;
        private Predicate<NodeAlgorithm<D>> executeIf;
        private Predicate<NodeAlgorithm<D>> finishIf;
        private int limitNumberIterations;

        public Builder(NodeAlgorithm<D> start) {
            this.start = start;
            this.executeIf = a -> true;
            this.finishIf = a -> false;
            this.limitNumberIterations = 100000000;
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
            return new AlgorithmRecursiveConfiguration<>(start, executeIf, finishIf, limitNumberIterations);
        }
    }

    public boolean isToExecute(NodeAlgorithm<D> t) {
        return executeIf.test(t);
    }

    public boolean isFinish(NodeAlgorithm<D> t) {
        return finishIf.test(t);
    }

    public NodeAlgorithm<D> getStart() {
        return start;
    }

    public int getLimitNumberIterations() {
        return limitNumberIterations;
    }
}
