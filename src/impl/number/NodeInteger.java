/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.number;

import algorithm.node.NodeAlgorithm;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kamil-Tomasz
 */
public class NodeInteger implements NodeAlgorithm<Integer> {
    private final int data;

    public NodeInteger(int data) {
        this.data = data;
    }

    @Override
    public List<NodeAlgorithm<Integer>> nodes() {
        List<NodeAlgorithm<Integer>> nodes = new ArrayList<>();
        nodes.add(new NodeInteger(data - 1));
        return nodes;
    }

    @Override
    public Integer data() {
        return data;
    }

    @Override
    public String toString() {
        return "NodeInteger{" + "data=" + data + '}';
    }
    
    
}
