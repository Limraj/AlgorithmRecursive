/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.number;

import java.util.ArrayList;
import java.util.List;
import algorithm.node.AlgorithmRecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 */
public class FactorialNode implements AlgorithmRecursiveNode<Integer> {
    private final Integer data;

    public FactorialNode(Integer data) {
        this.data = data;
    }

    @Override
    public List<AlgorithmRecursiveNode<Integer>> nodes() {
        List<AlgorithmRecursiveNode<Integer>> nodes = new ArrayList<>();
        nodes.add(new FactorialNode(data+1));
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