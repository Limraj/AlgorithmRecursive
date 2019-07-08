/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.algorithm.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Kamil-Tomasz
 * @param <D>
 * @param <R>
 */
abstract class AbstractModifierResultRecursive<D, R> implements ModifierResultRecursive<D, R> {
    
    private final AtomicLong serial = new AtomicLong();
    private long numberIterations;
    
    public AbstractModifierResultRecursive() {
        this.numberIterations = 0;
    }

    @Override
    public void incrementIterations() {
        numberIterations = serial.incrementAndGet();
    }
    
    @Override
    public boolean hasBeenExceeded(int limit) {
        return numberIterations > limit;
    }
    
    @Override
    public boolean isEndOfIterations(int endOfIterations) {
        return numberIterations > endOfIterations;
    }
    
    @Override
    public void reset() {
        serial.set(0);
        numberIterations = 0;
    }

    protected long numberIterations() {
        return numberIterations;
    }
}
