/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import algorithm.AlgorithmRecursive;
import impl.AlgorithmRecursiveNumericFactory;
import java.util.List;
import algorithm.result.RecursiveResult;
import impl.AlgorithmRecursiveFileFactory;
import impl.file.ext.Extension;
import java.io.File;
import java.math.BigDecimal;
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
        AlgorithmRecursive<Integer, BigInteger> factor = AlgorithmRecursiveNumericFactory.factorial(4500);
        runAndPrintResult(factor);
        
        AlgorithmRecursive<int[], Integer> fibonacci = AlgorithmRecursiveNumericFactory.fibonacci(7);
        runAndPrintResult(fibonacci);
       
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
