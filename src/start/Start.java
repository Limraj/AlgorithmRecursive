/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import algorithm.AlgorithmRecursive;
import algorithm.AlgorithmRecursiveFactory;
import algorithm.impl.file.NodeFile;
import algorithm.impl.number.NodeInteger;
import algorithm.impl.number.ResultBigDecimal;
import algorithm.impl.settlement.Settlement;
import algorithm.impl.settlement.SettlementsAggregator;
import algorithm.impl.settlement.NodeSettlement;
import java.util.List;
import algorithm.node.NodeAlgorithm;
import java.io.File;
import java.math.BigDecimal;
import util.FileUtil;

/**
 *
 * @author Kamil-Tomasz
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlgorithmRecursive<Integer, BigDecimal> factor = AlgorithmRecursiveFactory.factorial(750);
        System.out.println("result: " + factor.result().getValue());
        
    }
    
}
