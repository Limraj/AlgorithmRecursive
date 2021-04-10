/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.impl.number;

import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Kamil-Tomasz
 */
public class FibonacciLongNode implements RecursiveNode<long[]> {
    private final long[] data;

    public FibonacciLongNode(long[] data) {
        this.data = data;
    }

    @Override
    public List<RecursiveNode<long[]>> nodes() {
        List<RecursiveNode<long[]>> nodes = new ArrayList<>();
        nodes.add(new FibonacciLongNode(new long[]{data[1], data[0]+data[1]}));
        return nodes;
    }

    @Override
    public long[] data() {
        return data;
    }

    @Override
    public String toString() {
        return "NodeFibonacci{" + "data=" + Arrays.toString(data) + '}';
    }
}
