#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <memory.h>

#define BUFFER_SIZE 1024

int main(int argc, char * argv[]) {
    if (argc < 2) {
	printf("Usage:%s symlinkname\n", argv[0]);
	return 1;
    }

    char buffer[BUFFER_SIZE];
    memset(buffer, 0, sizeof(buffer));
    if (readlink(argv[1],  buffer, sizeof(buffer)) == -1) {
	printf("read sym link failed!\n");
	return 1;
    }

    printf("readlink %s:%s\n", argv[1], buffer);
    return 0;
}
    

