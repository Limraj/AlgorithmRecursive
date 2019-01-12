/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import algorithm.AlgorithmRecursive;
import algorithm.impl.AlgorithmRecursiveBuilder;
import impl.settlement_to_test.SettlementNode;
import impl.settlement_to_test.SettlementResult;
import impl.settlement_to_test.Settlement;
import java.util.List;
import java.util.function.Predicate;
import algorithm.node.AlgorithmRecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveSettlementFactory {
        
    public static AlgorithmRecursive<Settlement, SettlementResult> searchSettlementFirst(Settlement settlement, Predicate<AlgorithmRecursiveNode<Settlement>> searchCondition) {
        return AlgorithmRecursiveBuilder
                .mutableResult(new SettlementNode(settlement), () -> new SettlementResult())
                .executeIf(searchCondition)
                .finishIf(searchCondition)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, SettlementResult> searchSettlementLast(Settlement settlement, Predicate<AlgorithmRecursiveNode<Settlement>> searchCondition) {
        return AlgorithmRecursiveBuilder
                .mutableResult(new SettlementNode(settlement), () -> new SettlementResult())
                .executeIf(searchCondition)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<AlgorithmRecursiveNode<Settlement>> searchCondition) {
        return AlgorithmRecursiveBuilder
                .aggregateResult(new SettlementNode(settlement))
                .executeIf(searchCondition)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<AlgorithmRecursiveNode<Settlement>> searchCondition, Predicate<AlgorithmRecursiveNode<Settlement>> endCondition) {
        return AlgorithmRecursiveBuilder
                .aggregateResult(new SettlementNode(settlement))
                .executeIf(searchCondition)
                .finishIf(endCondition)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
}
