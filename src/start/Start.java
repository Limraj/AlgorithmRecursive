/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import algorithm.AlgorithmRecursive;
import algorithm.node.NodeAlgorithm;
import impl.AlgorithmRecursiveFactory;
import impl.settlement_to_test.Settlement;
import impl.settlement_to_test.SettlementsAggregator;
import impl.settlement_to_test.ResultSettlement;
import java.util.List;
import impl.AlgorithmRecursiveForSettlementFactory;
import impl.file.ext.Extension;
import java.io.File;
import java.math.BigDecimal;

/**
 *
 * @author Kamil-Tomasz
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlgorithmRecursive<Integer, BigDecimal> factor = AlgorithmRecursiveFactory.factorial(700);
        factor.run();
        System.out.println("result:" + factor.result().getValue());
        factor.run();
        System.out.println("result:" + factor.result().getValue());
        
        File dir = new File("C://dev");
        AlgorithmRecursive<File, List<File>> filesByExtension = AlgorithmRecursiveFactory.aggregateFilesByExtension(dir, Extension.DOCX);
        filesByExtension.run();
        System.out.println("result:" + filesByExtension.result().getValue());
        
        AlgorithmRecursive<File, List<File>> filesByName = AlgorithmRecursiveFactory.aggregateFilesByName(dir, "nameFile");
        filesByName.run();
        System.out.println("result:" + filesByName.result().getValue());
        
        Settlement settlement = SettlementsAggregator.get("456").iterator().next();
        AlgorithmRecursive<Settlement, ResultSettlement> search = AlgorithmRecursiveForSettlementFactory.searchSettlementFirst(settlement, a -> a.data().getSearch().equals("yes"));
        search.run();
        System.out.println("result:" + search.result().getValue());
        
        AlgorithmRecursive<Settlement, List<Settlement>> search2 = AlgorithmRecursiveForSettlementFactory.aggregateSettlements(settlement, a -> a.data().getSearch().equals("yes"));
        search2.run();
        System.out.println("result:" + search2.result().getValue());

        

    }
    
}
