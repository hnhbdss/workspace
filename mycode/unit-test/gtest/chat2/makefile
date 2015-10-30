gtest_home=/home/lili/workspace/source/googletest-read-only
target_name=test
cpp_files=$(wildcard *.cpp)
all:$(target_name)
$(target_name):$(cpp_files)
	g++ -o $@ $< -I$(gtest_home)/include -L$(gtest_home) -L/usr/lib/x86_64-linux-gnu -lgtest -lpthread
run:
	./test --gtest_output=xml:dss.xml
list:
	./test --gtest_list_tests
