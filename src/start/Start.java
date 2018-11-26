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
import algorithm.impl.settlement.ResultSettlement;
import java.util.List;
import algorithm.node.NodeAlgorithm;
import ext.Extension;
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

        AlgorithmRecursive<Integer, BigDecimal> factor = 
                AlgorithmRecursiveFactory.factorial(750);
        System.out.println("result:" + factor.result().getValue());
        
        File dir = new File("C://dev");
        AlgorithmRecursive<File, List<File>> filesByExtension = 
                AlgorithmRecursiveFactory.aggregateFilesByExtension(dir, Extension.JSON);
        System.out.println("result:" + filesByExtension.result().getValue());
        
        AlgorithmRecursive<File, List<File>> filesByName = 
                AlgorithmRecursiveFactory.aggregateFilesByName(dir, "nameFile");
        System.out.println("result:" + filesByName.result().getValue());
        
        Settlement settlement = SettlementsAggregator.get("123").iterator().next();
        AlgorithmRecursive<Settlement, ResultSettlement> search = AlgorithmRecursive
                .mutableResultBuilder(new NodeSettlement(settlement), new ResultSettlement())
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> a.data().getSearch().equals("yes"))
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
        
        System.out.println("result:" + search.result().getValue());
    }
    
}
