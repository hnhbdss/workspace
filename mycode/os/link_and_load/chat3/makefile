c_files=$(wildcard *.c)
cpp_files=$(wildcard *.cpp)
c_targets=$(patsubst %.c, %, $(c_files))
cpp_targets=$(patsubst %.cpp, %, $(cpp_files))
targets=$(c_targets) $(cpp_targets)
obj_targets=$(patsubst %, %.o, $(obj_targets))

all:$(targets)
%.o:%.c
	gcc -o $@ $^
%.o:%.cpp
	g++ -o $@ $^	

clean:
	rm -rf *.o
	rm -rf SimpleSection SpecialSymbol
	echo $(c_targets)
	echo $(cpp_targets)
	echo $(targets)
