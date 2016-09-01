#include <iostream>
#include <string>

char * convert(const char * p) {
    if (!p) {
        return 0;
    }

    char * buffer = new char[strlen(p)/2 + 1];
    while(*p != '\0') {
        ++p;
    }
}

int main(int argc, char * arg[]) {
    if (argc < 2) {
        std::cerr << "param is not enough " << std::endl
                  << "Uages: convert \"0101#\" " << std::endl;
        return 1;
    }

}


