/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.impl.settlement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author Kamil-Tomasz
 */
public class SettlementsAggregator {
    
    private static final Map<Long, Settlement> rozliczenia = new HashMap<>();
    
    static {
        put(new Settlement("123", "234", "456", "no"));
        put(new Settlement("123", "235", "457", "no"));
        put(new Settlement("123", "236", "458", "no"));
        put(new Settlement("123", "237", "459", "no"));
        put(new Settlement("234", "233", "", "no"));
        put(new Settlement("456", "333", "", "no"));
        put(new Settlement("233", "", "", "no"));
        put(new Settlement("235", "", "", "no"));
        put(new Settlement("457", "", "", "no"));
        put(new Settlement("236", "", "", "yes"));
        put(new Settlement("458", "", "", "no"));
        put(new Settlement("237", "", "", "no"));
        put(new Settlement("459", "", "566", "no"));
        put(new Settlement("566", "567", "444", "yes"));
        put(new Settlement("444", "", "", "no"));
        put(new Settlement("567", "111", "", "no"));
        put(new Settlement("111", "112", "", "no"));
        put(new Settlement("112", "113", "114", "no"));
        put(new Settlement("113", "", "", "no"));
        put(new Settlement("114", "", "115", "no"));
        put(new Settlement("115", "116", "", "no"));
        put(new Settlement("116", "117", "118", "no"));
        put(new Settlement("117", "", "", "no"));
        put(new Settlement("118", "", "", "yes"));
    }

    public static Settlement put(Settlement value) {
        return rozliczenia.put(value.getId(), value);
    }
    
    public static Set<Settlement> get(String nr) {
        return rozliczenia.entrySet().stream()
                .filter(a -> a.getValue().getNr().equalsIgnoreCase(nr))
                .map(a -> a.getValue())
                .collect(Collectors.toSet());
    }
    
    public static Settlement get(long id) {
        return rozliczenia.get(id);
    }
    
}
