/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.number;

import java.math.BigDecimal;

/**
 *
 * @author Kamil-Tomasz
 */
public class ResultBigDecimal {
    private BigDecimal result;

    public ResultBigDecimal(BigDecimal result) {
        this.result = result;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultBigDecimal{" + "result=" + result + '}';
    }
}
