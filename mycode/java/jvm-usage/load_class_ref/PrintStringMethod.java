import java.lang.reflect.*;

public class PrintStringMethod {

    public static void main(String[] args) throws Exception{

	Class clz = Class.forName("java.lang.String");
	Method[] methods = clz.getDeclaredMethods();
	for (Method m : methods) {
	    String modifier = Modifier.toString(m.getModifiers());
	    System.out.print(modifier + " " + m.getName() + "(");
	    Class<?>[] ps = m.getParameterTypes();
	    if (ps.length == 0) {
		System.out.println(")");
	    }
	    else {
		for (Class<?> p : ps) {
		    System.out.print(p.getSimpleName());
		    if (p != ps[ps.length -1]) {
			System.out.print(",");
		    }
		}
		System.out.println(")");
	    }
	}
    }
}
