/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import algorithm.AlgorithmRecursive;
import algorithm.AlgorithmRecursiveBuilder;
import impl.settlement_to_test.NodeSettlement;
import impl.settlement_to_test.ResultSettlement;
import impl.settlement_to_test.Settlement;
import java.util.List;
import java.util.function.Predicate;
import algorithm.node.NodeAlgorithmRecursive;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveSettlementFactory {
        
    public static AlgorithmRecursive<Settlement, ResultSettlement> searchSettlementFirst(Settlement settlement, Predicate<NodeAlgorithmRecursive<Settlement>> searchCondition) {
        return AlgorithmRecursiveBuilder
                .mutableResult(new NodeSettlement(settlement), () -> new ResultSettlement())
                .executeIf(searchCondition)
                .finishIf(searchCondition)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, ResultSettlement> searchSettlementLast(Settlement settlement, Predicate<NodeAlgorithmRecursive<Settlement>> searchCondition) {
        return AlgorithmRecursiveBuilder
                .mutableResult(new NodeSettlement(settlement), () -> new ResultSettlement())
                .executeIf(searchCondition)
                .finishIf(a -> false)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<NodeAlgorithmRecursive<Settlement>> searchCondition) {
        return AlgorithmRecursiveBuilder
                .aggregateResult(new NodeSettlement(settlement))
                .executeIf(searchCondition)
                .finishIf(a -> false)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<NodeAlgorithmRecursive<Settlement>> searchCondition, Predicate<NodeAlgorithmRecursive<Settlement>> endCondition) {
        return AlgorithmRecursiveBuilder
                .aggregateResult(new NodeSettlement(settlement))
                .executeIf(searchCondition)
                .finishIf(endCondition)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
}
