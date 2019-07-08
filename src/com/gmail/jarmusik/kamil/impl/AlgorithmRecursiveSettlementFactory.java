/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.impl;

import com.gmail.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementNode;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementResult;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.Settlement;
import java.util.List;
import java.util.function.Predicate;
import com.gmail.jarmusik.kamil.algorithm.node.RecursiveNode;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveSettlementFactory {
        
    public static AlgorithmRecursive<Settlement, SettlementResult> searchSettlementFirst(Settlement settlement, Predicate<RecursiveNode<Settlement>> searchCondition) {
        return AlgorithmRecursive
                .mutableResult(new SettlementNode(settlement), () -> new SettlementResult())
                .executeIf(searchCondition)
                .finishIf(searchCondition)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, SettlementResult> searchSettlementLast(Settlement settlement, Predicate<RecursiveNode<Settlement>> searchCondition) {
        return AlgorithmRecursive
                .mutableResult(new SettlementNode(settlement), () -> new SettlementResult())
                .executeIf(searchCondition)
                .toExecute((a, b) -> b.setSettlement(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<RecursiveNode<Settlement>> searchCondition) {
        return AlgorithmRecursive
                .aggregateResult(new SettlementNode(settlement))
                .executeIf(searchCondition)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
    
    public static AlgorithmRecursive<Settlement, List<Settlement>> aggregateSettlements(Settlement settlement, Predicate<RecursiveNode<Settlement>> searchCondition, Predicate<RecursiveNode<Settlement>> endCondition) {
        return AlgorithmRecursive
                .aggregateResult(new SettlementNode(settlement))
                .executeIf(searchCondition)
                .finishIf(endCondition)
                .toExecute((a, b) -> b.add(a))
                .build();
    }
}
