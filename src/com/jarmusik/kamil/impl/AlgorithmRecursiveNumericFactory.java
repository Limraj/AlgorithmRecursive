/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.impl;

import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.jarmusik.kamil.impl.number.FactorialNode;
import com.jarmusik.kamil.impl.number.FibonacciNode;
import java.math.BigInteger;

/**
 *
 * @author Kamil-Tomasz
 */
public final class AlgorithmRecursiveNumericFactory {

    public static AlgorithmRecursive<Integer, BigInteger> factorial(int arg) {
        return AlgorithmRecursive.immutableResult(new FactorialNode(1), BigInteger.ONE)
                        .finishIf(node -> node.data() >= arg)
                        .limitNumberIterations(6500)
                        .toExecute((a,result) -> result.multiply(BigInteger.valueOf(a)))
                        .build();
    }
    
    public static AlgorithmRecursive<int[], Integer> fibonacci(int arg) {
        return AlgorithmRecursive.immutableResult(new FibonacciNode(new int[]{0, 1}), 0)
                        .endPostIterations(arg)
                        .toExecute((a,result) -> a[0])
                        .build();
    }
}
