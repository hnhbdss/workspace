prefix=lib
suffix=.so

target=shared_function
target_name=$(prefix)$(target)$(suffix)
source_files=$(wildcard *.c)
object_files=$(patsubst %.c,%.o,$(source_files))

include_header_dirs=/home/lili/workspace/code/mycode/study/linker/shared_lib/mymath
include_lib_dirs=/home/lili/workspace/code/mycode/study/linker/shared_lib/mymath
include_libs=mymath

all:$(target_name)
$(target_name):$(object_files)
	gcc -shared -o $@ -Wl,-rpath,/usr/local/lib -Wl,--enable-new-dtags $(patsubst %,-L%,$(include_lib_dirs)) $(patsubst %,-l%,$(include_libs)) $^
%.o:%.c
	gcc -c -o $@ $(patsubst %,-I%,$(include_header_dirs)) -fPIC $^
.intermediate: *.o *.so
