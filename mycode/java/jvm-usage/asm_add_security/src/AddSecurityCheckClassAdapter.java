import org.objectweb.asm.*;

public class AddSecurityCheckClassAdapter extends ClassVisitor {

    public AddSecurityCheckClassAdapter(ClassVisitor cv) {
	super(Opcodes.ASM5, cv);
    }

    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
	MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);

	MethodVisitor wrappedMv = mv;
	if (mv != null) {
	    if (name.equals("operation")) {
		wrappedMv = new AddSecurityCheckMethodAdapter(mv);
	    }
	}
	return wrappedMv;
    }
}
