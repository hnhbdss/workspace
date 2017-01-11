#include <stdio.h>

#include "mymath.h"

void output_error(char * msg) {
  printf("error no:%d, info:%s\n" , add(1, 3),msg);
}
