/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.impl.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 */
public class FibonacciNode implements RecursiveNode<int[]> {
    private final int[] data;

    public FibonacciNode(int[] data) {
        this.data = data;
    }

    @Override
    public List<RecursiveNode<int[]>> nodes() {
        List<RecursiveNode<int[]>> nodes = new ArrayList<>();
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
