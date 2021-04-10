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
public class FibonacciIntNode implements RecursiveNode<int[]> {
    private final int[] data;

    public FibonacciIntNode(int[] data) {
        this.data = data;
    }

    @Override
    public List<RecursiveNode<int[]>> nodes() {
        List<RecursiveNode<int[]>> nodes = new ArrayList<>();
        nodes.add(new FibonacciIntNode(new int[]{data[1], data[0]+data[1]}));
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
