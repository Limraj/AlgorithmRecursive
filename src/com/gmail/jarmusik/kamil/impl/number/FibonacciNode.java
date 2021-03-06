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
public abstract class FibonacciNode<T extends Number> implements RecursiveNode<T[]> {
    private final T[] data;

    public FibonacciNode(T[] data) {
        this.data = data;
    }

    @Override
    public List<RecursiveNode<T[]>> nodes() {
        List<RecursiveNode<T[]>> nodes = new ArrayList<>();
        nodes.add(create(data[0], data[1]));
        return nodes;
    }

    protected abstract FibonacciNode<T> create(T a, T b);

    @Override
    public T[] data() {
        return data;
    }

    @Override
    public String toString() {
        return "NodeFibonacci{" + "data=" + Arrays.toString(data) + '}';
    }
}
