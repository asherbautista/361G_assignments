
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.VM;
import gov.nasa.jpf.ListenerAdapter;
import java.util.*;

public class CoverageListener extends ListenerAdapter {
    private final Map<String, Set<Integer>> coverage = new HashMap<>();

    @Override
    public void instructionExecuted(VM vm, ThreadInfo ti, Instruction nextInsn, Instruction executedInsn) {
        String className = executedInsn.getMethodInfo().getClassName();
        int lineNumber = executedInsn.getLineNumber();

        if (!coverage.containsKey(className)) {
            coverage.put(className, new TreeSet<>());
        }
        if (lineNumber > 0) {
            coverage.get(className).add(lineNumber);
        }
    }

    @Override
    public void searchFinished(VM vm) {
        // Output the report.txt
        try (PrintWriter writer = new PrintWriter(new File("results/report.txt"))) {
            List<String> sortedClasses = new ArrayList<>(coverage.keySet());
            Collections.sort(sortedClasses);

            for (String className : sortedClasses) {
                Set<Integer> lines = coverage.get(className);
                for (Integer line : lines) {
                    writer.println(className + ":" + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
