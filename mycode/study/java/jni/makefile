JAVA_HOME=/usr/lib/jvm/java-1.7.0-openjdk-amd64
all:
	javac HelloWorld.java
	javah HelloWorld
	clang -I$(JAVA_HOME)/include -L$(JAVA_HOME)/lib -Wall -fPIC -shared -o libhello.so -D_JNI_IMPLEMENTATION_  hello.c
	(export LD_LIBRARY_PATH=$(LD_LIBRARY_PATH):/home/lili/workspace/git-hub/mycode/java/jni; java HelloWorld)
clean:
	rm -rf *.class
	rm -rf *.o
	rm -rf *.so
	rm -rf *~
	rm -rf *.h
