/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.impl;

import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.jarmusik.kamil.impl.file.FileNode;
import com.jarmusik.kamil.impl.file.ext.Extension;
import com.jarmusik.kamil.impl.file.util.FileUtil;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Kamil-Tomasz
 */
@Deprecated
public class AlgorithmRecursiveFileFactory {
    
    public static AlgorithmRecursive<File, List<File>> aggregateFiles(File dir) {
        return AlgorithmRecursive.aggregateResult(new FileNode(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()))
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<File, List<File>> aggregateFilesByName(File dir, String name) {
        return AlgorithmRecursive.aggregateResult(new FileNode(dir))
                        .finishIf(node -> false)
                        .executeIf(node -> !FileUtil.isDirectory(node.data()) 
                                && node.data().getName().contains(name))
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<File, List<File>> aggregateFilesByExtension(File dir, Extension extension) {
        return AlgorithmRecursive.aggregateResult(new FileNode(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()) 
                                && Extension.ext(node.data()) == extension)
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
    
    public static AlgorithmRecursive<File, List<File>> aggregateFilesByExtensions(File dir, Set<Extension> extension) {
        return AlgorithmRecursive.aggregateResult(new FileNode(dir))
                        .executeIf(node -> !FileUtil.isDirectory(node.data()) 
                                && extension.contains(Extension.ext(node.data())))
                        .toExecute((file,result) -> result.add(file))
                        .build();
    }
}
