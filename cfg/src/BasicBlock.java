package utils;

import java.util.*;

public class BasicBlock {
    public int id;
    public List<String> instructions = new ArrayList<>();
    public Set<Integer> successors = new HashSet<>();

    public BasicBlock(int id) {
        this.id = id;
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    public void addSuccessor(int bbId) {
        successors.add(bbId);
    }

    @Override
    public String toString() {
        return id + " => " + successors.toString();
    }
}
