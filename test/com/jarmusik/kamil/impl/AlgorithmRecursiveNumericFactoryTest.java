/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.impl;

import com.jarmusik.kamil.impl.AlgorithmRecursiveNumericFactory;
import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigInteger;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveNumericFactoryTest {

    @Test
    public void testFactorial() {
        System.out.println("factorial");
        int arg = 3;
        BigInteger expResult = new BigInteger("6");
        AlgorithmRecursive<Integer, BigInteger> algorithm = AlgorithmRecursiveNumericFactory.factorial(arg);
        BigInteger result = algorithm.runAndResult().getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFactorialZero() {
        System.out.println("factorial");
        int arg = 0;
        BigInteger expResult = new BigInteger("1");
        AlgorithmRecursive<Integer, BigInteger> algorithm = AlgorithmRecursiveNumericFactory.factorial(arg);
        BigInteger result = algorithm.runAndResult().getValue();
        assertEquals(expResult, result);
    }

    @Test
    public void testFibonacciZero() {
        System.out.println("fibonacci");
        int arg = 0;
        int expResult = 0;
        AlgorithmRecursive<int[], Integer> algorithm = AlgorithmRecursiveNumericFactory.fibonacci(arg);
        int result = algorithm.runAndResult().getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFibonacci() {
        System.out.println("fibonacci");
        int arg = 11;
        int expResult = 89;
        AlgorithmRecursive<int[], Integer> algorithm = AlgorithmRecursiveNumericFactory.fibonacci(arg);
        int result = algorithm.runAndResult().getValue();
        assertEquals(expResult, result);
    }
}
