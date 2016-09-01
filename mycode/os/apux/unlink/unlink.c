#include <stdio.h>
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>

int main(int argc, char * arv[]) {
    
    if (open("mytest", O_RDWR) == -1) {
	printf("open file failed!\n");
	return 1;
    }

    if (unlink("mytest") == -1) {
	printf("unlink file failed\n");
	return 1;
    }

    printf("unlink file ok!\n");
    
    sleep(10);
    
    printf("sleep ok!\n");
    
    return 0;
}
