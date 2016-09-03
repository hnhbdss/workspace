#include <stdio.h>
#include <fcntl.h>
#include <sys/unistd.h>
#include <sys/stat.h>
#include <stdlib.h>

int main(int argc, char * argv[]) {
	int fd = open("./a.txt", O_CREAT | O_TRUNC | O_RDWR, S_IRUSR | S_IWUSR);
	int fd2 = dup(fd);
	int fd3 = open("./a.txt", O_RDWR);

	write(fd, "Hello", 6);
	write(fd2, "world", 6);
	lseek(fd2, 0, SEEK_SET);
	write(fd, "HELLO", 6);
	write(fd3, "Gidday", 6);
	
	close(fd);
	close(fd2);
	close(fd3);
	return 0;
}
