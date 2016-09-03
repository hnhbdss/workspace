#include <stdlib.h>
#include <sys/unistd.h>
#include <stdio.h>

int main(int argc, char * argv[]) {
  int fd;
  char template[] = "/tmp/somestringXXXXXX";
  fd = mktemp(template);
  if (fd == -1) {
    printf("error to open file!");
    exit(1);
  }

  printf("open file is: %s\n", template);

  unlink(template);

  if (close(fd) == -1) {
    printf("error to close file!");
    exit(1);
  }

  return 0;
}
    
  
