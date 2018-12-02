/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import algorithm.AlgorithmRecursive;
import algorithm.AlgorithmRecursiveFactory;
import impl.settlement_to_test.NodeSettlement;
import impl.settlement_to_test.ResultSettlement;
import impl.settlement_to_test.Settlement;
import algorithm.node.NodeAlgorithm;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveForSettlementFactory {
        
    public static AlgorithmRecursive<Settlement, ResultSettlement> searchSettlementFirst(Settlement settlement, Predicate<NodeAlgorithm<Settlement>> searchCondition) {
        return AlgorithmRecursiveFactory
                .mutableResult(new NodeSettlement(settlement), () -> new ResultSettlement())
                .executeIf(searchCondition)
                .finishIf(searchCondition)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, ResultSettlement> searchSettlementLast(Settlement settlement, Predicate<NodeAlgorithm<Settlement>> searchCondition) {
        return AlgorithmRecursiveFactory
                .mutableResult(new NodeSettlement(settlement), () -> new ResultSettlement())
                .executeIf(searchCondition)
                .finishIf(a -> false)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<NodeAlgorithm<Settlement>> searchCondition) {
        return AlgorithmRecursiveFactory
                .aggregateResult(new NodeSettlement(settlement))
                .executeIf(searchCondition)
                .finishIf(a -> false)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<NodeAlgorithm<Settlement>> searchCondition, Predicate<NodeAlgorithm<Settlement>> endCondition) {
        return AlgorithmRecursiveFactory
                .aggregateResult(new NodeSettlement(settlement))
                .executeIf(searchCondition)
                .finishIf(endCondition)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
}
