/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.impl;

import com.gmail.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.gmail.jarmusik.kamil.impl.number.*;

import java.math.BigInteger;

/**
 *
 * @author Kamil-Tomasz
 */
public final class AlgorithmRecursiveNumericFactory {

    private static final int MAX_ARG_FOR_LONG = 92;
    private static final int MAX_ARG_FOR_INT = 46;

    private static final int MIN_ARG_FIBO = 0;
    private static final int MIN_ARG_FACT = 0;

    public static AlgorithmRecursive<Integer, BigInteger> factorial(int arg) {
        minArg(arg, MIN_ARG_FACT);
        return AlgorithmRecursive.immutableResult(new FactorialNode(1), BigInteger.ONE)
                        .finishIf(node -> node.data() >= arg)
                        .toExecute((a,result) -> result.multiply(BigInteger.valueOf(a)))
                        .build();
    }

    public static AlgorithmRecursive<int[], Integer> fibonacci(int arg) {
        minArg(arg, MIN_ARG_FIBO);
        maxArg(arg, MAX_ARG_FOR_INT, "Due to an int overflow, the maximum arg is ");
        return AlgorithmRecursive.immutableResult(new FibonacciIntNode(new int[]{0, 1}), 0)
                .endPostIterations(arg)
                .toExecute((a,result) -> a[0])
                .build();
    }
    
    public static AlgorithmRecursive<BigInteger[], BigInteger> fibonacciBig(int arg) {
        minArg(arg, MIN_ARG_FIBO);
        return AlgorithmRecursive.immutableResult(new FibonacciBigIntegerNode(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}), BigInteger.ZERO)
                        .endPostIterations(arg)
                        .toExecute((a,result) -> a[0])
                        .build();
    }

    public static AlgorithmRecursive<BigInteger[], BigIntegerResult> fibonacciBigMuttable(int arg) {
        minArg(arg, MIN_ARG_FIBO);
        return AlgorithmRecursive.mutableResult(new FibonacciBigIntegerNode(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}), () -> new BigIntegerResult(BigInteger.ZERO))
                .endPostIterations(arg)
                .toExecute((a,result) -> result.setResult(a[0]))
                .build();
    }

    public static AlgorithmRecursive<long[], Long> fibonacciLong(int arg) {
        minArg(arg, MIN_ARG_FIBO);
        maxArg(arg, MAX_ARG_FOR_LONG,"Due to an long overflow, the maximum arg is ");
        return AlgorithmRecursive.immutableResult(new FibonacciLongNode(new long[]{0L, 1L}), 0L)
                .endPostIterations(arg)
                .toExecute((a, result) -> a[0])
                .build();
    }

    private static void maxArg(int arg, int max, String msg) {
        if(arg > max) {
            throw new IllegalArgumentException(msg + max);
        }
    }

    private static void minArg(int arg, int min) {
        if(arg < min) {
            throw new IllegalArgumentException("min arg is " + min);
        }
    }
}
