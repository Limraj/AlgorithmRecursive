/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import algorithm.AlgorithmRecursive;
import impl.settlement_to_test.SettlementNode;
import impl.settlement_to_test.Settlement;
import impl.settlement_to_test.SettlementsAggregator;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveImmutableResultFirstTest {
        
    private static Settlement notFound;
    private static Settlement initSettlement;
    private static AlgorithmRecursive<Settlement, Settlement> immutable;
    
    @BeforeClass
    public static void initTest() {
        initSettlement = null;
        notFound = SettlementsAggregator.get("456").iterator().next();
        immutable = AlgorithmRecursiveBuilder.immutableResult(new SettlementNode(notFound), initSettlement)
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> a.data().getSearch().equals("yes"))
                .toExecute((a,b) -> a)
                .build();
    }

    @Test
    public void testResultNotFound() {
        //given:
        RecursiveResult<Settlement> expResult = RecursiveResult.newInstance(null, 1);
        //when:
        RecursiveResult<Settlement> result = immutable.runAndResult();
        //then:
        assertEquals(expResult, result);
    }
    
    @Test
    public void testResultFoundFirstInBranch() {
        //given:
        Settlement yes = SettlementsAggregator.get("566").iterator().next();
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        RecursiveResult<Settlement> expResult = RecursiveResult.newInstance(yes, 4);
        //when:
        RecursiveResult<Settlement> result = immutable.runAndResultForStart(new SettlementNode(start));
        //then:
        assertEquals(expResult, result);
    }
}
