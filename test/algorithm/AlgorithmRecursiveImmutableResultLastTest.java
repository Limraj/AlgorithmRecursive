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
import java.util.Iterator;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveImmutableResultLastTest {
            
    private static Settlement notFound;
    private static Settlement initSettlement;
    private static AlgorithmRecursive<Settlement, Settlement> immutable;
    
    @BeforeClass
    public static void initTest() {
        initSettlement = null;
        notFound = SettlementsAggregator.get("456").iterator().next();
        immutable = AlgorithmRecursiveFactory.immutableResult(new NodeSettlement(notFound), initSettlement)
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> false)
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
    public void testResultFoundLastInBranch() {
        //given:
        Settlement yes = SettlementsAggregator.get("118").iterator().next();
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        System.out.println("start: " + start);
        ResultRecursive<Settlement> expResult = ResultRecursive.newInstance(yes, 11);
        
        //when:
        immutable.changeStartAndRun(new NodeSettlement(start));
        ResultRecursive<Settlement> result = immutable.result();
        //then:
        assertEquals(expResult, result);
    }
}
