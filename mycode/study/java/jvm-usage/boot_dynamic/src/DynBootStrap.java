import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.util.*;

public class DynBootStrap {
    public static CallSite bootstrap(Lookup lookup, String name, MethodType mt, Object value) throws Exception{
	System.out.println("called in bootstrap method with name:" + name);
	MethodHandle h = lookup.findVirtual(value.getClass(), name, mt).bindTo(value);
	return new ConstantCallSite(h);
    }
}
	
	
