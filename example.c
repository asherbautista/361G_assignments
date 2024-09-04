#include <stdio.h>

// Sample function demonstrating the new construct
int n() {
    return 5; // Example function returning a fixed value
}

int m(int a, int b) {
    // Example usage of the new construct
    int c = [[ a, n(), b ]]; // This uses the newly implemented syntax
    return c;
}

int main() {
    int result = m(0, 1);
    printf("Result: %d\n", result);
    return 0;
}
