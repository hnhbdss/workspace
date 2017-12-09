import org.objectweb.asm.*;
    
public class AddSecurityCheckMethodAdapter extends MethodVisitor {

    public AddSecurityCheckMethodAdapter(MethodVisitor mv) {
	super(Opcodes.ASM5, mv);
    }

    public void visitCode() {

	Label continueLabel = new Label();

	visitMethodInsn(Opcodes.INVOKESTATIC, "SecurityChecker", "checkSecurity", "()Z");
	visitJumpInsn(Opcodes.IFNE, continueLabel);
	visitInsn(Opcodes.RETURN);
	visitLabel(continueLabel);

	super.visitCode();
    }
}

