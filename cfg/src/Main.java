import utils.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String classFilePath = args[0];
        CFG cfg = BytecodeParser.parse(classFilePath);

        Map<Integer, BasicBlock> blocks = cfg.getBlocks();
        Map<Integer, Set<Integer>> dom = DominatorSet.computeDominatorSets(cfg);

        // Write CFG to file
        try (PrintWriter writer = new PrintWriter("output/cfg_output.txt")) {
            for (BasicBlock block : blocks.values()) {
                writer.println(block);
            }
        }

        // Write Dominator Sets to file
        try (PrintWriter writer = new PrintWriter("output/dom_output.txt")) {
            for (int id : dom.keySet()) {
                writer.println("DOM(" + id + "): " + dom.get(id));
            }
        }
    }
}
