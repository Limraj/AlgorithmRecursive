/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.impl.settlement_to_test;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Kamil-Tomasz
 */
public class Settlement {
    
    private static final AtomicInteger genId = new AtomicInteger();
    private final int id;
    private String numberMain;
    private String nr1;
    private String nr2;
    private String search;
    
    public Settlement() {
        this.id = genId.incrementAndGet();
    }

    public Settlement(String numberMain, String nr1, String nr2, String search) {
        this.id = genId.incrementAndGet();
        this.numberMain = numberMain;
        this.nr1 = nr1;
        this.nr2 = nr2;
        this.search = search;
    }

    public long getId() {
        return id;
    }

    public String getNumberMain() {
        return numberMain;
    }

    public String getNr1() {
        return nr1;
    }

    public String getNr2() {
        return nr2;
    }

    public String getSearch() {
        return search;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.numberMain);
        hash = 31 * hash + Objects.hashCode(this.nr1);
        hash = 31 * hash + Objects.hashCode(this.nr2);
        hash = 31 * hash + Objects.hashCode(this.search);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Settlement other = (Settlement) obj;
        if (!Objects.equals(this.numberMain, other.numberMain)) {
            return false;
        }
        if (!Objects.equals(this.nr1, other.nr1)) {
            return false;
        }
        if (!Objects.equals(this.nr2, other.nr2)) {
            return false;
        }
        return Objects.equals(this.search, other.search);
    }

    @Override
    public String toString() {
        return "Settlement{" + "id=" + id + ", numberMain=" + numberMain + ", nr1=" + nr1 + ", nr2=" + nr2 + ", search=" + search + '}';
    }
}
