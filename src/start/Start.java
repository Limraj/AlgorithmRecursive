/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import algorithm.AlgorithmRecursive;
import impl.AlgorithmRecursiveFactory;
import impl.file.NodeFile;
import impl.number.NodeInteger;
import impl.number.ResultBigDecimal;
import impl.settlement.Settlement;
import impl.settlement.SettlementsAggregator;
import impl.settlement.NodeSettlement;
import impl.settlement.ResultSettlement;
import java.util.List;
import algorithm.node.NodeAlgorithm;
import impl.AlgorithmRecursiveForSettlementFactory;
import impl.file.ext.Extension;
import java.io.File;
import java.math.BigDecimal;
import impl.file.util.FileUtil;

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
        factor.start();
        System.out.println("result:" + factor.result().getValue());
        factor.start();
        System.out.println("result:" + factor.result().getValue());
        
        File dir = new File("C://dev");
        AlgorithmRecursive<File, List<File>> filesByExtension = 
                AlgorithmRecursiveFactory.aggregateFilesByExtension(dir, Extension.JSON);
        filesByExtension.start();
        System.out.println("result:" + filesByExtension.result().getValue());
        
        AlgorithmRecursive<File, List<File>> filesByName = 
                AlgorithmRecursiveFactory.aggregateFilesByName(dir, "nameFile");
        filesByName.start();
        System.out.println("result:" + filesByName.result().getValue());
        
        Settlement settlement = SettlementsAggregator.get("123").iterator().next();
        AlgorithmRecursive<Settlement, ResultSettlement> search = AlgorithmRecursiveForSettlementFactory
                .searchSettlementLast(settlement, a -> a.data().getSearch().equals("yes"));
        search.start();
        System.out.println("result:" + search.result().getValue());
        
        AlgorithmRecursive<Settlement, List<Settlement>> search2 = AlgorithmRecursiveForSettlementFactory.aggregateSettlements(settlement, a -> a.data().getSearch().equals("yes"));
        search2.start();
        System.out.println("result:" + search2.result().getValue());
    }
    
}
