#include <errno.h>
#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/cdefs.h>
#include <sys/fcntl.h>

int main(int argc, char * argv[]) {
    
    if (argc < 2) {
	printf("Usage:%s filename newfilename\n", argv[0]);
	return 1;
    }
    char pwd[1024];
    if (getcwd(pwd, sizeof(pwd)) != pwd) {
	printf("get pwd failed!\n");
	return 2;
    }
    char oldName[1024];
    char newName[1024];
    memset(oldName, 0, sizeof(oldName));
    memset(newName, 0, sizeof(newName));    
    strcat(oldName, pwd);
    strcat(oldName, "/");
    strcat(oldName, argv[1]);
    
    strcat(newName, pwd);
    strcat(newName, "/");
    strcat(newName, argv[2]);

    //if (link(oldName, newName) == -1) {// hard link
    if (linkat(0, oldName, 0, newName, AT_SYMLINK_NOFOLLOW)  == -1) {
	printf("error:link %s, %s\n", oldName, strerror(errno));
	printf("create link failed!\n");
	return 1;
    }
    return 0;
}
    
