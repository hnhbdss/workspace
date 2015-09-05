import org.objectweb.asm.*;
import java.io.*;
public class SecurityWeaveGenerator {
    public static void main(String[] args) throws Exception {
	
	String className = Account.class.getName();
	ClassReader reader = new ClassReader(className);
	ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS|ClassWriter.COMPUTE_FRAMES);
	AddSecurityCheckClassAdapter classAdapter = new AddSecurityCheckClassAdapter(writer);

	reader.accept(classAdapter, ClassReader.SKIP_DEBUG);
	byte[] data = writer.toByteArray();

	File file =  new File("bin/" + className.replaceAll("\\.", "/") + ".class");
	FileOutputStream fout = new FileOutputStream(file);
	fout.write(data);
	fout.close();
    }
}
