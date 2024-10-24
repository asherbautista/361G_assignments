
// This program is used to test both the coverage tool and memoization framework.

public class TestProgramSupport {
    // Static method that satisfies memoization constraints (int return type)
    public static int sum(int a, int b) {
        return a + b;
    }

    // Static method that satisfies memoization constraints (double return type)
    public static double multiply(double x, double y) {
        return x * y;
    }

    // Static method that does not satisfy memoization constraints (Object return type)
    public static Object createObject(int x, int y) {
        return new Object();
    }

    // Non-static method (not memoizable)
    public int nonStaticMethod(int a) {
        return a * 2;
    }

    // Method using object graph, memoizable if "Support" class
    public static int sumFields(CustomSupport obj) {
        return obj.a + obj.b;
    }

    public static void main(String[] args) {
        // Test static primitive methods
        int result1 = sum(3, 5);            // First call (should compute and memoize)
        int result2 = sum(3, 5);            // Second call (should return memoized result)
        double result3 = multiply(2.0, 4.0); // First call (should compute and memoize)
        double result4 = multiply(2.0, 4.0); // Second call (should return memoized result)

        // This method should not be memoized
        Object obj = createObject(10, 20);

        // Non-static method (should not be memoized)
        TestProgramSupport instance = new TestProgramSupport();
        int result5 = instance.nonStaticMethod(10);

        // Test method with object fields (CustomSupport class)
        CustomSupport customObj1 = new CustomSupport(10, 20);
        int result6 = sumFields(customObj1);   // First call (should compute and memoize)
        int result7 = sumFields(customObj1);   // Second call (should return memoized result)

        // Print results for verification
        System.out.println("Sum result 1: " + result1);
        System.out.println("Sum result 2: " + result2);
        System.out.println("Multiply result 3: " + result3);
        System.out.println("Multiply result 4: " + result4);
        System.out.println("Non-static method result 5: " + result5);
        System.out.println("Sum fields result 6: " + result6);
        System.out.println("Sum fields result 7: " + result7);
    }
}

// Helper class used for testing object graph traversal in memoization
class CustomSupport {
    int a, b;

    CustomSupport(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
