package com.gmail.jarmusik.kamil.impl.number;

public class FibonacciIntegerNode extends FibonacciNode<Integer> {

    public FibonacciIntegerNode(Integer[] data) {
        super(data);
    }

    @Override
    public FibonacciNode<Integer> create(Integer a, Integer b) {
        return new FibonacciIntegerNode(new Integer[]{b, a + b});
    }
}
