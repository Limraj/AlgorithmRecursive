/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl.settlement;

import algorithm.impl.settlement.Settlement;

/**
 *
 * @author Kamil-Tomasz
 */
public class ResultSettlement {
    private Settlement settlement;

    public ResultSettlement() {
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public void setSettlement(Settlement settlement) {
        this.settlement = settlement;
    }

    @Override
    public String toString() {
        return "ResultSettlement{" + "settlement=" + settlement + '}';
    }
}
