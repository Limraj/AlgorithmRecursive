/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.settlement_to_test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import algorithm.node.NodeAlgorithmRecursive;

/**
 *
 * @author Kamil-Tomasz
 */
public class NodeSettlement implements NodeAlgorithmRecursive<Settlement> {
    
    private final Settlement settlement;

    public NodeSettlement(Settlement rozliczenie) {
        this.settlement = rozliczenie;
    }

    @Override
    public List<NodeAlgorithmRecursive<Settlement>> nodes() {
        Set<Settlement> start = SettlementsAggregator.get(settlement.getNumberMain());
        Set<Settlement> nodesNr1 = start.stream().flatMap(a -> SettlementsAggregator.get(a.getNr1()).stream()).collect(Collectors.toSet());
        Set<Settlement> nodesNr2 = start.stream().flatMap(a -> SettlementsAggregator.get(a.getNr2()).stream()).collect(Collectors.toSet());
        nodesNr1.addAll(nodesNr2);
        return nodesNr1.stream().map(a -> new NodeSettlement(a)).collect(Collectors.toList());
    }

    @Override
    public Settlement data() {
        return settlement;
    }

    @Override
    public String toString() {
        return "NodeSettlement{" + "settlement=" + settlement + '}';
    }
}
