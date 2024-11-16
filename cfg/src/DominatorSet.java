package utils;

import java.util.*;

public class DominatorSet {
    public static Map<Integer, Set<Integer>> computeDominatorSets(CFG cfg) {
        Map<Integer, BasicBlock> blocks = cfg.getBlocks();
        Map<Integer, Set<Integer>> dom = new HashMap<>();

        // Initialize DOM(x) for all nodes
        for (int id : blocks.keySet()) {
            dom.put(id, new HashSet<>(blocks.keySet()));
        }

        // Start node dominates itself
        int start = 0;
        dom.get(start).clear();
        dom.get(start).add(start);

        boolean changed;
        do {
            changed = false;
            for (int id : blocks.keySet()) {
                if (id == start) continue;

                Set<Integer> newDom = new HashSet<>(blocks.keySet());
                for (int pred : blocks.get(id).successors) {
                    newDom.retainAll(dom.get(pred));
                }
                newDom.add(id);

                if (!newDom.equals(dom.get(id))) {
                    dom.put(id, newDom);
                    changed = true;
                }
            }
        } while (changed);

        return dom;
    }
}
