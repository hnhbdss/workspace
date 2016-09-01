#include <stdio.h>

int main(int argc, char * argv[]) {
    
    if (argc < 2) {
	printf("Usage:%s filename\n", argv[0]);
	return 1;
    }

    FILE * f = fopen(argv[1], "w+");

    fwrite("hello", sizeof(char), 5, f);
    fflush(f);
    fwrite("world\n", sizeof(char), 6, f);
    fclose(f);
    return 0;
}
