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

class FooTest : public testing::Test {
public:
    static void SetUpTestCase(void) {
        std::cout << "Set up Foo test suite!" << std::endl;
    }

    static void TearDownTestCase(void) {
        std::cout << "Tear down Foo test suite!" << std::endl;
    }

    virtual void SetUp(void) {
        std::cout << "set up foo test case " << std::endl;
    }
    
    virtual void TearDown(void) {
        std::cout << "tear down foo test case" << std::endl;
    }
};

TEST_F(FooTest, HandleNoneZeroInput) {
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

TEST(FloatTest, FloatEqInput) {
    EXPECT_PRED_FORMAT2(testing::FloatLE, 4, 5);
}

template<typename T> class FooType {
public:
    void bar() {
        testing::StaticAssertTypeEq<int, T>();
    }
};

TEST(TypeAssertionTest, Demo) {
    FooType<int> foo;
    foo.bar();
}

class FooEnvironment : public testing::Environment {
public:
    virtual void SetUp(void) {
        std::cout << "Foo Environment setup!" << std::endl;
    }
    
    virtual void TearDown(void) {
        std::cout << "Foo Environment teardown!" << std::endl;
    }
};

bool isPrime(int n) {
    if (n <=1 ) return false;
    if (n % 2 == 0) return false;
    for (int i = 3; ; i +=2) {
        if (i * i > n) return true;
        if ( n % i == 0) return false;
    }
    return true;
}

class IsPrimeTest : public testing::TestWithParam<int> {
};

TEST_P(IsPrimeTest, ReturnTrue) {   
    int n = GetParam(); 
    EXPECT_TRUE(isPrime(n));
}

INSTANTIATE_TEST_CASE_P(TrueReturn, IsPrimeTest, testing::Values(3, 5, 13, 17));

int main(int argc, char * argv[]) {
    //testing::GTEST_FLAG(output) = "xml:";
    testing::AddGlobalTestEnvironment(new FooEnvironment);
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}
