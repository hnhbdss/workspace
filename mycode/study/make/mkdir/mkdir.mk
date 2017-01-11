modules := a b c 
test := $(shell for f in $(modules); \
		do \
			test -d $$f || mkdir -p $$f; \
		done)

all:
.PHONY:clean
clean:
	$(shell for f in $(modules); \
		do \
			test -d $$f && rm -rf $$f; \
		done 1>&2)




