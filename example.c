#include <stdio.h>

// Sample function demonstrating the new construct
int test_function() {
    int a = 0, b = 5;
    int result = [[ a, a + 1, b ]];  // Example usage of the new construct
    return result;
}

int main() {
    printf("Result: %d\n", test_function());
    return 0;
}
