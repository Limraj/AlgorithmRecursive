/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.algorithm.impl;

import com.gmail.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementNode;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.Settlement;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementsAggregator;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import com.gmail.jarmusik.kamil.algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveAggregateResultTest {
    
    private static Settlement notFound;
    private static AlgorithmRecursive<Settlement, List<Settlement>> aggregate;
    
    @BeforeClass
    public static void initTest() {
        notFound = SettlementsAggregator.get("456").iterator().next();
        aggregate = AlgorithmRecursive
                .aggregateResult(new SettlementNode(notFound))
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> false)
                .toExecute((a,b) -> b.add(a))
                .build();
    }
    
    @Test
    public void testResultNotFound() {
        //given:
        RecursiveResult<List<Settlement>> expResult = RecursiveResult.newInstance(Collections.emptyList(), 1);
        //when:
        RecursiveResult<List<Settlement>> result = aggregate.runAndResultForStart(new SettlementNode(notFound));
        //then:
        assertEquals(expResult, result);
    }
        
    @Test
    public void testResultFoundAll() {
        //given:
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        List<Settlement> end = SettlementsAggregator.getPreservedOrder("236", "566", "118");
        RecursiveResult<List<Settlement>> expResult = RecursiveResult.newInstance(end, 11);
        //when:
        RecursiveResult<List<Settlement>> result = aggregate.runAndResultForStart(new SettlementNode(start));
        //then:
        assertEquals(3, result.getValue().size());
        assertEquals(11, result.getNumberIterations());
        assertEquals(expResult, result);
    }
}
