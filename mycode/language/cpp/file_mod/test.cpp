#include <iostream>
#include <fstream>

int main(int argc, char * argv[]) {
    std::ofstream buffer("./a.txt", std::ios::binary|std::ios::in);
    if (!buffer.good()) {
        std::cerr << "file is not ok" << std::endl;
        return -1;
    }
    buffer.seekp(3, std::ios::beg);
    buffer.write("888", 3);
    buffer.close();
    return 0;
}


//1234567890123456789
