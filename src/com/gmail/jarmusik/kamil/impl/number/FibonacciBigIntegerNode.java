package com.gmail.jarmusik.kamil.impl.number;

import java.math.BigInteger;

public class FibonacciBigIntegerNode extends FibonacciNode<BigInteger> {

    public FibonacciBigIntegerNode(BigInteger[] data) {
        super(data);
    }

    @Override
    public FibonacciNode<BigInteger> create(BigInteger a, BigInteger b) {
        return new FibonacciBigIntegerNode(new BigInteger[]{b, a.add(b)});
    }
}
