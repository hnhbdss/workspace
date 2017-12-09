import java.lang.invoke.*;
import static java.lang.invoke.MethodHandles.*;
import org.objectweb.asm.*;
import org.objectweb.asm.commons.*;
import org.objectweb.asm.util.*;
import java.io.*;

public class DynInvokeSample extends ClassLoader {
    private static final Handle handle = new Handle(
	Opcodes.H_INVOKESTATIC, DynBootStrap.class.getName().replace('.', '/'),
	"bootstrap",
	MethodType.methodType(Lookup.class, String.class, MethodType.class, Object.class, CallSite.class).toMethodDescriptorString());

    public Class createClass() throws IOException {
	ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
	writer.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "DynInvokeSampleMain", null, "java/lang/Object", null);
	Method m = Method.getMethod("void <init> ()");
	GeneratorAdapter mg = new GeneratorAdapter(Opcodes.ACC_PUBLIC, m, null, null, writer);
	mg.loadThis();
	mg.invokeConstructor(Type.getType(Object.class), m);
	mg.returnValue();
	mg.endMethod();

	MethodVisitor mv = writer.visitMethod(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, "run", "()V", null, null);
	mv.visitCode();
	mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
	mv.visitInvokeDynamicInsn("hashCode", "()I", handle, "geym");
	mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V");
	mv.visitInsn(Opcodes.RETURN);
	mv.visitMaxs(0, 0);
	mv.visitEnd();

	writer.visitEnd();
	byte[] code = writer.toByteArray();
	return this.defineClass("DynInvokeSampleMain", code, 0, code.length);
    }

    public static void main(String[] args) throws Exception {

	DynInvokeSample me = new DynInvokeSample();
	Object obj = me.createClass().newInstance();
	
	obj.getClass().getMethod("run").invoke(null);
    }
}
