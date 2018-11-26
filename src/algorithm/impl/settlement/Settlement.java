/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl.settlement;

import java.util.Objects;

/**
 *
 * @author Kamil-Tomasz
 */
public class Settlement {
    
    private static long genId = 0;
    private final long id;
    private final String nr;
    private final String nr1;
    private final String nr2;
    private final String search;

    public Settlement(String nr, String nr1, String nr2, String search) {
        genId++;
        this.id = genId;
        this.nr = nr;
        this.nr1 = nr1;
        this.nr2 = nr2;
        this.search = search;
    }

    public long getId() {
        return id;
    }

    public String getNr() {
        return nr;
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
        hash = 31 * hash + Objects.hashCode(this.nr);
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
        if (!Objects.equals(this.nr, other.nr)) {
            return false;
        }
        if (!Objects.equals(this.nr1, other.nr1)) {
            return false;
        }
        if (!Objects.equals(this.nr2, other.nr2)) {
            return false;
        }
        if (!Objects.equals(this.search, other.search)) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "Rozliczenie{" + "id=" + id + ", nr=" + nr + ", nr1=" + nr1 + ", nr2=" + nr2 + ", search=" + search + '}';
    }
}
