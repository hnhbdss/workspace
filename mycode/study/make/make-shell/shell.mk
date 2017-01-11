#.INTERMEDIATE:file_list
file_list:
	for d in /home/lili/workspace/code/mycode/algorithm/java/MinSubArray/src/com/dss; \
	do  \
	    echo $$d/*.java; \
	done > $@
