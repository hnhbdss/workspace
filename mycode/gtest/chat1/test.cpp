#include <exception>
#include "gtest/gtest.h"

int foo(int a, int b)
{
    if (a == 0 || b == 0) {
        throw "don't do that";
    }
    int c = a % b;
    if (c == 0)
        return b;
    return foo(b, c);
}

int add(int a, int b) {
    return a + b;
}

TEST(FooTest, HandleNoneZeroInput) {
    EXPECT_EQ(2, foo(4, 10));
    EXPECT_EQ(6, foo(30, 18));
}

TEST(AddTest, NormalInput) {
    EXPECT_EQ(2, add(1, 4));
}

TEST(FailureTest, NormalTest) {
    ADD_FAILURE() << "sorry dushishuang!";
    SUCCEED();
}

TEST(FooExpectionTest, HandleZeroInput) {
    EXPECT_ANY_THROW(foo(0, 0));
    EXPECT_THROW(foo(0,0), const char *);
}

int main(int argc, char * argv[]) {
    //testing::GTEST_FLAG(output) = "xml:";
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
