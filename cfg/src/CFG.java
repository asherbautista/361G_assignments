package utils;

import java.util.*;

public class CFG {
    private Map<Integer, BasicBlock> blocks = new LinkedHashMap<>();
    private int nextId = 0;

    public BasicBlock createBlock() {
        BasicBlock bb = new BasicBlock(nextId++);
        blocks.put(bb.id, bb);
        return bb;
    }

    public Map<Integer, BasicBlock> getBlocks() {
        return blocks;
    }
}
