#include <stdio.h>

namespace myname {
    int var;
}

extern "C" double _ZN6myname3varE;

int main(int argc, char * argv[]) {
    printf("%l\n", _ZN6myname3varE);
    return 0;
}
