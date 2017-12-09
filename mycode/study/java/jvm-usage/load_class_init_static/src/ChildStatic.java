public class ChildStatic extends SimpleStatic {

    static {
	id = 2;
    }

    public static void main(String[] args) {

	System.out.println("id is " + id);
    }
}
