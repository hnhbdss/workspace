#include <time.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/time.h>
#include <sys/stat.h>

int main(int argc, char * argv[]) {
    printf("param:%d\n", argc);

    struct timeval date[2];
    
    if (argc == 1) {
	if (futimens(3, NULL) == -1) {
	    printf("modify time to now 2 failed\n");	    
	    return 2;
	}
    }
    else if (argc == 2) {
	time_t now = time(NULL);
	date[0].tv_nsec = 0;
	date[0].tv_sec = now;
	date[1].tv_nsec = 0;
	date[1].tv_sec = now;
	if (futimens(3, date) == -1) {
	    printf("modify time to now failed\n");
	    return 1;
	}
    }

    return 0;
}
	    
