source_files := $(wildcard *.c)
obj_files := $(patsubst %.c,%.o,$(source_files))
target := main
target_file := $(target)
.PHONY : all clean

all:$(target_file)

$(target_file):$(obj_files)
	gcc -static -o $@ $^ -L./funcs -lfuncs -lc

%.o:%.c
	gcc -fPIC -c -I ./funcs -o $@ $^

clean :
	rm -rf $(target_file)
	rm -rf $(obj_files)

