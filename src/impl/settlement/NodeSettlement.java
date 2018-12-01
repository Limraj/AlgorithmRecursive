/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.settlement;

import algorithm.node.NodeAlgorithm;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Kamil-Tomasz
 */
public class NodeSettlement implements NodeAlgorithm<Settlement> {
    
    private final Settlement rozliczenie;

    public NodeSettlement(Settlement rozliczenie) {
        System.out.println("roz: " + rozliczenie);
        this.rozliczenie = rozliczenie;
    }

    @Override
    public List<NodeAlgorithm<Settlement>> nodes() {
        Set<Settlement> start = SettlementsAggregator.get(rozliczenie.getNr());
        System.out.println("start: " + start);
        Set<Settlement> nodesNr1 = start.stream().flatMap(a -> SettlementsAggregator.get(a.getNr1()).stream()).collect(Collectors.toSet());
        Set<Settlement> nodesNr2 = start.stream().flatMap(a -> SettlementsAggregator.get(a.getNr2()).stream()).collect(Collectors.toSet());
        nodesNr1.addAll(nodesNr2);
        //System.out.println("nodes: " + nodesNr1);
        System.out.println("nodesNr2: " + nodesNr2);
        return nodesNr1.stream().map(a -> new NodeSettlement(a)).collect(Collectors.toList());
    }

    @Override
    public Settlement data() {
        return rozliczenie;
    }
    
}
