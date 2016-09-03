
ifdef compile_dir
all:
	$(MAKE) --directory=$(compile_dir) all
clean:
	$(MAKE) --directory=$(compile_dir) clean
else 
define src_to_lib_target
$(LIB_DIR)/$(basename $(notdir $@))$(suffix $@)
endef

vpath %.c src
vpath %.cpp src
vpath %.o lib
vpath %.d lib

ifdef target_name 
LIB_DIR ?= lib

SOURCE_FILES = $(foreach dir, $(include_dirs), $(wildcard $(dir)/*.c $(dir)/*.cpp))

OBJ_FILES += $(notdir $(patsubst %.c, %.o, $(filter %.c, $(SOURCE_FILES))))
OBJ_FILES += $(notdir $(patsubst %.cpp, %.o, $(filter %.cpp, $(SOURCE_FILES))))

LIB_OBJ_FILES =$(addprefix lib/, $(OBJ_FILES))
LIB_DEP_FILES = $(addprefix lib/, $(subst .o,.d,$(OBJ_FILES)))

INCLUDES_DIRS += $(addprefix -I,$(include_dirs))

-include $(LIB_DEP_FILES)

all:$(target_name) 

$(target_name):$(OBJ_FILES) 
	$(LD) ${LDFLAGS} -o $(LIB_DIR)/$@ $(addprefix lib/, $^)

%.d : %.c
	$(CC) -MM $(INCLUDES_DIRS) $^ >$(call src_to_lib_target)
%.d : %.cpp
	$(CC) -MM $(INCLUDES_DIRS) $^ >$(call src_to_lib_target)

%.o : %.c
	$(CC) -c -o $(LIB_DIR)/$@ $^
%.o : %.cpp
	$(CC) -c -o $(LIB_DIR)/$@ $^

INCLUDES = $(patsubst %,-I %, $(INCLUDES_DIRS))

clean:
	@rm -rf $(LIB_OBJ_FILES)
	@rm -rf $(LIB_DEP_FILES)
	@rm -rf $(target_name)
endif
endif 
