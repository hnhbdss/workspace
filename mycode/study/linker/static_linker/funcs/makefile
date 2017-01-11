source_files := $(filter-out func_5%,$(wildcard *.c))
dynamic_source_files := $(filter func_5%,$(wildcard *.c))

obj_files := $(patsubst %.c,%.o,$(source_files))
dynamic_obj_files := $(patsubst %.c,%.o,$(dynamic_source_files))

target := funcs
static_target_file :=lib$(target).a
dynamic_target_file :=lib$(target)2.so

.PHONY : all clean
all:$(static_target_file) $(dynamic_target_file)

$(static_target_file):$(obj_files)
	ar -r $@ $^

$(dynamic_target_file):$(dynamic_obj_files) #$(static_target_file) 
	gcc -shared -Wl,-runpath,/usr/local/lib -Wl,-rpath,/usr/local/lib -o $@ $< -Wl,-soname,$(dynamic_target_file).2 #-Wl,#--whole-archive $(static_target_file) 
$(dynamic_obj_files):$(dynamic_source_files)
	gcc -fPIC -c -o $@ $^
%.o:%.c
	gcc -fPIC -c -o $@ $^
clean :
	rm -rf $(static_target_file)
	rm -rf $(dynamic_target_file)
	rm -rf $(obj_files)
	rm -rf $(dynamic_obj_files)
