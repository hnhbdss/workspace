prefix=lib
suffix=.so

target=mymath
target_name=$(prefix)$(target)$(suffix)
source_files=$(wildcard *.c)
object_files=$(patsubst %.c,%.o,$(source_files))

all:$(target_name)
$(target_name):$(object_files)
	gcc -shared -o $@ $^
%.o:%.c
	gcc -c -o $@ -fPIC $^
