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
        /*Settlement settlement = SettlementsAggregator.get("123").iterator().next();
        NodeAlgorithm<Settlement> start = new NodeSettlement(settlement);
        AlgorithmRecursive<Settlement, List<Settlement>> searcher = 
                AlgorithmRecursive.aggregateResultBuilder(new NodeSettlement(settlement))
                .executeIf(a -> a.data().getSearch().contains("yes"))
                .finishIf(a -> false)
                .limitNumberIterations(0)
                .toExecute((a, b) -> b.add(a))
                .build();
        
        System.out.println("search: " + searcher.result().getValue());
        System.out.println("number: " + searcher.result().getNumberIteration());*/
        File dir = new File("C:\\$RECYCLE.BIN");
        AlgorithmRecursive<File, List<File>> factor = 
                AlgorithmRecursive.aggregateResultBuilder(new NodeFile(dir))
                .executeIf(node -> (node.nodes() == null || node.nodes().isEmpty()))
                .finishIf(a -> false)
                .limitNumberIterations(0)
                .toExecute((a, b) -> b.add(a))
                .build();
        
        System.out.println("search: " + factor.result().getValue().size());
        System.out.println("number: " + factor.result().getNumberIteration());
        
        AlgorithmRecursive<Integer, BigDecimal> factor2 = AlgorithmRecursiveFactory.factorial(949);
        System.out.println("factor2: " + factor2.result().getValue());
        
    }
    
}
