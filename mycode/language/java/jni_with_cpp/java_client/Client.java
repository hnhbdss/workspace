import com.dss.SayHello2Cpp;

public class Client {
    
    public static void main(String[] args) {
	SayHello2Cpp test = new SayHello2Cpp();
	System.out.println(System.getProperty("java.library.path"));
	test.sayHello("lili");
    }
}
