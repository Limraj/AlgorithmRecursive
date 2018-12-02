/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import algorithm.AlgorithmRecursive;
import impl.AlgorithmRecursiveFileFactory;
import impl.AlgorithmRecursiveNumericFactory;
import java.util.List;
import impl.file.ext.Extension;
import java.io.File;
import java.math.BigDecimal;

/**
 *
 * @author Kamil-Tomasz
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlgorithmRecursive<Integer, BigDecimal> factor = AlgorithmRecursiveNumericFactory.factorial(6500);
        runAndPrintResult(factor);
        
        File dev = new File("C:\\dev");
        AlgorithmRecursive<File, List<File>> filesByExtension = AlgorithmRecursiveFileFactory.aggregateFilesByExtension(dev, Extension.UNKNOWN);
        runAndPrintResultAggregate(filesByExtension);
        
        AlgorithmRecursive<File, List<File>> filesByName = AlgorithmRecursiveFileFactory.aggregateFilesByName(dev, "liferay");
        runAndPrintResultAggregate(filesByName);
        
        AlgorithmRecursive<File, List<File>> filesAll = AlgorithmRecursiveFileFactory.aggregateFiles(dev);
        runAndPrintResultAggregate(filesAll);
    }
    
    public static <D, R> void runAndPrintResult(AlgorithmRecursive<D, R> algorithm) {
        algorithm.run();
        System.out.println("number iterations: " + algorithm.result().getNumberIteration());
        System.out.println("result value: " + algorithm.result().getValue());
    }
    
    public static <D> void runAndPrintResultAggregate(AlgorithmRecursive<D, List<D>> algorithm) {
        algorithm.run();
        System.out.println("number iterations: " + algorithm.result().getNumberIteration());
        System.out.println("result value: ");
        algorithm.result().getValue().forEach(a -> System.out.println(a));
        System.out.println("result size: " + algorithm.result().getValue().size());
    }
}
