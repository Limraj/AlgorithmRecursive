/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.modifier.ResultRecursive;
import impl.settlement_to_test.NodeSettlement;
import impl.settlement_to_test.Settlement;
import impl.settlement_to_test.SettlementsAggregator;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

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
        aggregate = AlgorithmRecursiveFactory
                .aggregateResult(new NodeSettlement(found))
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> a.data().getSearch().equals("yes"))
                .toExecute((a,b) -> b.add(a))
                .build();
    }
    
    @Test
    public void testResultFoundFirstInBranch() {
        //given:
        List<Settlement> end = SettlementsAggregator.getPreservedOrder("236" , "566");
        ResultRecursive<List<Settlement>> expResult = ResultRecursive.newInstance(end, 4);
        //when:
        aggregate.run();
        ResultRecursive<List<Settlement>> result = aggregate.result();
        //then:
        assertEquals(expResult, result);
    }
}
