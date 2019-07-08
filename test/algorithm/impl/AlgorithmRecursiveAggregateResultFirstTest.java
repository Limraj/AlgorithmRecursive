/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl;

import com.jarmusik.kamil.algorithm.impl.AlgorithmRecursiveBuilder;
import com.jarmusik.kamil.algorithm.AlgorithmRecursive;
import com.jarmusik.kamil.impl.settlement_to_test.SettlementNode;
import com.jarmusik.kamil.impl.settlement_to_test.Settlement;
import com.jarmusik.kamil.impl.settlement_to_test.SettlementsAggregator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import com.jarmusik.kamil.algorithm.result.RecursiveResult;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveAggregateResultFirstTest {
        
    private static Settlement found;
    private static AlgorithmRecursive<Settlement, List<Settlement>> aggregate;
    
    @BeforeClass
    public static void initTest() {
        found = SettlementsAggregator.get("123").iterator().next();
        aggregate = AlgorithmRecursiveBuilder
                .aggregateResult(new SettlementNode(found))
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> a.data().getSearch().equals("yes"))
                .toExecute((a,b) -> b.add(a))
                .build();
    }
    
    @Test
    public void testResultFoundFirstInBranch() {
        //given:
        List<Settlement> end = SettlementsAggregator.getPreservedOrder("236" , "566");
        RecursiveResult<List<Settlement>> expResult = RecursiveResult.newInstance(end, 4);
        //when:
        RecursiveResult<List<Settlement>> result = aggregate.runAndResult();
        //then:
        assertEquals(expResult, result);
    }
}
