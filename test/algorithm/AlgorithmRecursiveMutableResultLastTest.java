/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

import algorithm.modifier.ResultRecursive;
import impl.settlement_to_test.NodeSettlement;
import impl.settlement_to_test.ResultSettlement;
import impl.settlement_to_test.Settlement;
import impl.settlement_to_test.SettlementsAggregator;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kamil-Tomasz
 */
public class AlgorithmRecursiveMutableResultLastTest {
    
    private static Settlement notFound;
    private static AlgorithmRecursive<Settlement, ResultSettlement> mutable;
    
    @BeforeClass
    public static void initTest() {
        notFound = SettlementsAggregator.get("456").iterator().next();
        mutable = AlgorithmRecursiveFactory
                .mutableResult(new NodeSettlement(notFound), () -> new ResultSettlement())
                .executeIf(a -> a.data().getSearch().equals("yes"))
                .finishIf(a -> false)
                .toExecute((a,b) -> b.setSettlement(a))
                .build();
    }

    @Test
    public void testResultNotFound() {
        //given:
        ResultRecursive<ResultSettlement> expResult = ResultRecursive.newInstance(new ResultSettlement(), 1);
        //when:
        mutable.run();
        ResultRecursive<ResultSettlement> result = mutable.result();
        //then:
        assertEquals(expResult, result);
    }
    
    @Test
    public void testResultFoundLastInBranch() {
        //given:
        Settlement yes = SettlementsAggregator.get("118").iterator().next();
        ResultSettlement end = new ResultSettlement();
        end.setSettlement(yes);
        ResultRecursive<ResultSettlement> expResult = ResultRecursive.newInstance(end, 11);
        Settlement start = SettlementsAggregator.get("123").iterator().next();
        //when:
        mutable.changeStartAndRun(new NodeSettlement(start));
        ResultRecursive<ResultSettlement> result = mutable.result();
        //then:
        assertEquals(expResult, result);
    }
}
