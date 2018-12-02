/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import algorithm.AlgorithmRecursive;
import algorithm.AlgorithmRecursiveFactory;
import impl.file.NodeFile;
import impl.number.NodeInteger;
import impl.file.ext.Extension;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import impl.file.util.FileUtil;

/**
 *
 * @author Kamil-Tomasz
 */
public final class AlgorithmRecursiveNumericFactory {

    public static AlgorithmRecursive<Integer, BigDecimal> factorial(int arg) {
        return AlgorithmRecursiveFactory.immutableResult(new NodeInteger(arg), BigDecimal.ONE)
                        .finishIf(node -> node.data() < 2)
                        .executeIf(node -> true)
                        .limitNumberIterations(700)
                        .toExecute((a,result) -> result.multiply(BigDecimal.valueOf(a)))
                        .build();
    }
}
