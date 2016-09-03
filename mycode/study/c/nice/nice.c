#include <time.h>
#include <unistd.h>
#include <limits.h>
#include <sys/time.h>
#include <stdio.h>

int main(int argc, char * argv[]) {
    printf("nice:%d\n", (int)(sysconf(_SC_NZERO)));
    return 0;
}
