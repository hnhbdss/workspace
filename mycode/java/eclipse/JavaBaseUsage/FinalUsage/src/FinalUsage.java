import java.util.Set;
import java.util.HashSet;

public class FinalUsage {
	
	public final Set<String> tests = new HashSet<String>();
	
	public FinalUsage() {
		tests.add("test");
		tests.add("lili");
	}
	
	public static void main(String[] args) {
		FinalUsage obj = new FinalUsage();
		System.out.println("hello:" + obj.tests.add("2"));
	}

}
