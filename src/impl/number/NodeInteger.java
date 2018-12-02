/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.number;

import java.util.ArrayList;
import java.util.List;
import algorithm.node.NodeAlgorithmRecursive;

/**
 *
 * @author Kamil-Tomasz
 */
public class NodeInteger implements NodeAlgorithmRecursive<Integer> {
    private final Integer data;

    public NodeInteger(Integer data) {
        this.data = data;
    }

    @Override
    public List<NodeAlgorithmRecursive<Integer>> nodes() {
        List<NodeAlgorithmRecursive<Integer>> nodes = new ArrayList<>();
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
