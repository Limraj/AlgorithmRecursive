/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.jarmusik.kamil.algorithm.impl;

import com.gmail.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementNode;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementResult;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.Settlement;
import com.gmail.jarmusik.kamil.impl.settlement_to_test.SettlementsAggregator;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import com.gmail.jarmusik.kamil.algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveMutableResultLastTest {
    
    private static Settlement notFound;
    private static AlgorithmRecursive<Settlement, SettlementResult> mutable;
    
    @BeforeClass
    public static void initTest() {
        notFound = SettlementsAggregator.get("456").iterator().next();
        mutable = AlgorithmRecursive
                .mutableResult(new SettlementNode(notFound), () -> new SettlementResult())
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> false)
                .toExecute((a,b) -> b.setSettlement(a))
                .build();
    }

    @Test
    public void testResultNotFound() {
        //given:
        RecursiveResult<SettlementResult> expResult = RecursiveResult.newInstance(new SettlementResult(), 1);
        //when:
        RecursiveResult<SettlementResult> result = mutable.runAndResult();
        //then:
        assertEquals(expResult, result);
    }
    
    @Test
    public void testResultFoundLastInBranch() {
        //given:
        Settlement yes = SettlementsAggregator.get("118").iterator().next();
        SettlementResult end = new SettlementResult();
        end.setSettlement(yes);
        RecursiveResult<SettlementResult> expResult = RecursiveResult.newInstance(end, 11);
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        //when:
        RecursiveResult<SettlementResult> result = mutable.runAndResultForStart(new SettlementNode(start));
        //then:
        assertEquals(expResult, result);
    }
}
