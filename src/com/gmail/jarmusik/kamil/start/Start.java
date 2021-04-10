/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.start;

import com.gmail.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.gmail.jarmusik.kamil.impl.AlgorithmRecursiveNumericFactory;
import java.util.List;
import com.gmail.jarmusik.kamil.algorithm.result.RecursiveResult;
import com.gmail.jarmusik.kamil.impl.number.BigIntegerResult;

import java.math.BigInteger;

/**
 *
 * @author Kamil-Tomasz
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlgorithmRecursive<Integer, BigInteger> factor = AlgorithmRecursiveNumericFactory.factorial(6080);
        runAndPrintResult(factor);
        
        AlgorithmRecursive<int[], Integer> fibonacci = AlgorithmRecursiveNumericFactory.fibonacci(46);
        runAndPrintResult(fibonacci);

        AlgorithmRecursive<long[], Long> fibonacci2 = AlgorithmRecursiveNumericFactory.fibonacciLong(92);
        runAndPrintResult(fibonacci2);

        AlgorithmRecursive<BigInteger[], BigInteger> fibonacci3 = AlgorithmRecursiveNumericFactory.fibonacciBig(5263);
        runAndPrintResult(fibonacci3);

        AlgorithmRecursive<BigInteger[], BigIntegerResult> fibonacci4 = AlgorithmRecursiveNumericFactory.fibonacciBigMuttable(8357);
        runAndPrintResult(fibonacci4);
       
    }
    
    public static <D, R> void runAndPrintResult(AlgorithmRecursive<D, R> algorithm) {
        RecursiveResult<R> result = algorithm.runAndResult();
        System.out.println("number iterations: " + result.getNumberIterations());
        System.out.println("result value: " + result.getValue());
    }
    
    public static <D> void runAndPrintResultAggregate(AlgorithmRecursive<D, List<D>> algorithm) {
        RecursiveResult<List<D>> result = algorithm.runAndResult();
        System.out.println("number iterations: " + result.getNumberIterations());
        System.out.println("result value: ");
        result.getValue().forEach(a -> System.out.println(a));
        System.out.println("result size: " + result.getValue().size());
    }
}
