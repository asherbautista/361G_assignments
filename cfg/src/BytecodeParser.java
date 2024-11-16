package utils;

import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.util.*;

public class BytecodeParser {
    public static CFG parse(String classFilePath) throws Exception {
        // Parse class bytecode
        CFG cfg = new CFG();

        ClassReader cr = new ClassReader(classFilePath);
        ClassNode cn = new ClassNode();
        cr.accept(cn, 0);

        MethodNode mainMethod = null;
        for (MethodNode mn : cn.methods) {
            if (mn.name.equals("main") && mn.desc.contains("([Ljava/lang/String;)V")) {
                mainMethod = mn;
                break;
            }
        }

        if (mainMethod == null) throw new IllegalArgumentException("Main method not found!");

        // Process instructions
        BasicBlock currentBlock = cfg.createBlock();
        for (AbstractInsnNode insn : mainMethod.instructions) {
            if (insn.getOpcode() == -1) continue;
            currentBlock.addInstruction(insn.toString());
            // Add control flow transitions...
        }

        return cfg;
    }
}
