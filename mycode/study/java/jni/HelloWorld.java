public class HelloWorld {
    public native void displayHelloWorld();
    
    static {
	System.loadLibrary("hello");
    }

    public static void main(String[] args) {
	System.out.printf(System.getProperty("java.library.path"));
	System.out.printf("dushishuang\n");
	new HelloWorld().displayHelloWorld();
    }
}
