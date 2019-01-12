/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import algorithm.AlgorithmRecursive;
import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;
import algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveNumericFactoryTest {
    
    public AlgorithmRecursiveNumericFactoryTest() {
    }

    /**
     * Test of factorial method, of class AlgorithmRecursiveNumericFactory.
     */
    @Test
    public void testFactorial() {
        System.out.println("factorial");
        int arg = 3;
        BigDecimal expResult = new BigDecimal("6");
        AlgorithmRecursive<Integer, BigDecimal> algorithm = AlgorithmRecursiveNumericFactory.factorial(arg);
        algorithm.run();
        BigDecimal result = algorithm.result().getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFactorialZero() {
        System.out.println("factorial");
        int arg = 0;
        BigDecimal expResult = new BigDecimal("1");
        AlgorithmRecursive<Integer, BigDecimal> algorithm = AlgorithmRecursiveNumericFactory.factorial(arg);
        algorithm.run();
        BigDecimal result = algorithm.result().getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of fibonacci method, of class AlgorithmRecursiveNumericFactory.
     */
    @Test
    public void testFibonacciZero() {
        System.out.println("fibonacci");
        int arg = 0;
        int expResult = 0;
        AlgorithmRecursive<int[], Integer> algorithm = AlgorithmRecursiveNumericFactory.fibonacci(arg);
        algorithm.run();
        int result = algorithm.result().getValue();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFibonacci() {
        System.out.println("fibonacci");
        int arg = 11;
        int expResult = 89;
        AlgorithmRecursive<int[], Integer> algorithm = AlgorithmRecursiveNumericFactory.fibonacci(arg);
        algorithm.run();
        int result = algorithm.result().getValue();
        assertEquals(expResult, result);
    }
    
}
