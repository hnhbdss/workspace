#include <stdio.h>

extern char __executable_start[];
extern char etext[], _etext[], __etext[];
extern char edata[], _edata[];
extern char end[], _end[];


int main(int argc, char * argv) {
    printf("executable_start: %x\n", __executable_start);
    printf("end of text: %x, %x, %x\n", etext, _etext, __etext);
    printf("end of data: %x, %x\n", edata, _edata);
    printf("end of programs:%x, %x\n", end, _end);
    return 0;
}
