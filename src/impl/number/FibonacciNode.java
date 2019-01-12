/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import algorithm.node.AlgorithmRecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 */
public class FibonacciNode implements AlgorithmRecursiveNode<int[]> {
    private final int[] data;

    public FibonacciNode(int[] data) {
        this.data = data;
    }

    @Override
    public List<AlgorithmRecursiveNode<int[]>> nodes() {
        List<AlgorithmRecursiveNode<int[]>> nodes = new ArrayList<>();
        nodes.add(new FibonacciNode(new int[] {data[1], data[1] + data[0]}));
        return nodes;
    }

    @Override
    public int[] data() {
        return data;
    }

    @Override
    public String toString() {
        return "NodeFibonacci{" + "data=" + Arrays.toString(data) + '}';
    }
}
