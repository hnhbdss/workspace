#include "gtest/gtest.h"

int foo(void) {
    int * p = 0;
    *p  = 200;
}

TEST(FooDeathTest, Demo) {
    EXPECT_DEATH(foo(), "");
}


int main(int argc, char * argv[]) {
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}

