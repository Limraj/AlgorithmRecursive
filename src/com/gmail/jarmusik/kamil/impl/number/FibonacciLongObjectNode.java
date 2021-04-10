package com.gmail.jarmusik.kamil.impl.number;

public class FibonacciLongObjectNode extends FibonacciNode<Long> {

    public FibonacciLongObjectNode(Long[] data) {
        super(data);
    }

    @Override
    public FibonacciNode<Long> create(Long a, Long b) {
        return new FibonacciLongObjectNode(new Long[]{b, a + b});
    }
}
