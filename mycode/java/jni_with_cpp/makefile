JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64
all:
	javac -d bin/ java_impl/src/com/dss/SayHello2Cpp.java
	cd bin; javah -d . com.dss.SayHello2Cpp; cd ..
	g++ -I$(JAVA_HOME)/include -Ibin -L$(JAVA_HOME)/lib -Wall -fPIC -shared -o bin/libSayHello2Cpp.so -D_JNI_IMPLEMENTATION_  cpp/src/SayHello2Cpp.cpp
	javac -d bin/ -cp ./bin java_client/Client.java
	(export LD_LIBRARY_PATH=$(LD_LIBRARY_PATH):./bin; java -cp ./bin Client)

clean:
	find . -name "*.o" -print -exec rm -rf {} \;	
	find . -name "*.class" -print -exec rm -rf {} \;	
	find . -name "*.h" -print -exec rm -rf {} \;	
	find . -name "*~" -print -exec rm -rf {} \;	
