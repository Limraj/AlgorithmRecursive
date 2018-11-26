/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl.file;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import algorithm.node.NodeAlgorithm;

/**
 *
 * @author kamil.jarmusik
 */
public class NodeFile implements NodeAlgorithm<File> {
    
    private final File file;

    public NodeFile(File file) {
        this.file = file;
    }

    @Override
    public List<NodeAlgorithm<File>> nodes() {
        File[] files = file.listFiles();
        return (files == null || files.length == 0) ? Collections.emptyList() :
                Stream.of(files).map(f -> new NodeFile(f))
                .collect(Collectors.toList());
    }

    @Override
    public File data() {
        return file;
    }
}
