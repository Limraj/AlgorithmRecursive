/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.impl.file.NodeFile;
import algorithm.impl.number.NodeInteger;
import ext.Extension;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import util.FileUtil;

/**
 *
 * @author Kamil-Tomasz
 */
public final class AlgorithmRecursiveFactory {
    
    public static AlgorithmRecursive<File, List<File>> aggregateFiles(File dir) {
        return AlgorithmRecursive.aggregateResultBuilder(new NodeFile(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()))
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<File, List<File>> aggregateFilesByName(File dir, String name) {
        return AlgorithmRecursive.aggregateResultBuilder(new NodeFile(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()) 
                                && node.data().getName().contains(name))
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<File, List<File>> aggregateFilesByExtension(File dir, Extension extension) {
        return AlgorithmRecursive.aggregateResultBuilder(new NodeFile(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()) 
                                && Extension.ext(node.data()) == extension)
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<File, List<File>> aggregateFilesByExtensions(File dir, Set<Extension> extension) {
        return AlgorithmRecursive.aggregateResultBuilder(new NodeFile(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()) 
                                && extension.contains(Extension.ext(node.data())))
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<Integer, BigDecimal> factorial(int arg) {
        return AlgorithmRecursive.immutableResultBuilder(new NodeInteger(arg), BigDecimal.ONE)
                        .finishIf(node -> node.data() < 2)
                        .executeIf(node -> true)
                        .limitNumberIterations(949)
                        .toExecute((a,result) -> result.multiply(BigDecimal.valueOf(a)))
                        .build();
    }
}
