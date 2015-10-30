package com.dss;

public class SayHello2Cpp {
    
    public SayHello2Cpp() {
    }
    
    static {
	System.loadLibrary("SayHello2Cpp");
    }
    
    public native void sayHello(String words);
}
