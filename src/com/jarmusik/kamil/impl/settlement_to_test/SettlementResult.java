/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jarmusik.kamil.impl.settlement_to_test;

import java.util.Objects;

/**
 *
 * @author Kamil-Tomasz
 */
public class SettlementResult {
    private Settlement settlement;

    public SettlementResult() {
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.settlement);
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
        final SettlementResult other = (SettlementResult) obj;
        return Objects.equals(this.settlement, other.settlement);
    }

    @Override
    public String toString() {
        return "ResultSettlement{" + "settlement=" + settlement + '}';
    }
}
