/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.impl.file;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author kamil.jarmusik
 */
public class FileNode implements RecursiveNode<File> {
    
    private final File file;

    public FileNode(File file) {
        this.file = file;
    }

    @Override
    public List<RecursiveNode<File>> nodes() {
        File[] files = file.listFiles();
        return (files == null || files.length == 0) ? Collections.emptyList() :
                Stream.of(files).map(f -> new FileNode(f))
                .collect(Collectors.toList());
    }

    @Override
    public File data() {
        return file;
    }

    @Override
    public String toString() {
        return "NodeFile{" + "file=" + file + '}';
    }
}
