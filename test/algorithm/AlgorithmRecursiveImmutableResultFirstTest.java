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
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

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
        immutable = AlgorithmRecursiveBuilder.immutableResult(new NodeSettlement(notFound), initSettlement)
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> a.data().getSearch().equals("yes"))
                .toExecute((a,b) -> a)
                .build();
    }

    @Test
    public void testResultNotFound() {
        //given:
        ResultRecursive<Settlement> expResult = ResultRecursive.newInstance(null, 1);
        //when:
        immutable.run();
        ResultRecursive<Settlement> result = immutable.result();
        //then:
        assertEquals(expResult, result);
    }
    
    @Test
    public void testResultFoundFirstInBranch() {
        //given:
        Settlement yes = SettlementsAggregator.get("566").iterator().next();
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        ResultRecursive<Settlement> expResult = ResultRecursive.newInstance(yes, 4);
        
        //when:
        immutable.changeStartAndRun(new NodeSettlement(start));
        ResultRecursive<Settlement> result = immutable.result();
        //then:
        assertEquals(expResult, result);
    }
}
