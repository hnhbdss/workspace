#include <zlib.h>
#include <vector>
#include <string>
#include <iostream>
#include <iterator>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char * argv[]) {
    
    std::string inputStr("hello world dushishuang");
    
    unsigned maxSize = compressBound(inputStr.size());
    
    std::cout << "buffer max size:" << maxSize << std::endl;

    unsigned char * buffer = new unsigned char[maxSize];
    memset(buffer, 0, maxSize);
    unsigned long realSize = maxSize;
    int ret_code = 0;
    ret_code = compress(buffer, &realSize, inputStr.c_str(), inputStr.size());
    std::cout << "ret code :" << ret_code << ", z_OK:" << Z_OK << std::endl; 
    if (ret_code != Z_OK) {
        std::cout << "bad" << std::endl;
    }   
    else {
        std::cout << buffer << std::endl;
    }
    
    char dstbuffer[100];
    memset(dstbuffer, 0, sizeof(dstbuffer));
    unsigned long dstlen = sizeof(dstbuffer);
    ret_code = uncompress(dstbuffer, &dstlen, buffer, realSize);
    std::cout << "uncompress code:" << ret_code << std::endl;
    if (ret_code != Z_OK) {  
        std::cout << "bad2" << std::endl;
    }
    else {
        std::cout << dstbuffer << std::endl;
    }

    delete buffer;
    return 0;
}


