#include <sys/stat.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>

#ifndef BUF_SIZE
#define BUF_SIZE 1024
#endif

int main(int argc, char * argv[]) {
	
	if (argc < 3 || strcmp(argv[1], "--help") == 0) { 
		printf("Usage:%s oldfile newfile\n", argv[0]);
		exit(1);
	}
	char buffer[BUF_SIZE];
	memset(buffer, sizeof(buffer), 0);
        int input_fd = open(argv[1], O_RDONLY);
	if (input_fd == -1) {
		printf("error to open file:%s\n", argv[1]);
		exit(1);
	}	 
	int output_fd = open(argv[2], O_CREAT | O_TRUNC| O_RDWR, S_IRUSR| S_IWUSR);
	if (output_fd == -1) {
		printf("error to open file:%s\n", argv[2]);
		exit(1);
	}
	int numRead=-1;
	int numWrite=-1;
	while((numRead=read(input_fd, buffer, sizeof(buffer))) > 0) {
		if ((numWrite=write(output_fd, buffer, numRead)) != numRead) {
			printf("error to copy file\n");
			exit(1);
		}
	}	
	close(input_fd);
	close(output_fd);
}

		
