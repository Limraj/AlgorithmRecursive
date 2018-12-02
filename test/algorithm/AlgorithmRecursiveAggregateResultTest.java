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
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

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
        aggregate = AlgorithmRecursiveFactory
                .aggregateResult(new NodeSettlement(notFound))
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> false)
                .toExecute((a,b) -> b.add(a))
                .build();
    }
    
    @Test
    public void testResultNotFound() {
        //given:
        ResultRecursive<List<Settlement>> expResult = ResultRecursive.newInstance(Collections.emptyList(), 1);
        //when:
        aggregate.changeStartAndRun(new NodeSettlement(notFound));
        ResultRecursive<List<Settlement>> result = aggregate.result();
        //then:
        assertEquals(expResult, result);
    }
        
    @Test
    public void testResultFoundAll() {
        //given:
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        List<Settlement> end = SettlementsAggregator.getPreservedOrder("236", "566", "118");
        ResultRecursive<List<Settlement>> expResult = ResultRecursive.newInstance(end, 11);
        //when:
        aggregate.changeStartAndRun(new NodeSettlement(start));
        ResultRecursive<List<Settlement>> result = aggregate.result();
        //then:
        assertEquals(3, result.getValue().size());
        assertEquals(11, result.getNumberIteration());
        assertEquals(expResult, result);
    }
}
