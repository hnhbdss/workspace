#include <unistd.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <memory.h>
#include <stdio.h>

int main(int argc, char * argv[]) {
    struct stat st;
    memset(&st, 0, sizeof(struct stat));
    
    if (stat(argv[1], &st) == -1) {
	printf("get stat of file %s failed\n", argv[1]);
	return 1;
    }

    printf("major dev no : %d, minor dev no : %d\n", major(st.st_dev), minor(st.st_dev));
    if (S_ISCHR(st.st_mode) || S_ISBLK(st.st_mode)) {
	printf("(%s) rdev = %d/%d\n", S_ISCHR(st.st_mode) ? "Char" : "Block", major(st.st_rdev), minor(st.st_rdev));
    }
    return 0;
}
