#include <unistd.h>
#include <stdio.h>

int main(int argc, char * argv[]) {

    char * name = NULL;
    if ((name = getlogin()) != NULL) {
	printf("login name :%s\n", name);
	return 0;
    }
    else {
	printf("get login failed\n");
    }
    return -1;
}
