#include <iostream>

int prime(int n) {
    int i;
    for (i = 2; i < n; ++i) {
        if (n % i == 0) {
            return 0;
        }
    }
    return 1;
}

int main(int argc, char * argv[]) {
    int i, n;
    n = 1000;
    for (i = 2; i <= n; ++i) {
        if (prime(i)) {
            std::cout << i << std::endl;
        }
    }
}
